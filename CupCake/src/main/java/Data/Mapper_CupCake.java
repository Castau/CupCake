package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;

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
            double topPrice = rs.getInt("top_price");
            double bottomPrice = rs.getInt("bottom_price");
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
            double topPrice = rs.getInt("top_price");
            double bottomPrice = rs.getInt("bottom_price");
            cupCake = new Model_CupCake(topID, bottomID, bottomName, topName, bottomPrice, topPrice);
            allCupCakes.add(cupCake);
        }
        return allCupCakes;
    }

//    public ArrayList<Model_CupCake> getAllCupcakesNoDuplicates() throws SQLException //these damn cupcakes aren't unique
//    {
//        ArrayList<Model_CupCake> allCupcakes = getAllCupCakes(); //Get all cupcakes
//        LinkedHashSet<Model_CupCake> noDuplicates = new LinkedHashSet<>(); //New LinkedHashSet (no duplicates)
//
//        //noDuplicates.addAll(allCupcakes); //Add all cupcakes, therefore removing duplicates
//        for (Model_CupCake cupcake : allCupcakes)
//        {
//            noDuplicates.add(cupcake);
//        }
//        allCupcakes.clear(); //Clear original cupcake-arraylist
//        allCupcakes.addAll(noDuplicates); //Add no-duplicates collection to original cupcake-arraylist
//
//        return allCupcakes;
//    }
}
