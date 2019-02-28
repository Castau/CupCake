package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author Shevitar
 */
public class Mapper_CupCake
{
    public Model_CupCake getCupCake(int tID, int bID) throws SQLException
    {
        DBConnector c = new DBConnector();
        Connection conn = c.getConnection();
        String query = "SELECT * FROM Cupcake_top JOIN Cupcake_bottom WHERE id_top = ? AND id_bottom = ?";
        PreparedStatement stmt = c.getConnection().prepareStatement(query);
<<<<<<< HEAD
        stmt.setString(1, "" + tID);
        stmt.setString(2, "" + bID);
=======
        stmt.setInt(1, tID);
        stmt.setInt(2, bID);
>>>>>>> 04fb3923fa209bc12bef11a97969fd42d78dce98
        ResultSet rs = stmt.executeQuery(query);
        Model_CupCake cupCake = null;
        while(rs.next())
        {
            String topName = rs.getString("top_name");
            String bottomName = rs.getString("bottom_name");
            double topPrice = Integer.parseInt(rs.getString("top_price"));
            double bottomPrice = Integer.parseInt(rs.getString("bottom_price"));
            cupCake = new Model_CupCake(bID, tID, bottomName, topName, bottomPrice, topPrice);
        }
        return cupCake;
    }
    
    public ArrayList<Model_CupCake> getAllCupCakes() throws SQLException
    {
        DBConnector c = new DBConnector();
        Connection conn = c.getConnection();
        String query = "SELECT * FROM Cupcake_top JOIN Cupcake_bottom;";
        ResultSet rs = conn.createStatement().executeQuery(query);
        ArrayList<Model_CupCake> allCupCakes = new ArrayList();
        Model_CupCake cupCake = null;
        while(rs.next())
        {
            int topID = Integer.parseInt(rs.getString("id_top"));
            int bottomID = Integer.parseInt(("id_bottom"));
            String topName = rs.getString("top_name");
            String bottomName = rs.getString("bottom_name");
            double topPrice = Integer.parseInt(rs.getString("top_price"));
            double bottomPrice = Integer.parseInt(rs.getString("bottom_price"));
            cupCake = new Model_CupCake(topID, bottomID, bottomName, topName, bottomPrice, topPrice);
            allCupCakes.add(cupCake);
        }
        return allCupCakes;
    }
    
    
}
