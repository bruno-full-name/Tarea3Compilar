
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Clase Java para dtReserva complex type.
 * 
 * <p>El siguiente fragmento de esquema especifica el contenido que se espera que haya en esta clase.
 * 
 * <pre>
 * &lt;complexType name="dtReserva">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="date" type="{http://servidor/}dtFecha" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://servidor/}estado" minOccurs="0"/>
 *         &lt;element name="infoReserva" type="{http://servidor/}dtInfoReserva" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="cli" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="precio" type="{http://www.w3.org/2001/XMLSchema}float"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dtReserva", propOrder = {
    "id",
    "date",
    "estado",
    "infoReserva",
    "cli",
    "precio"
})
public class DtReserva {

    protected int id;
    protected DtFecha date;
    protected Estado estado;
    @XmlElement(nillable = true)
    protected List<DtInfoReserva> infoReserva;
    protected String cli;
    protected float precio;

    /**
     * Obtiene el valor de la propiedad id.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Define el valor de la propiedad id.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Obtiene el valor de la propiedad date.
     * 
     * @return
     *     possible object is
     *     {@link DtFecha }
     *     
     */
    public DtFecha getDate() {
        return date;
    }

    /**
     * Define el valor de la propiedad date.
     * 
     * @param value
     *     allowed object is
     *     {@link DtFecha }
     *     
     */
    public void setDate(DtFecha value) {
        this.date = value;
    }

    /**
     * Obtiene el valor de la propiedad estado.
     * 
     * @return
     *     possible object is
     *     {@link Estado }
     *     
     */
    public Estado getEstado() {
        return estado;
    }

    /**
     * Define el valor de la propiedad estado.
     * 
     * @param value
     *     allowed object is
     *     {@link Estado }
     *     
     */
    public void setEstado(Estado value) {
        this.estado = value;
    }

    /**
     * Gets the value of the infoReserva property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the infoReserva property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getInfoReserva().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DtInfoReserva }
     * 
     * 
     */
    public List<DtInfoReserva> getInfoReserva() {
        if (infoReserva == null) {
            infoReserva = new ArrayList<DtInfoReserva>();
        }
        return this.infoReserva;
    }

    /**
     * Obtiene el valor de la propiedad cli.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCli() {
        return cli;
    }

    /**
     * Define el valor de la propiedad cli.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCli(String value) {
        this.cli = value;
    }

    /**
     * Obtiene el valor de la propiedad precio.
     * 
     */
    public float getPrecio() {
        return precio;
    }

    /**
     * Define el valor de la propiedad precio.
     * 
     */
    public void setPrecio(float value) {
        this.precio = value;
    }

}
