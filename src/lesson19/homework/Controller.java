package lesson19.homework;

public class Controller {

    public void put(Storage storage, File file) throws Exception {
        if (storage == null || file == null)
            return;

        if (StorageValidator.isFull(storage, file) || !StorageValidator.isTrueFormat(storage, file.getFormat()) || StorageValidator.isFileContained(storage, file))
            throw new Exception("File " + file.getId() + " can not be added to storage " + storage.getId());

        storage.addFile(file);
    }

    public void delete(Storage storage, File file) throws Exception {
        if (storage == null || file == null)
            return;

        File fileToDelete = storage.getFileById(file.getId());

        if (!file.equals(fileToDelete))
            throw new Exception("File " + file.getId() + " can not be found in storage " + storage.getId());

        storage.deleteFile(file);
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        if (storageFrom == null || storageTo == null)
            return;

        File transmittedFile = storageFrom.getFileById(id);
//
        if (transmittedFile == null)
            throw new Exception("File " + id + " was not transmitted from storage " + storageFrom.getId() + " to storage " + storageTo.getId());

        put(storageTo, transmittedFile);
        storageFrom.deleteFile(transmittedFile);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        if (storageFrom == null || storageTo == null)
            return;

        if (!StorageValidator.isPossibleToTransferAllFiles(storageFrom, storageTo))
            throw new Exception("Files can not be transmitted from storage " + storageFrom.getId() + " to storage " + storageTo.getId());

        storageFrom.transferAllFiles(storageTo);
    }
}