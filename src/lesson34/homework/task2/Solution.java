package lesson34.homework.task2;

import java.io.*;
import java.util.regex.Pattern;

public class Solution {
    public static void transferSentences(String fileFromPath, String fileToPath, String word) throws Exception {
        validate(fileFromPath, fileToPath);

        StringBuffer fileToContent = new StringBuffer();
        StringBuffer fileFromContent = new StringBuffer();

        String[] sentences = Pattern.compile("\\.").split(readFromFile(fileFromPath));

        for (String sentence : sentences) {
            if (sentence.length() > 10 && isSentenceContainWord(sentence, word)) {
                fileToContent.append(sentence).append(".");
            } else {
                if (!sentence.isEmpty()) {
                    fileFromContent.append(sentence).append(".");
                }
            }
        }

        if (!isFileEmpty(fileToPath)) {
            fileToContent.insert(0, "\r\n");
        }

        writeToFile(fileToPath, fileToContent, true);
        writeToFile(fileFromPath, fileFromContent, false);
    }

    private static boolean isSentenceContainWord(String sentence, String word) {
        String[] words = sentence.split(" ");

        for (String w : words) {
            if (w != null && w.equals(word))
                return true;
        }

        return false;
    }

    private static void writeToFile(String path, StringBuffer contentToWrite, boolean append) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, append))) {
            bufferedWriter.append(contentToWrite);
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

    private static StringBuffer readFromFile(String path) throws Exception {
        StringBuffer res = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                res.append(line);
            }

        } catch (IOException e) {
            throw new IOException("Can't read file with path  " + path);
        }

        return res;
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
