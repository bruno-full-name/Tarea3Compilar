package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtCategoria", propOrder = {
    "nombre",
    "nombrePadre",
    "nivel"
})
public class DtCategoria {

    protected String nombre;
    protected String nombrePadre;
    protected int nivel;

    /**
     * Obtiene el valor de la propiedad nombre.
     *
     * @return possible object is {@link String }
     *
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Define el valor de la propiedad nombre.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Obtiene el valor de la propiedad nombrePadre.
     *
     * @return possible object is {@link String }
     *
     */
    public String getNombrePadre() {
        return nombrePadre;
    }

    /**
     * Define el valor de la propiedad nombrePadre.
     *
     * @param value allowed object is {@link String }
     *
     */
    public void setNombrePadre(String value) {
        this.nombrePadre = value;
    }

    /**
     * Obtiene el valor de la propiedad nivel.
     *
     * @return
     */
    public int getNivel() {
        return nivel;
    }

    /**
     * Define el valor de la propiedad nivel.
     *
     * @param value
     */
    public void setNivel(int value) {
        this.nivel = value;
    }

}
