package com.example.connectdb;

import java.io.File;
import java.util.Arrays;
import java.util.Comparator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RenameFilesController {

    @GetMapping("rename-file")
    public int renameFile() {

        int start = 34 + 1;
        int seq = 0;
        String path = "C:/Users/KOOKKIK.SWW/Desktop/New folder/";

        File directory = new File(path);
        int fileCount = directory.list().length;
        System.out.println("File Count:" + fileCount);

        File[] listOfFiles = directory.listFiles();

        Arrays.sort(listOfFiles, Comparator.comparingLong(File::lastModified));

        for (int i = 0; i < listOfFiles.length; i++) {

            if (listOfFiles[i].isFile()) {

                seq = start + i;

                System.out.println("Name file:" + listOfFiles[i].getName());

                File f = new File(path + listOfFiles[i].getName());

                f.renameTo(new File(path + "Screenshot_" + seq + ".png"));
            }
        }

        return fileCount;
    }

}
