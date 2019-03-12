/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Presentation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Command for handling and showing application errors
 * 
 * @author Camilla
 */
public class CMD_Unknown extends Command
{

    /**
     * This is the application default command which is called when nothing else
     * in the Command switchcase is called. Usually it's called when the sesison
     * is expired.
     * 
     * @param request the Http request
     * @param response the Http response
     * @throws ServletException when error occurs while forwarding
     * @throws IOException when error occurs while redirecting
     */
    @Override
    public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        response.setContentType("text/html;charset=UTF-8");

        try (PrintWriter out = response.getWriter())
        {
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>ERROR 404</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Error 404 - no such webpage</h1>");
            out.println("<h2>Unknown page/path: " + request.getPathInfo() + "</h2>");
            out.println("<a href=\"/\"><h2>Start over</h2></a>");
            out.println("</html>");
        }
    }

}
