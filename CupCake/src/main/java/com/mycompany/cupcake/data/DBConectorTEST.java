package com.mycompany.cupcake.data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Camilla
 */
public class DBConectorTEST {
    public static void main(String[] args) throws SQLException {
        System.out.println("RUNNING");
        
        DBConnector db = new DBConnector();
        Connection conn = db.getConnection();
        String res = "";
        
        String sqlQuery = "SELECT * FROM cupcake.Cupcake_bottom;";
        ResultSet rs = conn.prepareStatement(sqlQuery).executeQuery();

        while (rs.next()) {
            res= rs.getString("bottom_name");
        }
        
        System.out.println(res);
    }
    
}
