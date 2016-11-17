package help4travelling;

public class Visita {
    private int id, cantVisitas;

    public Visita(int id, int cantVisitas) {
        this.id = id;
        this.cantVisitas = cantVisitas;
    }

    public Visita() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCantVisitas() {
        return cantVisitas;
    }

    public void setCantVisitas(int cantVisitas) {
        this.cantVisitas = cantVisitas;
    }
    
}
