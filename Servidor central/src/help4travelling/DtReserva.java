
package help4travelling;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtReserva implements Serializable {
    
    private int id;
    private DtFecha date;
    private Estado estado;
    private ArrayList<DtInfoReserva> infoReserva = new ArrayList<DtInfoReserva>();
    private String cli;
    private float precio;
    
    public DtReserva(){
    }
    
    public DtReserva(int id, Estado estado, DtFecha date, ArrayList<DtInfoReserva> infoReserva ,String nickCli, float precio){
        this.id = id;
        this.estado = estado;
        this.date = date;
        this.infoReserva = infoReserva;
        this.cli = nickCli;
        this.precio = precio;
    }    
    
     public DtReserva(Estado estado, DtFecha date, ArrayList<DtInfoReserva> infoReserva ,String nickCli, float precio){
        this.estado = estado;
        this.date = date;
        this.infoReserva = infoReserva;
        this.cli = nickCli;
        this.precio = precio;
    }   

    public int getId() {
        return id;
    }

    public DtFecha getDate() {
        return date;
    }

    public Estado getEstado() {
        return estado;
    }

    public ArrayList<DtInfoReserva> getInfoReserva() {
        return infoReserva;
    }

    public String getCli() {
        return cli;
    }

    public float getPrecio() {
        return precio;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDate(DtFecha date) {
        this.date = date;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public void setInfoReserva(ArrayList<DtInfoReserva> infoReserva) {
        this.infoReserva = infoReserva;
    }

    public void setCli(String cli) {
        this.cli = cli;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }
     
     
}
