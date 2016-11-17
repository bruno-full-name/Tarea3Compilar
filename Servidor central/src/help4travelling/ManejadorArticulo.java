package help4travelling;

import java.util.ArrayList;
import java.util.Map;
import javafx.util.Pair;

public class ManejadorArticulo {

    private static ArrayList<Articulo> articulos = new ArrayList<Articulo>();
    private static ManejadorArticulo instance = null;


    public static ManejadorArticulo GetInstance(){
        if (instance==null){
            instance = new ManejadorArticulo();
        }
        articulos.clear();
        Map<Pair<String,String>,Promocion> arrayProm = ManejadorSQL.GetInstance().cargarPromociones();
        Map<Pair<String,String>,Servicio> arrayServ = ManejadorSQL.GetInstance().cargarServicios();
        for (Pair<String,String> name: arrayProm.keySet()) {
            Promocion prom = new Promocion(name.getKey(),name.getValue());
            articulos.add((Articulo)prom);
        }
        for (Pair<String,String> name2: arrayServ.keySet()) {
            Servicio ser = new Servicio(name2.getKey(),name2.getValue());
            articulos.add((Articulo)ser);

        }
        return instance;
    }

    public void AgregarPromocion(Promocion p){
        this.articulos.add(p);
    }

    public void AgregarServicio(Servicio s){
        this.articulos.add(s);
    }

    public boolean IsPromocion(String name, String nomProv){
        for (int i = 0; i < articulos.size(); i++) {
             if (articulos.get(i).GetNombre() == name && articulos.get(i).getProv() == nomProv && articulos.get(i).isPromocion())
                return true;
        }
        return false;
    }

     public ArrayList<DtPromocion> listarPromociones(){
        ArrayList<DtPromocion> ArrayPromociones = new ArrayList<DtPromocion>();
        for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).isPromocion())
                ArrayPromociones.add(articulos.get(i).getDtPromocion());
        }
        return ArrayPromociones;
    }

    public ArrayList<DtServicio> ListarServicios(){
        ArrayList<DtServicio> ret = new ArrayList<>();
        for (int i = 0; i < articulos.size(); i++) {
            if(articulos.get(i).IsServicio()){
                ret.add(articulos.get(i).GetDtServicio());
            }
        }
        return ret;
    }

    public ArrayList<DtPromocion> listarPromocionesProv(String nick){
        ArrayList<DtPromocion> ArrayPromociones = new ArrayList<>();
        for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).isPromocion() && articulos.get(i).getProv().equals(nick)){
                ArrayPromociones.add(new DtPromocion(articulos.get(i).getDtPromocion().getNombre(),articulos.get(i).getDtPromocion().getNickProv()));
            }
        }
        return ArrayPromociones;
    }

    public ArrayList<DtServicio> ListarServiciosProv(String nick){
        ArrayList<DtServicio> ret = new ArrayList<>();
        for (int i = 0; i < articulos.size(); i++) {
            if(articulos.get(i).IsServicio() && articulos.get(i).getProv().equals(nick)){
                ret.add(ManejadorSQL.GetInstance().devolverServicio(articulos.get(i).GetDtServicio().getNickProveedor(), articulos.get(i).GetDtServicio().getNombre()));
            }
        }
        return ret;
    }


    public DtPromocion datosPromociones(String nombreProm, String nomProv){
         for (int i = 0; i < articulos.size(); i++) {
             if (articulos.get(i).GetNombre().equals(nombreProm) && articulos.get(i).getProv().equals(nomProv))
                 return articulos.get(i).getDtPromocion();
         }
         return ManejadorSQL.GetInstance().devolverPromocion(nomProv, nombreProm);
    }

    public DtServicio datosServicio(String nombreServ, String nomProv){
         return this.BuscarServicio(nombreServ, nomProv).GetDtServicio();
    }

    public Servicio BuscarServicio(String nameServ, String nomProv){
        Articulo serv = null;
        for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).GetNombre().equals(nameServ) && articulos.get(i).getProv().equals(nomProv) && articulos.get(i).IsServicio()){
                serv = articulos.get(i);
            }
        }
        return (Servicio)serv;
    }

    public Servicio ModificarServicio(DtServicio modSer){
        ManejadorSQL.GetInstance().atualizarServicio(modSer);
        return new Servicio(modSer);
    }

    public Articulo ObtenerArticulo(String nameArti, String nomProv){
        Articulo Art = null;
        for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).GetNombre().equals(nameArti) && articulos.get(i).getProv().equals(nomProv)){
                Art = articulos.get(i);
            }
        }
        return Art;
    }

    public boolean insertarServicio(DtServicio DtServ, Ciudad ciudadO, Ciudad ciudadD){
       for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).GetNombre().equals(DtServ.getNombre()) && articulos.get(i).getProv().equals(DtServ.getNickProveedor()) )
                return false;
       }
       Servicio serv = new Servicio(DtServ.getNombre(), DtServ.getNickProveedor());
       //Servicio serv = new Servicio(DtServ.getNombre(), DtServ.getNickProveedor(), DtServ.getDescripcion(), ciudadO, ciudadD, DtServ.getPrecio());
       articulos .add((Articulo)serv);
       //mandar datos a la base de datos
       return ManejadorSQL.GetInstance().agregarServicio(DtServ, DtServ.getNickProveedor(), DtServ.getCategorias());
    }

    public boolean insertarPromocion(DtPromocion promo){
       for (int i = 0; i < articulos.size(); i++) {
            if (articulos.get(i).GetNombre().equals(promo.getNombre()) && articulos.get(i).getProv().equals(promo.getNickProv()) )
                return false;
       }
       Promocion p = new Promocion(promo.getNombre(), promo.getNickProv());
       articulos.add((Articulo)p);
       return ManejadorSQL.GetInstance().agregarPromocion(promo, promo.getNickProv(), promo.getServicios());
    }

    public int devolverVisitas(String nickP, String nombreA){
        return ManejadorSQL.GetInstance().devolverVisitas(nickP, nombreA);
    }
    
    public ArrayList<DtServicio> devolverVisitas(){
        return ManejadorSQL.GetInstance().devolverVisitas();
    }

    public boolean agregarVisita(String nickP, String nombreA){
        return ManejadorSQL.GetInstance().ingresarVisita(nickP, nombreA);
    }
    
    public ArrayList<String> listarServiciosXprom(String nickP, String nombrePromo){
        return ManejadorSQL.GetInstance().listarServiciosXprom(nickP, nombrePromo);
    }

}
