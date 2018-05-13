package lesson34.homework.task1;

import java.io.*;

public class Solution {
    public static void transferFileContent(String fileFromPath, String fileToPath) throws Exception {
        validate(fileFromPath, fileToPath);

        writeToFile(fileToPath, readFromFile(fileFromPath));

        clearFile(fileFromPath);
    }

    private static void clearFile(String path) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path))) {
            bufferedWriter.append("");
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }

    private static boolean isFileEmpty(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            if (br.readLine() != null)
                return false;
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }

        return true;
    }

    private static StringBuffer readFromFile(String path) {
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                res.append(line);
                res.append("\r\n");
            }

            res.replace(res.length() - 1, res.length(), "");
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.err.println("Reading from file " + path + " failed");
        }

        return res;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            if (!isFileEmpty(path))
                bufferedWriter.append("\r\n");

            bufferedWriter.append(contentToWrite);
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
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

        if (!fileFrom.canWrite()) {
            throw new Exception("File " + fileFromPath + " does not have permission to write");
        }

        if (!fileTo.canWrite()) {
            throw new Exception("File " + fileToPath + " does not have permission to written");
        }
    }
}
