/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import Logic.Controller_User;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author Camilla
 */

public class CMD_Customer extends Command {
     @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String recipeID = request.getParameter("userID");
        int userID = Integer.parseInt(recipeID);
        
        Controller_User controller = new Controller_User();
         try {
             controller.getInvoices(userID);
         } catch (SQLException ex) {
             System.out.println("SQLException" + ex);
         }
        
       
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Invoices</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1></h1>");
            out.println("<p>SOMETHING</p>");
            out.println("</body>");
            out.println("</html>");
        }
    }

}
