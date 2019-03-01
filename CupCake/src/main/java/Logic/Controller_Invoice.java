package Logic;

import Data.Mapper_Invoice;
import Data.Mapper_User;
import Data.Model_Invoice;
import Data.Model_InvoiceDetails;
import Data.Model_User;
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
        Model_Invoice invoice = mapperInvoice.getInvoiceByID(invoiceID);
        ArrayList<Model_InvoiceDetails> invoiceDetails = mapperInvoice.getInvoiceByID(invoiceID).getInvoiceDetails();
        invoice.setInvoiceDetals(invoiceDetails);

        return invoice;    
    }
    
}
