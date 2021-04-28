package airport.details.data;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.stream.Collectors;

import airport.details.entities.Airport;
import airport.details.entities.Country;
import airport.details.entities.Runway;
import airport.details.exception.ProcessingException;
import com.opencsv.CSVParser;
import com.opencsv.CSVReader;

public class DataStore {

	private static DataStore dataStore = null;

	private static List<Country> countryData;

	private static List<Airport> airportData;

	private static List<Runway> runwayData;

	// private constructor to make singleton object
	private DataStore() {

	}

	public static DataStore getDataStore() {
		if (dataStore == null) {
			dataStore = new DataStore();
		}
		return dataStore;
	}

	public List<Country> getCountryData() {
		return countryData;
	}

	public List<Airport> getAirportData() {
		return airportData;
	}

	public List<Runway> getRunwayData() {
		return runwayData;
	}

	public void loadData() throws ProcessingException {
		countryData = readCsvFile("countries.csv").parallelStream().map(Country::new).collect(Collectors.toList());
		airportData = readCsvFile("airports.csv").parallelStream().map(Airport::new).collect(Collectors.toList());
		runwayData = readCsvFile("runways.csv").parallelStream().map(Runway::new).collect(Collectors.toList());
	}

	/*
	 * @Description : Load the data from csv file, Read whole data at once
	 * 
	 */
	private static List<String[]> readCsvFile(String fileName) throws ProcessingException {
		try (CSVReader reader = new CSVReader(
				new BufferedReader(
						new InputStreamReader(DataStore.class.getClassLoader().getResourceAsStream(fileName))),
				CSVParser.DEFAULT_SEPARATOR, CSVParser.DEFAULT_QUOTE_CHARACTER, 1)) {
			return reader.readAll();
		} catch (IOException e) {
			throw new ProcessingException("Error while loading data for " + fileName);
		}
	}
}
