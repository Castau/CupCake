package Data;

import java.util.ArrayList;

/**
 * The main invoice
 Fields:
 id_invoice - ID of this specific invoice
 id_user - ID of the user tied to this invoice
 totalPrice - price of all items tied to this invoice
 (Model) Model_invoiceDetails - The InvoiceDetails (order details) related to this specific invoice
 (ArrayList) invoiceDetails a complete list of all related InvoiceDetails
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
     *
     */
    public Model_Invoice()
    {
    }

    /**
     *
     * @param invoiceID
     * @param userID
     * @param totalPrice
     * @param invoiceDetails
     */
    public Model_Invoice(int invoiceID, int userID, double totalPrice, ArrayList<Model_InvoiceDetails> invoiceDetails)
    {
        this.id_invoice = invoiceID;
        this.id_user = userID;
        this.totalPrice = totalPrice;
        this.invoiceDetails = invoiceDetails;
    }

    /**
     *
     * @return
     */
    public int getId_invoice()
    {
        return id_invoice;
    }

    /**
     *
     * @param id_invoice
     */
    public void setId_invoice(int id_invoice)
    {
        this.id_invoice = id_invoice;
    }

    /**
     *
     * @return
     */
    public int getId_user()
    {
        return id_user;
    }

    /**
     *
     * @param id_user
     */
    public void setId_user(int id_user)
    {
        this.id_user = id_user;
    }

    /**
     *
     * @return
     */
    public double getTotalPrice()
    {
        return totalPrice;
    }

    /**
     *
     * @param totalPrice
     */
    public void setTotalPrice(double totalPrice)
    {
        this.totalPrice = totalPrice;
    }

    /**
     *
     * @return
     */
    public ArrayList<Model_InvoiceDetails> getInvoiceDetails()
    {
        return invoiceDetails;
    }

    /**
     *
     * @param invoiceDetals
     */
    public void setInvoiceDetals(ArrayList<Model_InvoiceDetails> invoiceDetals)
    {
        this.invoiceDetails = invoiceDetals;
    }

}
