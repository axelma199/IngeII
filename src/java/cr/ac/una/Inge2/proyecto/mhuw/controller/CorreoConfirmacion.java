/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.Inge2.proyecto.mhuw.controller;

import cr.ac.una.Inge2.proyecto.mhuw.bl.impl.UsuarioBL;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CorreoConfirmacion", urlPatterns = {"/CorreoConfirmacion"})
public class CorreoConfirmacion extends HttpServlet {

    private static final long serialVersionUID = 1L;
    public static String aleatoria = "";

    /**
     * @see HttpServlet#HttpServlet()
     */
    public String getCadenaAlfanumAleatoria(int longitud) {
        String cadenaAleatoria = "";
        long milis = new java.util.GregorianCalendar().getTimeInMillis();
        Random r = new Random(milis);
        int i = 0;
        while (i < longitud) {
            char c = (char) r.nextInt(255);
            //System.out.println("char:"+c);
            if ((c >= '0' && c <= 9) || (c >= 'A' && c <= 'Z')) {
                cadenaAleatoria += c;
                i++;
            }
        }
        return cadenaAleatoria;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        Usuario user = new Usuario();
        UsuarioBL ubl = new UsuarioBL();
        String accion = request.getParameter("accion");
        switch (accion) {

            case "confirmar":
                List<Usuario> list = ubl.findByQuery("FROM Usuario where UK_EMAIL='" + request.getParameter("email") + "'");
                if (list.size() > 0) {
                    user = list.get(0);
                    if (user.getCodigoConfirmacion().equals(request.getParameter("cod"))) {
                        user.setEstado(1);
                        ubl.merge(user);
                        response.sendRedirect("Paginas/ActivarCuenta.jsp");
                    }
                } else {
                    out.print("E~El correo no existe o el codigo es incorrecto");
                }
                break;

            default:
                out.print("E~No se indico la acción que se desea realizare");
                break;
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>n
}
