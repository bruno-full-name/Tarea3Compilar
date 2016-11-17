package servidor;

import help4travelling.*;
import java.io.ByteArrayInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Properties;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.ParameterStyle;
import javax.jws.soap.SOAPBinding.Style;
import javax.xml.ws.Endpoint;

@WebService
@SOAPBinding(style = Style.RPC, parameterStyle = ParameterStyle.WRAPPED)
public class Publicador {

    //private Logica logica = new Logica();
    private static IControladorCategoria ICCategoria = Factory.GetInstance().getIControladorCategoria();
    private static IControladorArticulo ICArticulo = Factory.GetInstance().getIControladorArticulo();
    private static IControladorReserva ICReserva = Factory.GetInstance().getIControladorReserva();
    private static IControladorUsuario ICUsuario = Factory.GetInstance().getIControladorUsuario();
    private static IControladorRegistro ICRegistro = Factory.GetInstance().getIControladorRegistro();
    private Endpoint endpoint = null;

    //Constructor
    public Publicador() {
    }

    @WebMethod(exclude = true)
    public void publicar() {
            
        Properties propiedades = new Properties();
        InputStream entrada = null;
        
        try{
            
            entrada = new FileInputStream("Conexion.properties");
            
            propiedades.load(entrada);
            
            String publicador_ip = propiedades.getProperty("publicador.ip");
            String publicador_port = propiedades.getProperty("publicador.port");
            String publicador_name = propiedades.getProperty("publicador.name");
            
            endpoint = Endpoint.publish("http://"+publicador_ip+":"+publicador_port+"/"+publicador_name, this);
    
            entrada.close();
            
        }catch(IOException ex){
            ex.printStackTrace();
        }
        
        //endpoint = Endpoint.publish("http://localhost:9130/publicadorWeb", this);
    }

