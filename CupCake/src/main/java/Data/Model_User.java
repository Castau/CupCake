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
     *
     */
    public Model_User()
    {
    }

    /**
     *
     * @param userID
     * @param userName
     * @param password
     * @param balance
     * @param email
     * @param role
     * @param invoices
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

    /**
     *
     * @return
     */
    public int getUserID()
    {

        return userID;
    }

    /**
     *
     * @param userID
     */
    public void setUserID(int userID)
    {
        this.userID = userID;
    }

    /**
     *
     * @return
     */
    public String getUserName()
    {
        return userName;
    }

    /**
     *
     * @param userName
     */
    public void setUserName(String userName)
    {
        this.userName = userName;
    }

    /**
     *
     * @return
     */
    public String getPassword()
    {
        return password;
    }

    /**
     *
     * @param password
     */
    public void setPassword(String password)
    {
        this.password = password;
    }

    /**
     *
     * @return
     */
    public double getBalance()
    {
        return balance;
    }

    /**
     *
     * @param balance
     */
    public void setBalance(double balance)
    {
        this.balance = balance;
    }

    /**
     *
     * @return
     */
    public String getEmail()
    {
        return email;
    }

    /**
     *
     * @param email
     */
    public void setEmail(String email)
    {
        this.email = email;
    }

    /**
     *
     * @return
     */
    public Role getRole()
    {
        return role;
    }

    /**
     *
     * @param role
     */
    public void setRole(Role role)
    {
        this.role = role;
    }

    /**
     *
     * @return
     */
    public ArrayList<Model_Invoice> getInvoices()
    {
        return invoices;
    }

    /**
     *
     * @param invoices
     */
    public void setInvoices(ArrayList<Model_Invoice> invoices)
    {
        this.invoices = invoices;
    }

    /**
     *
     */
    public enum Role
    {

        /**
         *
         */
        admin,

        /**
         *
         */
        user;

    }
}
