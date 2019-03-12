package Data;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Handling all CRUD operations related to @Model_Invoice and @Model_InvoiceDetails
 *
 * @author Camilla
 */
public class Mapper_Invoice {

    DBConnector connection;

    /**
     * Constructor, gets connection
     * 
     * @throws SQLException when error occurs while establishing connection to 
     * the database
     */
    public Mapper_Invoice() throws SQLException {
        connection = new DBConnector();
    }

    /* This is for Model_Invoice*/

    /**
     * Sends querry to databse and creates a Model_Invoice object with the
     * returned data
     * 
     * @param invoiceID the id for the specific invoice
     * @return Model_Invoice object 
     * @throws SQLException when error occurs while establishing connection to 
     * the database
     */

    public Model_Invoice getInvoiceByID(int invoiceID) throws SQLException {
        Model_Invoice invoice = new Model_Invoice();
        String sqlQuery = "SELECT * FROM cupcake.Invoice "
                + "WHERE id_invoice = " + invoiceID + ";";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();
        while (rs.next()) {
            invoice.setId_invoice(rs.getInt("id_invoice"));
            invoice.setId_user(rs.getInt("id_user"));
            invoice.setTotalPrice(rs.getInt("totalprice"));
        }
        return invoice;
    }

    /**
     * Sends querry to databse and creates a Model_Invoice object with the
     * returned data
     * 
     * @param userID the id for the specific user
     * @return Model_Invoice object 
     * @throws SQLException when error occurs while establishing connection to 
     * the database
     */
    public Model_Invoice getInvoiceByUserID(int userID) throws SQLException {
        Model_Invoice invoice = new Model_Invoice();
        String sqlQuery = "SELECT * FROM cupcake.Invoice "
                + "WHERE id_user = " + userID + ";";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();
        while (rs.next()) {
            invoice.setId_invoice(rs.getInt("id_invoice"));
            invoice.setId_user(rs.getInt("id_user"));
            invoice.setTotalPrice(rs.getInt("totalprice"));
        }
        return invoice;
    }

    /**
     * Sends querry to databse and creates an ArrayList of Model_Invoice objects 
     * with the returned data
     * 
     * @param userID the id for the specific user
     * @return ArrayList
     * @throws SQLException when error occurs while establishing connection to 
     * the database
     */
    public ArrayList<Model_Invoice> getAllInvoicesByID(int userID) throws SQLException {
        ArrayList<Model_Invoice> allInvoices = new ArrayList();
        Model_Invoice invoice = new Model_Invoice();
        String sqlQuery = "SELECT * FROM cupcake.Invoice "
                + "WHERE id_user = '" + userID + "';";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();

        while (rs.next()) {
            invoice.setId_invoice(rs.getInt("id_invoice"));
            invoice.setId_user(rs.getInt("id_user"));
            invoice.setTotalPrice(rs.getInt("totalprice"));
            allInvoices.add(invoice);
        }
        return allInvoices;
    }

    /**
     * Sends querry to databse and creates an ArrayList of Model_Invoice objects 
     * with the returned data
     * 
     * @return ArrayList 
     * @throws SQLException when error occurs while establishing connection to 
     * the database
     */
    public ArrayList<Model_Invoice> getAllInvoices() throws SQLException {
        ArrayList<Model_Invoice> allInvoices = new ArrayList();
        String sqlQuery = "SELECT * FROM cupcake.Invoice;";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();

        while (rs.next()) {
            Model_Invoice invoice = new Model_Invoice();
            invoice.setId_invoice(rs.getInt("id_invoice"));
            invoice.setId_user(rs.getInt("id_user"));
            invoice.setTotalPrice(rs.getInt("totalprice"));
            allInvoices.add(invoice);
        }
        return allInvoices;
    }

    /**
     * Sends querry to databse and gets the highest invoice_id number
     * 
     * @return invoice id as int 
     * @throws SQLException when error occurs while establishing connection to 
     * the database
     */
    public int getLatestInvoiceID() throws SQLException
    {
        String sqlQuery = "SELECT MAX(id_invoice) AS id_invoice FROM cupcake.Invoice ORDER BY 'id_invoices' DESC LIMIT 1;";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();
        int id = 0;
        while (rs.next()) 
        {
            id = rs.getInt("id_invoice");
        }
        return id;
    }
    
    /**
     * Sends querry to databse and adds the specific Model_Invoice to the 
     * the database
     * 
     * @param invoice specific Model_Invoice object
     * @return boolean to specify wether the execute returns data
     * @throws SQLException when error occurs while establishing connection to 
     * the database
     */
    public boolean addInvoice(Model_Invoice invoice) throws SQLException {
        //int invoice_id, int id_user, double totalPrice
        String sqlQuery = "INSERT INTO cupcake.Invoice"
                + "(id_user, totalprice)"
                + "VALUES (?, ?)";

        PreparedStatement stmt = connection.getConnection().prepareStatement(sqlQuery);
        stmt.setInt(1, invoice.getId_user());
        stmt.setDouble(2, invoice.getTotalPrice());
        return stmt.execute();

    }
    
