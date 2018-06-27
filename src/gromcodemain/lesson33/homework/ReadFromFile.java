package gromcodemain.lesson33.homework;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class ReadFromFile {
    public static void readFileByConsolePath() throws Exception {
        String path = readPathFromConsole();

        FileReader reader;

        try {
            reader = new FileReader(path);
        } catch (FileNotFoundException e) {
            System.err.println("File with path " + path + " not found");
            return;
        }

        BufferedReader br = new BufferedReader(reader);

        try {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Can't read file by path " + path);
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }
    }

    private static String readPathFromConsole() throws Exception {
        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        System.out.println("Please, enter file path to read:");

        try {
            return br.readLine();
        } catch (IOException e) {
            System.err.println("Reading from console failed");
        } finally {
            IOUtils.closeQuietly(br);
            IOUtils.closeQuietly(reader);
        }

        throw new Exception("Unexpected exception");
    }
}