package help4travelling;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtCliente implements Serializable {

    private String nick;
    private String clave;
    private String nombre;
    private String apellido;
    private String email;
    private DtFecha fechaN;
    private ArrayList<Integer> reservas;

    public DtCliente() {
    }

    public DtCliente(String nick, String nombre, String apellido, String email, DtFecha fechaN, ArrayList<Integer> r, String clave){
        this.nick=nick;
        this.nombre=nombre;
        this.apellido=apellido;
        this.email=email;
        this.fechaN=fechaN;
        this.reservas=r;
        this.clave=clave;
    }
    
    public String getNick() {
        return nick;
    }

    public String getClave() {
        return clave;
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

    public ArrayList<Integer> getReservas() {
        return reservas;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setClave(String clave) {
        this.clave = clave;
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

    public void setReservas(ArrayList<Integer> reservas) {
        this.reservas = reservas;
    }

}
