package org.example.app;

import org.example.exception.MetadataExtractionException;

/**
 * Main class to run the Metadata Extraction application.
 */
public class Main {

    public static void main(String[] args) {

        MetadataApp metadataApp = new MetadataApp();

        try {

            metadataApp.run(args);

        } catch (MetadataExtractionException e) {

            System.err.println(e.getMessage());

        }

    }

}
