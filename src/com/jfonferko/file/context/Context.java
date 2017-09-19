package com.jfonferko.file.context;

import com.jfonferko.file.expcetion.InvalidPathException;

import java.io.File;

public class Context {

    private File file;
    private String pathFrom;
    private String pathTo;

    public Context(String pathFrom, String pathTo) throws InvalidPathException {
        this.pathFrom = pathFrom;
        this.pathTo = pathTo;
        File folder = new File(pathFrom);
        if (!isPathCorrect(folder))
            throw new InvalidPathException("Nieprawidłowa ścieżka");
        isPathToReplaceCorrect(pathTo);
    }

    private boolean isPathCorrect(File path) {
        file = new File(path.getPath());
        if (file.isDirectory()) {
            return true;
        }
        return false;
    }

    private void isPathToReplaceCorrect(String pathToReplace) {
        File f = new File(pathToReplace);
        if (!f.exists() || !f.isDirectory()) {
            System.out.println("Folder " + pathToReplace + " nie istnieje. Tworzę folder.");
            new File(pathToReplace).mkdir();
        }
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public String getPathFrom() {
        return pathFrom;
    }

    public void setPathFrom(String pathFrom) {
        this.pathFrom = pathFrom;
    }

    public String getPathTo() {
        return pathTo;
    }

    public void setPathTo(String pathTo) {
        this.pathTo = pathTo;
    }
}