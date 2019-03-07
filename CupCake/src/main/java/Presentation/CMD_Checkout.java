/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Data.Model_Invoice;
import Data.Model_User;
import java.io.IOException;
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
        
        Model_User user = (Model_User)request.getSession().getAttribute("user");
        boolean buyPermission = (boolean)request.getSession().getAttribute("buyPermission");
        Model_Invoice invoice = new Model_Invoice
        double balance = user.getBalance();
        double finalPrice = (double)request.getSession().getAttribute("finalPrice");
        
        if (buyPermission)
        {
            user.setBalance(balance - finalPrice);
        }
        else
        {
        }
        
        request.getRequestDispatcher("/jsp/ShopCheckOut.jsp").forward(request, response);
    }
    
}
