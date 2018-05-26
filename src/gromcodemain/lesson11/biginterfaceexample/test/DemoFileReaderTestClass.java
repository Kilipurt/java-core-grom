package gromcodemain.lesson11.biginterfaceexample.test;

import gromcodemain.lesson11.biginterfaceexample.File;
import gromcodemain.lesson11.biginterfaceexample.FileReader;
import gromcodemain.lesson11.biginterfaceexample.Storage;

public class DemoFileReaderTestClass {
    public static void main(String[] args) {
        File file1 = new File("test", "C:/user/home", "txt", 11);
        File file2 = new File("test", "C:/user/home", "txt", 11);
        File file3 = new File("video", "C:/user/home", "txt", 11);
        File file4 = new File("test", "C:/user/home", "txt", 11);
        File file5 = new File("myhome", "C:/user/home", "jpg", 120);

        File[] files = new File[]{file1, file2, file3, file4, file5};
        File[] files1 = new File[]{file1, file2, file3, null, file4, file5};
        File[] files2 = null;

        FileReader fileReader = new FileReader();

        //findMaxSizeFile(File[] files)
        //ищет файл с макс. размером +
        //если файл равен null +
        //если массив равен null +

        System.out.println(fileReader.findMaxSizeFile(files));

        System.out.println(fileReader.findMaxSizeFile(files1));

        System.out.println(fileReader.findMaxSizeFile(files2));

        //readFilesFromStorage(Storage storage)
        //выводит файл с найбольшым размером +
        //если storage равен null +
        //если массив файлов в storage равен null +

        Storage storage = new Storage(files);
        Storage storage1 = new Storage(files2);
        Storage storage2 = null;

        fileReader.readFilesFromStorage(storage);

        fileReader.readFilesFromStorage(storage2);

        fileReader.readFilesFromStorage(storage1);

        //printFile(File file)
        //выводит всю информацию о файле +
        //если файл равен null +

        File newFile = null;

        fileReader.printFile(file1);

        fileReader.printFile(newFile);
    }
}
