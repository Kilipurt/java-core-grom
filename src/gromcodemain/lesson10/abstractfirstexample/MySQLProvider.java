package gromcodemain.lesson10.abstractfirstexample;

public class MySQLProvider extends DbProvider{

    public MySQLProvider(String dbHost) {
        super(dbHost);
    }

    @Override
    public void connectToDb(){

    }

    @Override
    public void disconnectFromDb() {

    }
}
