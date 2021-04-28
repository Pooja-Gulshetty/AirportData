package airport.details.daemon;

import java.util.Scanner;

import airport.details.constants.Constants;
import airport.details.data.DataStore;
import airport.details.dataflow.RequestObject;
import airport.details.dataflow.ResponseObject;
import airport.details.exception.ProcessingException;
import airport.details.process.ReportProcessor;
import airport.details.process.RequestProcessor;

public class MainDaemon {

	public static void main(String[] args) {
		// initialize the data
		try {
			init();
		} catch (ProcessingException exp) {
			System.out.println("Error accurred while loading the data.");
		}
		// start
		displayMenu();
	}

	private static void init() throws ProcessingException {
		DataStore store = DataStore.getDataStore();
		store.loadData();
		RequestProcessor.initializeQueryData();
	}

	private static void displayMenu() {
		System.out.println("Data loaded successfully!"+ Constants.LINE_SEPERATOR+Constants.LINE_SEPERATOR);
		// execute repeatedly
		@SuppressWarnings("resource")
		Scanner in = new Scanner(System.in);
		String input = null;
		ResponseObject response = null;
		while (true) {
			System.out.println(Constants.MAIN_MENU);
			System.out.println(Constants.ENTER_CHOICE);
			input = in.next();
			if (input.equalsIgnoreCase(Constants.SYSTEM_EXIT)) {
				System.exit(Integer.valueOf(Constants.SYSTEM_EXIT));
			}
			switch (input) {
			case Constants.FIRST_OPTION:
				boolean isGoToMainMenuFromQuery = false;
				// if it is in main menu then as for input query
				while (true) {
					if (isGoToMainMenuFromQuery)
						break;
					System.out.println(Constants.EXIT_OR_GO_TO_MAIN_MENU);
					System.out.println(Constants.COUNTRY_QUERY_DETAIL);
					input = in.next();
					switch (input) {
					case Constants.SYSTEM_EXIT:
						System.out.println(Constants.APPLICATION_EXIT);
						System.exit(0);
						break;
					case Constants.RETURN_TO_MAIN_MENU:
						isGoToMainMenuFromQuery = true;
						break;

					default:
						RequestObject request = new RequestObject();
						request.setSearchString(input);
						response = RequestProcessor.processQueryRequest(request);
						if (response.getErrorMessage() != null) {
							System.out.println(response.getErrorMessage());
						} else {
							System.out.println(response.getData());
						}
						break;
					}
				}
				break;
			case Constants.REPORT_INPUT:
				boolean isGoToMainManuFromReport = false;
				while (true) {
					if (isGoToMainManuFromReport)
						break;
					System.out.println(Constants.REPORT_MENU);
					System.out.println(Constants.ENTER_CHOICE);
					input = in.next();
					switch (input) {
					case Constants.SYSTEM_EXIT:
						System.out.println(Constants.APPLICATION_EXIT);
						System.exit(0);
						break;
					case Constants.RETURN_TO_MAIN_MENU:
						isGoToMainManuFromReport = true;
						break;

					case Constants.REPORT_TOP_10_HIGHEST_AND_LOWEST_NUMBER_AIPORTS:
						response = ReportProcessor.countryWithHighestAndLowestAirports();
						System.out.println(response.getData());
						break;

					case Constants.REPORT_RUNWAY_PER_COUNTRY:
						response = ReportProcessor.typeOfRunwaysPerCountry();
						System.out.println(response.getData());
						break;

					case Constants.REPORT_10_MOST_COMMON_RUNWAY:
						response = ReportProcessor.topTenMostComonRunwayLatitude();
						System.out.println(response.getData());
						break;

					default:
						System.out.println(Constants.CHOOSE_VALID_INPUT);
						break;
					}
				}
				break;
			default:
				System.out.println(Constants.CHOOSE_VALID_INPUT);
				break;
			}
		}
	}
}