    @WebMethod(exclude = true)
    public Endpoint getEndpoint() {
        return endpoint;
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    //Articulos
    @WebMethod
    public DtPromocion[] listarPromociones() {
        //return ICArticulo.listarPromociones();
        ArrayList<DtPromocion> prom = ICArticulo.listarPromociones();
        DtPromocion[] ret = prom.toArray(new DtPromocion[prom.size()]);
        return ret;
    }
    
    @WebMethod
    public boolean agregarVisita(String nickP, String nombreA){
        return ICArticulo.agregarVisita(nickP, nombreA);
    }
    
    @WebMethod
    public DtPromocion datosPromocion(String nombreProm, String nameProv) {
        return ICArticulo.datosPromociones(nombreProm, nameProv);
    }

    @WebMethod
    public boolean EsServicio(String nombreServicio) {
        //Toma por sentado que el nombre es de un servicio, recorre todos las promociones del sistema, si el nombre es igual a una de ellas devuelve false
        ArrayList<DtPromocion> lart = ICArticulo.listarPromociones();
        boolean ret = true;
        for (DtPromocion x : lart) {
            if (x.getNombre().equalsIgnoreCase(nombreServicio)) {
                ret = false;
            }
        }
        return ret;
    }

    @WebMethod
    public DtServicio[] serviciosXprov(String nickP) {
        //return ICArticulo.ListarServiciosProv(nickP);
        ArrayList<DtServicio> servXprom = ICArticulo.ListarServiciosProv(nickP);
        DtServicio[] ret = servXprom.toArray(new DtServicio[servXprom.size()]);
        return ret;
    }
    
    @WebMethod
    public String[] listarServiciosXprom(String nickP, String nombrePromo) {
        //return ICArticulo.ListarServiciosProv(nickP);
        ArrayList<String> servXprom = ICArticulo.listarServiciosXprom(nickP, nombrePromo);
        String[] ret = servXprom.toArray(new String[servXprom.size()]);
        /*for(int x = 0; x < servXprom.size(); x++){
            ret[x] = servXprom.get(x);
        }*/
        return ret;
    }

    @WebMethod
    public DtCategoria[] listarCategorias() {
        //return ICCategoria.listarCategorias();
        ArrayList<DtCategoria> cat = ICCategoria.listarCategorias();
        DtCategoria[] ret = cat.toArray(new DtCategoria[cat.size()]);
        return ret;
    }

    @WebMethod
    public DtServicio[] listarServicios() {
        //return ICArticulo.ListarServicios();
        ArrayList<DtServicio> serv = ICArticulo.ListarServicios();
        DtServicio[] ret = serv.toArray(new DtServicio[serv.size()]);
        return ret;
    }

    @WebMethod
    public DtServicio[] serviciosXcat(String nameCat) {
        //return ICCategoria.listarServicios(nameCat);
        ArrayList<DtServicio> servXcat = ICCategoria.listarServicios(nameCat);
        DtServicio[] ret = servXcat.toArray(new DtServicio[servXcat.size()]);
        return ret;
    }

    @WebMethod
    public DtServicio ObtenerDatosServicio(String nameServ, String nameProv) {
        return ICArticulo.datosServicio(nameServ, nameProv);
    }

    @WebMethod
    public byte[] getImagenArt(String nickP, String nomA, String num) {
        return ManejadorSQL.GetInstance().selectImgServicio(num, nickP, nomA);
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    //Reservas
    @WebMethod
    public Integer[] listarReservas(String nickname) {
        //return ICReserva.listarReservasXcli(nickname);
        ArrayList<Integer> res = ICReserva.listarReservasXcli(nickname);
        Integer[] ret = res.toArray(new Integer[res.size()]);
        return ret;
    }

    @WebMethod
    public DtReserva devolverReserva(int id) {
        return ICReserva.datosReservas(id);
    }

    @WebMethod
    public Integer[] ObtenerReservas(String cli) {
        ArrayList<Integer> res = ICReserva.listarReservasXcli(cli);
        Integer[] Iret = res.toArray(new Integer[res.size()]);
        return Iret;
    }

    @WebMethod
    public DtInfoReserva[] ObtenerDatosReserva(int idRes) {
        //return ICReserva.ObtenerInfoArticulosReservados(idRes);
        ArrayList<DtInfoReserva> datRes = ICReserva.ObtenerInfoArticulosReservados(idRes);
        DtInfoReserva[] ret = datRes.toArray(new DtInfoReserva[datRes.size()]);
        return ret;
    }

    @WebMethod
    public boolean agregarRes(Estado E, DtFecha fecha, DtInfoReserva[] DtInf, String nick, float F) {
        ArrayList<DtInfoReserva> infRes = new ArrayList<>(Arrays.asList(DtInf));
        return ICReserva.CrearReserva(new DtReserva(E, fecha, infRes, nick, F));
    }

    @WebMethod
    public boolean cancelarReserva(int id) {
        return ICReserva.actualizarEstado(Estado.Cancelada, id);
    }
    
    @WebMethod
    public boolean pagarReserva(int id) {
        //System.out.println("pagada");
        return ICReserva.actualizarEstado(Estado.Pagada, id);
    }
    
    @WebMethod
    public boolean agregarFactura(String idReserva, String nickCliente, float precio, String fecha){
        return ICReserva.agregarFactura(idReserva, nickCliente, precio, fecha);
    }
    
    @WebMethod
    public boolean facturarArticuloReserva(int idReserva, String nickP) {
        return ICReserva.facturarArticuloReserva(idReserva, nickP);
    }
    
    @WebMethod
    public boolean estaFacturadaReserva(int idReserva){
        return ICReserva.estaFacturadaReserva(idReserva);
    }
    
    @WebMethod
    public boolean estaFacturadoArticulo(int idReserva, String nickP, String nombreA){
        return ICReserva.estaFacturadoArticulo(idReserva, nickP, nombreA);
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    //Usuarios
    
    @WebMethod
    public boolean autenticarProveedor(String nickname, String password) {
        return ICUsuario.autenticarProveedor(nickname, password);
    }
    
    @WebMethod
    public boolean autenticarCliente(String nickname, String password) {
        return ICUsuario.autenticarCliente(nickname, password);
    }

    @WebMethod
    public DtCliente verPerfil(String nickname) {
        return ICUsuario.datosCliente(nickname);
    }

    @WebMethod
    public String[] listarProveedores() {
        //return (ArrayList)ICUsuario.listarProveedores();
        ArrayList<String> listProv = (ArrayList) ICUsuario.listarProveedores();
        String[] ret = listProv.toArray(new String[listProv.size()]);
        return ret;
    }

    @WebMethod
    public void agregarCliente(DtCliente dtcli) {
        ICUsuario.AltaCliente(dtcli);
    }

    @WebMethod
    public boolean VerificarNickCliente(String nick) {
        return ICUsuario.chequearNick(nick);
    }

    @WebMethod
    public boolean VerificarEmailCliente(String email) {
        return ICUsuario.chequearEmail(email);
    }

    @WebMethod
    public DtProveedor[] listarProveedoresDatos() {
        ArrayList<DtProveedor> ret = new ArrayList<>();
        ArrayList<String> provs = (ArrayList) ICUsuario.listarProveedores();
        for (int x = 0; x < provs.size(); x++) {
            ret.add(ICUsuario.datosProveedor(provs.get(x).trim()));
        }
        DtProveedor[] ret2 = ret.toArray(new DtProveedor[ret.size()]);
        return ret2;
    }

    @WebMethod
    public byte[] getImagenUsu(String nickP) {
        //System.out.println(ManejadorSQL.GetInstance().selectImgUsuario(nickP));
        return ManejadorSQL.GetInstance().selectImgUsuario(nickP);
    }

    @WebMethod
    public DtCliente devolverCliente(String nick) {
        return ICUsuario.datosCliente(nick);
    }

    @WebMethod
    public DtProveedor devolverProveedor(String nick) {
        return ICUsuario.datosProveedor(nick);
    }

    public void agregarImagenCliente(byte[] f, String NickC) {
        try {
            InputStream is = new ByteArrayInputStream(f);
            ManejadorSQL.GetInstance().insertImgUsuariov2(is, NickC);
        } catch (Exception e) {
        }
    }

    //-----------------------------------------------------------------------------------------------------------------------------------------------------
    // DISPOSITIVO MOVIL
    @WebMethod
    public Integer[] listarReservasXprov(String nickP) {
        ArrayList<Integer> res = ICReserva.listarReservasXprov(nickP);
        return res.toArray(new Integer[res.size()]);
    }

    @WebMethod
    public boolean actualizarEstadoArticulo(String idReserva, String nickP, String nombreA) {
        return ICReserva.actualizarEstadoArticulo(idReserva, nickP, nombreA);
    }

    @WebMethod
    public DtServicio[] listarServiciosXprov(String nickP) {
        ArrayList<DtServicio> s = ICArticulo.ListarServiciosProv(nickP);
        return s.toArray(new DtServicio[s.size()]);
    }

    @WebMethod
    public DtPromocion[] listarPromocionesXprov(String nickP) {
        ArrayList<DtPromocion> s = ICArticulo.listarPromocionesProv(nickP);
        return s.toArray(new DtPromocion[s.size()]);
    }

    @WebMethod
    public int agregarRegistro(String ip, String url, String navegador, String so) {
        if (ICRegistro.agregarRegistro(ip, url, navegador, so)) {
            return 1;
        } else {
            return 0;
        }
    }

}
