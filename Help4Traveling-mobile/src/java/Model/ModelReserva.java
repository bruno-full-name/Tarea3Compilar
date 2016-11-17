package Model;

import java.util.ArrayList;
import net.java.dev.jaxb.array.IntArray;
import servidor.DtReserva;
import servidor.Publicador;
import servidor.PublicadorService;

public class ModelReserva {
    private static ModelReserva instancia;
    
    public static ModelReserva getInstance(){
        if (instancia==null){
            instancia = new ModelReserva();
        }
        return instancia;
    }
    
    public ArrayList<Integer> listarReservasXProv(String nickP){
        PublicadorService service =  new PublicadorService();
        Publicador port = service.getPublicadorPort();
        IntArray r =  port.listarReservasXprov(nickP);
        ArrayList<Integer> ret = new ArrayList<>();
        for(int x = 0; x < r.getItem().size(); x++){
            ret.add(r.getItem().get(x));
        }
        return ret;
    }
    
    public DtReserva devolverReserva(int idReserva){
        PublicadorService service =  new PublicadorService();
        Publicador port = service.getPublicadorPort();
        return port.devolverReserva(idReserva);
    }
    
    public boolean actualizarEstadoArticulo(String idReserva, String nickP, String nombreA){
        PublicadorService service =  new PublicadorService();
        Publicador port = service.getPublicadorPort();
        return port.actualizarEstadoArticulo(idReserva, nickP, nombreA);
    }
    
    public boolean facturarArticuloReserva(int idReserva, String nickProveedor){
        PublicadorService service =  new PublicadorService();
        Publicador port = service.getPublicadorPort();
        return port.facturarArticuloReserva(idReserva, nickProveedor);
    }
    
}
