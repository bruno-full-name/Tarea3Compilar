package help4travelling;

public class infoReserva {
    private DtFecha fechaIni;
    private DtFecha fechaFin;
    private int cantidad;
    private String provArt;
    private String nombreArt;
    private int idRes;
    private Estado estado;
    
    /*public infoReserva(DtInfoReserva dtir, Articulo a, Reserva r){
        this.fechaIni = dtir.GetFechaIni();
        this.fechaFin = dtir.GetFechaFin();
        this.cantidad = dtir.GetCantidad();
        this.art = a;
        this.res = r;
    }*/

    public infoReserva(DtFecha fechaIni, DtFecha fechaFin, int cantidad, String provArt, String nombreArt, int idRes, Estado estado) {
        this.fechaIni = fechaIni;
        this.fechaFin = fechaFin;
        this.cantidad = cantidad;
        this.provArt = provArt;
        this.nombreArt = nombreArt;
        this.idRes = idRes;
        this.estado = estado;
    }

    public infoReserva() {
    }
    
    
    
    public DtFecha getFechaIni() {
        return fechaIni;
    }

    public void setFechaIni(DtFecha fechaIni) {
        this.fechaIni = fechaIni;
    }

    public DtFecha getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(DtFecha fechaFin) {
        this.fechaFin = fechaFin;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getProvArt() {
        return provArt;
    }

    public void setProvArt(String provArt) {
        this.provArt = provArt;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }
    
    
    
    public infoReserva(String provArt, String nombreArt, int idRes){
        this.provArt = provArt;
        this.nombreArt = nombreArt;
        this.idRes = idRes;
    }
    
    public int GetCantidad(){
        return this.cantidad;
    }
    
   /* public Articulo GetArticulo(){
        return this.art;
    }
    
    public Reserva GetReserva(){
        return this.res;
    }*/
    
    public DtFecha GetFechaIni(){
        return this.fechaIni;
    }
    
    public DtFecha GetFechaFin(){
        return this.fechaFin;
    }
    
    public void EnlazarReserva(Articulo a){
        this.provArt = a.prov;
        this.nombreArt = a.nombre;
    }    
    
    public void EnlazarReserva(Reserva r){
        this.idRes = r.GetId();
    }
    
    public DtInfoReserva GetDtInfoReserva(){
        return ManejadorSQL.GetInstance().devolverInfoReserva(this.idRes, this.nombreArt, this.provArt);
    }

    public String getNickProveedor() {
        return this.provArt;
    }
    
     public String getNombreArt() {
        return nombreArt;
    }

    public int getIdRes() {
        return idRes;
    }
       
     public void DesenlazarInfoReserva(){
        this.provArt = null;
        this.idRes = 0;
     }
}
