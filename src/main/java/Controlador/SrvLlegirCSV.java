/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CodisDAO;
import Model.LlistaCodis;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Model.LlistaCodisMOS;
import Model.LlistaCodisMTA;
import java.io.InputStream;
import java.sql.SQLException;
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
public class SrvLlegirCSV extends HttpServlet {

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
        LlistaCodisMOS llistatCodisMOS = new LlistaCodisMOS();
        LlistaCodisMTA llistatCodisPreTestMTA = new LlistaCodisMTA();
        request.setAttribute("PreTestMOS", llistatCodisMOS.llegirCodis());
        request.setAttribute("PreTestMTA", llistatCodisPreTestMTA.llegirCodis());*/
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
        //LlistaCodisMOS lc = new LlistaCodisMOS();
        //LlistaCodisMTA llistatMTA = new LlistaCodisMTA();
        LlistaCodis lc = new LlistaCodis();
        Part filePartMOS = request.getPart("fileMOS");
        String tipusCodi = request.getParameter("tipusCodi");
        if("MOS".equals(tipusCodi)){
            InputStream fileContent = filePartMOS.getInputStream();
            CodisDAO.inserirCodisMOS(lc.llegirCodis(fileContent));
        }else if("MTA".equals(tipusCodi)){
            InputStream fileContent = filePartMOS.getInputStream();
            CodisDAO.inserirCodisMTA(lc.llegirCodis(fileContent));
        }
        //Part filePartMTA = request.getPart("fileMTA");
        //if(filePartMOS != null){
            //InputStream fileContent = filePartMOS.getInputStream();
            //CodisDAO.inserirCodisMOS(lc.llegirCodis(fileContent));
            //request.setAttribute("PreTestMOS", llistatCodisMOS.llegirCodis(fileContent));
        
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
