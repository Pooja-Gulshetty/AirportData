package airport.details.process;

import java.util.Comparator;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.stream.Collectors;

import airport.details.constants.Constants;
import airport.details.entities.Runway;
import airport.details.data.DataStore;
import airport.details.dataflow.ResponseObject;
import airport.details.entities.Airport;

public class ReportProcessor {

	public static ResponseObject countryWithHighestAndLowestAirports() {
		// descending order sorting to get first 10 elements having maximum
		// number of airports
		StringBuilder data = new StringBuilder(
				Constants.HEADER_MAKER + Constants.LINE_SEPERATOR+"         Countries Having Highest Number Of Airports" + Constants.LINE_SEPERATOR);
		data.append("         [Country Name                  Number Of Airports]" + Constants.LINE_SEPERATOR);
		ResponseObject response = new ResponseObject();
		// sort the map in descending order of number of airports
		Map<String, List<Airport>> sortedMap = RequestProcessor.countryAirportMap.entrySet().stream()
				.sorted((entry1, entry2) -> (entry2.getValue().size() - entry1.getValue().size()))
				.collect(Collectors.toMap(Entry::getKey, Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
		// add first 10 airports details response
		sortedMap.entrySet().stream().limit(10)
				.forEach(
						entry -> data.append("         [")
								.append(RequestProcessor.countryMap.get(entry.getKey()).get(Constants.FIRST_ELEMENT)
										.getName())
								.append("                  ").append(entry.getValue().size()).append("]")
								.append(Constants.LINE_SEPERATOR));

		// get last 10 elements from above sorted map
		data.append(Constants.LINE_SEPERATOR + Constants.LINE_SEPERATOR
				+ "          Countries Having Lowest Number Of Airports" + Constants.LINE_SEPERATOR);
		data.append("         [Country Name     Number Of Airports]"+Constants.LINE_SEPERATOR);
		// add last 10 airports details response
		sortedMap.entrySet().stream().skip(sortedMap.size() - 10)
				.forEach(
						entry -> data.append("         [")
								.append(RequestProcessor.countryMap.get(entry.getKey()).get(Constants.FIRST_ELEMENT)
										.getName())
								.append("                  ").append(entry.getValue().size()).append("]")
								.append(Constants.LINE_SEPERATOR));
		response.setData(data.append(Constants.HEADER_MAKER).toString());
		return response;
	}

	public static ResponseObject typeOfRunwaysPerCountry() {
		StringBuilder builder = new StringBuilder(Constants.HEADER_MAKER);
		DataStore.getDataStore().getCountryData().stream().forEach(country -> {
			// to avoid duplicate surfaces of same type per country
			Set<String> runwaySurfaceSet = new HashSet<String>();
			builder.append(Constants.LINE_SEPERATOR);
			builder.append(country);
			if (RequestProcessor.countryAirportMap.containsKey(country.getCode())) {
				RequestProcessor.countryAirportMap.get(country.getCode()).forEach(airport -> {
					// If there is a run ways then bring runway data
					if (RequestProcessor.airportRunwayMap.containsKey(airport.getId())) {
						RequestProcessor.airportRunwayMap.get(airport.getId()).forEach(runway -> {
							runwaySurfaceSet.add(runway.getSurface());
						});
					}
				});
			}
			builder.append(Constants.LINE_SEPERATOR);
			builder.append(Constants.RUNWAYS_SURFACES).append(runwaySurfaceSet);
		});
		ResponseObject response = new ResponseObject();
		response.setData(builder.append(Constants.HEADER_MAKER).toString());
		return response;
	}

	public static ResponseObject topTenMostComonRunwayLatitude() {
		ResponseObject response = new ResponseObject();
		StringBuilder data = new StringBuilder(Constants.HEADER_MAKER)
				.append("    Ten most common runway latitude" + Constants.LINE_SEPERATOR);
		DataStore.getDataStore().getRunwayData().stream()
				.collect(Collectors.groupingBy(Runway::getLeIdent, Collectors.counting())).entrySet().stream()
				.sorted(Map.Entry.comparingByValue(Comparator.<Long> reverseOrder())).limit(10)
				.forEach(e -> data.append("\t[" + e.getKey()).append("            ").append(e.getValue()).append("]")
						.append(Constants.LINE_SEPERATOR));
		response.setData(data.append(Constants.HEADER_MAKER).toString());
		return response;
	}
}
