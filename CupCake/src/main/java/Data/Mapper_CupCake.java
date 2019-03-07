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
        String query = "SELECT * FROM Cupcake_top JOIN Cupcake_bottom WHERE id_top = ? AND id_bottom = ?;";
        PreparedStatement stmt = c.getConnection().prepareStatement(query);
        stmt.setInt(1, tID);
        stmt.setInt(2, bID);
        ResultSet rs = stmt.executeQuery();
        Model_CupCake cupCake = null;
        while (rs.next())
        {
            String topName = rs.getString("top_name");
            String bottomName = rs.getString("bottom_name");
            double topPrice = rs.getDouble("top_price");
            double bottomPrice = rs.getDouble("bottom_price");
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
        while (rs.next())
        {
            int topID = rs.getInt("id_top");
            int bottomID = rs.getInt("id_bottom");
            String topName = rs.getString("top_name");
            String bottomName = rs.getString("bottom_name");
            double topPrice = rs.getDouble("top_price");
            double bottomPrice = rs.getDouble("bottom_price");
            cupCake = new Model_CupCake(topID, bottomID, bottomName, topName, bottomPrice, topPrice);
            allCupCakes.add(cupCake);
        }
        return allCupCakes;
    }

}
