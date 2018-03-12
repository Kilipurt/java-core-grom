package lesson10.abstractfirstexample;

public class PostgreSQLDbProvider extends DbProvider{

    public PostgreSQLDbProvider(String dbHost) {
        super(dbHost);
    }

    @Override
    public void connectToDb(){

    }

    @Override
    public void disconnectFromDb(){

    }
}
