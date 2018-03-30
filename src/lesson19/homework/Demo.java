package lesson19.homework;

public class Demo {

    public static void main(String[] args) {
        File file1 = null;
        File file2 = null;
        File file3 = null;
        File file4 = null;
        File file5 = null;
        File file6 = null;
        File file7 = null;
        File file8 = null;

        try {
            file1 = new File(1, "file1", "txt", 7);
            file2 = new File(2, "file2", "jpg", 7);
            file3 = new File(3, "file3", "jpeg", 7);
            file4 = new File(4, "file4", "jpg", 7);
            file5 = new File(5, "file5", "txt", 7);
            file6 = new File(6, "file6", "txt", 7);
            file7 = new File(7, "file7", "txt", 7);
            file8 = new File(8, "file8", "xml", 7);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        File[] files1 = new File[5];
        files1[0] = file1;
        files1[1] = file2;
        files1[2] = file3;

        File[] files2 = new File[5];
        files2[0] = file5;
        files2[1] = file6;
        files2[2] = file7;

        String[] formatsSupported1 = {"txt", "jpg", "jpeg"};
        String[] formatsSupported2 = {"txt"};

        Storage storage1 = new Storage(1, files1, formatsSupported1, "Ukraine", 28);
        Storage storage2 = new Storage(2, files2, formatsSupported2, "Germany", 28);

        Controller controller = new Controller();

        System.out.println("Test put() 1:");
        testPut(storage1, file4, controller);

        System.out.println("Test put() 2:");
        testPut(storage1, file8, controller);

        System.out.println("Test put() 3:");
        testPut(storage1, null, controller);

        System.out.println("Test delete() 1:");
        testDelete(storage1, file4, controller);

        System.out.println("Test delete() 2:");
        testDelete(storage1, file5, controller);

        System.out.println("Test delete() 3:");
        testDelete(storage1, null, controller);

        System.out.println("Test transferFile() 1:");
        testTransferFile(storage1, storage2, 5, controller);

        System.out.println("Test transferFile() 2:");
        testTransferFile(storage1, storage2, 2, controller);

        System.out.println("Test transferFile() 3:");
        testTransferFile(storage1, storage2, 8, controller);

        System.out.println("Test transferAll() 1:");
        testTransferAll(storage1, storage2, controller);

        System.out.println("Test transferAll() 2:");
        testTransferAll(storage2, storage1, controller);

        System.out.println("Test transferAll() 3:");
        testTransferAll(null, storage1, controller);
    }

    public static void testPut(Storage storage, File file, Controller controller) {
        System.out.println("Before:\n" + storage.toString());

        try {
            controller.put(storage, file);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("After:\n" + storage.toString());
    }

    public static void testDelete(Storage storage, File file, Controller controller) {
        System.out.println("Before:\n" + storage.toString());

        try {
            controller.delete(storage, file);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("After:\n" + storage.toString());
    }

    public static void testTransferFile(Storage storageFrom, Storage storageTo, long id, Controller controller) {
        System.out.println("Before:\n" + storageFrom.toString() + "\n" + storageTo.toString());

        try {
            controller.transferFile(storageFrom, storageTo, id);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        System.out.println("After:\n" + storageFrom.toString() + "\n" + storageTo.toString());
    }

    public static void testTransferAll(Storage storageFrom, Storage storageTo, Controller controller) {
        if (storageFrom != null)
            System.out.println("Before:\n" + storageFrom.toString() + "\n" + storageTo.toString());
        else
            System.out.println("Before:\n" + null + "\n" + storageTo.toString());

        try {
            controller.transferAll(storageFrom, storageTo);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }

        if (storageFrom != null)
            System.out.println("After:\n" + storageFrom.toString() + "\n" + storageTo.toString());
        else
            System.out.println("After:\n" + null + "\n" + storageTo.toString());
    }
}
