package com.jfonferko.file.dao;

import com.jfonferko.file.context.Context;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class PathContentReader {

    private Context context;
    private List<String> fileList;
    private List<String> directoryList;

    public PathContentReader(Context context) {
        this.context = context;
        fileList = new LinkedList<String>();
        directoryList = new LinkedList<String>();
        listFilesForFolder(context.getFile());
    }

    private void listFilesForFolder(File folderPath) {
        for (File fileEntry : folderPath.listFiles()) {
            if (fileEntry.isDirectory()) {
                directoryList.add(fileEntry.getName());
            } else {
                fileList.add(fileEntry.getName());
            }
        }
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public List<String> getFileList() {
        return fileList;
    }

    public void setFileList(List<String> fileList) {
        this.fileList = fileList;
    }

    public List<String> getDirectoryList() {
        return directoryList;
    }

    public void setDirectoryList(List<String> directoryList) {
        this.directoryList = directoryList;
    }
}