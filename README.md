# AirportDetails

Provide airport and runway details in a country
## Description

## Supported operation
*  Query Option will ask the user for the country name or code and print the airports & runways at each airport. The input can be country code or country name. Also, partial/fuzzy. e.g. entering zimb will result in Zimbabwe :)
* Choosing Reports will print the following:
    1. 10 countries with highest number of airports (with count)
    2. countries  with lowest number of airports.
    3. Type of runways (as indicated in "surface" column) per country 
    4. Print the top 10 most common runway latitude (indicated in "le_ident" column)

## Available resources
* [Country](/countries/{countryCode})
* [Airports](/countries/{countryCode}/airports)
* [Runways in a country](/countries/{countryCode}/runways)
* [Runways in of a airport](/airports/{airportId}/runways)
* [10 Countries having highest number of airports](/countries/highestAirports)


# Corresponding RestAPI implementation is
https://github.com/Pooja-Gulshetty/AirportDetails

## project can be build using maven
```
$ mvn clean install
```

## Run project
Can run the jar file directly as it has the data files in resource directory no other external details required
```
$ java -jar target/AiportDetails-1.0-SNAPSHOT.jar
```

## Tests
Needs to be implemented

# public data files: Data files: https://ourairports.com/data/