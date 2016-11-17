package help4travelling;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtCategoria implements Serializable {
    
    private String nombre;
    private String nombrePadre;
    private int nivel;
    
    public DtCategoria(){
    }
    
    public DtCategoria(String nombre,String nombrePadre, int nivel){
       this.nombre=nombre;
       this.nombrePadre=nombrePadre; 
       this.nivel=nivel;
    }

    public String getNombre() {
        return nombre;
    }

    public String getNombrePadre() {
        return nombrePadre;
    }

    public int getNivel() {
        return nivel;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setNombrePadre(String nombrePadre) {
        this.nombrePadre = nombrePadre;
    }

    public void setNivel(int nivel) {
        this.nivel = nivel;
    }

    
    
}
