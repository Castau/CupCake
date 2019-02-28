package com.mycompany.cupcake.data;

/**
 * @author Camilla
 */
public class Model_InvoiceDetails {
    private int invoiceDetailsID;
    private int invoiceID;
    private int bottomID;
    private int topID;
    private int quantity;
    private double price;

    public Model_InvoiceDetails() {
    }

    public Model_InvoiceDetails(int invoiceDetailsID, int invoiceID, int bottomID, int topID, int quantity, double price) {
        this.invoiceDetailsID = invoiceDetailsID;
        this.invoiceID = invoiceID;
        this.bottomID = bottomID;
        this.topID = topID;
        this.quantity = quantity;
        this.price = price;
    }

    public int getInvoiceDetailsID() {
        return invoiceDetailsID;
    }

    public void setInvoiceDetailsID(int invoiceDetailsID) {
        this.invoiceDetailsID = invoiceDetailsID;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getBottomID() {
        return bottomID;
    }

    public void setBottomID(int bottomID) {
        this.bottomID = bottomID;
    }

    public int getTopID() {
        return topID;
    }

    public void setTopID(int topID) {
        this.topID = topID;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
    
    
}
