package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Camilla
 */
public class Mapper_User
{

    DBConnector connection;

    public Mapper_User() throws SQLException
    {
        this.connection = new DBConnector();
    }

    public Model_User getUserByID(int userID) throws SQLException
    {

        Model_User user = new Model_User();
        String sqlQuery = "SELECT * FROM cupcake.User\n"
                + "WHERE id_user = " + userID + ";";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();

        while (rs.next())
        {
            user.setUserID(rs.getInt("id_user"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setBalance(rs.getDouble("balance"));
            user.setRole(Model_User.Role.valueOf(rs.getString("role")));
        }
        return user;
    }

    public Model_User getUserByName(String userName) throws SQLException
    {

        Model_User user = new Model_User();
        String sqlQuery = "SELECT * FROM cupcake.User "
                + "WHERE username = '" + userName + "'";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();

        while (rs.next())
        {
            user.setUserID(rs.getInt("id_user"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setBalance(rs.getDouble("balance"));
            user.setRole(Model_User.Role.valueOf(rs.getString("role")));
        }
        return user;
    }

    public ArrayList<Model_User> getAllUsers() throws SQLException
    {

        ArrayList<Model_User> allUsers = new ArrayList();
        Model_User user = new Model_User();
        String sqlQuery = "SELECT * FROM cupcake.User\n";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();

        while (rs.next())
        {
            user.setUserID(rs.getInt("id_user"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setBalance(rs.getDouble("balance"));
            user.setRole(Model_User.Role.valueOf(rs.getString("role")));

            allUsers.add(user);
        }
        return allUsers;
    }

    public Model_User createUser(String username, String password, String email) throws SQLException
    {

        String sqlQuery = "INSERT INTO cupcake.User\n"
                + "(username, password, email)\n"
                + "values (?, ?, ?)";

        PreparedStatement stmt = null;
        stmt = connection.getConnection().prepareStatement(sqlQuery, PreparedStatement.RETURN_GENERATED_KEYS);
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.setString(3, email);

        stmt.executeUpdate();

        ResultSet resultSet = stmt.getGeneratedKeys();
        if (resultSet.next())
        {
            return new Model_User(resultSet.getInt(1), username, password, 0, email, Model_User.Role.user, null);
        }
        return null;
    }

    public Model_User getUserWithInvoice(int userID) throws SQLException
    {

        Model_User user = new Model_User();
        ArrayList<Model_Invoice> userInvoices = new ArrayList();
        String sqlQuery = "SELECT * FROM cupcake.User\n"
                + " LEFT JOIN cupcake.Invoice\n"
                + " ON User.id_user = Invoice.id_user\n"
                + " WHERE User.id_user = " + userID + ";";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();

        while (rs.next())
        {
            Model_Invoice invoice = new Model_Invoice();
            if (user.getUserID() <= 0)
            {
                user.setUserID(rs.getInt("id_user"));
                user.setUserName(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setEmail(rs.getString("email"));
                user.setBalance(rs.getDouble("balance"));
                user.setRole(Model_User.Role.valueOf(rs.getString("role")));
            }
            invoice.setId_invoice(rs.getInt("id_invoice"));
            invoice.setId_user(rs.getInt("id_user"));
            invoice.setTotalPrice(rs.getInt("totalprice"));
            userInvoices.add(invoice);
        }
        user.setInvoices(userInvoices);
        return user;
    }

}
