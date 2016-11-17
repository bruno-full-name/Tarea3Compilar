package help4travelling;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DtVisita implements Serializable{
    private int id, cantVisitas;

    public DtVisita(int id, int cantVisitas) {
        this.id = id;
        this.cantVisitas = cantVisitas;
    }

    public DtVisita() {
    }

    public int getId() {
        return id;
    }

    public int getCantVisitas() {
        return cantVisitas;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCantVisitas(int cantVisitas) {
        this.cantVisitas = cantVisitas;
    }
    

}
