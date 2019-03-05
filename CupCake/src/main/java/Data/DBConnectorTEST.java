package Data;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Camilla
 */
public class DBConnectorTEST {
    public static void main(String[] args) throws SQLException {
        System.out.println("RUNNING");
        
        DBConnector db = new DBConnector();
        Connection conn = db.getConnection();
        String res = "";
        
        String sqlQuery = "SELECT password FROM cupcake.User";
        ResultSet rs = conn.prepareStatement(sqlQuery).executeQuery();

        while (rs.next()) {
            res= rs.getString("password");
        }
        System.out.println(res);
    }
    
}
