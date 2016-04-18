package org.rest.csv;

import org.rest.exception.RestConsumerException;
import org.rest.util.ValidationUtils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Collection;

/**
 * Created by TJ on 4/18/2016.
 * Handles writing data to a file.
 */
public class CSVExporter {

    /**
     * Writes to a file line by line.
     * @param csvEntries The lines to be written in a collection as Strings. Each String in the collection will be
     *                   written in separate lines.
     * @param fileName File name to be written.
     * @throws RestConsumerException if writing to the file writing fails
     */
    public static void writeToCSV(Collection<String> csvEntries, String fileName){

        try(final BufferedWriter csvWriter = new BufferedWriter(new FileWriter(fileName))) {

            for(String csvLine:csvEntries) {
                csvWriter.write(csvLine);
                csvWriter.newLine();
            }
        } catch(IOException e){
            throw new RestConsumerException("Unable to write to the file.", e);
        }
    }
}
