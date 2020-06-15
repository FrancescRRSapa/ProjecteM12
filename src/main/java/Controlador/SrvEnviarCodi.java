/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CodisDAO;
import DAO.ConfiguracioDAO;
import DAO.UsuarisDAO;
import Model.Configuracio;
import Model.LlistaCodis;
import Model.Mail;
import Model.Usuari;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.MessagingException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author ferna
 */
@WebServlet(name = "SrvEnviarCodi", urlPatterns = {"/SrvEnviarCodi"})
public class SrvEnviarCodi extends HttpServlet {

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
            out.println("<title>Servlet SrvEnviarCodis</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet SrvEnviarCodis at " + request.getContextPath() + "</h1>");
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
        String certificacio = request.getParameter("certificacio");
        try {
            int id = UsuarisDAO.buscarId(request.getParameter("direccioCorreu"));
            System.out.println(id);
            if(id == 0){
                request.setAttribute("error", "No existeix el mail específicat per a cap usuari");
                request.getRequestDispatcher("codisAdmin.jsp").forward(request, response);
            }
            if(certificacio.equals("MOS")){
                LlistaCodis lc = CodisDAO.llistarCodisMOS();
                for(int i=0; i < lc.size(); i++){
                    if(lc.get(i).getUsuariId() == 0){
                        CodisDAO.assignarCodiMOS(lc.get(i).getUsuariId() ,id);
                        Usuari u = UsuarisDAO.buscar(id);
                        Configuracio c = ConfiguracioDAO.llistar();
                        Mail.enviarCodis(c.getDireccioCorreu() ,u.getCorreu(), c.getCorreuEnviaCodis(), c.getContrasenyaCorreu());
                        break;
                    }
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(SrvEnviarCodi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SrvEnviarCodi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (MessagingException ex) {
            Logger.getLogger(SrvEnviarCodi.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SrvEnviarCodi.class.getName()).log(Level.SEVERE, null, ex);
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
