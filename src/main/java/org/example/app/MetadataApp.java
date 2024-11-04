package org.example.app;

import org.example.exception.MetadataExtractionException;
import org.example.metadataextraction.FileValidator;
import org.example.metadataextraction.JsonWriter;
import org.example.metadataextraction.MetadataExtractor;

import java.io.File;
import java.util.Map;

/**
 * Class representing the main application for extracting metadata from files.
 */
public class MetadataApp {

    public void run(String[] args) throws MetadataExtractionException {

        if (args.length == 0) {
            throw new MetadataExtractionException("ERROR: No file provided.");
        }

        //Creating a file
        String filePath = args[0];
        File file = new File(filePath);

        //Validating the file
        FileValidator.validateFile(file);

        //Adding .json
        String jsonFileName = file.getAbsolutePath() + ".json";
        File jsonOutput = new File(jsonFileName);

        MetadataExtractor metadataExtractor = new MetadataExtractor();
        Map<String, String> metadataMap;

        try {

            //Extracting metadata
            metadataMap = metadataExtractor.extractMetadata(file);

        } catch (MetadataExtractionException e) {
            throw new MetadataExtractionException("ERROR: Unable to extract metadata from the file: " + e.getMessage(), e);
        }

        try {

            //Writing metadata to JSON file
            JsonWriter.writeMetadataToJson(metadataMap, jsonOutput);

        } catch (MetadataExtractionException e) {
            throw new MetadataExtractionException("ERROR: Unable to write metadata to JSON: " + e.getMessage(), e);
        }

        System.out.println("Metadata successfully extracted to: " + jsonOutput.getAbsolutePath());
    }

}
