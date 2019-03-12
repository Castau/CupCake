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

    DBConnector connection;

    /**
     * Handles cupcakes from the frontend to the backend and vice versa.
     *
     * @see DBConnector
     *
     * @throws SQLException goodbye exception
     */
    public Mapper_CupCake() throws SQLException
    {
        connection = new DBConnector();
    }

    /**
     * Creates a new cupcake-object by the use of the cupcake_top and
     * cupcake_bottom UID (ID)
     *
     * @see Model_CupCake
     *
     * @param topID ID of cupcake_top
     * @param bottomID ID of cupcake_bottom
     * @return Returns a new cupcake object containing the requested cupcake_top
     * and cupcake_bottom
     * @throws SQLException bye exception
     */
    public Model_CupCake getCupCake(int topID, int bottomID) throws SQLException
    {
        String query = "SELECT * FROM Cupcake_top JOIN Cupcake_bottom WHERE id_top = ? AND id_bottom = ?;";
        PreparedStatement stmt = connection.getConnection().prepareStatement(query);
        stmt.setInt(1, topID);
        stmt.setInt(2, bottomID);
        ResultSet rs = stmt.executeQuery();
        Model_CupCake cupCake = null;
        while (rs.next())
        {
            String topName = rs.getString("top_name");
            String bottomName = rs.getString("bottom_name");
            double topPrice = rs.getDouble("top_price");
            double bottomPrice = rs.getDouble("bottom_price");
            cupCake = new Model_CupCake(bottomID, topID, bottomName, topName, bottomPrice, topPrice);
        }
        return cupCake;
    }

    /**
     *
     * Returns all cupcake_tops and cupcake_bottoms combined into
     * Cupcake-objects.
     *
     * @see Model_CupCake
     * @return Returns an ArrayList of Cupcake_objects
     * @throws SQLException bye exception.
     */
    public ArrayList<Model_CupCake> getAllCupCakes() throws SQLException
    {
        Connection conn = connection.getConnection();
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

    /**
     * Returns cupcake_tops only.
     *
     * @return Returns all cupcake tops (without bottoms).
     * @throws SQLException goodbye exception.
     */
    public ArrayList<Model_CupCake.Cupcake_Top> getAllCupcakeTops() throws SQLException
    {
        String query = "SELECT * FROM Cupcake_top;";
        PreparedStatement stmt = connection.getConnection().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Model_CupCake.Cupcake_Top> allCupcakeTops = new ArrayList();
        while (rs.next())
        {
            int topID = rs.getInt("id_top");
            String topName = rs.getString("top_name");
            double topPrice = rs.getDouble("top_price");
            allCupcakeTops.add(new Model_CupCake.Cupcake_Top(topID, topName, topPrice));
        }
        return allCupcakeTops;
    }

    /**
     * Returns cupcake_bottoms only.
     *
     * @return Returns all cupcake bottoms (without tops).
     * @throws SQLException goodbye exception.
     *
     */
    public ArrayList<Model_CupCake.Cupcake_Bottom> getAllCupcakeBottoms() throws SQLException
    {
        String query = "SELECT * FROM Cupcake_bottom;";
        PreparedStatement stmt = connection.getConnection().prepareStatement(query);
        ResultSet rs = stmt.executeQuery();
        ArrayList<Model_CupCake.Cupcake_Bottom> allCupcakeBottoms = new ArrayList();
        while (rs.next())
        {
            int bottomID = rs.getInt("id_bottom");
            String bottomName = rs.getString("bottom_name");
            double bottomPrice = rs.getDouble("bottom_price");
            allCupcakeBottoms.add(new Model_CupCake.Cupcake_Bottom(bottomID, bottomName, bottomPrice));
        }
        return allCupcakeBottoms;
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