    /**
     * Sends querry to databse and adds the specific Model_Invoice and 
     * ArrayList of Model_InvoiceDetails to the database
     * 
     * @param inv Model_Invoice Object
     * @param detailsList ArrayList of Model_InvoiceDetails
     * @return true
     * @throws SQLException when error occurs while establishing connection to 
     * the database
     */
    public boolean addInvoiceWithAllDetails(Model_Invoice inv, ArrayList<Model_InvoiceDetails> detailsList) throws SQLException
    {
        Model_Invoice invoice = inv;
        int userID = invoice.getId_user();
        double totalPrice = invoice.getTotalPrice();
        Connection conn = connection.getConnection();
        conn.setAutoCommit(false);
        String queryInvoice = "INSERT INTO cupcake.Invoice"
                + "(id_user, totalprice)"
                + "VALUES (?, ?)";
        
        PreparedStatement stmt1 = connection.getConnection().prepareStatement(queryInvoice);
        stmt1.setInt(1, userID);
        stmt1.setDouble(2, totalPrice);
        stmt1.executeUpdate();
        conn.commit();
        
        int latestID = getLatestInvoiceID();
        String  queryDetails = "INSERT INTO `cupcake`.`Invoice_Details`"
                + " ( `id_invoice`, `id_top`, `id_bottom`, `quantity`, `price`)"
                + " VALUES ( " + latestID + ", ?, ?, ?, ?);";
        
        PreparedStatement stmt = connection.getConnection().prepareStatement(queryDetails);
        for (int i = 0; i < detailsList.size(); i++)
        {
            stmt.setInt(1, detailsList.get(i).getCupcake().getTopID());
            stmt.setInt(2, detailsList.get(i).getCupcake().getBottomID());
            stmt.setInt(3, detailsList.get(i).getQuantity());
            stmt.setDouble(4, detailsList.get(i).getCupcake().getTotalPrice());
            stmt.executeUpdate();
            conn.commit();
        }
        conn.setAutoCommit(true);
        return true;
    }

    /**
     * Sends querry to databse gets the specific Model_Invoice and the ArrayList 
     * of Invoice_Details connected to it from the database
     * 
     * @param invoiceID id of the specific Model_Invoice object
     * @return the Model_Invoice object with the ArrayList of Invoice_Details
     * @throws SQLException when error occurs while establishing connection to 
     * the database
     */
    public Model_Invoice getInvoiceWithDetails(int invoiceID) throws SQLException {

        Model_Invoice invoice = new Model_Invoice();
        ArrayList<Model_InvoiceDetails> detailsList = new ArrayList();
        String sqlQuery = "SELECT Invoice_Details.id_invoice, Invoice.id_user, Invoice.totalprice, Invoice_Details.id_invoice_details,\n"
                + " Invoice_Details.quantity, Cupcake_bottom.id_bottom, Cupcake_bottom.bottom_name,\n"
                + " Cupcake_bottom.bottom_price, Cupcake_top.id_top, Cupcake_top.top_name, Cupcake_top.top_price\n"
                + " FROM cupcake.Invoice\n"
                + " LEFT JOIN cupcake.Invoice_Details\n"
                + " ON Invoice.id_invoice = Invoice_Details.id_invoice\n"
                + " LEFT JOIN cupcake.Cupcake_top\n"
                + " ON Invoice_Details.id_top = Cupcake_top.id_top\n"
                + " LEFT JOIN cupcake.Cupcake_bottom\n"
                + " ON Invoice_Details.id_bottom = Cupcake_bottom.id_bottom\n"
                + " WHERE Invoice.id_invoice = " + invoiceID + ";";

        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();

        while (rs.next()) {
            Model_CupCake cake = new Model_CupCake();
            Model_InvoiceDetails invoiceDetails = new Model_InvoiceDetails();
            if (invoice.getId_invoice() <= 0) {
                invoice.setId_invoice(rs.getInt("id_invoice"));
                invoice.setId_user(rs.getInt("id_user"));
                invoice.setTotalPrice(rs.getDouble("totalprice"));
            }

            invoiceDetails.setId_Invoice(rs.getInt("id_invoice"));
            invoiceDetails.setId_Invoice_Details(rs.getInt("id_invoice_details"));
            invoiceDetails.setPrice(rs.getDouble("totalprice"));
            invoiceDetails.setQuantity(rs.getInt("quantity"));

            cake.setBottomID(rs.getInt("id_bottom"));
            cake.setBottomName(rs.getString("bottom_name"));
            cake.setBottomPrice(rs.getDouble("bottom_price"));
            cake.setTopID(rs.getInt("id_top"));
            cake.setTopName(rs.getString("top_name"));
            cake.setTopPrice(rs.getDouble("top_price"));

            invoiceDetails.setCupcake(cake);
            detailsList.add(invoiceDetails);
        }
        invoice.setInvoiceDetals(detailsList);
        
        return invoice;

    }
}
