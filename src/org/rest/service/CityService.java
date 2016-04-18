package org.rest.service;

import org.rest.connection.HTTPConnectionManager;
import org.rest.json.JSONParser;
import org.rest.model.City;
import org.rest.util.ValidationUtils;

import java.util.Collection;

/**
 * Created by TJ on 4/17/2016.
 */
public class CityService {

    private final String END_POINT="http://api.goeuro.com/api/v2/position/suggest/en/";

    public Collection<City> loadCities(String cityName) {
        ValidationUtils.validateNotEmpty(cityName, "City Name");

        String jsonResponse = HTTPConnectionManager.GET(END_POINT+cityName);

        Collection<City> cities = JSONParser.parseCities(jsonResponse);

        return cities;
    }
}
