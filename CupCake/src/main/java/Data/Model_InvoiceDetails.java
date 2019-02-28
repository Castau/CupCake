package Data;

/**
 * Fields: (All are related to the invoice in question) id_Invoice_Details - the
 * ID of this specific order id_Invoice - ID of the invoice which this
 * invoice_details is related to id_Bottom - id of the bottom part of the
 * cupcake in question id_Top - id of the top part of the cupcake in question
 * price - total price of the two cupcake-parts combined
 *
 * @author Camilla
 */
public class Model_InvoiceDetails
{

    private int id_Invoice_Details;
    private int id_Invoice;
    private int id_Top;
    private int id_Bottom;
    private int quantity;
    private double price;

    public Model_InvoiceDetails()
    {
    }

    public Model_InvoiceDetails(int id_Invoice_Details, int id_Invoice, int id_Top, int id_Bottom, int quantity, double price)
    {
        this.id_Invoice_Details = id_Invoice_Details;
        this.id_Invoice = id_Invoice;
        this.id_Top = id_Top;
        this.id_Bottom = id_Bottom;
        this.quantity = quantity;
        this.price = price;
    }

    public int getId_Invoice_Details()
    {
        return id_Invoice_Details;
    }

    public void setId_Invoice_Details(int id_Invoice_Details)
    {
        this.id_Invoice_Details = id_Invoice_Details;
    }

    public int getId_Invoice()
    {
        return id_Invoice;
    }

    public void setId_Invoice(int id_Invoice)
    {
        this.id_Invoice = id_Invoice;
    }

    public int getId_Bottom()
    {
        return id_Bottom;
    }

    public void setId_Bottom(int id_Bottom)
    {
        this.id_Bottom = id_Bottom;
    }

    public int getId_Top()
    {
        return id_Top;
    }

    public void setId_Top(int id_Top)
    {
        this.id_Top = id_Top;
    }

    public int getQuantity()
    {
        return quantity;
    }

    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    public double getPrice()
    {
        return price;
    }

    public void setPrice(double price)
    {
        this.price = price;
    }

}
