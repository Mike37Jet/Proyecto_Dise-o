package mod_administracion;

import mod_paquetes.EstadoDelPaquete;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;

public abstract class Usuario {
    private String nombre;
    private String identificacion;
    private String direccion;
    private String telefono;
    private String email;

    public Usuario(String nombre, String identificacion, String direccion, String telefono, String email) {
        this.nombre = nombre;
        this.identificacion = identificacion;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
    }

    public Paquete obtenerPaquete(String codigoTracking) {
        return Inventario.obtenerInstancia().obtenerPaquete(codigoTracking);
    }

    @Override
    public String toString() {
        return nombre;
    }

    public abstract void reportarIncidente(String codigoTracking);
    public abstract void cambiarEstadoPaquete(String codigoTracking, EstadoDelPaquete estado);
}
