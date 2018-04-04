package lesson19.homework;

public class StorageValidator {

    public static boolean isFull(Storage storage, File file) {
        if (storage.getFiles() == null)
            return true;

        boolean isEnoughSpaceForFile = storage.filesContainedSize() + file.getSize() > storage.getStorageSize();

        for (File f : storage.getFiles()) {
            if (f == null)
                return isEnoughSpaceForFile;
        }

        return true;
    }

    public static boolean isTrueFormat(Storage storage, String type) {
        if (type == null || storage.getFormatsSupported() == null)
            return false;

        for (String format : storage.getFormatsSupported()) {
            if (type.equals(format))
                return true;
        }

        return false;
    }

    public static boolean isFileContained(Storage storage, File file) {
        if (storage.getFiles() == null || file == null)
            return false;

        for (File f : storage.getFiles()) {
            if (f != null && file.getId() == f.getId())
                return true;
        }

        return false;
    }

    public static boolean isPossibleToTransferAllFiles(Storage storageFrom, Storage storageTo) {
        if (storageFrom.getFiles() == null || storageTo.getFiles() == null)
            return false;

        int numberOfFiles = 0;
        int transmittedFilesSize = 0;

        for (File file : storageFrom.getFiles()) {
            if (file != null && !isFileContained(storageTo, file)) {
                numberOfFiles++;
                transmittedFilesSize += file.getSize();
            }
        }

        int numberOfFreeCells = 0;

        for (File file : storageTo.getFiles()) {
            if (file == null)
                numberOfFreeCells++;
        }

        for (File file : storageFrom.getFiles()) {
            if (file != null && !isTrueFormat(storageTo, file.getFormat()))
                return false;
        }

        return numberOfFreeCells >= numberOfFiles && transmittedFilesSize <= storageTo.getStorageSize() - storageTo.filesContainedSize();
    }
}
