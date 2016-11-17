package help4travelling;

import java.util.ArrayList;
import java.util.HashMap;

public class ManejadorRegistro {
    private HashMap<String, DtRegistro> registros = new HashMap<String, DtRegistro>();
    private DtRegistro registro;
    private static ManejadorRegistro instance = null;

    public static ManejadorRegistro GetInstance(){
        if (instance==null){
            instance = new ManejadorRegistro();
            ManejadorSQL.GetInstance().cargarCategorias();
        }
        return instance;
    }

    public boolean agregarRegistro(DtRegistro r){
        return ManejadorSQL.GetInstance().ingresarRegistro(r.getIp(), r.getUrl(), r.getNavegador(), r.getSo());
    }

    public ArrayList<DtRegistro> listarRegistros(){
        return ManejadorSQL.GetInstance().listarRegistros();
    }

}
