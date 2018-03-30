package lesson19.homework;

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

    public boolean isFull() {
        if (files == null)
            return true;

        boolean isArrayFull = true;

        for (File file : files) {
            if (file == null)
                isArrayFull = false;
        }

        return isArrayFull || (filesContainedSize() == this.storageSize);
    }

    public boolean isTrueFormat(String type) {
        if (type == null || formatsSupported == null)
            return false;

        for (String format : formatsSupported) {
            if (type.equals(format))
                return true;
        }

        return false;
    }

    public boolean isFileContained(File file) {
        if (files == null || file == null)
            return false;

        for (File f : files) {
            if (f != null && file.getId() == f.getId())
                return true;
        }

        return false;
    }

    public boolean isEnoughSpaceForTransferAllFiles(Storage storageTo) {
        if (files == null || storageTo.files == null)
            return false;

        int numberOfFiles = 0;
        int transmittedFilesSize = 0;

        for (File file : files) {
            if (file != null && !storageTo.isFileContained(file)) {
                numberOfFiles++;
                transmittedFilesSize += file.getSize();
            }
        }

        int numberOfFreeCells = 0;

        for (File file : storageTo.files) {
            if (file == null)
                numberOfFreeCells++;
        }

        return numberOfFreeCells >= numberOfFiles && transmittedFilesSize <= storageTo.storageSize - storageTo.filesContainedSize();
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

    public int filesContainedSize() {
        int storageSize = 0;

        for (File file : files) {
            if (file != null)
                storageSize += file.getSize();
        }

        return storageSize;
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
