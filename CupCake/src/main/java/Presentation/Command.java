/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author stein
 */
public abstract class Command
{

    public abstract void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

    public static Command from(HttpServletRequest request)
    {
        Command command;
        String path = request.getPathInfo().substring(1);
        //String path = request.getParameter("path");

        switch (path)
        {
            case "login":
                command = new CMD_Login();
                break;
            case "shop":
                command = new CMD_Shop();
                break;
            case "cart":
                command = new CMD_ShoppingCart();
                break;
            case "customer":
                command = new CMD_Customer();   
                break;
            case "customerinvoice":
                command = new CMD_CustomerInvoiceDetails();
                break;
            case "logout":
                command = new CMD_Logout();
                break;
            default:
                command = new CMD_Unknown();
                break;
        }
        return command;
    }
}
