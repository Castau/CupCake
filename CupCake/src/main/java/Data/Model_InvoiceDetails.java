package Data;

/**
 * Fields: (All are related to the invoice in question)
 *
 * id_Invoice_Details - the ID of this specific order.
 *
 * id_Invoice - ID of the invoice which this invoice_details is related to.
 *
 * id_Bottom - id of the bottom part of the cupcake in question.
 *
 * id_Top - id of the top part of the cupcake in question.
 *
 * price - total price of the two cupcake-parts combined.
 * 
 * cupcake - the combined cupcake (top and bottom) in question
 * 
 *
 *
 * @author Camilla
 */
public class Model_InvoiceDetails
{

    private int id_Invoice_Details;
    private int id_Invoice;
    private int quantity;
    private double price;
    private Model_CupCake cupcake;

    /**
     * Used for empty object creation.
     */
    public Model_InvoiceDetails()
    {
    }

    /**
     * Java object for a Invoice_Details as seen in the database. Used for
     * handling of objects from backend to frontend and vice-versa.
     *
     * @param id_Invoice Invoice ID
     * @param quantity quantity of cupcake object
     * @param price combined price
     * @param cupcake Cupcake object
     */
    public Model_InvoiceDetails(int id_Invoice, int quantity, double price, Model_CupCake cupcake)
    {
        this.id_Invoice = id_Invoice;
        this.quantity = quantity;
        this.price = price;
        this.cupcake = cupcake;
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

    public Model_CupCake getCupcake()
    {
        return cupcake;
    }

    public void setCupcake(Model_CupCake theCupcake)
    {
        this.cupcake = theCupcake;
    }

}
