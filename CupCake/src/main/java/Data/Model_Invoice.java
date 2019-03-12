package Data;

import java.util.ArrayList;

/**
 * The main invoice
 *
 * Fields:
 *
 * id_invoice - ID of this specific invoice.
 *
 * id_user - ID of the user tied to this invoice.
 *
 * totalPrice - price of all items tied to this invoice.
 *
 * (Model) Model_invoiceDetails - The InvoiceDetails (order details) related to
 * this specific invoice.
 *
 * (ArrayList) invoiceDetails a complete list of all related InvoiceDetails.
 *
 * @author Camilla
 */
public class Model_Invoice
{

    private int id_invoice;
    private int id_user;
    private double totalPrice;
    private ArrayList<Model_InvoiceDetails> invoiceDetails;

    /**
     * Used for empty object creation
     */
    public Model_Invoice()
    {
    }

    /**
     ** Java object for a Invoice as seen in the database.
     *
     * Used for handling of objects from backend to frontend and vice-versa.
     *
     * @param invoiceID The invoice ID.
     * @param userID the user related to the Invoice's ID.
     * @param totalPrice total price of all the item listed in the
     * InvoiceDetails.
     * @param invoiceDetails a list of all line items (specific items) related
     * to this order.
     */
    public Model_Invoice(int invoiceID, int userID, double totalPrice, ArrayList<Model_InvoiceDetails> invoiceDetails)
    {
        this.id_invoice = invoiceID;
        this.id_user = userID;
        this.totalPrice = totalPrice;
        this.invoiceDetails = invoiceDetails;
    }

    public int getId_invoice()
    {
        return id_invoice;
    }

    public void setId_invoice(int id_invoice)
    {
        this.id_invoice = id_invoice;
    }

    public int getId_user()
    {
        return id_user;
    }

    public void setId_user(int id_user)
    {
        this.id_user = id_user;
    }

    public double getTotalPrice()
    {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    public ArrayList<Model_InvoiceDetails> getInvoiceDetails()
    {
        return invoiceDetails;
    }

    public void setInvoiceDetals(ArrayList<Model_InvoiceDetails> invoiceDetals)
    {
        this.invoiceDetails = invoiceDetals;
    }

}
