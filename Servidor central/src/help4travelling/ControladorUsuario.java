package help4travelling;

import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorUsuario implements IControladorUsuario{

    private Usuario usuMem;

    @Override
    public List<String> listarClientes(){
        List<String> manejuser = ManejadorUsuario.getinstance().listarClientes();
        return manejuser;
    }

    @Override
    public List<String> listarProveedores(){
        List<String> manejuser = ManejadorUsuario.getinstance().listarProveedores();
        return manejuser;
    }

    @Override
    public DtCliente datosCliente(String nick) {
        ManejadorUsuario manejuser = ManejadorUsuario.getinstance();
        return manejuser.ObtenerCliente(nick).getDtCliente();
    }

    @Override
    public DtProveedor datosProveedor(String nick) {
        ManejadorUsuario manejuser = ManejadorUsuario.getinstance();
        return manejuser.ObtenerProveedor(nick).getDtProveedor();
    }

    @Override
    public DtReserva datosReserva(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public DtServicio datosServicio(int num) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean VerificarUsuario(String nickUsaurio, String email){
        return ManejadorUsuario.getinstance().ExisteUsuario(nickUsaurio, email);
    }

    @Override
    public boolean AltaCliente(DtCliente dataCli){
        String hashtext ="";
        try {

            try {
                String pass = new String(dataCli.getClave());
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] clave = md.digest(pass.getBytes("UTF-8"));
                BigInteger bigInt = new BigInteger(1,clave);
                hashtext = bigInt.toString(16);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        dataCli.setClave(hashtext);
        return ManejadorUsuario.getinstance().InstertarCliente(dataCli);
    }

    @Override
    public boolean AltaProveedor(DtProveedor dataProv){
        String hashtext ="";
        try {

            try {
                String pass = new String(dataProv.getClave());
                MessageDigest md = MessageDigest.getInstance("MD5");
                byte[] clave = md.digest(pass.getBytes("UTF-8"));
                BigInteger bigInt = new BigInteger(1,clave);
                hashtext = bigInt.toString(16);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(ControladorUsuario.class.getName()).log(Level.SEVERE, null, ex);
        }
        dataProv.setClave(hashtext);
        return ManejadorUsuario.getinstance().InstertarProveedor(dataProv);
    }

    @Override
    public boolean chequearNick(String nick){
        return ManejadorUsuario.getinstance().chequearNick(nick);
    }

    @Override
    public boolean chequearEmail(String email){
        return ManejadorUsuario.getinstance().chequearEmail(email);
    }

    /*@Override
    public boolean AutenticarProveedor(String nickP, String password){
        return ManejadorUsuario.getinstance().autenticarProveedor(nickP, password);
    }*/

    @Override
    public boolean autenticarProveedor(String nickname, String password) {
        return ManejadorUsuario.getinstance().autenticarProveedor(nickname, password);
    }

    @Override
    public boolean autenticarCliente(String nickname, String password) {
        return ManejadorUsuario.getinstance().autenticarCliente(nickname, password);
    }
    
}
