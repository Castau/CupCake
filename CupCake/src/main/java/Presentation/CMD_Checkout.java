/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Cart;
import Data.Mapper_Invoice;
import Data.Mapper_User;
import Data.Model_Invoice;
import Data.Model_InvoiceDetails;
import Data.Model_User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Shevitar
 */
public class CMD_Checkout extends Command
{

    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");
        Mapper_Invoice mi = null;
        Mapper_User mu = null;
        try
        {
            mu = new Mapper_User();
            mi = new Mapper_Invoice();
        } catch (SQLException ex)
        {
            System.out.println("Could not create Mapper_Invoice (error from CMD_Checkout)");
            Logger.getLogger(CMD_Checkout.class.getName()).log(Level.SEVERE, null, ex);
        }
        Model_User user = (Model_User) request.getSession().getAttribute("user");
        boolean buyPermission = (boolean) request.getSession().getAttribute("buyPermission");
        Cart cart = (Cart) request.getSession().getAttribute("cart");
        
        if (buyPermission && !cart.getCakes().isEmpty())
        {
            ArrayList<Model_InvoiceDetails> detailsList = new ArrayList();
            double balance = user.getBalance();
            double finalPrice = (double) request.getSession().getAttribute("finalPrice");
            Model_InvoiceDetails details = null;
            Model_Invoice invoice = new Model_Invoice();
            user.setBalance(balance - finalPrice);
            invoice.setId_user(user.getUserID());
            invoice.setTotalPrice(finalPrice);
            for (int i = 0; i < cart.getCakes().size(); i++)
            {
                details = new Model_InvoiceDetails();
                details.setCupcake(cart.getCakes().get(i));
                details.setPrice(cart.getCakes().get(i).getTotalPrice());
                details.setQuantity(1);
                detailsList.add(details);
            }
            try
            {
                mi.addInvoiceWithAllDetails(invoice, detailsList);
                System.out.println("Succesfully created invoice in the database");
                mu.updateUserBalance(user.getUserID(), balance - finalPrice);
                System.out.println("Succesfully updated balance in the database for the chosen user");
            } catch (SQLException ex)
            {
                
                Logger.getLogger(CMD_Checkout.class.getName()).log(Level.SEVERE, null, ex);
            }
            user.setBalance(balance - finalPrice);
            //Write the actual code to make the actual changes in the DB
            request.getSession().setAttribute("user", user);
        } else
        {
            //Something
        }

        request.getRequestDispatcher("/jsp/ShopCheckOut.jsp").forward(request, response);
    }

}
