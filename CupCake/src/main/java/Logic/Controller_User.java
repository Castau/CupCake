package Logic;

import Data.Mapper_User;
import Data.Model_User;
import java.sql.SQLException;

/**
 * @author Camilla
 */
public class Controller_User 
{

    /**
     *
     */
    public Controller_User() 
    {
        
    }
    
    /**
     * Used to check if a given name and password pair matches any user in the database
     * @param name String representing the username
     * @param password String representing the supposed password matching the given username
     * @return boolean - True if the given name and password matches that of an existing user, False otherwise
     * @throws SQLException bye exception.
     */
    public boolean checkPasswordValidity(String name, String password) throws SQLException
    {
        String passwordDB ="";
        Mapper_User userDAO = new Mapper_User();
        Model_User user = userDAO.getUserByName(name);
        passwordDB = user.getPassword();
        return password.equals(passwordDB);
    }

    /**
     * Used to fetch a user from the database. 
     * This method returns a user object based on the given ID. The user object 
     * will contain invoices. The invoices will not contain any details
     * @param userID The ID of the chosen user
     * @return Model_User
     * @throws SQLException  bye exception.
     */
    public Model_User getUserWithInvoices(int userID) throws SQLException {
        Mapper_User mapperUser = new Mapper_User();
        Model_User user = mapperUser.getUserWithInvoice(userID);

        return user;    
    }
    
    /**
     * Used to fetch a user from the database. 
     * This method returns a user object based on the given ID. The user object 
     * will not contain invoices. 
     * @param userID The ID of the chosen user
     * @return Model_User
     * @throws SQLException bye exception.
     */
    public Model_User getUser(int userID) throws SQLException {
        Mapper_User mapperUser = new Mapper_User();
        Model_User user = mapperUser.getUserByID(userID);
        return user;    
    }
    
    /**
     * Used to update the balance of a given user. 
     * This method will update the balance of a user if the given userID matches 
     * an ID in the database. 
     * @param userID The ID of the chosen user
     * @param balance A double representing the amount of money that should either 
     * be added or removed from the user.
     * @throws SQLException bye exception.
     */
    public void updateBalance(int userID, double balance) throws SQLException{
        Mapper_User mapperUser = new Mapper_User();
        double oldBalance = mapperUser.getUserByID(userID).getBalance();
        double newBalance = oldBalance + balance;
        
        mapperUser.updateUserBalance(userID, newBalance);
        
    }
}
