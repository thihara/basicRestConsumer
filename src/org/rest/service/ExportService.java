package org.rest.service;

import org.rest.csv.CSVExporter;
import org.rest.model.City;
import org.rest.util.ValidationUtils;

import java.util.Collection;
import java.util.stream.Collectors;

/**
 * Created by TJ on 4/17/2016.
 */
public class ExportService {

    public static final String DEFAULT_FILE_NAME = "cities.csv";
    public static final String CSV_SEPARATOR = ",";

    public void exportToCSV(Collection<City> cities, String fileName){

        ValidationUtils.validateNotEmpty(cities, "Cities");

        ValidationUtils.validateNotEmpty(fileName, "File Name");

        Collection<String> csvFileEntries = cities.stream().map(city -> getCSVRepresentation(city)).
                collect(Collectors.toList());

        CSVExporter.writeToCSV(csvFileEntries, fileName);
    }

    public void exportToCSV(Collection<City> cities){
        exportToCSV(cities, DEFAULT_FILE_NAME);
    }

    private String getCSVRepresentation(City city) {
        return city.get_id()+ CSV_SEPARATOR +city.getName()+ CSV_SEPARATOR +city.getType()+ CSV_SEPARATOR +city.getGeo_position().getLatitude()+
                CSV_SEPARATOR +city.getGeo_position().getLongitude();
    }
}
