package org.rest.json;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import org.rest.model.City;

import java.lang.reflect.Type;
import java.util.Collection;
import java.util.Collections;

/**
 * Created by TJ on 4/17/2016.
 * Manages JSON parsing.
 */
public class JSONParser {
    private final static Gson gson = new Gson();

    public final static Type collectionType = new TypeToken<Collection<City>>(){}.getType();

    /**
     * Parses a JSON string into City objects.
     * @param jsonCities JSON string containing the city data.
     * @return Collection of parsed city information. Or an empty Collection if no data is present.
     */
    public static Collection<City> parseCities(String jsonCities){
        if(jsonCities == null)
            return Collections.emptyList();

        return gson.fromJson(jsonCities,collectionType);
    }
}
