/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.Conexio;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author ferna
 */
@WebServlet(name = "SrvSesioUsuari", urlPatterns = {"/SrvSesioUsuari"})
public class SrvSesioUsuari extends HttpServlet {

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
            out.println("<title>Servlet SrvSesioUsuari</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SrvSesioUsuari at " + request.getContextPath() + "</h1>");
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
            throws ServletException, IOException {
        //processRequest(request, response);
        Conexio c = new Conexio();
            if(request.getParameter("btnLogin")!= null){
                String nombre = request.getParameter("username");
                String contrasenya = request.getParameter("pass");
                HttpSession sesion = request.getSession();
            try {
                switch(c.loguear(nombre, contrasenya)){
                    case "administrador":
                        sesion.setAttribute("user", nombre);
                        sesion.setAttribute("tipusUsuari", "administrador");
                        response.sendRedirect("indexAdmin.jsp");
                        break;
                    case "professor":
                        sesion.setAttribute("user", nombre);
                        sesion.setAttribute("tipusUsuari", "professor");
                        response.sendRedirect("indexUser.jsp");
                        break;
                    case "alumne":
                        sesion.setAttribute("user", nombre);
                        sesion.setAttribute("tipusUsuari", "alumne");
                        response.sendRedirect("indexUser.jsp");
                        break;
                    case "extern":
                        sesion.setAttribute("user", nombre);
                        sesion.setAttribute("tipusUsuari", "extern");
                        response.sendRedirect("indexUser.jsp");
                        break;
                    default:
                        request.setAttribute("error", "usuari/contrasenya invàlida");
                        request.getRequestDispatcher("index.jsp").forward(request, response);
                        break;
                }
            } catch (SQLException ex) {
                Logger.getLogger(SrvSesioUsuari.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(SrvSesioUsuari.class.getName()).log(Level.SEVERE, null, ex);
            }

            }
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
