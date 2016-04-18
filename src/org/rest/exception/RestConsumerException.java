package org.rest.exception;

/**
 * Created by TJ on 4/18/2016.
 */
public class RestConsumerException extends RuntimeException{

    public RestConsumerException() {
        super();
    }

    public RestConsumerException(String message) {
        super(message);
    }

    public RestConsumerException(String message, Throwable cause) {
        super(message, cause);
    }

    public RestConsumerException(Throwable cause) {
        super(cause);
    }
}
