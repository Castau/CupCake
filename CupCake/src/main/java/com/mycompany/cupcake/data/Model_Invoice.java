package com.mycompany.cupcake.data;

import java.util.ArrayList;

/**
 * @author Camilla
 */
public class Model_Invoice {
    private int invoiceID;
    private int userID;
    private double totalPrice;
    private Model_InvoiceDetails invoiceDetails;
    private ArrayList<Model_InvoiceDetails> invoiceDetals;

    public Model_Invoice() {
    }

    public Model_Invoice(int invoiceID, int userID, double totalPrice, Model_InvoiceDetails invoiceDetails, ArrayList<Model_InvoiceDetails> invoiceDetals) {
        this.invoiceID = invoiceID;
        this.userID = userID;
        this.totalPrice = totalPrice;
        this.invoiceDetails = invoiceDetails;
        this.invoiceDetals = invoiceDetals;
    }

    public int getInvoiceID() {
        return invoiceID;
    }

    public void setInvoiceID(int invoiceID) {
        this.invoiceID = invoiceID;
    }

    public int getUserID() {
        return userID;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Model_InvoiceDetails getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(Model_InvoiceDetails invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public ArrayList<Model_InvoiceDetails> getInvoiceDetals() {
        return invoiceDetals;
    }

    public void setInvoiceDetals(ArrayList<Model_InvoiceDetails> invoiceDetals) {
        this.invoiceDetals = invoiceDetals;
    }

    
    
    
}
