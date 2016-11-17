package Control;

import Modelo.ModelReserva;
import com.google.gson.Gson;
import servidor.DtInfoReserva;
import servidor.DtReserva;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControllerInfoReserva extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        ModelReserva modRes = new ModelReserva();
        String cli = request.getParameter("cli");
        String id2 = request.getParameter("resID");
        String num2 = request.getParameter("num");
        int id = 0;
        if (id2 != null)
            id = Integer.valueOf(id2);
        int num = 0;
        if (num2 != null)
            num = Integer.valueOf(num2);
        
        boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
        //System.out.println("AJAX:  " + ajax + "--------------------");
        if (ajax) {
            if (id != 0 && num == 1){
                //System.out.println("Servlet1");
                
                List<DtInfoReserva> lResID = modRes.ObtenerDatosReserva(id);
                String json = new Gson().toJson(lResID);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);   
            }else if (id != 0 && num == 2){
                //System.out.println("Servlet2");
                
                DtReserva datosRes = modRes.devolverReserva(id);
                String json = new Gson().toJson(datosRes);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
            }
        } else {
            String nick = (String) request.getSession().getAttribute("usuario_logueado");
            List<Integer> idReservas = modRes.ObtenerReservas(nick);
            Integer[] Ires = idReservas.toArray(new Integer[idReservas.size()]);
            request.setAttribute("arrayReservas", Ires);
            request.setAttribute("namecli", nick);
            request.getRequestDispatcher("consultarReservas.jsp").forward(request, response);
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
