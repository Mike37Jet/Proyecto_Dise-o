package mod_paquetes;

import java.util.ArrayList;

public final class Inventario {
    private static Inventario instancia;
    private ArrayList<Paquete> paquetes;

    private Inventario() {
        paquetes = new ArrayList<>();
    }

    public static Inventario obtenerInstancia() {
        if (instancia == null) {
            instancia = new Inventario();
        }
        return instancia;
    }

    public void agregarPaquete(Paquete paquete) {
        paquetes.add(paquete);
    }

    public void eliminarPaquete(Paquete paquete) {
        paquetes.remove(paquete);
    }

    public Paquete obtenerPaquete(String codigoTracking) {
        for (Paquete paquete : paquetes) {
            if (paquete.obtenerCodigo().equals(codigoTracking)) {
                return paquete;
            }
        }
        return null;
    }

    public EstadoDelPaquete verificarEstadoPaquete(String codigoTracking) {
        for (Paquete paquete : paquetes) {
            if (paquete.obtenerCodigo().equals(codigoTracking)) {
                return paquete.obtenerEstado();
            }
        }
        return null;
    }

    public ArrayList<Paquete> obtenerPaquetesPendientes() {
        ArrayList<Paquete> paquetesPendientes = new ArrayList<>();
        for (Paquete paquete : paquetes) {
            if (paquete.obtenerEstado() instanceof Pendiente) {
                paquetesPendientes.add(paquete);
            }
        }
        return paquetesPendientes;
    }

    public ArrayList<Paquete> obtenerPaquetes() {
        return paquetes;
    }
}
