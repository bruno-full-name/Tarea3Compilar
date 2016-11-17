
package help4travelling;

import java.util.List;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.Iterator;

public class ManejadorUsuario {
    private static ManejadorUsuario instancia=null;
    private static HashMap<String, Usuario> usuarios;
    private static ArrayList<String> emails = new ArrayList<>();

     private ManejadorUsuario(){
       usuarios=new HashMap<String, Usuario>();
    }

     public static ManejadorUsuario getinstance(){
        if (instancia==null){
            instancia = new ManejadorUsuario();
            //cargar HashMap usuarios de la base de datos
        }
        usuarios.clear();
        ArrayList<String> arrayCli = ManejadorSQL.GetInstance().cargarClientes();
        for (int i = 0; i < arrayCli.size(); i++) {
            Usuario u = new Cliente(arrayCli.get(i));
            usuarios.put(u.getNickCliente(),u);
        }
        ArrayList<String> arrayProv = ManejadorSQL.GetInstance().cargarProveedores();
        for (int i = 0; i < arrayProv.size(); i++) {
            Usuario p = new Proveedor(arrayProv.get(i));
            usuarios.put(p.getNickProveedor(),p);
        }
        emails.clear();
        ArrayList<String> arrayEmails = ManejadorSQL.GetInstance().cargarEmail();
        for (int i = 0; i < arrayEmails.size(); i++) {
            emails.add(arrayEmails.get(i));
        }
        return instancia;
    }

     public List<String> listarClientes(){
        List<String> userCi = new ArrayList<String>();
        for (String name: usuarios.keySet()){
            String nombre = usuarios.get(name).getNickCliente();
            if (nombre != null)
                userCi.add(nombre);
        }
        return  userCi;
  }

     public List<String> listarProveedores(){
        List<String> userCi = new ArrayList<String>();
        for (String name: usuarios.keySet()){
            String nombre = usuarios.get(name).getNickProveedor();
            if (nombre != null)
                userCi.add(nombre);
        }
        return  userCi;
  }
    public Cliente ObtenerCliente(String nameCli){
        return (Cliente)this.usuarios.get(nameCli);
    }

    public Proveedor ObtenerProveedor(String nameProv){
        return (Proveedor)this.usuarios.get(nameProv);
    }

   /* public void InstertarUsuario(Usuario u){
        this.usuarios.put(u.getNickCliente(), u);
    }*/

   /* public void InstertarProveedor(DtProveedor p){
        Proveedor newprov = new Proveedor(p);
        this.usuarios.put(p.getNick(), newprov);
        ManejadorSQL.GetInstance().agregarUsuario(p);
    }*/

    public boolean InstertarProveedor(DtProveedor p){
        if (this.chequearNick(p.getNick()) || this.chequearEmail(p.getEmail()))
            return false;
        Proveedor newprov = new Proveedor(p.getNick());
        this.usuarios.put(p.getNick(), newprov);
        return ManejadorSQL.GetInstance().agregarUsuario(p);
    }

    public boolean chequearNick(String nick){
        for (String name: usuarios.keySet()){
            if (name.equals(nick))
                return true;
        }
        return false;
    }

    public boolean chequearEmail(String email){
        for (int i = 0; i < emails.size(); i++) {
            if (emails.get(i).equals(email))
                return true;
        }
        return false;
    }

    public boolean InstertarCliente(DtCliente c){
        if (this.chequearNick(c.getNick()) || this.chequearEmail(c.getEmail()))
            return false;
        Cliente newcli = new Cliente(c.getNick());
        this.usuarios.put(c.getNick(), newcli);
        return ManejadorSQL.GetInstance().agregarUsuario(c);
    }

     public boolean ExisteUsuario(String nickUsu, String email){
         return this.usuarios.containsKey(nickUsu);
     }
     
     public boolean autenticarProveedor(String nickname, String password){
         boolean esUsuario = ManejadorSQL.GetInstance().autenticarUsuario(nickname, password);
         // la funcion se llama autenticarCliente, pero chequea en la tabla usuarios, no en cliente unicamente. cosas de la vida...
         if(esUsuario)
             return ManejadorSQL.GetInstance().esCliente(nickname) == false;
         else
             return false;
         
     }
     public boolean autenticarCliente(String nickname, String password){
         boolean esUsuario = ManejadorSQL.GetInstance().autenticarUsuario(nickname, password);
         // la funcion se llama autenticarCliente, pero chequea en la tabla usuarios, no en cliente unicamente. cosas de la vida...
         if(esUsuario)
             return ManejadorSQL.GetInstance().esCliente(nickname);
         else
             return false;
         
     }
}
