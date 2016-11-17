package help4travelling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.util.Pair;

public class ManejadorSQL {

    private String ip;
    private static ManejadorSQL instance = null;

    public static ManejadorSQL GetInstance(){
        if (instance==null)
            instance = new ManejadorSQL();
        return instance;
    }

    public boolean init(String ip){
        this.ip = ip;
        return true;
    }
    
    public boolean agregarFactura(String idReserva, String nickCliente, float precio, DtFecha fechaGeneracion){
        String sql = "INSERT INTO INFO_FACTURAS (precio, fecha, nickCliente, idReserva) VALUES ('" + precio + "','" + fechaGeneracion.getAnio() + "/" + fechaGeneracion.getMes() + "/" + fechaGeneracion.getDia() + "','" + nickCliente + "','" + idReserva + "');";
        Statement usuarios;
        boolean ret = false;
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ManejadorSQL.GetInstance().setForeignKeysOff(usuarios);
            usuarios.executeUpdate(sql);
            ManejadorSQL.GetInstance().setForeignKeysOn(usuarios);
            ret = true;
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public boolean facturarArticuloReserva(int idReserva, String nickP){
        boolean ret = false;
        String sql = "UPDATE INFO_RESERVA SET estado='true' WHERE id='" + idReserva + "' AND nicknameProveedor='" + nickP + "';";
        Statement usuarios;
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            usuarios.executeUpdate(sql);
            conex.close();
            ret = true;
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public boolean estaFacturadaReserva(int idReserva){
        boolean ret = true;
        String sql = "SELECT estado FROM INFO_RESERVA WHERE id='" + idReserva + "';";
        Statement usuarios;
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            while(rs.next()){
                if(!rs.getBoolean("estado")){
                    return false;
                }
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public boolean estaFacturadoArticulo(int idReserva, String nickP, String nombreA){
        String sql = "SELECT estado FROM INFO_RESERVA WHERE id='" + idReserva + "' AND nicknameProveedor='" + nickP + "' AND nombreArticulo='" + nombreA + "';";
        Statement usuarios;
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            rs.next();
            conex.close();
            return rs.getBoolean("estado");
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }
    
    public boolean esCliente(String nickname){
        boolean ret = false;
        String sql = "SELECT nicknameCliente FROM CLIENTES WHERE nicknameCliente='"+nickname+"';";
        Statement usuarios;
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            if(rs.first())
              ret = true;
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public ArrayList<String> listarServiciosXprom(String nickP, String nombrePromo){
        String sql = "SELECT nombreArticuloServ FROM COMPUESTOS WHERE nicknameProvServ='"+ nickP +"' AND nicknameProvProm='"+ nickP +"' AND nombreArticuloProm='"+ nombrePromo +"';";
        Statement usuarios;
        ArrayList<String> ret= new ArrayList<>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            rs.next();
            while(rs.next()){
                System.out.println(rs.getString("nombreArticuloServ"));
                ret.add(rs.getString("nombreArticuloServ"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public ArrayList<String> listarServiciosProv(String nickP){
        String sql = "SELECT nombreArticulo FROM SERVICIOS WHERE nicknameProveedor='"+ nickP +"';";
        Statement usuarios;
        ArrayList<String> ret= new ArrayList<>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            rs.next();
            while(rs.next()){
                ret.add(rs.getString("nombreArticulo"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

        public ArrayList<String> listarPromocionesProv(String nickP){
        String sql = "SELECT nombreArticulo FROM PROMOCIONES WHERE nicknameProveedor='"+ nickP +"';";
        Statement usuarios;
        ArrayList<String> ret= new ArrayList<>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            rs.next();
            while(rs.next()){
                ret.add(rs.getString("nombreArticulo"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public ArrayList<Integer> listarReservasXprov(String nickP){
        String sql = "SELECT DISTINCT id FROM INFO_RESERVA where nicknameProveedor='"+nickP+"';";
        Statement usuarios;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            while(rs.next()){
                ret.add(rs.getInt("id"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public boolean ingresarRegistro(String ip, String url, String navegador, String so){
        String sql = "INSERT INTO REGISTROS (ip, url, navegador, so) VALUES ('"+ ip +"','"+ url +"','"+ navegador +"','"+ so +"');";
        Statement usuarios;
        boolean ret = false;
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ManejadorSQL.GetInstance().setForeignKeysOff(usuarios);
            usuarios.executeUpdate(sql);
            ManejadorSQL.GetInstance().setForeignKeysOn(usuarios);
            ret = true;
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public ArrayList<DtRegistro> listarRegistros(){
        String sql = "SELECT * FROM REGISTROS;";
        Statement usuarios;
        ArrayList<DtRegistro> ret = new ArrayList<DtRegistro>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            while(rs.next()){
                ret.add(new DtRegistro(rs.getString("id"), rs.getString("ip"), rs.getString("url"), rs.getString("so"), rs.getString("navegador")));
            }
            conex.close();
        } catch (SQLException ex){
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public boolean actualizarEstadoArticulo(String idReserva, String nickP, String nombreA, String estadoNuevo){
        boolean ret = false;
        String sql = "UPDATE INFO_RESERVA SET estado='true' WHERE id='" + idReserva + "' AND nicknameProveedor='" + nickP + "' AND nombreArticulo='" + nombreA + "';";
        Statement usuarios;
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            ret = true;
            conex.close();
        } catch (SQLException ex){
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public ArrayList<DtServicio> devolverVisitas(){
        ArrayList<DtServicio> ret = new ArrayList<>();
        String sql1 = "SELECT nombreArticulo, cantVisitas FROM SERVICIOS GROUP BY cantVisitas ORDER BY cantVisitas DESC LIMIT 10;";
        Statement usuarios;
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql1);
            while(rs.next()){
                ret.add(new DtServicio(rs.getString("nombreArticulo"), rs.getInt("cantVisitas")));
            }
            conex.close();
        } catch (SQLException ex){
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }
    
    public int devolverVisitas(String nickP, String servicio){
        int ret = 0;
        String sql1 = "SELECT cantVisitas FROM SERVICIOS WHERE nicknameProveedor='" + nickP + "' AND nombreArticulo='" + servicio + "';";
        Statement usuarios;
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql1);
            rs.next();
            ret = rs.getInt("cantVisitas");
            conex.close();
        } catch (SQLException ex){
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public boolean ingresarVisita(String nickP, String nombreA){
        boolean ret = false;
        Statement usuarios;
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            int cantVisitas = ManejadorSQL.GetInstance().devolverVisitas(nickP, nombreA);
            String sq2 = "UPDATE SERVICIOS SET cantVisitas='" + cantVisitas+1 + "' WHERE nicknameProveedor='" + nickP + "' AND nombreArticulo='" + nombreA + "';";
            // ----> NEGRADA DETECTED <----
            usuarios.executeUpdate(sq2);
            ret = true;
            conex.close();
        } catch (SQLException ex){
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public boolean agregarServicioReserva(DtInfoReserva inf){
        boolean ret = false;
        String sql1 = "INSERT INTO INFO_RESERVA(id,cantArticulos,nicknameProveedor,nombreArticulo,fechaIni,fechaFin,precioUnitario,precioTotal)";
        sql1 += " VALUES (" + inf.getIdReserva() + "," + inf.getCantidad() + ",'" + inf.getNickProveedor() + "','" + inf.getNameArticulo() + "','";
        sql1 += inf.getFechaIni().getAnio() + "/" + inf.getFechaIni().getMes() + "/" + inf.getFechaIni().getDia() + "','";
        sql1 += inf.getFechaFin().getAnio() + "/" + inf.getFechaFin().getMes() + "/" + inf.getFechaFin().getDia() + "',";
        sql1 += inf.getPrecioArticulo() + "," + (inf.getPrecioArticulo()*inf.getCantidad()) + ");";

        Statement usuarios;
        Connection conex = getConex();
        try {
            usuarios = conex.createStatement();
            ManejadorSQL.GetInstance().setForeignKeysOff(usuarios);
            usuarios.executeUpdate(sql1);
            ManejadorSQL.GetInstance().setForeignKeysOn(usuarios);
            ret = true;
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }


    public ArrayList<Integer> cargarReservasXcli(String nickU){
        String sql = "SELECT id FROM RESERVAS where nicknameCliente='"+nickU+"';";
        Statement usuarios;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            while(rs.next()){
                ret.add(rs.getInt("id"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public ArrayList<String> cargarEmail(){
        String sql = "SELECT email FROM USUARIOS;";
        Statement usuarios;
        ArrayList<String> ret= new ArrayList<>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            rs.next();
            while(rs.next()){
                ret.add(rs.getString("email"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;

    }

    public boolean autenticarCliente(String nickname){
        boolean ret = false;
        String sql = "SELECT COUNT(*) FROM USUARIOS WHERE nickname='"+nickname+"';";
        Statement usuarios;
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            if(rs.isAfterLast()){
                ret = true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public boolean autenticarUsuario(String nickname, String pass){
      boolean ret = false;
      String sql = "SELECT nickname FROM USUARIOS WHERE nickname='"+nickname+"' AND clave='"+pass+"';";
      Statement usuarios;
      try {
          Connection conex = getConex();
          usuarios = conex.createStatement();
          ResultSet rs = usuarios.executeQuery(sql);
          if(rs.first())
              ret = true;

      } catch (SQLException ex) {
          Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
      }
      return ret;
    }

    // CARGAR USUARIOS
    public ArrayList<String> cargarUsuarios(){
        String sql = "SELECT nickname FROM USUARIOS;";
        Statement usuarios;
        ArrayList<String> ret = new ArrayList<String>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            while(rs.next()){
                ret.add(rs.getString("nickname"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

        // CARGAR PROVEEDORES
    public ArrayList<String> cargarProveedores(){
        String sql = "SELECT nicknameProveedor FROM PROVEEDORES;";
        Statement usuarios;
        ArrayList<String> ret = new ArrayList<String>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            while(rs.next()){
                ret.add(rs.getString("nicknameProveedor"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    // CARGAR CLIENTES
    public ArrayList<String> cargarClientes(){
        String sql = "SELECT nicknameCliente FROM CLIENTES;";
        Statement usuarios;
        ArrayList<String> ret = new ArrayList<String>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            while(rs.next()){
                ret.add(rs.getString("nicknameCliente"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    // CARGAR CIUDADES POR PAISES
    public ArrayList<String> cargarCiudades(){
        String sql = "SELECT nombrePais, nombre FROM CIUDADES;";
        Statement usuarios;
        ArrayList<String> ret = new ArrayList<String>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            while(usuarios.getResultSet().next()){
                ret.add(rs.getString("nombre"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

        // CARGAR ARTICULOS
    public Map<Pair<String,String>,Articulo> cargarArticulos(){
        String sql = "SELECT nicknameProveedor, nombreArticulo FROM ARTICULOS;";
        Statement usuarios;
        Map<Pair<String,String>,Articulo> ret = new HashMap<Pair<String,String>,Articulo>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            while(usuarios.getResultSet().next()){
                //ret.put(rs.getString("nicknameProveedor"),rs.getString("nombre"));
                ret.put(new Pair(rs.getString("nicknameProveedor"),rs.getString("nombre")),null);
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    // CARGAR SERVICIOS
    public Map<Pair<String,String>,Servicio> cargarServicios(){
        String sql = "SELECT nicknameProveedor, nombreArticulo FROM SERVICIOS;";
        Statement usuarios;
        Map<Pair<String,String>,Servicio> ret = new HashMap<Pair<String,String>,Servicio>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            while(usuarios.getResultSet().next()){
                //ret.put(rs.getString("nicknameProveedor"),rs.getString("nombreArticulo"));
                ret.put(new Pair(rs.getString("nicknameProveedor"),rs.getString("nombreArticulo")),null);
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

        // CARGAR PROMOCIONES
    public Map<Pair<String,String>,Promocion> cargarPromociones(){
        String sql = "SELECT nicknameProveedor, nombreArticulo FROM PROMOCIONES;";
        Statement usuarios;
        Map<Pair<String,String>,Promocion> ret = new HashMap<Pair<String,String>,Promocion>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            while(rs.next()){
                //ret.put(rs.getString("nicknameProveedor"), rs.getString("nombreArticulo"));
                ret.put(new Pair(rs.getString("nicknameProveedor"),rs.getString("nombreArticulo")),null);
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;

    }

    // CARGAR RESERVAS
    public ArrayList<Integer> cargarReservas(){
        String sql = "SELECT nicknameCliente, id FROM RESERVAS;";
        Statement usuarios;
        ArrayList<Integer> ret = new ArrayList<Integer>();
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            while(rs.next()){
                ret.add(rs.getInt("id"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

     // CARGAR CATEGORIAS
    public void cargarCategorias(){
        String sql = "SELECT nombre, nombreCategoriaPadre FROM HEREDA;";
        Statement usuarios;
        try {
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            while(rs.next()){
                ManejadorCategoria.GetInstance().IngresarCategoriaBD(rs.getString("nombre"),rs.getString("nombreCategoriaPadre"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // CARGAR PROVEEDORES POR CATEGORIAS
    public ArrayList<String> cargarProveedoresXcat(String nombreCat){
        ArrayList<String> ret = null;
        try {
            String sql = "SELECT DISTINCT nicknameProveedor FROM POSEEN WHERE nombreCategoria = '"+ nombreCat + "';";
            Statement usuarios;
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            ret = new ArrayList<String>();
            while(rs.next()){
                ret.add(rs.getString("nicknameProveedor"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

        // CARGAR SERVICIOS POR PROVEEDOR Y CATEGORIA
    public ArrayList<String> cargarServiciosXcatYprov(String nickProveedor, String nombreCat){
        ArrayList<String> ret = null;
        try {
            String sql = "SELECT nombreArticulo FROM POSEEN WHERE nombreCategoria = '"+ nombreCat + "' AND nicknameProveedor = '" + nickProveedor + "';";
            Statement usuarios;
            Connection conex = getConex();
            usuarios = conex.createStatement();
            ResultSet rs = usuarios.executeQuery(sql);
            ret = new ArrayList<String>();
            while(rs.next()){
                ret.add(rs.getString("nombreArticulo"));
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    // ALTA DE CLIENTE
    public boolean agregarUsuario(DtCliente c){
        String sql1 = "INSERT INTO USUARIOS(nickname, nombre, apellido, email, fechaNac, clave) VALUES ('" + c.getNick() + "','" + c.getNombre() + "','" + c.getApellido() + "','" + c.getEmail()+ "','" + c.getFechaN().getAnio() + "/" + c.getFechaN().getMes() + "/" + c.getFechaN().getDia() + "','" + c.getClave() + "');";
        String sql2 = "INSERT INTO CLIENTES(nicknameCliente) VALUES ('" + c.getNick() + "' );";
        Statement usuario;
        boolean ret = false;
        try {
            Connection conex = getConex();
            usuario = conex.createStatement();
            usuario.executeUpdate(sql1);
            usuario.executeUpdate(sql2);
            ret = true;
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    // ALTA DE PROVEEDOR.
    public boolean agregarUsuario(DtProveedor p){
        String sql1 = "INSERT INTO USUARIOS(nickname, nombre, apellido, email, fechaNac, clave) VALUES ('" + p.getNick() + "','" + p.getNombre() + "','" + p.getApellido() + "','" + p.getEmail()+ "','" + p.getFechaN().getAnio() + "/" + p.getFechaN().getMes() + "/" + p.getFechaN().getDia() + "','" + p.getClave() + "');";
        String sql2 = "INSERT INTO PROVEEDORES(nicknameProveedor, nombreEmp, linkEmp) VALUES ('" + p.getNick() + "','" + p.getNombreEmpresa() + "','" + p.getUrl() + "');";
        Statement usuario;
        boolean ret = false;
        try {
            Connection conex = getConex();
            usuario = conex.createStatement();
            usuario.executeUpdate(sql1);
            usuario.executeUpdate(sql2);
            ret = true;
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    // ALTA DE SERVICIO.
    public boolean agregarServicio(DtServicio s, String nickProveedor, ArrayList<String> categorias){
        String sql1 = "INSERT INTO ARTICULOS(nicknameProveedor, nombre) VALUES ('" + nickProveedor + "','" + s.getNombre() + "');";
        String sql2, sql3;
        if(s.getCiudadDestino() == null ){
            sql2 = "INSERT INTO SERVICIOS(nicknameProveedor,nombreArticulo,descripcion,precio,ciudadO) VALUES ('" + nickProveedor + "','" + s.getNombre() + "','" + s.getDescripcion() + "'," + s.getPrecio() + ",'" + s.getCiudadOrigen() + "');";
        }else{
            sql2 = "INSERT INTO SERVICIOS(nicknameProveedor,nombreArticulo,descripcion,precio,ciudadO,ciudadD) VALUES ('" + nickProveedor + "','" + s.getNombre() + "','" + s.getDescripcion() + "'," + s.getPrecio() + ",'" + s.getCiudadOrigen() + "','" + s.getCiudadDestino() + "' );";
        }
        Statement usuario;
        // para cuando se considere las imagenes, hacer un alter table por cada imagen. de esa manera, no hay que hacer if anidados, por ambos casos.
        boolean ret = false;
        try {
            Connection conex = getConex();
            usuario = conex.createStatement();
            usuario.executeUpdate(sql1); // ingreso en articulos
            this.setForeignKeysOff(usuario);
            usuario.executeUpdate(sql2); // ingreso en servicios
            for(int x = 0; x < categorias.size(); x++){
                sql3 = "INSERT INTO POSEEN(nicknameProveedor, nombreArticulo, nombreCategoria) VALUES ('" + nickProveedor.trim() + "','" + s.getNombre().trim() + "','" + categorias.get(x).trim() + "');";
                usuario.executeUpdate(sql3); // ingreso las categorias, asumo que estas ya existen debido a que fueron seleccionadas.
            }
            this.setForeignKeysOn(usuario);
            ret = true;
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    // ALTA DE CATEGORIA.
    public boolean agregarCategoria(String nombre, String nombrePadre){
        String sql1 = "INSERT INTO CATEGORIAS(nombre) VALUES ('" + nombre + "');";
        String sql2 = "INSERT INTO HEREDA(nombre, nombreCategoriaPadre) VALUES ('" + nombre + "','" + nombrePadre + "');";
        Statement usuario;
        boolean ret = false;
        try {
            Connection conex = getConex();
            usuario = conex.createStatement();
            usuario.executeUpdate(sql1);
            usuario.executeUpdate(sql2);
            ret = true;
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

        // ALTA DE PROMOCION.
    public boolean agregarPromocion(DtPromocion p, String nickProveedor, ArrayList<String> servicios){
        String sql1 = "INSERT INTO ARTICULOS(nicknameProveedor, nombre) VALUES ('" + p.getNickProv() + "','" + p.getNombre()+ "');";
        String sql2 = "INSERT INTO PROMOCIONES(nicknameProveedor, nombreArticulo, descuento, precio) VALUES ('" + p.getNickProv() + "', '" + p.getNombre() + "', '" + p.getDescuento() + "', '" + p.getPrecio() + "');";
        String sql3;
        Statement usuario;
        boolean ret = false;
        try {
            Connection conex = getConex();
            usuario = conex.createStatement();
            ManejadorSQL.GetInstance().setForeignKeysOff(usuario);
            usuario.executeUpdate(sql1);
            usuario.executeUpdate(sql2);
            for(int x = 0; x < servicios.size(); x++){
                sql3 = "INSERT INTO COMPUESTOS(nicknameProvServ, nombreArticuloServ, nicknameProvProm, nombreArticuloProm) VALUES ('" + p.getNickProv() + "', '" + servicios.get(x) + "', '" + p.getNickProv() + "', '" + p.getNombre() + "');";
                usuario.executeUpdate(sql3); // ingreso las categorias, asumo que estas ya existen debido a que fueron seleccionadas.
            }
            ret = true;
            ManejadorSQL.GetInstance().setForeignKeysOn(usuario);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

        // ALTA DE RESERVAS
    public boolean agregarReserva(DtReserva r){
        boolean ret = false;
        Statement usuario;
        //System.out.println(r.getPrecio() + "', '" + r.getDate().getAnio() + "/" + r.getDate().getMes() + "/" + r.getDate().getDia() + "', '" + r.getEstado() + "', '" + r.getCli());
        String sql1 = "INSERT INTO RESERVAS(precioTotal,fechaCreacion,estado,nicknameCliente) VALUES ('" + r.getPrecio() + "', '" + r.getDate().getAnio() + "/" + r.getDate().getMes() + "/" + r.getDate().getDia() + "', '" + r.getEstado() + "', '" + r.getCli() + "' );";
        String sql2 = "SELECT MAX(id) FROM RESERVAS;";
        //String sql3;
        try {
            Connection conex = getConex();
            usuario = conex.createStatement();
            ManejadorSQL.GetInstance().setForeignKeysOff(usuario);
            usuario.executeUpdate(sql1);
            ResultSet rs = usuario.executeQuery(sql2);
            rs.next();
            int id = rs.getInt("MAX(id)");
            for(int x = 0; x < r.getInfoReserva().size(); x++){
                DtInfoReserva inf = r.getInfoReserva().get(x);
                String sql3 = "INSERT INTO INFO_RESERVA(id,cantArticulos,nicknameProveedor,nombreArticulo,precioUnitario,precioTotal)";
                sql3 += " VALUES (" + id + "," + inf.getCantidad() + ",'" + inf.getNickProveedor() + "','" + inf.getNameArticulo() + "',";
                sql3 += inf.getPrecioArticulo() + "," + (inf.getPrecioArticulo()*inf.getCantidad()) + ");";
                //System.out.println(sql3);
                usuario.executeUpdate(sql3);
            }

            ManejadorSQL.GetInstance().setForeignKeysOn(usuario);
            conex.close();
            ret = true;
        } catch(SQLException ex){
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    // ACTUALIZAR ESTADO DE RESERVA
    public boolean actualizarEstado(int idReserva, String estadoNuevo){
        Statement usuario;
        boolean ret = false;
        String sql1 = "UPDATE RESERVAS SET estado = '" + estadoNuevo + "' WHERE id = " + idReserva + ";";
        try {
            Connection conex = getConex();
            usuario = conex.createStatement();
            usuario.executeUpdate(sql1);
            ret = true;
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    // DEVOLVER USUARIO
    public DtCliente devolverCliente(String nickUsuario){
        DtCliente ret = null;
        String sql1 = "SELECT nombre, apellido, email, fechaNac FROM USUARIOS WHERE nickname = '" + nickUsuario + "';";
        String sql2 = "SELECT id FROM RESERVAS WHERE nicknameCliente = '" + nickUsuario + "';";
        String name, ap, email, fechaN;
        ArrayList<Integer> ids = new ArrayList<Integer>();
        try {
            Connection conex = getConex();
            Statement usuario = conex.createStatement();
            ResultSet rs = usuario.executeQuery(sql1);
            rs.next();
            name = rs.getString("nombre");
            ap = rs.getString("apellido");
            email = rs.getString("email");
            fechaN = rs.getDate("fechaNac").toString();
            DtFecha nac = new DtFecha(fechaN);
            rs = usuario.executeQuery(sql2);
            while(rs.next()){
                ids.add(usuario.getResultSet().getInt("id"));
            }
            ret = new DtCliente(nickUsuario, name, ap, email, nac, ids, null);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

        // DEVOLVER PROVEEDOR
    public DtProveedor devolverProveedor(String nickUsuario){
        DtProveedor ret = null;
        String sql1 = "SELECT nombre, apellido, email, fechaNac FROM USUARIOS WHERE nickname = '" + nickUsuario + "';";
        String sql2 = "SELECT nombreEmp, linkEmp FROM PROVEEDORES WHERE nicknameProveedor = '" + nickUsuario + "';";
        String sql3 = "SELECT nombreArticulo FROM SERVICIOS WHERE nicknameProveedor = '" + nickUsuario + "';";
        String name, ap, email, fechaN, nombreE, linkE;
        ArrayList<DtServicio> nombreA = new ArrayList<DtServicio>();
        try {
            Connection conex = getConex();
            Statement usuario = conex.createStatement();
            ResultSet rs = usuario.executeQuery(sql1);
            rs.next();
            name = rs.getString("nombre");
            ap = rs.getString("apellido");
            email = rs.getString("email");
            fechaN = rs.getDate("fechaNac").toString();
            DtFecha nac = new DtFecha(fechaN);
            rs = usuario.executeQuery(sql2);
            rs.next();
            nombreE = rs.getString("nombreEmp");
            linkE = rs.getString("linkEmp");
            rs = usuario.executeQuery(sql3);
            while(rs.next()){
                nombreA.add(new DtServicio(rs.getString("nombreArticulo")));
            }
            ret = new DtProveedor(nickUsuario, name, ap, email, nac, nombreE, linkE, nombreA, null);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    // DEVOLVER SERVICIOS
    public DtServicio devolverServicio(String nickProveedor, String nombre){
        String sql1 = "SELECT descripcion, precio, ciudadO, ciudadD FROM SERVICIOS WHERE nicknameProveedor = '" + nickProveedor + "' AND nombreArticulo = '"+ nombre + "';";
        String sql2 = "SELECT nombreCategoria FROM POSEEN WHERE nicknameProveedor = '" + nickProveedor + "' AND nombreArticulo = '"+ nombre + "';";
        String desc, co, cd;
        float p;
        ArrayList<String> categorias = new ArrayList<String>();
        Statement usuario;
        DtServicio ret = null;
        try{
            Connection conex = getConex();
            usuario = conex.createStatement();
            ResultSet rs = usuario.executeQuery(sql1);
            rs.next();
            desc = rs.getString("descripcion");
            p = rs.getFloat("precio");
            co = rs.getString("ciudadO");
            cd = rs.getString("ciudadD");
            rs = usuario.executeQuery(sql2);
            while(rs.next()){
                categorias.add(rs.getString("nombreCategoria"));
            }
            ret = new DtServicio(nombre,nickProveedor, p, desc, categorias, co, cd);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public void atualizarServicio(DtServicio s){
        String sql1 = "UPDATE SERVICIOS SET descripcion='" + s.getDescripcion() + "', precio='" + s.getPrecio() + "', ciudadO='" + s.getCiudadOrigen() + "', ciudadD='" + s.getCiudadDestino() + "' WHERE nicknameProveedor = '" + s.getNickProveedor() + "' AND nombreArticulo = '"+ s.getNombre() + "';";
        String sql2, sql3, sql4;
        try{
            Connection conex = getConex();
            Statement usuario = conex.createStatement();
            usuario.executeUpdate(sql1);
            this.setForeignKeysOff(usuario);
            sql2 = "DELETE FROM POSEEN WHERE nicknameProveedor='" + s.getNickProveedor().trim() + "' AND nombreArticulo='" + s.getNombre().trim() + "';";
            usuario.executeUpdate(sql2);
            for(int x = 0; x < s.getCategorias().size(); x++){
                sql3 = "INSERT INTO POSEEN(nicknameProveedor, nombreArticulo, nombreCategoria) VALUES ('" + s.getNickProveedor().trim() + "','" + s.getNombre().trim() + "','" + s.getCategorias().get(x).trim() + "');";
                usuario.executeUpdate(sql3);
            }
            sql4 = "UPDATE PROMOCIONES prom, COMPUESTOS comp SET prom.precio=('" + s.getPrecio() + "'-(prom.descuento*'" + s.getPrecio() + "')/100) WHERE comp.nicknameProvServ='" + s.getNickProveedor().trim() + "' AND comp.nombreArticuloServ='" + s.getNombre().trim() + "' AND comp.nicknameProvProm=prom.nicknameProveedor AND comp.nombreArticuloProm=prom.nombreArticulo;";
            usuario.executeUpdate(sql4);
            this.setForeignKeysOn(usuario);
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    // DEVOLVER SERVICIOS POR CATEGORIA
    public ArrayList<DtServicio> devolverSerPorCat(String nombreCat){
        String sql1 = "SELECT nicknameProveedor,nombreArticulo FROM POSEEN WHERE nombreCategoria = '" + nombreCat + "';";
        String nombre, nick;
        ArrayList<DtServicio> ret = new ArrayList<DtServicio>();
        try {
            Connection conex = getConex();
            Statement usuario = conex.createStatement();
            ResultSet rs = usuario.executeQuery(sql1);
            while(rs.next()){
                nombre = rs.getString("nombreArticulo");
                nick = rs.getString("nicknameProveedor");
                DtServicio ser = this.devolverServicio(nick, nombre);
                ret.add(ser);
            }
            conex.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

        // DEVOLVER PROMOCIONES
    public DtPromocion devolverPromocion(String nickProveedor, String nombre){
        String sql1 = "SELECT precio, descuento FROM PROMOCIONES WHERE nicknameProveedor = '" + nickProveedor + "' AND nombreArticulo = '"+ nombre + "';";
        String sql2 = "SELECT nombreArticuloServ FROM COMPUESTOS WHERE nicknameProvProm = '" + nickProveedor + "' AND nombreArticuloProm = '"+ nombre + "';";
        ArrayList<String> servicios = new ArrayList<String>();
        Statement usuario;
        float p, descu;
        DtPromocion ret = null;
        try{
            try (Connection conex = getConex()) {
                usuario = conex.createStatement();
                ResultSet rs = usuario.executeQuery(sql1), rs2;
                rs.next();
                descu = rs.getFloat("descuento");
                p = rs.getFloat("precio");
                rs2 = usuario.executeQuery(sql2);
                while(rs2.next()){
                    servicios.add(rs2.getString("nombreArticuloServ"));
                }
                ret = new DtPromocion(nombre,nickProveedor, descu, p, servicios);
                conex.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

        // DEVOLVER RESERVA
   public DtReserva devolverReserva(int idReserva){
        DtReserva ret = null;
        String sql1 = "SELECT precioTotal, fechaCreacion, estado, nicknameCliente FROM RESERVAS WHERE id = " + idReserva + ";";
        String sql2 = "SELECT cantArticulos, nicknameProveedor, nombreArticulo, fechaIni, fechaFin, precioUnitario, precioTotal FROM INFO_RESERVA WHERE id = " + idReserva + ";";
        try {
            Connection conex = getConex();
            Statement usuario = conex.createStatement();
            float ptR; String nickC, estado; DtFecha fc;
            ArrayList<DtInfoReserva> r = new ArrayList();
            ResultSet rs = usuario.executeQuery(sql1);
            rs.next();
            ptR = rs.getFloat("precioTotal");
            String Fecha = rs.getDate("fechaCreacion").toString();
            fc = new DtFecha(Fecha);
            estado = rs.getString("estado");
            if(this.estaFacturadaReserva(idReserva))
                estado = "Facturada";
            
            nickC = rs.getString("nicknameCliente");
            ResultSet rs2 = usuario.executeQuery(sql2);
            while(rs2.next()){
                //System.out.println(rs2.getDate("fechaIni"));
                if (rs2.getDate("fechaIni") == null || rs2.getDate("fechaFin") == null){
                    //System.out.println("true");
                    r.add(new DtInfoReserva(null, null, rs2.getInt("cantArticulos"), rs2.getString("nombreArticulo"), rs2.getString("nicknameProveedor"), idReserva, rs2.getFloat("precioUnitario")));
                }else{
                    r.add(new DtInfoReserva(new DtFecha(rs2.getDate("fechaIni").toString()), new DtFecha(rs2.getDate("fechaFin").toString()), rs2.getInt("cantArticulos"), rs2.getString("nombreArticulo"), rs2.getString("nicknameProveedor"), idReserva, rs2.getFloat("precioUnitario")));
                }

            }
            ret = new DtReserva(idReserva, Estado.valueOf(estado), fc, r, nickC, ptR);
            usuario.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

        // DEVOLVER INFO-RESERVA
    public DtInfoReserva devolverInfoReserva(int idReserva, String nomArt, String provArt){
        DtInfoReserva ret = null;
        String sql1 = "SELECT cantArticulos,fechaIni,fechaFin,precioUnitario FROM INFO_RESERVA WHERE id = '" + idReserva + "' AND nicknameProveedor ='" + provArt + "' AND nombreArticulo ='" + nomArt + "';";
        try {
            Connection conex = getConex();
            Statement usuario = conex.createStatement();
            int cantArt; DtFecha fechaIni, fechaFin; float precio = 0;
            //ArrayList<DtInfoReserva> r = new ArrayList();
            ResultSet rs = usuario.executeQuery(sql1);
            rs.next();
            cantArt = rs.getInt("cantArticulos");
            fechaIni = new DtFecha(rs.getDate("fechaIni").toString());
            fechaFin = new DtFecha(rs.getDate("fechaFin").toString());
            precio = rs.getFloat("precioUnitario");
            ret = new DtInfoReserva(fechaIni, fechaFin, cantArt, nomArt, provArt, idReserva, precio);
            usuario.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

     // DEVOLVER INFO-RESERVA
    public ArrayList<DtInfoReserva> devolverInfoReserva(int idReserva){
        ArrayList<DtInfoReserva> ret = new ArrayList<DtInfoReserva>();
        String nomArt, provArt;
        String sql1 = "SELECT cantArticulos,nicknameProveedor,nombreArticulo,fechaIni,fechaFin,precioUnitario FROM INFO_RESERVA WHERE id=" + idReserva + ";";
        try {
            Connection conex = getConex();
            Statement usuario = conex.createStatement();
            int cantArt; DtFecha fechaIni, fechaFin; float precio = 0;

            ResultSet rs = usuario.executeQuery(sql1), rs2, rs3;
            while(rs.next()){
                cantArt = rs.getInt("cantArticulos");
                if (rs.getDate("fechaIni") == null || rs.getDate("fechaFin") == null){
                        fechaIni=null;
                        fechaFin=null;
                }else{
                        fechaIni = new DtFecha(rs.getDate("fechaIni").toString());
                        fechaFin = new DtFecha(rs.getDate("fechaFin").toString());
                }
                nomArt=rs.getString("nombreArticulo");
                provArt=rs.getString("nicknameProveedor");
                precio = rs.getFloat("precioUnitario");
                ret.add(new DtInfoReserva(fechaIni, fechaFin, cantArt, nomArt, provArt, idReserva, precio));
            }
            usuario.close();
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }


    //Eliminar Reserva
    public boolean eliminarReserva(String id){
        boolean ret = false;
        Statement usuario;
        String sql1 = "DELETE FROM INFO_RESERVA WHERE id=" + id.trim() + ";";
        String sql2 = "DELETE FROM RESERVAS WHERE id=" + id.trim() + ";";
        try {
            Connection conex = getConex();
            usuario = conex.createStatement();
            usuario.executeUpdate(sql1);
            usuario.executeUpdate(sql2);
            conex.close();
            ret = true;
        } catch(SQLException ex){
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ret;
    }

    public Connection getConex() {
        Properties propiedades = new Properties();
        InputStream entrada = null;
        Connection c=null;
                
        try {         
            
            
            
            entrada = new FileInputStream("Conexion.properties");
            
            propiedades.load(entrada);
            
            String sql_ip = propiedades.getProperty("SQL.ip");
            String sql_port = propiedades.getProperty("SQL.port");
            String sql_name = propiedades.getProperty("SQL.name");
            String sql_user = propiedades.getProperty("SQL.user");
            String sql_pass = propiedades.getProperty("SQL.pass");
            c = DriverManager.getConnection("jdbc:mysql://"+sql_ip+":"+sql_port+"/"+sql_name,sql_user,sql_pass);
            
            entrada.close();
            
        }catch(SQLException ex){
            c = null;
        }
        catch(IOException ex){
            ex.printStackTrace();
        }
        return c;
    }

    public void setForeignKeysOff(Statement usuario){
        try {
            String sql1 = "SET FOREIGN_KEY_CHECKS=0;";
            usuario.execute(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void setForeignKeysOn(Statement usuario){
        try {
            String sql1 = "SET FOREIGN_KEY_CHECKS=1;";
            usuario.execute(sql1);
        } catch (SQLException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ManejadorSQL getInstance() {
        return instance;
    }

    public void insertImgServicio(File f, String campo, String nickP, String nombreA) throws FileNotFoundException{
        String sql1 = "UPDATE SERVICIOS SET "+ campo + " = ? WHERE nicknameProveedor = '" + nickP + "' AND nombreArticulo = '" + nombreA + "';";
        //System.out.println(sql1);
        try {
            Connection conex = getConex();
            PreparedStatement usuario = conex.prepareStatement(sql1);
            //ruta puede ser: "/home/cmop/Desktop/1.jpg"
            FileInputStream   fis = new FileInputStream(f);
            //Lo convertimos en un Stream
            usuario.setBinaryStream(1, fis, (int) f.length());
            //Asignamos el Stream al Statement
            usuario.executeUpdate();
            usuario.close();
        } catch (SQLException ex2) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex2);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertImgUsuario(File f, String nickU) throws FileNotFoundException{
        String sql1 = "UPDATE USUARIOS SET imagen = ? WHERE nickname = '" + nickU + "';";
        try {
            Connection conex = getConex();
            PreparedStatement usuario = conex.prepareStatement(sql1);
            //ruta puede ser: "/home/cmop/Desktop/1.jpg"
            FileInputStream   fis = new FileInputStream(f);
            //Lo convertimos en un Stream
            usuario.setBinaryStream(1, fis, (int) f.length());
            //Asignamos el Stream al Statement
            usuario.executeUpdate();
            usuario.close();
        } catch (SQLException ex2) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex2);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void insertImgUsuariov2(InputStream f, String nickU) throws SQLException, IOException{
        String sql1 = "UPDATE USUARIOS SET imagen = ? WHERE nickname = '" + nickU + "';";
        try{
            Connection conex = getConex();
            PreparedStatement usuario = conex.prepareStatement(sql1);

            usuario.setBinaryStream(1, f, f.available());
            usuario.executeUpdate();
            usuario.close();
        } catch (SQLException ex2) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex2);
        }
    }

    public byte[] selectImgServicio(String campo, String nickP, String nombreA){
        String sql1 = "SELECT "+ campo +" FROM SERVICIOS WHERE nicknameProveedor='" + nickP + "' AND nombreArticulo='"+ nombreA +"';";
        try {
            Connection conex = getConex();
            Statement usuario = conex.createStatement();
            ResultSet rs = usuario.executeQuery(sql1);
            if (rs.next()) {
                byte[] imgData = rs.getBytes(campo);//Here r1.getBytes() extract byte data from resultSet
                //System.out.println(imgData);
                return imgData;
            }
            usuario.close();
        } catch (SQLException ex2) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex2);
        }
        return null;
    }

    public byte[] selectImgUsuario(String nickU){
        String sql1 = "SELECT imagen FROM USUARIOS WHERE nickname='"+ nickU.trim() +"';";
        try {
            Connection conex = getConex();
            Statement usuario = conex.createStatement();
            ResultSet rs = usuario.executeQuery(sql1);
            if (rs.next()) {
                byte[] imgData = rs.getBytes("imagen");//Here r1.getBytes() extract byte data from resultSet
                //System.out.println(imgData);
                return imgData;
            }
            usuario.close();
        } catch (SQLException ex2) {
            Logger.getLogger(ManejadorSQL.class.getName()).log(Level.SEVERE, null, ex2);
        }
        return null;
    }

}
