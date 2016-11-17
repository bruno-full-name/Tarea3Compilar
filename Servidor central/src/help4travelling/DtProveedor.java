package help4travelling;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtProveedor implements Serializable {
 
    private String nick;
    private String nombre;
    private String apellido;
    private String email;
    private DtFecha fechaN;
    private String nombreEmpresa;
    private String url;
    private ArrayList<DtServicio> servicio;
    private String clave;
    
    public DtProveedor(){
    }
     
    public DtProveedor(String nick, String nombre, String apellido, String email, DtFecha fechaN, String nombreEmpresa, String url, ArrayList<DtServicio> servicio, String clave){
        this.nick=nick;
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.fechaN=fechaN;
        this.nombreEmpresa=nombreEmpresa; 
        this.url=url;
        this.servicio=servicio;
        this.clave=clave;
    }

    public String getNick() {
        return nick;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getEmail() {
        return email;
    }

    public DtFecha getFechaN() {
        return fechaN;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public String getUrl() {
        return url;
    }

    public ArrayList<DtServicio> getServicio() {
        return servicio;
    }

    public String getClave() {
        return clave;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setFechaN(DtFecha fechaN) {
        this.fechaN = fechaN;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setServicio(ArrayList<DtServicio> servicio) {
        this.servicio = servicio;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
    
    
    
    
}
