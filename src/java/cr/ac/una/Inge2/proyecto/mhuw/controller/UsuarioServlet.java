/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cr.ac.una.Inge2.proyecto.mhuw.controller;

import cr.ac.una.Inge2.proyecto.mhuw.bl.impl.EstudianteBL;
import cr.ac.una.Inge2.proyecto.mhuw.bl.impl.TelefonosBL;
import cr.ac.una.Inge2.proyecto.mhuw.bl.impl.UsuarioBL;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Estudiante;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Telefonos;
import cr.ac.una.Inge2.proyecto.mhuw.domain.Usuario;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.Random;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author patei
 */
public class UsuarioServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected String getCadenaAlfanumAleatoria(int longitud) {
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

    protected void enviarCorreo(String dest, String cadena) {
        try {
            // Propiedades de la conexión
            Properties props = new Properties();
            props.setProperty("mail.smtp.host", "smtp.gmail.com");
            props.setProperty("mail.smtp.starttls.enable", "true");
            props.setProperty("mail.smtp.port", "587");
            props.setProperty("mail.smtp.user", "ingenieriasistemasg10@gmail.com");
            props.setProperty("mail.smtp.auth", "true");

            // Preparamos la sesion
            Session session = Session.getDefaultInstance(props);

            // Construimos el mensaje
            MimeMessage message = new MimeMessage(session);
            //la persona k tiene k verificar
            message.setFrom(new InternetAddress("ingenieriasistemasg10@gmail.com"));
            message.addRecipient(
                    Message.RecipientType.TO,
                    new InternetAddress(dest));
            message.addHeader("Disposition-Notification-To", "ingenieriasistemasg10@gmail.com");
            message.setSubject("Correo de verificacion, por favor no responder");
            message.setText(
                    "Para confirmar su cuenta:\n"
                    + "Haga click en el siguiente link:\n"
                    + "http://localhost:8080/IngeII/CorreoConfirmacion?accion=confirmar&&cod="+cadena+"&&email="+dest);

            // Lo enviamos.
            Transport t = session.getTransport("smtp");
            t.connect("ingenieriasistemasg10@gmail.com", "INgenieria10");
            t.sendMessage(message, message.getAllRecipients());

            // Cierre.
            t.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {

            Usuario user = new Usuario();
            UsuarioBL ubl = new UsuarioBL();
            Estudiante clienteAux = new Estudiante();
            EstudianteBL cbl = new EstudianteBL();
            Telefonos tel = new Telefonos();
            TelefonosBL telbl = new TelefonosBL();
            //Se hace una pausa para ver el modal
            Thread.sleep(1000);

            //**********************************************************************
            //se toman los datos de la session
            //**********************************************************************
            HttpSession session = request.getSession();

            //**********************************************************************
            //se consulta cual accion se desea realizar
            //**********************************************************************
            String accion = request.getParameter("accion");
            switch (accion) {

                case "ingresarUsuario":
                    //Se llena el objeto con los datos enviados por AJAX por el metodo post

                    clienteAux.setCedula(request.getParameter("cedula"));
                    clienteAux.setNombre(request.getParameter("nombre"));
                    clienteAux.setApellidos(request.getParameter("apellidos"));
                    clienteAux.setNacionalidad(request.getParameter("nacionalidad"));
                    tel.setCelular(request.getParameter("celular"));
                    user.setTipo(0);
                    user.setEstado(0);
                    user.setFechaCreacion(new Date());
                    user.setPasswordSha512(request.getParameter("sha512pass"));
                    user.setPasswordBcrypt(request.getParameter("hash"));
                    user.setUkEmail(request.getParameter("correo"));
                    user.setUsuario(request.getParameter("usuario"));
                    String cadena = getCadenaAlfanumAleatoria(10);
                    user.setCodigoConfirmacion(cadena);
                    if (accion.equals("ingresarUsuario")) {
                        List<Usuario> list = ubl.findByQuery("FROM Usuario where UK_EMAIL='" + request.getParameter("correo") + "'");
                        if (ubl.findByNombreUsuario(request.getParameter("usuario")) == null) {
                            if (list.size() > 0) {
                                out.print("E~El correo ya esta registrado");
                            } else {
                                telbl.save(tel);
                                List<Telefonos> listTel = telbl.findAll(Telefonos.class.getName());
                                clienteAux.setTelefonos(listTel.get(listTel.size() - 1));
                                ubl.save(user);
                                Usuario cursor = ubl.findByNombreUsuario(request.getParameter("usuario"));
                                clienteAux.setUsuario(cursor);
                                cbl.save(clienteAux);
                                enviarCorreo(user.getUkEmail(),cadena);
                                //Se imprime la respuesta con el response
                                out.print("C~El Usuario fue ingresado correctamente");
                            }
                        } else {
                            out.print("E~El nombre de usuario ya existe");
                        }

                    }

                    break;
                case "login":
                    String correo = request.getParameter("usuario");
                    List<Usuario> lista = ubl.findByQuery("FROM Usuario where UK_EMAIL='" + request.getParameter("usuario") + "'");
                    if (lista.size() > 0) { //Si el usuario existe
                        String sha512 = request.getParameter("sha512pass");
                        if (lista.get(0).getPasswordSha512().equals(sha512)) {
                            String hash = lista.get(0).getPasswordBcrypt();
                            Usuario userAux = lista.get(0);
                            if (userAux.getEstado() == 1) {
                                if (BCrypt.checkpw(sha512, hash)) {

                                    request.getSession(true);
                                    session.setAttribute("usuario", userAux.getUsuario());
                                    session.setAttribute("tipo", userAux.getTipo());
                                    session.setAttribute("loginStatus", "login");
                                    out.print("C~ Correcto");
                                } else {
                                    out.print("E~Usuario o contraseña incorrectos");
                                }

                            } else {
                                out.print("E~La cuenta no ha sido activada");
                            }
                        } else {
                            out.print("E~ error, el usuario o clave no existe");
                        }
                    } else {
                        out.print("E~ error, el usuario o clave no existe");
                    }

                    break;
                default:
                    out.print("E~No se indico la acción que se desea realizare");
                    break;
            }

        } catch (NumberFormatException e) {
            out.print("E~" + e.getMessage());
        } catch (Exception e) {
            out.print("E~" + e.getMessage());
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
    }// </editor-fold>

}
