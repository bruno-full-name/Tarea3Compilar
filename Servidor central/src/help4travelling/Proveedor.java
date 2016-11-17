package help4travelling;

import java.util.HashMap;
import java.util.ArrayList;

public class Proveedor extends Usuario{

    private String nombreEmpresa;
    private String url;
    private HashMap<String, Servicio> servicios = new HashMap<String, Servicio>();

    public Proveedor (DtProveedor u){
        this.nick= u.getNick();
        this.clave = u.getClave();
        this.nombre= u.getNombre();
        this.apellido= u.getApellido();
        this.email= u.getEmail();
        this.fechaN = u.getFechaN();
        this.nombreEmpresa= u.getNombreEmpresa();
        this.url= u.getUrl();
    }
    
     public Proveedor (String nick){
        this.nick = nick;
    }

    public String getNickCliente(){
        return null;
    }

    public String getNickProveedor(){
        return this.nick;
    }

    public DtProveedor getDtProveedor(){
        return ManejadorSQL.GetInstance().devolverProveedor(this.nick);        
    }
}
