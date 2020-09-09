package ReactJavaProject.nursePatientTest.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    private Connection _connection=null;
    public Connection getDBconnection(){
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            _connection= DriverManager.getConnection("jdbc:oracle:thin:@199.212.26.208:1521:SQLD", "comp214_f19_zor_9","password");
            System.out.println("Successfull connection");
        } catch(ClassNotFoundException e) {
            System.err.println("ERROR! oracle.jdbc.OracleDriver not found.");
        }
        catch(SQLException e) {

            System.err.println("ERROR! Couldn't connect to the DB: " + e.getMessage());
        }
        return _connection;
    }

}
