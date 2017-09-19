package com.jfonferko.file.context;

import com.jfonferko.file.expcetion.InvalidPathException;

import java.io.File;

public class Context {

    private final static String INVALID_BASE_PATH = "Nieprawidłowa ścieżka";
    private final static String INVALID_DESTINATION_PATH = "Katalog docelowy nie isniteje, tworzę katalog.";


    private String sourcePath;
    private String destinationPath;

    public Context(String sourcePath, String destinationPath) throws InvalidPathException {
        this.sourcePath = sourcePath;
        this.destinationPath = destinationPath;
        if (!isBaseFolderCorrect(sourcePath))
            throw new InvalidPathException(INVALID_BASE_PATH);
        if (!isDestinationFolderCorrect(destinationPath)) {
            createFolder(destinationPath);
            System.out.println(INVALID_DESTINATION_PATH);
        }
    }

    private boolean isBaseFolderCorrect(String pathFrom) {
        File baseFolder = new File(pathFrom);
        return baseFolder.isDirectory();
    }

    private boolean isDestinationFolderCorrect(String pathToReplace) {
        File destinationFolder = new File(pathToReplace);
        return (destinationFolder.exists() || destinationFolder.isDirectory());
    }

    private void createFolder(String folderName) {
        new File(folderName).mkdir();
    }

    public String getSourcePath() {
        return sourcePath;
    }

    public void setSourcePath(String sourcePath) {
        this.sourcePath = sourcePath;
    }

    public String getDestinationPath() {
        return destinationPath;
    }

    public void setDestinationPath(String destinationPath) {
        this.destinationPath = destinationPath;
    }
}