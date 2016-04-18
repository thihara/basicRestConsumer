package org.rest.json;

import org.rest.model.City;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.Collection;

import static org.testng.Assert.*;

public class JSONParserTest {

    @DataProvider(name = "cityJSONEmpty")
    public static Object[][] jsonCitiesInvalid() {
        return new Object[][] {{null}, {"[]"}};
    }

    @DataProvider(name = "cityJSON")
    public static Object[][] jsonCitiesValid() {
        return new Object[][] {{"[{'_id':376217,'key':null,'name':'Berlin','fullName':'Berlin, Germany'," +
                "'iata_airport_code':null,'type':'location','country':'Germany','geo_position':{'latitude':52.52437," +
                "'longitude':13.41053},'locationId':8384,'inEurope':true,'countryCode':'DE','coreCountry':true," +
                "'distance':null},{'_id':448103,'key':null,'name':'Berlingo','fullName':'Berlingo, Italy'," +
                "'iata_airport_code':null,'type':'location','country':'Italy','geo_position':{'latitude':45.50298," +
                "'longitude':10.04366},'locationId':147721,'inEurope':true,'countryCode':'IT','coreCountry':true," +
                "'distance':null},{'_id':425332,'key':null,'name':'Berlingerode','fullName':'Berlingerode, Germany'," +
                "'iata_airport_code':null,'type':'location','country':'Germany','geo_position':{'latitude':51.45775," +
                "'longitude':10.2384},'locationId':124675,'inEurope':true,'countryCode':'DE','coreCountry':true," +
                "'distance':null},{'_id':425326,'key':null,'name':'Bernau bei Berlin','fullName':'Bernau bei Berlin, " +
                "Germany','iata_airport_code':null,'type':'location','country':'Germany','geo_position':" +
                "{'latitude':52.67982,'longitude':13.58708},'locationId':124669,'inEurope':true,'countryCode':'DE'," +
                "'coreCountry':true,'distance':null},{'_id':314826,'key':null,'name':'Berlin Tegel'," +
                "'fullName':'Berlin Tegel (TXL), Germany','iata_airport_code':'TXL','type':'airport','country':'Germany'" +
                ",'geo_position':{'latitude':52.5548,'longitude':13.28903},'locationId':null,'inEurope':true," +
                "'countryCode':'DE','coreCountry':true,'distance':null},{'_id':314827,'key':null," +
                "'name':'Berlin Schönefeld','fullName':'Berlin Schönefeld (SXF), Germany','iata_airport_code':'SXF'," +
                "'type':'airport','country':'Germany','geo_position':{'latitude':52.3887261,'longitude':13.5180874}," +
                "'locationId':null,'inEurope':true,'countryCode':'DE','coreCountry':true,'distance':null}," +
                "{'_id':334098,'key':null,'name':'Berlin Spandau','fullName':'Berlin Spandau, Germany'," +
                "'iata_airport_code':null,'type':'station','country':'Germany','geo_position':{'latitude':52.53447," +
                "'longitude':13.19753},'locationId':null,'inEurope':true,'countryCode':'DE','coreCountry':true," +
                "'distance':null},{'_id':334196,'key':null,'name':'Berlin Hbf','fullName':'Berlin Hbf, Germany'," +
                "'iata_airport_code':null,'type':'station','country':'Germany','geo_position':{'latitude':52.525589," +
                "'longitude':13.369548},'locationId':null,'inEurope':true,'countryCode':'DE','coreCountry':true," +
                "'distance':null}]"}};
    }

    @Test(dataProvider = "cityJSONEmpty")
    public void testParseCitiesInvalid(String jsonCities) throws Exception {
        Collection<City> cities = JSONParser.parseCities(jsonCities);
        assertNotNull(cities);
        assertEquals(cities.size(),0);
    }

    @Test(dataProvider = "cityJSON")
    public void testParseCities(String jsonCities) throws Exception {
        Collection<City> cities = JSONParser.parseCities(jsonCities);
        assertNotNull(cities);
        assertEquals(cities.size(),8);
    }
}