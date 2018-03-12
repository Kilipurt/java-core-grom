package lesson10.abstractfirstexample;

public abstract class DbProvider {
    private String dbHost;

    public DbProvider(String dbHost) {
        this.dbHost = dbHost;
    }

    public abstract void connectToDb();

    public abstract void disconnectFromDb();

    public void printDbHost(){
        System.out.println("DB host is" + dbHost);
    }
}
