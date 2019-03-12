package Data;

import java.util.ArrayList;

/**
 * @author Camilla
 */
public class Model_User
{

    private int userID;
    private String userName;
    private String password;
    private double balance;
    private String email;
    private Role role;
    private ArrayList<Model_Invoice> invoices;

    /**
     * Used for empty object creation
     */
    public Model_User()
    {
    }

    /**
     * Java object for a User as seen in the database. Used for handling of
     * objects from backend to frontend and vice-versa.
     *
     * @param userID Users ID (AUTO_INCREMENT, use RETURN_GENERATED_KEYS)
     * @param userName Users username
     * @param password Users password
     * @param balance Users Balance (Default: 0.00 (set by database))
     * @param email Users email (Used at registration)
     * @param role Users role (Enum: user, admin) (see inner class Role)
     * @param invoices An arraylist of users @Model_Invoice's
     */
    public Model_User(int userID, String userName, String password, double balance, String email, Role role, ArrayList<Model_Invoice> invoices)
    {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        this.balance = balance;
        this.email = email;
        this.role = role;
        this.invoices = invoices;
    }

    public int getUserID()
    {
        return userID;
    }

    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    public String getUserName()
    {
        return userName;
    }

    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public double getBalance()
    {
        return balance;
    }

    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Role getRole()
    {
        return role;
    }

    public void setRole(Role role)
    {
        this.role = role;
    }

    /**
     *
     * @return returns a list of all the users invoices, containing
     * Model_InvoiceDetails
     */
    public ArrayList<Model_Invoice> getInvoices()
    {
        return invoices;
    }

    /**
     * Updates or changes the users invoice list
     *
     * @param invoices the new invoice list
     */
    public void setInvoices(ArrayList<Model_Invoice> invoices)
    {
        this.invoices = invoices;
    }

    /**
     * Enum used to specify the users role. Admin is used for access to the
     * admin panel and admin functions Default (by database) is user.
     */
    public enum Role
    {
        admin, user;
    }
}
