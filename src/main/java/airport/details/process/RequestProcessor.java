package airport.details.process;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import airport.details.constants.Constants;
import airport.details.data.DataStore;
import airport.details.dataflow.RequestObject;
import airport.details.dataflow.ResponseObject;
import airport.details.entities.Airport;
import airport.details.entities.Country;
import airport.details.entities.Runway;

public class RequestProcessor {

	public static Map<String, List<Airport>> countryAirportMap = null;

	public static Map<String, List<Runway>> airportRunwayMap = null;

	public static Map<String, List<Country>> countryMap = null;

	// private static RequestProcessor
	@SuppressWarnings("unchecked")
	public static ResponseObject processQueryRequest(RequestObject request) {

		ResponseObject response = new ResponseObject();
		Country countryData = null;
		// get the country details
		if (!countryMap.getOrDefault(request.getSearchString().toUpperCase(), Collections.EMPTY_LIST).isEmpty()) {
			countryData = countryMap.get(request.getSearchString().toUpperCase()).get(Constants.FIRST_ELEMENT);
		} else {
			Optional<Country> optionalCountry = DataStore.getDataStore().getCountryData().parallelStream().filter(
					country -> country.getName().toUpperCase().contains(request.getSearchString().toUpperCase()))
					.findFirst();
			if (optionalCountry.isPresent()) {
				countryData = optionalCountry.get();
			} else {
				response.setErrorMessage(Constants.NO_COUNTRY_FOUND + request.getSearchString());
				return response;
			}
		}
		// add the country details
		StringBuilder builder = new StringBuilder(Constants.HEADER_MAKER).append(Constants.LINE_SEPERATOR);
		builder.append(countryData);
		// add the corresponding airport and its corresponding runways
		if (countryAirportMap.containsKey(countryData.getCode())) {
			countryAirportMap.get(countryData.getCode()).forEach(airport -> {
				builder.append(Constants.LINE_SEPERATOR).append(Constants.TAB_SEPERATOR).append(airport);
				// If there is a run ways then bring runway data
				if (airportRunwayMap.containsKey(airport.getId())) {
					airportRunwayMap.get(airport.getId()).forEach(runway -> {
						builder.append(Constants.LINE_SEPERATOR).append(Constants.TAB_SEPERATOR)
								.append(Constants.TAB_SEPERATOR).append(runway);
					});
				}
			});
		}
		response.setData(builder.append(Constants.HEADER_MAKER).toString());
		return response;
	}

	/*
	 * @Description : Initialize the static data used to full fill query
	 * requests
	 * 
	 */
	public static void initializeQueryData() {
		countryAirportMap = DataStore.getDataStore().getAirportData().stream()
				.collect(Collectors.groupingBy(aiport -> aiport.getIsoCountry()));
		airportRunwayMap = DataStore.getDataStore().getRunwayData().stream()
				.collect(Collectors.groupingBy(Runway::getAirportRef));
		countryMap = DataStore.getDataStore().getCountryData().stream()
				.collect(Collectors.groupingBy(Country::getCode));

	}
}
