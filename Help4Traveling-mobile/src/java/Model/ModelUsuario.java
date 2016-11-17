package Model;

import servidor.Publicador;
import servidor.PublicadorService;

public class ModelUsuario {
    private static ModelUsuario instancia;
    
    public static ModelUsuario getInstance(){
        if (instancia==null){
            instancia = new ModelUsuario();
        }
        return instancia;
    }
    
    public boolean autenticarProveedor(String nick, String pass){
        PublicadorService service =  new PublicadorService();
        Publicador port = service.getPublicadorPort();
        return port.autenticarProveedor(nick, pass);
    }
    
    
}
