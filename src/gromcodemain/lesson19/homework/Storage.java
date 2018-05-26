package gromcodemain.lesson19.homework;

import java.util.Arrays;

public class Storage {
    private long id;
    private File[] files;
    private String[] formatsSupported;
    private String storageCountry;
    private long storageSize;

    public Storage(long id, File[] files, String[] formatsSupported, String storageCountry, long storageSize) {
        this.id = id;
        this.files = files;
        this.formatsSupported = formatsSupported;
        this.storageCountry = storageCountry;
        this.storageSize = storageSize;
    }

    public long getId() {
        return id;
    }

    public File[] getFiles() {
        return files;
    }

    public String[] getFormatsSupported() {
        return formatsSupported;
    }

    public String getStorageCountry() {
        return storageCountry;
    }

    public long getStorageSize() {
        return storageSize;
    }

    public void setStorageSize(long storageSize) {
        this.storageSize = storageSize;
    }

    public void addFile(File file) {
        for (int i = 0; i < files.length; i++) {
            if (files[i] == null) {
                files[i] = file;
                break;
            }
        }
    }

    public void deleteFile(File file) {
        for (int i = 0; i < files.length; i++) {
            if (file.equals(files[i])) {
                files[i] = null;
                break;
            }
        }
    }

    public void transferAllFiles(Storage storageTo) {
        for (File file : files) {
            if (file != null && !StorageValidator.isFileContained(storageTo, file)) {
                storageTo.addFile(file);
            }
        }

        for (File file : files) {
            if (file != null) {
                deleteFile(file);
            }
        }
    }

    public int filesContainedSize() {
        int storageSize = 0;

        for (File file : files) {
            if (file != null)
                storageSize += file.getSize();
        }

        return storageSize;
    }

    public File getFileById(long id) {
        if (files != null) {
            for (File file : files) {
                if (file != null && file.getId() == id)
                    return file;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "id=" + id +
                ", files=" + Arrays.toString(files) +
                ", formatsSupported=" + Arrays.toString(formatsSupported) +
                ", storageCountry='" + storageCountry + '\'' +
                ", storageSize=" + storageSize +
                '}';
    }
}
