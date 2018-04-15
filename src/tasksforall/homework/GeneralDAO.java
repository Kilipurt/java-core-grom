package tasksforall.homework;

public class GeneralDAO<T> {

    @SuppressWarnings("unchecked")
    private T[] array = (T[]) new Object[10];

    public T save(T t) throws Exception {
        validate(t);

        int index = 0;
        for (T obj : array) {
            if (obj == null) {
                array[index] = t;
                return array[index];
            }
            index++;
        }

        throw new Exception("Unexpected exception");
    }

    private void validate(T t) throws Exception {
        if (t == null)
            throw new Exception("Can't save empty object");

        if (!isEnoughSpace())
            throw new Exception("Don't enough space for saving object");

        T object = search(t);
        if (object != null)
            throw new Exception("Object already saved");
    }

    private boolean isEnoughSpace() {
        for (T t : array) {
            if (t == null)
                return true;
        }

        return false;
    }

    private T search(T t) {
        for (T object : array) {
            if (object != null && object.equals(t))
                return t;
        }

        return null;
    }

    public T[] getAll() throws Exception {
        int count = 0;
        for (T t : array) {
            if (t != null)
                count++;
        }

        if (count == 0)
            throw new Exception("Array is empty");

        @SuppressWarnings("unchecked")
        T[] allObjects = (T[]) new Object[count];

        int index = 0;
        for (T t : array) {
            if (t != null) {
                allObjects[index] = t;
                index++;
            }
        }

        return allObjects;
    }
}
