package Logic;

import Data.Mapper_Invoice;
import Data.Model_Invoice;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * 
 * @author Camilla
 */
public class Controller_Invoice {

    /**
     *
     */
    public Controller_Invoice() {
    }
    
    /**
     * Used to get an invoice from the database.
     * This method fetches the invoice with the matching ID from the database 
     * including all its details
     * @param invoiceID The ID of the specific invoice
     * @return Model_invoice 
     * @throws SQLException bye exception.
     */
    public Model_Invoice getInvoiceWithInvoiceDetails(int invoiceID) throws SQLException {
        Mapper_Invoice mapperInvoice = new Mapper_Invoice();
        Model_Invoice invoice = mapperInvoice.getInvoiceWithDetails(invoiceID);

        return invoice;    
    }
    
    /**
     * Used to get all invoices in a list. 
     * This method fetches all the invoices from the database. This method is meant  
     * to be used as an admin-only feature. The invoices returned from this method do not 
     * contain any details.
     * @return ArrayList - An ArrayList containing Model_Invoice objects
     * @throws SQLException bye exception.
     */
    public ArrayList<Model_Invoice> getAllInvoicesAdmin() throws SQLException{
        Mapper_Invoice mapperInvoice = new Mapper_Invoice();
        ArrayList<Model_Invoice> allInvoices = mapperInvoice.getAllInvoices();
        return allInvoices;
    }
    
}
