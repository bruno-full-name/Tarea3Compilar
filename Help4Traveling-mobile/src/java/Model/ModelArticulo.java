package Model;

import java.util.ArrayList;
import net.java.dev.jaxb.array.StringArray;
import servidor.DtPromocion;
import servidor.DtPromocionArray;
import servidor.DtServicio;
import servidor.DtServicioArray;
import servidor.Publicador;
import servidor.PublicadorService;


public class ModelArticulo {
    private static ModelArticulo instancia;
    
    public static ModelArticulo getInstance(){
        if (instancia==null){
            instancia = new ModelArticulo();
        }
        return instancia;
    }
    
    public ArrayList<String> listarServiciosXprom(String nickP, String nombrePromo){
        PublicadorService service =  new PublicadorService();
        Publicador port = service.getPublicadorPort();
        StringArray s = port.listarServiciosXprom(nickP, nombrePromo);
        ArrayList<String> ret = new ArrayList<>();
        for(int x = 0; x < s.getItem().size(); x++){
            ret.add(s.getItem().get(x));
        }
        return ret;
    }
    
    public ArrayList<DtServicio> listarServiciosXprov(String nickP){
        PublicadorService service =  new PublicadorService();
        Publicador port = service.getPublicadorPort();
        DtServicioArray s = port.listarServiciosXprov(nickP);
        ArrayList<DtServicio> ret = new ArrayList<>();
        for(int x = 0; x < s.getItem().size(); x++){
            ret.add(s.getItem().get(x));
        }
        return ret;
    }
        
    public ArrayList<DtPromocion> listarPromocionesXprov(String nickP){
        PublicadorService service =  new PublicadorService();
        Publicador port = service.getPublicadorPort();
        DtPromocionArray p = port.listarPromocionesXprov(nickP);
        ArrayList<DtPromocion> ret = new ArrayList<>();
        for(int x = 0; x < p.getItem().size(); x++){
            ret.add(p.getItem().get(x));
        }
        return ret;
    }
    
    public boolean agregarVisita(String nickP, String nombreA){
        PublicadorService service =  new PublicadorService();
        Publicador port = service.getPublicadorPort();
        return port.agregarVisita(nickP, nombreA);
    }
    
    public DtServicio devolverServicio(String nickP, String nombreA){
        PublicadorService service =  new PublicadorService();
        Publicador port = service.getPublicadorPort();
        return port.obtenerDatosServicio(nombreA, nickP);
    }
    
    public DtPromocion devolverPromocion(String nickP, String nombreA){
        PublicadorService service =  new PublicadorService();
        Publicador port = service.getPublicadorPort();
        return port.datosPromocion(nombreA, nickP);
    }
    
    public byte[] getImagen(String nickP, String nombreA, String num){
        PublicadorService service =  new PublicadorService();
        Publicador port = service.getPublicadorPort();
        byte[] a = port.getImagenArt(nickP, nombreA, num);
        return a;
    }
    
    public boolean esServicio(String arg0) {
        servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        return port.esServicio(arg0);
    }
    
}
