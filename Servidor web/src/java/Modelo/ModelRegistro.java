package Modelo;

import servidor.Publicador;
import servidor.PublicadorService;

public class ModelRegistro {
    
    public boolean agregarRegistro(String ip, String url, String nav, String so){
        PublicadorService service =  new PublicadorService();
        Publicador port = service.getPublicadorPort();
        return (port.agregarRegistro(ip, url, nav, so) == 1);
    }
    
}
