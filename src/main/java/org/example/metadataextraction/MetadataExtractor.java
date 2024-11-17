package org.example.metadataextraction;

import com.drew.imaging.ImageMetadataReader;
import com.drew.imaging.ImageProcessingException;
import com.drew.metadata.Directory;
import com.drew.metadata.Metadata;
import com.drew.metadata.Tag;
import org.example.exception.MetadataExtractionException;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class responsible for extracting metadata from image files.
 */
public class MetadataExtractor {

    public Map<String, String> extractMetadata(File file) throws MetadataExtractionException {

        //Validating the file
        //FileValidator.validateFile(file);

        Map<String, String> metadataMap = new HashMap<>();

        try {

            //Trying to read metadata
            Metadata metadata = ImageMetadataReader.readMetadata(file);

            //Processing metadata
            for (Directory d : metadata.getDirectories()) {
                for (Tag t : d.getTags()) {
                    metadataMap.put(t.getTagName(), t.getDescription());
                }
            }

        } catch (ImageProcessingException e) {

            throw new MetadataExtractionException("Error reading the file " + file.getName() + " is not a processed image format.", e);

        } catch (IOException e) {

            throw new MetadataExtractionException("Error reading the file: " + file.getName(), e);

        }

        return metadataMap;

    }

}
