# Metadata Extraction

## Descripción

Programa Java que permite extraer metadatos de archivos multimedia (imágenes y videos) y guardarlos en un archivo JSON. 

## Bibliotecas utilizadas
[metadata-extractor](https://github.com/drewnoakes/metadata-extractor) para la extracción de metadatos.
[Jackson](https://github.com/FasterXML/jackson) para la conversión de los metadatos a formato JSON.

## Características

- Extrae metadatos de archivos de imagen o vídeo.
- Valida los archivos antes de intentar extraer los metadatos.
- Guarda los metadatos extraídos en un archivo JSON.
- Maneja excepciones y errores.

## Requisitos

- Java 11 o superior.
- Maven para la gestión de dependencias.
