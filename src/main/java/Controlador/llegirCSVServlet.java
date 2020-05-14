/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.SQLException;
import java.util.ArrayList;
import Model.Codi;
import Model.LlistaCodisPreTestMOS;
import Model.LlistaCodisPreTestMTA;
import Model.LlistaCodisTestMOS;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.Part;

/**
 *
 * @author Francesc
 */
@WebServlet(name = "llegirCSVServlet", urlPatterns = {"/llegirCSVServlet"})
@MultipartConfig
public class llegirCSVServlet extends HttpServlet {

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
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet llegirCSVServlet</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet llegirCSVServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
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
            throws ServletException, IOException {
        /*
        try {
            //processRequest(request, response);
            CodisDAO.inserirCodis();
        } catch (SQLException ex) {
            Logger.getLogger(llegirCSVServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(llegirCSVServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
        LlistaCodisPreTestMOS llistatCodisPreTestMOS = new LlistaCodisPreTestMOS();
        //LlistaCodisTestMOS llistatCodisTestMOS = new LlistaCodisTestMOS();
        //LlistaCodisPreTestMTA llistatCodisPreTestMTA = new LlistaCodisPreTestMTA();
     
        //request.setAttribute("TestMOS", llistatCodisTestMOS.llegirCodis());
        //request.setAttribute("PreTestMOS", llistatCodisPreTestMOS.llegirCodis());
        //request.setAttribute("PreTestMTA", llistatCodisPreTestMTA.llegirCodis());
        request.getRequestDispatcher("LlistarCodisJSP.jsp").forward(request, response);
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
            throws ServletException, IOException {
        //processRequest(request, response);
        LlistaCodisPreTestMOS llistatCodisPreTestMOS = new LlistaCodisPreTestMOS();
        //LlistaCodisTestMOS llistatCodisTestMOS = new LlistaCodisTestMOS();
        //LlistaCodisPreTestMTA llistatCodisPreTestMTA = new LlistaCodisPreTestMTA();
        Part filePart = request.getPart("file");       
        //request.setAttribute("TestMOS", llistatCodisTestMOS.llegirCodis());
        InputStream fileContent = filePart.getInputStream();
        request.setAttribute("PreTestMOS", llistatCodisPreTestMOS.llegirCodis(fileContent));
        //request.setAttribute("PreTestMTA", llistatCodisPreTestMTA.llegirCodis());
        request.getRequestDispatcher("LlistarCodisJSP.jsp").forward(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
