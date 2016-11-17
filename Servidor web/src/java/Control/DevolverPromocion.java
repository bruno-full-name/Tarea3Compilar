package Control;

import Modelo.ModelArticulo;
import com.google.gson.Gson;
import servidor.DtPromocion;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DevolverPromocion extends HttpServlet {
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String promo = request.getParameter("descProm");
        String promo2 = request.getParameter("preProm");
        ModelArticulo modArt = new ModelArticulo();
        DtPromocion p = modArt.datosPromocion(request.getParameter("nomProm"), request.getParameter("nickProm"));
        boolean ajax = "XMLHttpRequest".equals(request.getHeader("X-Requested-With"));
        try {
            if (ajax) {
                if (promo == null){
                    String descuento = String.valueOf(p.getDescuento());
                    response.setContentType("text/plain");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(descuento);

                }else if (promo2 == null){
                    String precio = String.valueOf(p.getPrecio());
                    response.setContentType("text/plain");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(precio);
                }else {
                    List<String> servicos = p.getServicios();
                    String json = new Gson().toJson(servicos);
                    response.setContentType("application/json");
                    response.setCharacterEncoding("UTF-8");
                    response.getWriter().write(json);   
                }
            } else {
                //System.out.println("????????");
                // Handle regular (JSP) response.
            }
            
        } finally {
            out.close();
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
