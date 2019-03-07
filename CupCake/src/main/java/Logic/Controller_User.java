package Logic;

import Data.Mapper_User;
import Data.Model_User;
import java.sql.SQLException;

/**
 * @author Camilla
 */
public class Controller_User 
{

    public Controller_User() 
    {
        
    }
    
    public boolean checkPasswordValidity(String name, String password) throws SQLException
    {
        String passwordDB ="";
        Mapper_User userDAO = new Mapper_User();
        Model_User user = userDAO.getUserByName(name);
        passwordDB = user.getPassword();
        return password.equals(passwordDB);
    }

    public Model_User getUserWithInvoices(int userID) throws SQLException {
        Mapper_User mapperUser = new Mapper_User();
        Model_User user = mapperUser.getUserWithInvoice(userID);

        return user;    
    }
    
    public Model_User getUser(int userID) throws SQLException {
        Mapper_User mapperUser = new Mapper_User();
        Model_User user = mapperUser.getUserByID(userID);
        return user;    
    }
    
    public void updateBalance(int userID, double addedBalance) throws SQLException{
        Mapper_User mapperUser = new Mapper_User();
        double oldBalance = mapperUser.getUserByID(userID).getBalance();
        double newBalance = oldBalance + addedBalance;
        
        mapperUser.updateUserBalance(userID, newBalance);
        
    }
}
