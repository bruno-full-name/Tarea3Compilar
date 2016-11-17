package help4travelling;

import java.io.Serializable;
import java.util.ArrayList;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtServicio implements Serializable {

    private String nombre;
    private String nickProveedor;
    private Float precio;
    private String descripcion;
    private ArrayList<String> categorias;
    private String ciudadOrigen;
    private String ciudadDestino;
    private int visitas;

    public DtServicio() {
    }
    
    public DtServicio(String nombre, String nickProveedor) {
        this.nombre = nombre;
        this.nickProveedor = nickProveedor;
    }
    
    public DtServicio(String nombre, int cantVisitas){
        this.nombre = nombre;
        this.visitas = cantVisitas;
    }

    public DtServicio(String nombre, String nickProv, float precio, String descripcion, ArrayList<String> categorias, String ciudadOrigen, String ciudadDestino) {
        this.nombre = nombre;
        this.nickProveedor = nickProv;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categorias = categorias;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
    }

    public DtServicio(String nombre, String nickProv, float precio, String descripcion, ArrayList<String> categorias, String ciudadOrigen, String ciudadDestino, int v) {
        this.nombre = nombre;
        this.nickProveedor = nickProv;
        this.precio = precio;
        this.descripcion = descripcion;
        this.categorias = categorias;
        this.ciudadOrigen = ciudadOrigen;
        this.ciudadDestino = ciudadDestino;
        this.visitas = v;
    }

    public DtServicio(String nombre, Float precio, String descripcion) {
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
    }

    public DtServicio(String nombre) {
        this.nombre = nombre;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNickProveedor() {
        return nickProveedor;
    }

    public Float getPrecio() {
        return precio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public ArrayList<String> getCategorias() {
        return categorias;
    }

    public String getCiudadOrigen() {
        return ciudadOrigen;
    }

    public String getCiudadDestino() {
        return ciudadDestino;
    }

    public int getVisitas() {
        return visitas;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNickProveedor(String nickProveedor) {
        this.nickProveedor = nickProveedor;
    }

    public void setPrecio(Float precio) {
        this.precio = precio;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCategorias(ArrayList<String> categorias) {
        this.categorias = categorias;
    }

    public void setCiudadOrigen(String ciudadOrigen) {
        this.ciudadOrigen = ciudadOrigen;
    }

    public void setCiudadDestino(String ciudadDestino) {
        this.ciudadDestino = ciudadDestino;
    }

    public void setVisitas(int visitas) {
        this.visitas = visitas;
    }

}
