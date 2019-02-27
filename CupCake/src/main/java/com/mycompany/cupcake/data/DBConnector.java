package com.mycompany.cupcake.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Camilla
 */
public class DBConnector {

    private final String IP = "207.154.233.238";
    private final String PORT = "3306";
    public final String DATABASE = "cupcake";
    private final String USERNAME = "camilla";
    private final String PASSWORD = "1234";
    private Connection connection = null;

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
    
    public Connection getConnection() {
        return this.connection;
    }
}
