
package Control;

import Model.EstadoSesion;
import Model.ModelUsuario;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class iniciarSesion extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, NoSuchAlgorithmException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            HttpSession objSesion = request.getSession();
            String nickname = request.getParameter("nickname");
            String password = request.getParameter("password");
            String hashtext = "";
            
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] clave = md.digest(password.getBytes("UTF-8"));
                BigInteger bigInt = new BigInteger(1,clave);
                hashtext = bigInt.toString(16);
            } catch (UnsupportedEncodingException ex) {
            }

            EstadoSesion nuevoEstado;
            RequestDispatcher dispatcher = null;
            try {
                System.out.println("ssadsafdsafsaf");
                boolean usr = ModelUsuario.getInstance().autenticarProveedor(nickname, hashtext);
                System.out.println(usr);
                //System.out.println("ssadsafdsafsaf");
                if(!usr){
                        //out.print("sdfkgjfdkg");
                        nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
                        objSesion.setAttribute("estado_sesion", nuevoEstado);
                        dispatcher = request.getRequestDispatcher("errorPages/error404.jsp");
                        dispatcher.forward(request, response);
                } else {
                        nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
                        request.getSession().setAttribute("usuario_logueado", nickname);
                        objSesion.setAttribute("estado_sesion", nuevoEstado);
                        dispatcher = request.getRequestDispatcher("inicioProv.jsp");
                        dispatcher.forward(request, response);
                }
            } catch(Exception ex){
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
            throws ServletException, IOException {
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(iniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(iniciarSesion.class.getName()).log(Level.SEVERE, null, ex);
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
