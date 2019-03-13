package Presentation;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Asger
 */
@WebServlet(name = "FrontController", urlPatterns =
{
    "/app/*"
})
public class FrontController extends HttpServlet
{

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        try
        {
            Command c = Command.from(request);
            c.execute(request, response);
        } catch (IOException | ServletException ex)
        {
            System.out.println("FrontController exception  " + ex);
            response.setContentType("text/html;charset=UTF-8");
            try (PrintWriter out = response.getWriter())
            {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<p></p>");
                out.println("<h1>Error: " + ex + "</h1>");
                out.println("</body>");
                out.println("</html>");
            }
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String path = request.getPathInfo().substring(1);
        HttpSession session = request.getSession(); //Do not touch
        //Read documentation on above :false: if needed.
        //false means do not create new session. 
        //if set to true, new session will be created. Everything below will then be disregarded and user is granted free access.
        //Avoid this unless specifically needed.
        
        //System.out.println("(search #1338) pathname: " + path);
        if (!"index".equals(path))
        {
            if (session == null || session.getAttribute("user") == null)
            {
                //valid session doesn't exist -- or user log in went wrong.
                //do something like send the user to a login screen

                if (!path.equals("login")) //If user IS NOT at desired URL path
                {
                    response.setContentType("text/html;charset=UTF-8");

                    try (PrintWriter out = response.getWriter())
                    {
                        out.println("<!DOCTYPE html>");
                        out.println("<html>");
                        out.println("<head>");
                        out.println("<title>Servlet LoginServlet</title>");
                        out.println("</head>");
                        out.println("<body>");
                        out.println("<h1>Session or user invalid, try again!</h1>");
                        out.println("<a href=\"/\"><h2>Start over</h2></a>");
                        out.println("</body>");
                        out.println("</html>");
                    }
                }

            }
        }

        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>

}
