package lesson34;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadWriteFile {
    public static void main(String[] args) {
        readFile("D:\\JavaProjects\\test.txt");

        writeFile("D:\\JavaProjects\\test1.txt", null);
    }

    private static void readFile(String path) {
        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (FileNotFoundException e) {
            System.err.println("File does not exist");
        } catch (IOException e) {
            System.out.println("Reading from file " + path + " failed");
        }
    }

    private static void writeFile(String path, String content) {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(path, true))) {
            bufferedWriter.append("\n");
            bufferedWriter.append(content);
        } catch (IOException e) {
            System.err.println("Can't write to file");
        }
    }
}
