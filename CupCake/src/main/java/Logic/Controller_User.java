package Logic;

import Data.Mapper_Invoice;
import Data.Mapper_User;
import Data.Model_Invoice;
import Data.Model_User;
import java.sql.SQLException;
import java.util.ArrayList;

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

    public ArrayList<Model_Invoice> getInvoices(int userID) throws SQLException {
        Mapper_Invoice mapperInvoice = new Mapper_Invoice();
        return mapperInvoice.getAllInvoicesByID(userID);
    }
    
}
