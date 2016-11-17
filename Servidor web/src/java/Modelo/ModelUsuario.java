package Modelo;

import java.io.IOException;
import java.util.List;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.IOUtils;

public class ModelUsuario {
    private servidor.PublicadorService service =  new servidor.PublicadorService();;
    private servidor.Publicador port = service.getPublicadorPort();
    
    public servidor.DtCliente verPerfil(String nickname){
        //return ICUsuario.datosCliente(nickname);
        return port.verPerfil(nickname);
    }
    
    public boolean autenticarCliente(String nick, String pass){
        //return ICUsuario.VerificarUsuario(email, email);
        return port.autenticarCliente(nick, pass);
    }
    
    public List<String> listarProveedores(){
        //return ICUsuario.listarProveedores();
        return port.listarProveedores().getItem();
    } 
    
    public void agregarCliente(servidor.DtCliente dtcli){
        //ICUsuario.AltaCliente(dtcli);
        port.agregarCliente(dtcli);
    }
    
    public boolean VerificarNickCliente(String nick){
        //return ICUsuario.chequearNick(nick);
        return port.verificarNickCliente(nick);
    }
    
    public boolean VerificarEmailCliente(String email){
        //return ICUsuario.chequearEmail(email);
        return port.verificarEmailCliente(email);
    }
    
    public void agregarImagenCliente(InputStream f, String NickC){
        try {
            byte[] ff = IOUtils.readFully(f, -1, false);
            port.agregarImagenCliente(ff, NickC);
        } catch (IOException ex) {
            Logger.getLogger(ModelUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }          
    }
    
    public List<servidor.DtProveedor> listarProveedoresDatos(){
        return port.listarProveedoresDatos().getItem();
    }
       
    public byte[] getImagen(String nickP){
        //return ManejadorSQL.GetInstance().selectImgUsuario(nickP);
        //System.out.println(nickP);
        return port.getImagenUsu(nickP);
    }
    
    public servidor.DtCliente devolverCliente(String nick){
        //return ICUsuario.datosCliente(nick);
        return port.devolverCliente(nick);
    }
    
    public servidor.DtProveedor devolverProveedor(String nick){
        return port.devolverProveedor(nick);
    }
}
