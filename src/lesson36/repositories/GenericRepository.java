package lesson36.repositories;

import lesson36.exceptions.ObjectNotFoundException;
import lesson36.models.Entity;

import java.io.*;
import java.util.ArrayList;
import java.util.regex.Pattern;

public abstract class GenericRepository<T extends Entity> {

    private String path;

    public void setPath(String path) {
        this.path = path;
    }

    public T create(T t) throws Exception {
        generateId(t);

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            File file = new File(path);

            if (file.length() != 0) {
                bw.newLine();
            }

            bw.append(reverseMap(t));
        } catch (IOException e) {
            System.err.println("Object with id " + t.getId() + " was not saved");
        }

        return t;
    }

    public boolean isObjectExist(T t) {
        if (getAll().size() == 0)
            return false;

        for (T obj : getAll()) {
            if (obj != null && obj.equals(t)) {
                return true;
            }
        }

        return false;
    }

    private void generateId(T t) {
        boolean flag = true;
        while (flag) {
            t.setId((long) (Math.random() * 50000000));
            if (findById(t.getId()) == null)
                flag = false;
        }
    }

    public ArrayList<T> getAll() {
        StringBuffer allObjects = new StringBuffer();

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            String line;

            while ((line = br.readLine()) != null) {
                allObjects.append(line).append("\r\n");
            }

        } catch (IOException e) {
            e.getMessage();
        }

        return mapAll(allObjects);
    }

    public T findById(long id) {
        ArrayList<T> all = getAll();

        if (all.size() == 0)
            return null;

        for (T obj : all) {
            if (obj.getId() == id)
                return obj;
        }

        return null;
    }

    public T find(T t) {
        for (T obj : getAll()) {
            if (obj != null && obj.equals(t)) {
                return obj;
            }
        }

        return null;
    }

    public void remove(T t) throws Exception {
        if (!isObjectExist(t))
            throw new ObjectNotFoundException("Object was not found");

        ArrayList<T> allObjects = getAll();

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, false))) {
            int count = 1;
            for (T obj : allObjects) {
                if (!obj.equals(t)) {
                    bw.append(reverseMap(obj));

                    if (allObjects.size() != count) {
                        bw.newLine();
                    }
                }

                count++;
            }
        } catch (Exception e) {
            System.err.println("Object with id " + t.getId() + " was not deleted");
        }
    }

    public abstract T map(String obj);

    private ArrayList<T> mapAll(StringBuffer all) {
        ArrayList<T> allObjects = new ArrayList<>();

        String[] objects = Pattern.compile("\r\n").split(all);

        for (String obj : objects) {

            allObjects.add(map(obj));
        }

        return allObjects;
    }

    public abstract String reverseMap(T obj);
}
