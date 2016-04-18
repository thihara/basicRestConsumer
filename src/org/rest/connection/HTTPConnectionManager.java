package org.rest.connection;

import org.rest.exception.RestConsumerException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.util.stream.Collectors;

/**
 * Created by TJ on 4/17/2016.
 * Handles connecting via http methods.
 */
public class HTTPConnectionManager {

    public static final String GET = "GET";
    public static final String APPLICATION_JSON_MIME = "application/json";
    public static final String ACCEPT_HEADER = "Accept";

    /**
     * Retrieves the URL data from the given URL if successfull connection is established and the http response is
     * OK (200 response code).
     * @param endPointURL Valid URL
     * @return The response string returned by the http GET request.
     * @throws RestConsumerException if connection establishment fails, or if the server returns a response code other
     * than HTTP OK (200)
     */
    public static String GET(String endPointURL) {
        HttpURLConnection connection;

        try {
            URL url = new URL(endPointURL);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod(GET);
            connection.setRequestProperty(ACCEPT_HEADER, APPLICATION_JSON_MIME);

            if (connection.getResponseCode() != HttpURLConnection.HTTP_OK) {
                throw new RestConsumerException("Failed : HTTP error code : "
                        + connection.getResponseCode());
            }

            return readResponse(connection);
        } catch (MalformedURLException e) {
            throw new RestConsumerException("URL is incorrect.", e);
        } catch (IOException e) {
            throw new RestConsumerException("Unable to establish connection.", e);
        }
    }

    private static String readResponse(HttpURLConnection conn) throws IOException {
        try (BufferedReader buffer = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            return buffer.lines().collect(Collectors.joining(System.lineSeparator()));
        }
    }
}
