
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtInfoReserva complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtInfoReserva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechaIni" type="{http://servidor/}dtFecha" minOccurs="0"/>
 *         &lt;element name="fechaFin" type="{http://servidor/}dtFecha" minOccurs="0"/>
 *         &lt;element name="cantidad" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nameArticulo" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="nickProveedor" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="idReserva" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="precioArticulo" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *         &lt;element name="estado" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtInfoReserva", propOrder = {
    "fechaIni",
    "fechaFin",
    "cantidad",
    "nameArticulo",
    "nickProveedor",
    "idReserva",
    "precioArticulo",
    "estado"
})
public class DtInfoReserva {

    protected DtFecha fechaIni;
    protected DtFecha fechaFin;
    protected int cantidad;
    protected String nameArticulo;
    protected String nickProveedor;
    protected int idReserva;
    protected float precioArticulo;
    protected boolean estado;

    /**
     * Obtiene el valor de la propiedad fechaIni.
     * 
     * @return
     *     possible object is
     *     {@link DtFecha }
     *     
     */
    public DtFecha getFechaIni() {
        return fechaIni;
    }

    /**
     * Define el valor de la propiedad fechaIni.
     * 
     * @param value
     *     allowed object is
     *     {@link DtFecha }
     *     
     */
    public void setFechaIni(DtFecha value) {
        this.fechaIni = value;
    }

    /**
     * Obtiene el valor de la propiedad fechaFin.
     * 
     * @return
     *     possible object is
     *     {@link DtFecha }
     *     
     */
    public DtFecha getFechaFin() {
        return fechaFin;
    }

    /**
     * Define el valor de la propiedad fechaFin.
     * 
     * @param value
     *     allowed object is
     *     {@link DtFecha }
     *     
     */
    public void setFechaFin(DtFecha value) {
        this.fechaFin = value;
    }

    /**
     * Obtiene el valor de la propiedad cantidad.
     * 
     */
    public int getCantidad() {
        return cantidad;
    }

    /**
     * Define el valor de la propiedad cantidad.
     * 
     */
    public void setCantidad(int value) {
        this.cantidad = value;
    }

    /**
     * Obtiene el valor de la propiedad nameArticulo.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNameArticulo() {
        return nameArticulo;
    }

    /**
     * Define el valor de la propiedad nameArticulo.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNameArticulo(String value) {
        this.nameArticulo = value;
    }

    /**
     * Obtiene el valor de la propiedad nickProveedor.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNickProveedor() {
        return nickProveedor;
    }

    /**
     * Define el valor de la propiedad nickProveedor.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNickProveedor(String value) {
        this.nickProveedor = value;
    }

    /**
     * Obtiene el valor de la propiedad idReserva.
     * 
     */
    public int getIdReserva() {
        return idReserva;
    }

    /**
     * Define el valor de la propiedad idReserva.
     * 
     */
    public void setIdReserva(int value) {
        this.idReserva = value;
    }

    /**
     * Obtiene el valor de la propiedad precioArticulo.
     * 
     */
    public float getPrecioArticulo() {
        return precioArticulo;
    }

    /**
     * Define el valor de la propiedad precioArticulo.
     * 
     */
    public void setPrecioArticulo(float value) {
        this.precioArticulo = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     */
    public boolean isEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     */
    public void setEstado(boolean value) {
        this.estado = value;
    }

}
