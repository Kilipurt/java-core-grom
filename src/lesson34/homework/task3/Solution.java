package lesson34.homework.task3;

import org.apache.commons.io.FileUtils;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class Solution {
    public static void copyFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);

        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        Files.copy(fileFrom.toPath(), fileTo.toPath(), StandardCopyOption.REPLACE_EXISTING);
    }

    public static void copyFileContentApacheIO(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);
        FileUtils.copyFile(new File(fileFromPath), new File(fileToPath));
    }

    private static void validate(String fileFromPath, String fileToPath) throws Exception {
        File fileFrom = new File(fileFromPath);
        File fileTo = new File(fileToPath);

        if (!fileFrom.exists()) {
            throw new FileNotFoundException("File " + fileFromPath + " does not exist");
        }

        if (!fileTo.exists()) {
            throw new FileNotFoundException("File " + fileToPath + " does not exist");
        }

        if (!fileFrom.canRead()) {
            throw new Exception("File " + fileFromPath + " does not have permission to read");
        }

        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileToPath + " does not have permission to written");
        }
    }
}
