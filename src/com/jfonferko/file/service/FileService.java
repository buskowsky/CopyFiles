package com.jfonferko.file.service;

import com.jfonferko.file.context.Context;
import com.jfonferko.file.context.Result;
import com.jfonferko.file.dao.PathContentReader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

public class FileService {

    private PathContentReader pathContentReader;
    private Context context;

    public FileService(Context context) {
        this.context = context;
        this.pathContentReader = new PathContentReader(context);
    }

    public void copyFiles() throws IOException {
        Result result = new Result();
        for (String filename : pathContentReader.getFileList()) {
            File location = new File(context.getPathFrom() + filename);
            File destination = new File(context.getPathTo() + filename);

            if (destination.exists()) {
                Result.getNoCopiedFiles().add(location.toString());
            } else {
                Files.copy(location.toPath(), destination.toPath());
                Result.getCopiedFiles().add(location.toString());
            }
        }
    }
}