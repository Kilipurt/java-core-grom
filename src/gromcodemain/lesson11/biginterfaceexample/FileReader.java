package gromcodemain.lesson11.biginterfaceexample;

public class FileReader implements Readable {

    @Override
    public void readFilesFromStorage(Storage storage) {
        if(storage == null || storage.getFiles() == null)
            return;
        printFile(findMaxSizeFile(storage.getFiles()));
    }

    public File findMaxSizeFile(File[] files) {
        if(files == null)
            return null;
        File maxSizeFile = files[0];

        for (File file : files) {
            if (file != null && file.getSize() > maxSizeFile.getSize()) {
                maxSizeFile = file;
            }
        }
        return maxSizeFile;
    }

    public void printFile(File file) {
        if(file == null)
            return;
        System.out.println("max file will be printed now...");

        System.out.println(file.getName());
        System.out.println(file.getExtension());
        System.out.println(file.getPath());
        System.out.println(file.getSize());
        System.out.println();
    }
}
