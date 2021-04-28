package airport.details.constants;

public class Constants {

	public static final String LINE_SEPERATOR = System.getProperty("line.separator").toString();

	public static final String TAB_SEPERATOR = "\t";
	
	public static final String SYSTEM_EXIT = "0";
	
	public static final String FIRST_OPTION = "1";
	
	public static final String REPORT_TOP_10_HIGHEST_AND_LOWEST_NUMBER_AIPORTS = "1";
	
	public static final String REPORT_INPUT = "2";
	
	public static final String REPORT_RUNWAY_PER_COUNTRY = "2";
	
	public static final String REPORT_10_MOST_COMMON_RUNWAY = "3";
	
	public static final String RETURN_TO_MAIN_MENU = "5";

	public static final String HEADER_MAKER = LINE_SEPERATOR+"======================================================================================="+LINE_SEPERATOR;
	
	public static final String MAIN_MENU = "===================================================================================="+LINE_SEPERATOR				
									   + "																				        "+LINE_SEPERATOR
									   + "                       Welcome To Aiport Information System						    "+LINE_SEPERATOR											
									   + "																					    "+LINE_SEPERATOR
									   + "===================================================================================="+LINE_SEPERATOR
									   + "            Enter 1 for query"+LINE_SEPERATOR
									   + "            Enter 2 for Report"+LINE_SEPERATOR
									   + "            Enter 0 to Exit"+LINE_SEPERATOR;
	
	public static final String REPORT_MENU = "===================================================================================="+LINE_SEPERATOR				
			   + "																				       "+LINE_SEPERATOR
			   + "                         Welcome To Aiport Report Page											"+LINE_SEPERATOR											
			   + "																					   "+LINE_SEPERATOR
			   + "===================================================================================="+LINE_SEPERATOR
			   + "            Enter 1 for 10 countries with highest and lowest number of airports"+LINE_SEPERATOR
			   + "            Enter 2 for Type of runways per country"+LINE_SEPERATOR
			   + "            Enter 3 to Print the top 10 most common runway latitude"+LINE_SEPERATOR
			   + "            Enter 5 to main menu"+LINE_SEPERATOR
			   + "            Enter 0 to Exit"+LINE_SEPERATOR;
	
	public static final String EXIT_OR_GO_TO_MAIN_MENU = "            Enter 5 to main menu"+LINE_SEPERATOR
												       + "            Enter 0 to Exit"+LINE_SEPERATOR;
	
	public static final String APPLICATION_EXIT = "Closing the application....";
	
	public static final String COUNTRY_QUERY_DETAIL = "Please enter the contry code or country name :";
	
	public static final String ENTER_CHOICE = "Please enter your choice : ";
	
	public static final int FIRST_ELEMENT = 0;
	
	public static final String RUNWAYS_SURFACES = "Runways Surfaces ";
	
	public static final String NO_COUNTRY_FOUND = "No country record found for given search criteria : ";
	
	public static final String CHOOSE_VALID_INPUT = "Please choose the valid input..";
}
