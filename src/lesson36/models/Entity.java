package lesson36.models;

public abstract class Entity {

    public abstract long getId();

    public abstract void setId(long id);

    public abstract boolean equals(Object o);

    public  abstract int hashCode();
}
