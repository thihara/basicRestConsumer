package org.rest.connection;

import org.rest.exception.RestConsumerException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class HTTPConnectionManagerTest {

    @DataProvider(name = "invalidURLProvider")
    public static Object[][] jsonCitiesInvalid() {
        return new Object[][] {{null}, {""}, {"this is an invalid URL"}};
    }

    @DataProvider(name = "URLProvider")
    public static Object[][] jsonCities() {
        return new Object[][] {{"http://google.com"}, {"http://api.goeuro.com/api/v2/position/suggest/en/Berlin"}};
    }

    @Test(expectedExceptions = RestConsumerException.class, dataProvider ="invalidURLProvider" )
    public void testGETInvalidURL(String URL) throws Exception {
        HTTPConnectionManager.GET(URL);
    }

    @Test(dataProvider = "URLProvider")
    public void testGET(String URL) throws Exception {
        String response = HTTPConnectionManager.GET(URL);
        assertNotNull(response);
    }
}