/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Control;

//import help4travelling.DtInfoReserva;
import servidor.DtInfoReserva;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author bruno
 */
@WebServlet(name = "AgregarAlCarrito", urlPatterns = {"/AgregarAlCarrito"})
public class AgregarAlCarrito extends HttpServlet {

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        String nickProm = request.getParameter("nickProm");
        String nomProm = request.getParameter("nomProm");
        String precio = request.getParameter("preProm");
        String cant = request.getParameter("cant");
        
        float precio2 = 0;
        if (precio != null)
            precio2 = Float.valueOf(precio);
        int cant2 = 0;
        if (cant != null)
            cant2 = Integer.valueOf(cant);
        
        String nickServ =  request.getParameter("nickServ");
        String nomServ =  request.getParameter("nomServ");
        String precioServ = request.getParameter("preServ");
        String cantServ = request.getParameter("cantServ");
        
        float precioServ2 = 0;
        if (precioServ != null)
            precioServ2 = Float.valueOf(precioServ);
        int cantServ2 = 0;
        if (cantServ != null)
            cantServ2 = Integer.valueOf(cantServ);
        
        ArrayList<DtInfoReserva> listInfoRes= null;
        DtInfoReserva carrito = null;
        HttpSession session= null;
  
        if ( nickProm != null &&  nomProm != null){
            carrito = new DtInfoReserva();
            carrito.setCantidad(cant2);
            carrito.setNameArticulo(nomProm);
            carrito.setNickProveedor(nickProm);
            carrito.setPrecioArticulo(precio2);
            session = request.getSession();
        }else if (nickServ != null && nomServ != null){
            carrito = new DtInfoReserva();
            carrito.setCantidad(cantServ2);
            carrito.setNameArticulo(nomServ);
            carrito.setNickProveedor(nickServ);
            carrito.setPrecioArticulo(precioServ2);
            session = request.getSession();
        }
        listInfoRes = (ArrayList<DtInfoReserva>) session.getAttribute("ListaInfoRes");
        //System.out.println(listInfoRes);
        if (listInfoRes == null){
            ArrayList<DtInfoReserva> carrito2 = new ArrayList<DtInfoReserva>();
            carrito2.add(carrito);
            session.setAttribute("ListaInfoRes", carrito2);
        }else{
            boolean ent = false;
            int pos = 0;
            DtInfoReserva carrito3 = null;
            for (int i=0; i < listInfoRes.size(); i++){
                if(listInfoRes.get(i).getNameArticulo().equals(carrito.getNameArticulo())  && listInfoRes.get(i).getNickProveedor().equals(carrito.getNickProveedor())){
                    carrito3 = new DtInfoReserva();
                    carrito3.setCantidad(carrito.getCantidad() + listInfoRes.get(i).getCantidad());
                    carrito3.setNameArticulo(listInfoRes.get(i).getNameArticulo());
                    carrito3.setNickProveedor(listInfoRes.get(i).getNickProveedor());
                    carrito3.setPrecioArticulo(listInfoRes.get(i).getPrecioArticulo());
                    pos = i;
                    ent = true;
                }
            }
            if (ent == false){
                listInfoRes.add(carrito);
            }else{
                listInfoRes.remove(pos);
                listInfoRes.add(carrito3);
            }         
            session.setAttribute("ListaInfoRes", listInfoRes);
        }
        try {
            /* TODO output your page here. You may use following sample code. */

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
