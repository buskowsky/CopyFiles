package com.jfonferko.file.context;

import java.util.LinkedList;
import java.util.List;

public class Result {

    private static List<String> copiedFiles = new LinkedList<>();
    private static List<String> noCopiedFiles = new LinkedList<>();
    private static int copiedFilesCount;
    private static int noCopiedFilesCount;


    public static List<String> getCopiedFiles() {
        return copiedFiles;
    }

    public static void setCopiedFiles(List<String> copiedFiles) {
        Result.copiedFiles = copiedFiles;
    }

    public static List<String> getNoCopiedFiles() {
        return noCopiedFiles;
    }

    public static void setNoCopiedFiles(List<String> noCopiedFiles) {
        Result.noCopiedFiles = noCopiedFiles;
    }

    public static int getCopiedFilesCount() {
        return copiedFiles.size();
    }

    public static void setCopiedFilesCount(int copiedFilesCount) {
        Result.copiedFilesCount = copiedFilesCount;
    }

    public static int getNoCopiedFilesCount() {
        return noCopiedFiles.size();
    }

    public static void setNoCopiedFilesCount(int noCopiedFilesCount) {
        Result.noCopiedFilesCount = noCopiedFilesCount;
    }
}
