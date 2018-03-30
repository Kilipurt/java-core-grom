package lesson19.homework;

public class Controller {

    public void put(Storage storage, File file) throws Exception {
        if (storage == null || file == null)
            return;

        boolean isEnoughSpaceForFile = storage.filesContainedSize() + file.getSize() <= storage.getStorageSize();

        if (storage.isFull() || !storage.isTrueFormat(file.getFormat()) || storage.isFileContained(file) || !isEnoughSpaceForFile) {
            throw new Exception("File " + file.getId() + " can not be added to storage " + storage.getId());
        } else {
            storage.addFile(file);
        }
    }

    public void delete(Storage storage, File file) throws Exception {
        if (storage == null || file == null)
            return;

        if (!storage.isFileContained(file)) {
            throw new Exception("File " + file.getId() + " can not be found in storage " + storage.getId());
        } else {
            storage.deleteFile(file);
        }
    }

    public void transferFile(Storage storageFrom, Storage storageTo, long id) throws Exception {
        if (storageFrom == null || storageTo == null)
            return;

        File transmittedFile = null;

        if(storageFrom.getFiles() != null) {
            for (File file : storageFrom.getFiles()) {
                if (file != null && file.getId() == id)
                    transmittedFile = file;
            }
        }

        Exception e = new Exception("File " + id + " was not transmitted from storage " + storageFrom.getId() + " to storage " + storageTo.getId());

        if(transmittedFile == null)
            throw e;

        try{
            put(storageTo, transmittedFile);
        }catch (Exception ex){
            throw e;
        }

        storageFrom.deleteFile(transmittedFile);
    }

    public void transferAll(Storage storageFrom, Storage storageTo) throws Exception {
        if (storageFrom == null || storageTo == null)
            return;

        Exception e = new Exception("Files can not be transmitted from storage " + storageFrom.getId() + " to storage " + storageTo.getId());

        if(!storageFrom.isEnoughSpaceForTransferAllFiles(storageTo))
            throw e;

        for(File file : storageFrom.getFiles()){
            if(file != null && !storageTo.isTrueFormat(file.getFormat()))
                throw e;
        }

        for (File file : storageFrom.getFiles()) {
            if (file != null && !storageTo.isFileContained(file)) {
                storageTo.addFile(file);
            }
        }

        for(File file : storageFrom.getFiles()){
            if(file != null){
                storageFrom.deleteFile(file);
            }
        }
    }
}
