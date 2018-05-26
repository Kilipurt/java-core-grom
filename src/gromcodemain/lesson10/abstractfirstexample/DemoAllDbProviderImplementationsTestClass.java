package gromcodemain.lesson10.abstractfirstexample;

public class DemoAllDbProviderImplementationsTestClass {
    public static void main(String[] args) {

        MySQLProvider mySQLProvider = new MySQLProvider("r");
        OracleDbProvider oracleDbProvider = new OracleDbProvider("g");
        PostgreSQLDbProvider postgreSQLDbProvider = new PostgreSQLDbProvider("f");

        //printDbHost()
        //выводит DbHost +

        mySQLProvider.printDbHost();
        oracleDbProvider.printDbHost();
        postgreSQLDbProvider.printDbHost();
    }
}
