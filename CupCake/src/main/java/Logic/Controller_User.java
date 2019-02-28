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
    
}
