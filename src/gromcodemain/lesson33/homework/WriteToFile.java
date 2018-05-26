package gromcodemain.lesson33.homework;

import org.apache.commons.io.IOUtils;

import java.io.*;

public class WriteToFile {
    public static void writeToFileFromConsole(String path) throws FileNotFoundException {
        File file = new File(path);
        if (!file.exists())
            throw new FileNotFoundException("File with path " + path + " not found");

        FileWriter writer = null;
        BufferedWriter bufferedWriter = null;

        try {
            writer = new FileWriter(path, true);
            bufferedWriter = new BufferedWriter(writer);

            System.out.println("Enter file content to write in the file");
            String text = readFromConsole();

            bufferedWriter.newLine();
            bufferedWriter.append(text);
        } catch (IOException e) {
            System.err.println("Can't write to file with path " + path);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        } finally {
            IOUtils.closeQuietly(bufferedWriter);
            IOUtils.closeQuietly(writer);
        }
    }

    private static String readFromConsole() throws Exception {

        InputStreamReader reader = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(reader);

        try {
            return br.readLine();
        } catch (IOException e) {
            System.err.println("Reading from console failed");
        } finally {
            IOUtils.closeQuietly(reader);
            IOUtils.closeQuietly(br);
        }

        throw new Exception("Unexpected exception");
    }
}
