package gromcodemain.lesson10.abstractfirstexample;

public class OracleDbProvider extends DbProvider{

    public OracleDbProvider(String dbHost) {
        super(dbHost);
    }

    @Override
    public void connectToDb(){

    }

    @Override
    public void disconnectFromDb(){

    }
}
