package help4travelling;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtInfoReserva implements Serializable {

    private DtFecha fechaIni;
    private DtFecha fechaFin;
    private int cantidad;
    private String nameArticulo;
    private String nickProveedor;
    private int idReserva;
    private float precioArticulo;
    private boolean estado;

    public DtInfoReserva() {
        this.estado = false;
    }

    public DtInfoReserva(DtFecha fechaIni, DtFecha fechaFin, int cantidad, String nameArticulo, String nickProveedor, int idReserva, float precioArticulo) {
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.cantidad = cantidad;
        this.nameArticulo = nameArticulo;
        this.nickProveedor = nickProveedor;
        this.idReserva = idReserva;
        this.precioArticulo = precioArticulo;
    }

    public DtInfoReserva(DtFecha fechaIni, DtFecha fechaFin, int cantidad, String nameArticulo, String nickProveedor, float precioArticulo) {
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.cantidad = cantidad;
        this.nameArticulo = nameArticulo;
        this.nickProveedor = nickProveedor;
        this.precioArticulo = precioArticulo;
    }

    public DtInfoReserva(String nombreArticulo, int cantidad, String nickProv, DtFecha fechaFin, DtFecha fechaIni, float precio) {
        this.nameArticulo = nombreArticulo;
        this.cantidad = cantidad;
        this.nickProveedor = nickProv;
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.precioArticulo = precio;
    }

    public DtInfoReserva(DtFecha fechaIni, int cantidad, String nameArticulo, String nickProveedor, int idReserva, float precioArticulo, boolean estado) {
        this.fechaIni = fechaIni;
        this.cantidad = cantidad;
        this.nameArticulo = nameArticulo;
        this.nickProveedor = nickProveedor;
        this.idReserva = idReserva;
        this.precioArticulo = precioArticulo;
        this.estado = estado;
    }

    public boolean getEstado() {
        return estado;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public DtFecha getFechaIni() {
        return fechaIni;
    }

    public DtFecha getFechaFin() {
        return fechaFin;
    }

    public int getCantidad() {
        return cantidad;
    }

    public String getNameArticulo() {
        return nameArticulo;
    }

    public String getNickProveedor() {
        return nickProveedor;
    }

    public int getIdReserva() {
        return idReserva;
    }

    public float getPrecioArticulo() {
        return precioArticulo;
    }

    public void setFechaIni(DtFecha fechaIni) {
        this.fechaIni = fechaIni;
    }

    public void setFechaFin(DtFecha fechaFin) {
        this.fechaFin = fechaFin;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void setNameArticulo(String nameArticulo) {
        this.nameArticulo = nameArticulo;
    }

    public void setNickProveedor(String nickProveedor) {
        this.nickProveedor = nickProveedor;
    }

    public void setIdReserva(int idReserva) {
        this.idReserva = idReserva;
    }

    public void setPrecioArticulo(float precioArticulo) {
        this.precioArticulo = precioArticulo;
    }

}
