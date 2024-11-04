package org.example.metadataextraction;

import org.example.exception.MetadataExtractionException;

import java.io.File;

/**
 * Utility class for validating files before metadata extraction.
 */
public class FileValidator {

    public static void validateFile(File file) throws MetadataExtractionException {

        if (file == null)
            throw new MetadataExtractionException("Error: The provided file is null. Please ensure a valid file path is given.");
        if (!file.exists())
            throw new MetadataExtractionException("Error: The file at '" + file.getAbsolutePath() + "' does not exist.");
        if (!file.isFile())
            throw new MetadataExtractionException("Error: The path '" + file.getAbsolutePath() + "' is not a valid file.");

    }

}

