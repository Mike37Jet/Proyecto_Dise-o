package mod_administracion;

import mod_facturacion.Cotizacion;
import mod_paquetes.EstadoDelPaquete;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;
import mod_paquetes.Pendiente;

import java.util.ArrayList;

public class Recepcionista extends Usuario {
    private Paquete paqueteEnCotizacion;

    public Recepcionista(String nombre, String identificacion, String direccion, String telefono, String email) {
        super(nombre, identificacion, direccion, telefono, email);
    }

    @Override
    public void reportarIncidente(String codigoTracking) {
       Paquete paquete = obtenerPaquete(codigoTracking);
       if (!(paquete.obtenerEstado() instanceof Pendiente)) {
           System.out.println("El paquete se encuentra en otro estado fuera de su jurisdiccion, no se puede reportar el incidente");
       }
       // Delegar a modulo de incidentes
    }

    @Override
    public void cambiarEstadoPaquete(String codigoTracking, EstadoDelPaquete estado) {

    }

    public void agregarPaqueteInventario() {
        Inventario.obtenerInstancia().agregarPaquete(paqueteEnCotizacion);
    }

    public void eliminarPaqueteInventario(Paquete paquete) {
        Inventario.obtenerInstancia().eliminarPaquete(paquete);
    }

    public double consultarPrecioPaquete() {
        if (paqueteEnCotizacion == null) {
            return 0;
        }
        return Cotizacion.obtenerPrecioPaquete(paqueteEnCotizacion);
    }

    public void registrarPaquete(Paquete paquete) {
        paqueteEnCotizacion = paquete;
    }

    public ArrayList<Paquete> consultarPaquetesInventario() {
        return Inventario.obtenerInstancia().obtenerPaquetes();
    }
}
