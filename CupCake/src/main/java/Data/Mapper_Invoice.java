package Data;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class is for handling all CRUD operations related to @Model_Invoice &
 *
 * @Model_InvoiceDetails
 *
 * @author runin
 */
public class Mapper_Invoice {

    DBConnector connection;

    public Mapper_Invoice() throws SQLException {
        connection = new DBConnector();
    }

    /* This is for Model_Invoice*/
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

    public ArrayList<Model_Invoice> getAllInvoicesByID(int userID) throws SQLException {
        ArrayList<Model_Invoice> allInvoices = new ArrayList();
        Model_Invoice invoice = new Model_Invoice();
        String sqlQuery = "SELECT * FROM cupcake.Invoice "
                + "WHERE id_user = '" + userID + "';";
        System.out.println("QUERY " + sqlQuery);
        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();

        while (rs.next()) {
            invoice.setId_invoice(rs.getInt("id_invoice"));
            invoice.setId_user(rs.getInt("id_user"));
            invoice.setTotalPrice(rs.getInt("totalprice"));
            allInvoices.add(invoice);
        }
        return allInvoices;
    }

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

    public boolean addInvoice(Model_Invoice i) throws SQLException {
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

            invoiceDetails.setCupcakes(cake);
            detailsList.add(invoiceDetails);
        }
        invoice.setInvoiceDetals(detailsList);
        
        return invoice;

    }

    /*This is for Model_InvoiceDetails*/
//    public Model_InvoiceDetails getInvoiceDetailsByID(int idInvoiceDetail) throws SQLException
//    {
//        Model_InvoiceDetails invoiceDetails = new Model_InvoiceDetails();
//        String sqlQuery = "SELECT * FROM cupcake.Invoice_Details "
//                + "WHERE id_invoice_details = " + idInvoiceDetail + ";";
//        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();
//        while (rs.next())
//        {
//            invoiceDetails.setId_Invoice_Details(rs.getInt("id_invoice_details"));
//            invoiceDetails.setId_Invoice(rs.getInt("id_invoice"));
//            invoiceDetails.setQuantity(rs.getInt("quantity"));
//            invoiceDetails.setPrice(rs.getDouble("price"));
//        }
//        return invoiceDetails;
//    }
//
//    public ArrayList<Model_InvoiceDetails> getAllInvoiceDetails() throws SQLException
//    {
//        ArrayList<Model_InvoiceDetails> allInvoiceDetails = new ArrayList();
//        Model_InvoiceDetails invoiceDetails = new Model_InvoiceDetails();
//        String sqlQuery = "SELECT * FROM cupcake.Invoice_Details;";
//        ResultSet rs = connection.getConnection().prepareStatement(sqlQuery).executeQuery();
//
//        while (rs.next())
//        {
//            invoiceDetails.setId_Invoice_Details(rs.getInt("id_invoice_details"));
//            invoiceDetails.setId_Invoice(rs.getInt("id_invoice"));
//            invoiceDetails.setQuantity(rs.getInt("quantity"));
//            invoiceDetails.setPrice(rs.getDouble("price"));
//
//            allInvoiceDetails.add(invoiceDetails);
//        }
//        return allInvoiceDetails;
//    }
//
//    public boolean addInvoiceDetail(Model_InvoiceDetails i) throws SQLException
//    {
//        //int invoiceDetails_id, int id_top, int id_bottom, int quantity, double price
//        String sqlQuery = "INSERT INTO cupcake.Invoice_Details"
//                + "(id_invoice_details, id_invoice, id_top, id_bottom, quantity, price)"
//                + "VALUES (?, ?, ?, ?, ?, ?)";
//
//        PreparedStatement stmt = connection.getConnection().prepareStatement(sqlQuery);
//        stmt.setInt(1, i.getId_Invoice_Details());
//        stmt.setInt(2, i.getId_Invoice());
//        stmt.setInt(3, i.getQuantity());
//        stmt.setDouble(4, i.getPrice());
//        return stmt.execute();
//
//    }
}
