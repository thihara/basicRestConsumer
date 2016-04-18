package org.rest;

import org.rest.model.City;
import org.rest.service.CityService;
import org.rest.service.ExportService;

import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Main entry point into the application.
 */
public class Main {

    private static final Logger log = Logger.getLogger(Main.class.getName());

    private final static CityService cityService = new CityService();

    private final static ExportService exportService = new ExportService();

    public static void main(String[] args) {
        try{

            if (args.length < 1)
                severeError("Missing City Name argument. The usage pattern for this application is : " +
                        "java -jar <RestConsumer Jar File Name>.jar <CityName>");

            Collection<City> cities = cityService.loadCities(args[0]);

            if(cities.isEmpty())
                severeError("No cities found for the given name.");

            exportService.exportToCSV(cities);
        }catch (Exception e){
            severeError(e.getMessage());
        }
    }

    private static void severeError(String msg) {
        log.log(Level.SEVERE, msg);
        System.exit(1);
    }
}
