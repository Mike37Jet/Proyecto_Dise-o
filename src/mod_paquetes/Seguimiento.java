package mod_paquetes;

import java.util.ArrayList;

public class Seguimiento {
    private EstadoDelPaquete estadoActual;
    private ArrayList<String> estadosAnteriores;

    public Seguimiento(EstadoDelPaquete estado) {
        this.estadoActual = estado;
        this.estadosAnteriores = new ArrayList<>();
    }

    public void notificar(EstadoDelPaquete estado) {
        estadosAnteriores.add(estadoActual.toString());
        this.estadoActual = estado;
    }

    public boolean verificarEntregaPendiente() {
        return estadoActual instanceof Pendiente;
    }

    public ArrayList<String> obtenerEstadosAnteriores() {
        return estadosAnteriores;
    }
}
