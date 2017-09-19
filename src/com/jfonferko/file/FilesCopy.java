package com.jfonferko.file;

import com.jfonferko.file.context.Context;
import com.jfonferko.file.context.Result;
import com.jfonferko.file.service.FileService;

public class FilesCopy {

    public static void main(String[] args) {
        String path = "c:\\Temp\\SQLDeveloper\\";
        String pathToReplace = "c:\\Temp\\replace\\";

        try {
            Context context = new Context(path, pathToReplace);
            FileService fileService = new FileService(context);
            fileService.copyFiles();

        } catch (Exception e) {

            System.out.println(e.getCause());
        }

        if (!Result.getCopiedFiles().isEmpty()) {
            System.out.println("Skopiowane pliki: " + Result.getCopiedFilesCount());
            for (String filename : Result.getCopiedFiles()) {
                System.out.println(filename);
            }
        }

        if (!Result.getNoCopiedFiles().isEmpty()) {
            System.out.println("Nie skopiowane pliki: " + Result.getNoCopiedFilesCount());
            for (String filename : Result.getNoCopiedFiles()) {
                System.out.println(filename);
            }
        }
    }
}