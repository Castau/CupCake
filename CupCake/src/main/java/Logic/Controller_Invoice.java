package Logic;

import Data.Mapper_Invoice;
import Data.Model_Invoice;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 * @author Camilla
 */
public class Controller_Invoice {

    public Controller_Invoice() {
    }
    
    public Model_Invoice getInvoiceWithInvoiceDetails(int invoiceID) throws SQLException {
        Mapper_Invoice mapperInvoice = new Mapper_Invoice();
        Model_Invoice invoice = mapperInvoice.getInvoiceWithDetails(invoiceID);

        return invoice;    
    }
    
    public ArrayList<Model_Invoice> getAllInvoicesAdmin() throws SQLException{
        Mapper_Invoice mapperInvoice = new Mapper_Invoice();
        ArrayList<Model_Invoice> allInvoices = mapperInvoice.getAllInvoices();
        return allInvoices;
    }
    
}
