package gromcodemain.lesson11.biginterfaceexample.test;

import gromcodemain.lesson11.biginterfaceexample.File;
import gromcodemain.lesson11.biginterfaceexample.SimpleReader;
import gromcodemain.lesson11.biginterfaceexample.Storage;

public class DemoSimpleReaderTestClass {
    public static void main(String[] args) {
        File file1 = new File("test", "C:/user/home", "txt", 11);
        File file2 = new File("test", "C:/user/home", "txt", 11);
        File file3 = new File("video", "C:/user/home", "txt", 11);
        File file4 = new File("test", "C:/user/home", "txt", 11);
        File file5 = new File("myhome", "C:/user/home", "jpg", 120);

        File[] files = new File[]{file1, file2, file3, file4, file5};
        Storage storage = new Storage(files);

        SimpleReader simpleReader = new SimpleReader();

        //readFilesFromStorage(Storage storage)
        //выводит названия всех файлов +
        //если файл равен null +
        //если storage равен null +
        //если массив файлов в storage равен null +

        simpleReader.readFilesFromStorage(storage);

        File[] files1 = {null, null, null};
        Storage storage1 = new Storage(files1);
        simpleReader.readFilesFromStorage(storage1);

        simpleReader.readFilesFromStorage(null);

        File[] files2 = null;
        Storage storage2 = new Storage(files2);
        simpleReader.readFilesFromStorage(storage2);


    }
}
