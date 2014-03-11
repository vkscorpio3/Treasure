/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.*;

/**
 *
 * @author root
 */
public class input extends HttpServlet {

    Socket requestSocket;
    ObjectOutputStream out1;
    ObjectInputStream in;
    String message = "", option = "";
    static Socket clientSocket = null;

    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        try {

            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet input</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet input at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");


            requestSocket = new Socket("192.168.0.53", 2234);
            

            System.out.println("Connected to localhost in port 2222");
            out1 = new ObjectOutputStream(requestSocket.getOutputStream());
            out.flush();

            in = new ObjectInputStream(requestSocket.getInputStream());

            System.out.println("Enter your choice \n 1.Add \n 2.View\n 3.Quit:");
            out.println("<form action='input' type='get'>");

            out.println("Train No <input type='text' name ='trainno' value=''>");
            out.println("<input type='submit' value='Submit'>");
            out.println("</form>");

            System.out.println("vzxvgzvxzxcxz" + request.getParameter("trainno"));
            String trainno = request.getParameter("trainno");
           
            if (trainno != null) {

                sendMessage(trainno);
            }
           
                message = (String) in.readObject();
            System.out.println("mmmmmmmmmmmm"+message);
            out.println("<h3>" + message + "</h3>");
 
            


        }
        catch (ClassNotFoundException ex) {
                System.out.println("error");
            }
        finally {
            out.close();
        }
    }

    void sendMessage(String msg) {
        try {
            out1.writeObject(msg);
            out1.flush();
        //System.out.println("client>" + msg);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

        
    }

    /** 
     * Returns a short description of the servlet.
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
