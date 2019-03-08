/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Cart;
import Data.Mapper_Invoice;
import Data.Mapper_User;
import Data.Model_CupCake;
import Data.Model_Invoice;
import Data.Model_InvoiceDetails;
import Data.Model_User;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Comparator;
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
            ArrayList<Model_CupCake> cakes = cart.getCakes();
            cakes.sort(new TheComparator());
            for (int i = 0; i < cart.getCakes().size(); i++)
            {
                int amount = 0;
                int j = i;
                for (j = i; j < cakes.size(); j++)
                {
                    if (cakes.get(i).equals(cakes.get(j)))
                    {
                        ++amount;
                    }
                }
                details = new Model_InvoiceDetails();
                details.setCupcake(cakes.get(i));
                details.setPrice(cakes.get(i).getTotalPrice());
                details.setQuantity(amount);
                detailsList.add(details);
                i += amount - 1;
            }
            try
            {
                mi.addInvoiceWithAllDetails(invoice, detailsList);
                mu.updateUserBalance(user.getUserID(), balance - finalPrice);
            } catch (SQLException ex)
            {
                
                Logger.getLogger(CMD_Checkout.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            user.setBalance(balance - finalPrice);
            request.getSession().setAttribute("user", user);
        }

        request.getRequestDispatcher("/jsp/ShopCheckOut.jsp").forward(request, response);
    }
    
//    public void sortCakes(ArrayList<Model_CupCake> cakes)
//    {
//        Comparator comp = Comparator.naturalOrder();
//        
//    }
    
    static class TheComparator implements Comparator
    {
        @Override
        public int compare(Object o1, Object o2)
        {
            Model_CupCake cake1 = (Model_CupCake) o1;
            Model_CupCake cake2 = (Model_CupCake) o2;
            String cake1name = cake1.getTopName() + cake1.getBottomName();
            String cake2name = cake2.getTopName() + cake2.getBottomName();
            return 
            cake1name.compareToIgnoreCase(cake2name);
        }
    }

}
