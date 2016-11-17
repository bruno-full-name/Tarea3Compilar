package help4travelling;

import java.util.List;

/**
 *
 * @author Bruno
 */
public abstract interface IControladorUsuario {

    /*public abstract void ingresarUsuario( DtCliente cliente);
  public abstract void ingresarUsuario( DtProveedor proveedor);
     */
    public abstract List<String> listarClientes();

    public abstract List<String> listarProveedores();

    public abstract DtCliente datosCliente(String nick);

    public abstract DtProveedor datosProveedor(String nick);

    public abstract DtReserva datosReserva(int num);

    public abstract DtServicio datosServicio(int num);

    public abstract boolean VerificarUsuario(String nickUsaurio, String email);

    public abstract boolean AltaCliente(DtCliente dataCli);

    public abstract boolean AltaProveedor(DtProveedor dataProv);

    public abstract boolean chequearNick(String nick);

    public abstract boolean chequearEmail(String email);

    //public abstract boolean AutenticarProveedor(String nickP, String password);

    public abstract boolean autenticarProveedor(String nickname, String password);

    public abstract boolean autenticarCliente(String nickname, String password);
}
