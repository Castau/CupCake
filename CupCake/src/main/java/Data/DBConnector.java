package Data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * Command for handling the database connection
 * 
 * @author Camilla
 */
public class DBConnector {

    private final String IP = "207.154.233.238";
    private final String PORT = "3306";
    public final String DATABASE = "cupcake";
    private final String USERNAME = "admin";
    private final String PASSWORD = "1234";
    private Connection connection = null;

    /**
     * Constructor for the database connector. Establishes the connection and
     * saves the connection in the field connection
     * 
     * @throws SQLException when error occurs while establishing connection to 
     * the database
     */
    public DBConnector() throws SQLException {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver").newInstance();

            String url = "jdbc:mysql://" + IP + ":" + PORT + "/" + DATABASE;

            Properties props = new Properties();
            props.put("user", USERNAME);
            props.put("password", PASSWORD);
            props.put("allowMultiQueries", true);
            props.put("useUnicode", true);
            props.put("useJDBCCompliantTimezoneShift", true);
            props.put("useLegacyDatetimeCode", false);
            props.put("serverTimezone", "CET");
            this.connection = DriverManager.getConnection(url, props);
            System.out.println("Connection correctly established to the database: " + DATABASE);
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException ex) {
            ex.printStackTrace();
            throw new SQLException(ex.getMessage());
        }
    }
    
    /**
     * Returns the connection
     * 
     * @return connection
     */
    public Connection getConnection() {
        return this.connection;
    }
}
