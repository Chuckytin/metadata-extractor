package org.example.exception;

/**
 * Custom exception class for handling metadata extraction errors.
 */
public class MetadataExtractionException extends Exception {

    public MetadataExtractionException(String message, Throwable cause) {
        super(message, cause);
    }

    public MetadataExtractionException(String message) {
        super(message);
    }
}
