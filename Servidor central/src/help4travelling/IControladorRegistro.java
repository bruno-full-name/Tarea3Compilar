
package help4travelling;

import java.util.ArrayList;

public abstract interface IControladorRegistro{
    public abstract boolean agregarRegistro(String ip, String url, String navegador, String so);
    public abstract ArrayList<DtRegistro> listarRegistros();
}
