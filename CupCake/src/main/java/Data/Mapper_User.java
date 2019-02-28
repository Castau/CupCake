package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Camilla
 */
public class Mapper_User {

    DBConnector connection;

    public Mapper_User() throws SQLException {
        this.connection = new DBConnector();
    }

    public Model_User getUserByID(int userID) throws SQLException {

        Model_User user = new Model_User();
        String sqlQuery = "SELECT * FROM cupcake.User\n"
                + "WHERE id_user = " + userID + ";";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();

        while (rs.next()) {
            user.setUserID(rs.getInt("id_user"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setBalance(rs.getDouble("balance"));
            user.setRole(Role. valueOf(rs.getString("role")));
        }
        return user;
    }

    public Model_User getUserByName(String userName) throws SQLException {

        Model_User user = new Model_User();
        String sqlQuery = "SELECT * FROM cupcake.User "
                + "WHERE username = '" + userName + "'";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();

        while (rs.next()) {
            user.setUserID(rs.getInt("id_user"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setBalance(rs.getDouble("balance"));
            user.setRole(Role.valueOf(rs.getString("role")));
        }
        return user;
    }

    public ArrayList<Model_User> getAllUsers() throws SQLException {

        ArrayList<Model_User> allUsers = new ArrayList();
        Model_User user = new Model_User();
        String sqlQuery = "SELECT * FROM cupcake.User\n";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();

        while (rs.next()) {
            user.setUserID(rs.getInt("id_user"));
            user.setUserName(rs.getString("username"));
            user.setPassword(rs.getString("password"));
            user.setEmail(rs.getString("email"));
            user.setBalance(rs.getDouble("balance"));
            user.setRole(Role.valueOf(rs.getString("role")));

            allUsers.add(user);
        }
        return allUsers;
    }

    public boolean createUser(String username, String password, String email) throws SQLException {

        String sqlQuery = "INSERT INTO cupcake.User\n"
                + "(username, password, email)\n"
                + "values (?, ?, ?)";
        
        PreparedStatement stmt = connection.getConnection().prepareStatement(sqlQuery);
        stmt.setString(1, username);
        stmt.setString(2, password);
        stmt.setString(3, email);

        return stmt.execute();
    }
}
