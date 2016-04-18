package org.rest.util;

import org.rest.exception.RestConsumerException;

import java.util.Collection;

/**
 * Created by TJ on 4/18/2016.
 */
public class ValidationUtils {

    public static void validateNotEmpty(Collection collection, String fieldName){
        validateNotNull(collection, fieldName);

        if(collection.isEmpty())
            throwException(fieldName, " cannot be empty");
    }

    public static void validateNotEmpty(String string, String fieldName){
        validateNotNull(string, fieldName);

        if(string.isEmpty())
            throwException(fieldName, " cannot be empty");
    }

    public static void validateNotNull(Object object, String fieldName){
        if(object == null)
            throwException(fieldName, " cannot be null");
    }

    private static void throwException(String fieldName, String message) {
        throw new RestConsumerException(fieldName + message);
    }
}
