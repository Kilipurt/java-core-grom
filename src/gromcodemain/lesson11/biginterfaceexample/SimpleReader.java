package gromcodemain.lesson11.biginterfaceexample;

public class SimpleReader implements Readable {

    @Override
    public void readFilesFromStorage(Storage storage) {
        if (storage == null || storage.getFiles() == null)
            return;
        for (File file : storage.getFiles()) {
            if (file != null)
                System.out.println(file.getName());
            else
                System.out.println(file);
        }
    }
}
