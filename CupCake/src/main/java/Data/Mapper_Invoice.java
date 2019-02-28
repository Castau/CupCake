package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *This class is for handling all CRUD operations related to @Model_Invoice & @Model_InvoiceDetails
 * 
 * @author runin
 */
public class Mapper_Invoice
{
    DBConnector connection;

    public Mapper_Invoice(DBConnector connection)
    {
        this.connection = connection;
    }

    /* This is for Model_Invoice*/
    public Model_Invoice getInvoiceByID (int invoiceID) throws SQLException
    {
        Model_Invoice invoice = new Model_Invoice();
        String sqlQuery = "SELECT * FROM cupcake.Invoice"
                + "WHERE id_invoice = " + invoiceID + ";";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();
        while (rs.next()) {
            invoice.setId_invoice(rs.getInt("id_invoice"));
            invoice.setId_user(rs.getInt("id_user"));
            invoice.setTotalPrice(rs.getInt("totalprice"));
        }
        return invoice;   
    }
    
    public List<Model_Invoice> getAllInvoices() throws SQLException
    {
        List<Model_Invoice> allInvoices = new ArrayList();
        Model_Invoice invoice = new Model_Invoice();
        String sqlQuery = "SELECT * FROM cupcake.Invoice;";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();

        while (rs.next()) {
            invoice.setId_invoice(rs.getInt("id_invoice"));
            invoice.setId_user(rs.getInt("id_user"));
            invoice.setTotalPrice(rs.getInt("totalprice"));
            allInvoices.add(invoice);
        }
        return allInvoices;
    }
    
    public boolean addInvoice(Model_Invoice i) throws SQLException
    {
        //int invoice_id, int id_user, double totalPrice
        String sqlQuery = "INSERT INTO cupcake.Invoice"
                + "(id_invoice, id_user, totalprice)"
                + "VALUES (?, ?, ?)";
        
        PreparedStatement stmt = connection.getConnection().prepareStatement(sqlQuery);
        stmt.setInt(1, i.getId_invoice());
        stmt.setInt(2, i.getId_user());
        stmt.setDouble(3, i.getTotalPrice());
        return stmt.execute();
    }
    
    /*This is for Model_InvoiceDetails*/
    public Model_InvoiceDetails getInvoiceDetailsByID (int idInvoiceDetail) throws SQLException
    {
     Model_InvoiceDetails invoiceDetails = new Model_InvoiceDetails();
        String sqlQuery = "SELECT * FROM cupcake.Invoice_Details"
                + "WHERE id_invoice_details = " + idInvoiceDetail + ";";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();
        while (rs.next()) {
            invoiceDetails.setId_Invoice_Details(rs.getInt("id_invoice_details"));
            invoiceDetails.setId_Invoice(rs.getInt("id_invoice"));
            invoiceDetails.setId_Top(rs.getInt("id_top"));
            invoiceDetails.setId_Bottom(rs.getInt("id_bottom"));
            invoiceDetails.setQuantity(rs.getInt("quantity"));
            invoiceDetails.setPrice(rs.getDouble("price"));
        }
        return invoiceDetails;   
    }
    
    public List<Model_InvoiceDetails> getAllInvoiceDetails() throws SQLException
    {
        List<Model_InvoiceDetails> allInvoiceDetails = new ArrayList();
        Model_InvoiceDetails invoiceDetails = new Model_InvoiceDetails();
        String sqlQuery = "SELECT * FROM cupcake.Invoice_Details;";
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();

        while (rs.next()) {
            invoiceDetails.setId_Invoice_Details(rs.getInt("id_invoice_details"));
            invoiceDetails.setId_Invoice(rs.getInt("id_invoice"));
            invoiceDetails.setId_Top(rs.getInt("id_top"));
            invoiceDetails.setId_Bottom(rs.getInt("id_bottom"));
            invoiceDetails.setQuantity(rs.getInt("quantity"));
            invoiceDetails.setPrice(rs.getDouble("price"));
            
            allInvoiceDetails.add(invoiceDetails);
        }
        return allInvoiceDetails;
    }
    
    public boolean addInvoiceDetail(Model_InvoiceDetails i) throws SQLException
    {
        //int invoiceDetails_id, int id_top, int id_bottom, int quantity, double price
        String sqlQuery = "INSERT INTO cupcake.Invoice_Details"
                + "(id_invoice_details, id_invoice, id_top, id_bottom, quantity, price)"
                + "VALUES (?, ?, ?, ?, ?, ?)";
        
        PreparedStatement stmt = connection.getConnection().prepareStatement(sqlQuery);
        stmt.setInt(1, i.getId_Invoice_Details());
        stmt.setInt(2, i.getId_Invoice());
        stmt.setInt(3, i.getId_Top());
        stmt.setInt(4, i.getId_Bottom());
        stmt.setInt(5, i.getQuantity());
        stmt.setDouble(6, i.getPrice());
        return stmt.execute();
    }
}
