package help4travelling;

import java.util.ArrayList;
import java.util.Set;

public abstract interface IControladorReserva {
    public abstract boolean CrearReserva(DtReserva dtRes);

    public abstract void ReservarArticulo(DtInfoReserva dtir);

    public abstract void ConfirmarReserva(boolean ok);

    public abstract Set ListarNroReservas();

    public abstract DtReserva ObtenerDatosReserva(int idReserva);

    public abstract ArrayList<DtInfoReserva> ObtenerInfoArticulosReservados(int id);

    public abstract ArrayList<DtReserva> listarReservas();

    public abstract ArrayList<Integer> listarReservasXcli(String nickU);

    public abstract ArrayList<Integer> listarReservasXprov(String nickP);

    public abstract boolean actualizarEstado(Estado e, int idRes);

    public abstract DtReserva datosReservas(int idRes);

    public abstract boolean eliminarReserva(String id);

    public abstract boolean actualizarEstadoArticulo(String idReserva, String nickP, String nombreA);
    
    public abstract boolean estaFacturadaReserva(int idReserva);
    
    public abstract boolean estaFacturadoArticulo(int idReserva, String nickP, String nombreA);
    
    public abstract boolean agregarFactura(String idReserva, String nickCliente, float precio, String fecha);
    
    public abstract boolean facturarArticuloReserva(int idReserva, String nickP);
    
}
