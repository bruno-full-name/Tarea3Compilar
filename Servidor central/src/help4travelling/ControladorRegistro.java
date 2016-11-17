package help4travelling;

import java.util.ArrayList;

public class ControladorRegistro implements IControladorRegistro{

    @Override
    public boolean agregarRegistro(String ip, String url, String navegador, String so) {
        return ManejadorRegistro.GetInstance().agregarRegistro(new DtRegistro(ip, url, navegador, so));
    }

    @Override
    public ArrayList<DtRegistro> listarRegistros() {
        return ManejadorRegistro.GetInstance().listarRegistros();
    }
    
}
