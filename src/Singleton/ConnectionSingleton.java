package Singleton;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionSingleton {
	private static final String DRIVER = "net.sourceforge.jtds.jdbc.Driver";
	private static final String hostName = "192.168.99.103";
	private static final String	dbName = "ClinicaDentista";
	private static final String	user = "sa";
	private static final String	senha= "Lucastopn0x";
    private static ConnectionSingleton instance = null;
    private Connection con;

    public static ConnectionSingleton getInstance() {
        if (instance == null) {
            instance = new ConnectionSingleton();
        }
        return instance;
    }

    private ConnectionSingleton() {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        try {
            if (con == null || con.isClosed()) {
                con = DriverManager.getConnection(String.format(
                		"jdbc:jtds:sqlserver://%s:1433;databaseName=%s;user=%s;password=%s;", hostName, dbName, user, senha));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return con;
    }
}