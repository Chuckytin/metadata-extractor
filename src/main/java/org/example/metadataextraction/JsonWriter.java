package org.example.metadataextraction;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.example.exception.MetadataExtractionException;

import java.io.File;
import java.io.IOException;
import java.util.Map;

/**
 * Utility class for writing metadata to a JSON file.
 */
public class JsonWriter {

    public static void writeMetadataToJson(Map<String, String> metadataMap, File outputFile) throws MetadataExtractionException {

        ObjectMapper objectMapper = new ObjectMapper();

        try {

            //Converts metadata to JSON and saves then to a file
            objectMapper.writeValue(outputFile, metadataMap);

        } catch (IOException e) {
            throw new MetadataExtractionException("ERROR: Unable to write metadata to JSON.", e);
        }

    }

}
