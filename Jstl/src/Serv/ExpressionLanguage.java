/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Serv;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.Map;
import java.util.TreeMap;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 *
 * @author root
 */
public class ExpressionLanguage extends HttpServlet {

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
            /* TODO output your page here
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ExpressionLanguage</title>");  
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ExpressionLanguage at " + request.getContextPath () + "</h1>");
            out.println("</body>");
            out.println("</html>");
             */
            String[] favoriteMusic = {"Robo", "Boss", "Billa"};
            request.setAttribute("musicList", favoriteMusic);


            java.util.ArrayList favoriteFood = new java.util.ArrayList();
            favoriteFood.add(0, "Briyani");
            favoriteFood.add(1, "curd rice");
            favoriteFood.add(2, "Sambar rice");
            favoriteFood.add(3, "Tamarin rice");
            favoriteFood.add(4, "Tomato rice");

            request.setAttribute("favoriteFood", favoriteFood);

            Map<String, String> map = new TreeMap();

            map.put("1", "Ganesan");
            map.put("4", "an");
            map.put("gg", "Ganes");
            request.setAttribute("map", map);



            Map<Long, String> map1 = new TreeMap();
            map1.put(22L, "SREE");
            request.setAttribute("map1", map1);


            ExpressionLanguageBean bbbb=new ExpressionLanguageBean();
            bbbb.setName("Ganesh");
            request.setAttribute("bean", bbbb);

            Cookie cc= new Cookie("userName","ganesh+Cookies");
            response.addCookie(cc);


           request.setAttribute("normal", "String");


            System.out.println("1");
            request.getRequestDispatcher("/Expression/ExpressionLanguage.jsp").forward(request, response);

            //response.sendRedirect("/Expression/ExpressionLanguage.jsp");

        } finally {
            out.close();
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
        processRequest(request, response);
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
