
package help4travelling;

import java.io.Serializable;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtFecha implements Serializable{
    private int anio;
    private int mes;
    private int dia;
    
    public DtFecha(int anio, int mes, int dia){
        this.anio = anio;
        this.mes = mes;
        this.dia =  dia;
    }
    
    public DtFecha(){
       this.anio = Calendar.YEAR;
       this.mes = Calendar.MONTH;
       this.dia = Calendar.DATE;
    }

    @Override
    public String toString() {
        return (anio + "/" + mes + "/" + dia);
    }
    
    //Contruye la fecha con un string de esta forma "yyyy/mm/dd"
    public DtFecha(String bdformato){
        try{        
            String[] parts = bdformato.split("/");
            this.anio = Integer.parseInt(parts[0]);
            this.mes = Integer.parseInt(parts[1]);
            this.dia = Integer.parseInt(parts[2]);  
        } catch (Exception ex) {
            String[] parts = bdformato.split("-");
            this.anio = Integer.parseInt(parts[0]);
            this.mes = Integer.parseInt(parts[1]);
            this.dia = Integer.parseInt(parts[2]); 
        }

    }

    public int getAnio() {
        return this.anio;
    }

    public int getMes() {
        return this.mes;
    }

    public int getDia() {
        return this.dia;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    
}
