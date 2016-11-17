/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

import Modelo.ModelUsuario;
import servidor.DtCliente;
import servidor.DtFecha;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Agustin
 */
public class ControllerUsuario extends HttpServlet {

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
        
        String nick = request.getParameter("nick");
        String mail = request.getParameter("email");
        String name = request.getParameter("nombre");
        String pass = request.getParameter("pass");      
        String pass2 = request.getParameter("pass2");      
        String lastname = request.getParameter("apellido");        
        String fdia = request.getParameter("fnac1");               
        String fmes = request.getParameter("fnac2");
        String fanio = request.getParameter("fnac3");        
        String fnac = (fanio+"/"+fmes+"/"+fdia);
        
        ModelUsuario modUsu = new ModelUsuario();       
                    
        if(modUsu.VerificarNickCliente(nick)){
            request.setAttribute("error_registro","nick");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        if(modUsu.VerificarEmailCliente(mail)){
            request.setAttribute("error_registro","mail");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }

        if(!(pass.equals(pass2))){
            request.setAttribute("error_registro", "pass");
            request.getRequestDispatcher("index.jsp").forward(request, response);
        }
        
        DtFecha nac = new DtFecha();
        nac.setDia(Integer.valueOf(fdia));
        nac.setMes(Integer.valueOf(fmes));
        nac.setAnio(Integer.valueOf(fanio));
        
        DtCliente dtCli = new DtCliente();
        dtCli.setNick(nick);
        dtCli.setNombre(name);
        dtCli.setApellido(lastname);
        dtCli.setEmail(mail);
        dtCli.setFechaN(nac);
        dtCli.setClave(pass);
        
        //System.out.println(nick +"-"+ name +"-"+ lastname +"-"+ mail +"-"+ pass);
        //System.out.println(fnac);
        modUsu.agregarCliente(dtCli);

        request.setAttribute("mensaje", "Se agrego el cliente");
        
        request.getRequestDispatcher("registrarClienteImg.jsp").forward(request, response);        
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
