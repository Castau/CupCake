package Data;

import java.util.ArrayList;

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
    private int quantity;
    private double price;
    private Model_CupCake cupcake;
    
    /**
     *
     */
    public Model_InvoiceDetails()
    {
    }

    /**
     *
     * @param id_Invoice
     * @param quantity
     * @param price
     * @param cupcake
     */
    public Model_InvoiceDetails( int id_Invoice, int quantity, double price, Model_CupCake cupcake)
    {
        this.id_Invoice = id_Invoice;
        this.quantity = quantity;
        this.price = price;
        this.cupcake = cupcake;
    }

    /**
     *
     * @return
     */
    public int getId_Invoice_Details()
    {
        return id_Invoice_Details;
    }

    /**
     *
     * @param id_Invoice_Details
     */
    public void setId_Invoice_Details(int id_Invoice_Details)
    {
        this.id_Invoice_Details = id_Invoice_Details;
    }

    /**
     *
     * @return
     */
    public int getId_Invoice()
    {
        return id_Invoice;
    }

    /**
     *
     * @param id_Invoice
     */
    public void setId_Invoice(int id_Invoice)
    {
        this.id_Invoice = id_Invoice;
    }

    /**
     *
     * @return
     */
    public int getQuantity()
    {
        return quantity;
    }

    /**
     *
     * @param quantity
     */
    public void setQuantity(int quantity)
    {
        this.quantity = quantity;
    }

    /**
     *
     * @return
     */
    public double getPrice()
    {
        return price;
    }

    /**
     *
     * @param price
     */
    public void setPrice(double price)
    {
        this.price = price;
    }

    /**
     *
     * @return
     */
    public Model_CupCake getCupcake() {
        return cupcake;
    }

    /**
     *
     * @param theCupcake
     */
    public void setCupcake(Model_CupCake theCupcake) {
        this.cupcake = theCupcake;
    }

}
