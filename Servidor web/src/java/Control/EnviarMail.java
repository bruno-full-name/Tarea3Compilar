package Control;

import Modelo.ModelReserva;
import Modelo.ModelUsuario;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servidor.DtCliente;
import servidor.DtInfoReserva;
import servidor.DtReserva;

public class EnviarMail extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, AddressException, MessagingException {

        Properties mailServerProperties;
	Session getMailSession;
	MimeMessage generateMailMessage;
        
        String nickC = request.getParameter("nickClienteMail");
        String idReserva = request.getParameter("idReservaMail");
        ModelReserva mr = new ModelReserva();
        ModelUsuario mu = new ModelUsuario();

        System.out.println(nickC + " " + idReserva);

        DtCliente cliente = mu.devolverCliente(nickC);
        DtReserva reserva = mr.devolverReserva(Integer.valueOf(idReserva));
        List<DtInfoReserva> infoRes = mr.ObtenerDatosReserva(Integer.valueOf(idReserva));

        String to = "agustinmr1995@gmail.com";
        String from = "ventas@help4traveling.com";
        String fecha = (Calendar.getInstance().get(Calendar.YEAR) + "/" + Calendar.getInstance().get(Calendar.MONTH) + "/" + Calendar.getInstance().get(Calendar.DATE));
        String hora = (Calendar.getInstance().get(Calendar.HOUR_OF_DAY) + ":" + Calendar.getInstance().get(Calendar.MINUTE));

        try {
            String texto = "Estimado " + cliente.getNombre() + ", su compra ha sido facturada con exito: <br><br>";
            texto += "---> Detalles de la compra:<br>";
            texto += "- Servicios:<br>";
            for (int x = 0; x < infoRes.size(); x++) {
                texto += "-     Nombre: " + infoRes.get(x).getNameArticulo() + " - Proveedor: " + infoRes.get(x).getNickProveedor() + " - Cantidad: " + infoRes.get(x).getCantidad() + " - Precio: " + infoRes.get(x).getPrecioArticulo() + "<br>";
            }
            texto += "---> Precio total: " + reserva.getPrecio() + "<br>";
            texto += "----------------------------------------------------------<br>";
            texto += "Gracias por preferirnos,<br>";
            texto += "Saludos.<br>";
            texto += "Help4Traveling.<br>";

            mailServerProperties = new Properties();

            mailServerProperties = System.getProperties();
            mailServerProperties.put("mail.smtp.port", "587");
            mailServerProperties.put("mail.smtp.auth", "true");
            mailServerProperties.put("mail.smtp.starttls.enable", "true");
            
            getMailSession = Session.getDefaultInstance(mailServerProperties, null);
            generateMailMessage = new MimeMessage(getMailSession);
            generateMailMessage.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
            generateMailMessage.setSubject("[Help4Traveling][" + fecha + " " + hora + " ]");
            String emailBody = "Test email by Crunchify.com JavaMail API example. " + "<br><br> Regards, <br>Crunchify Admin";
            generateMailMessage.setContent(texto, "text/html");

            Transport transport = getMailSession.getTransport("smtp");

            transport.connect("smtp.gmail.com", "help4travelinggrupo1", "tecnoDBweb2016");
            transport.sendMessage(generateMailMessage, generateMailMessage.getAllRecipients());
            transport.close();

            System.out.println("Exito!!!");
            
        } catch (MessagingException mex) {
            System.out.println("Rompiste todo! Wei... ERROR \n\n" + mex);
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
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (MessagingException ex) {
            Logger.getLogger(EnviarMail.class.getName()).log(Level.SEVERE, null, ex);
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
