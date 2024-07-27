package mod_paquetes;

import mod_administracion.Usuario;

import java.util.ArrayList;

public class Paquete {
    private String codigoTracking;
    private double volumen;
    private double peso;
    private String contenido;
    private Usuario remitente;
    private Provincia provinciaOrigen;
    private Provincia provinciaDestino;
    private String direccionDestino;
    private EstadoDelPaquete estado;
    private Seguimiento seguimiento;

    public Paquete(String codigoTracking, double volumen, double peso, String contenido, Usuario remitente, Provincia provinciaOrigen, Provincia provinciaDestino, String direccionDestino) {
        this.codigoTracking = codigoTracking;
        this.volumen = volumen;
        this.peso = peso;
        this.contenido = contenido;
        this.remitente = remitente;
        this.provinciaOrigen = provinciaOrigen;
        this.provinciaDestino = provinciaDestino;
        this.direccionDestino = direccionDestino;
        this.estado = new Pendiente(this);
        this.seguimiento = new Seguimiento(estado);
    }

    public void cambiarEstado(EstadoDelPaquete estado) {
        this.estado = estado;
        seguimiento.notificar(estado);
    }

    public ArrayList<String> obtenerHistorialEstados() {
        return seguimiento.obtenerEstadosAnteriores();
    }

    public double calcularDistancia() {
        double longitude1 = provinciaOrigen.getLongitud();
        double longitude2 = provinciaDestino.getLongitud();
        double latitude1 = provinciaOrigen.getLatitud();
        double latitude2 = provinciaDestino.getLatitud();
        double theta = longitude1 - longitude2;
        double distance = 60 * 1.1515 * (180/Math.PI) * Math.acos(
                Math.sin(latitude1 * (Math.PI/180)) * Math.sin(latitude2 * (Math.PI/180)) +
                        Math.cos(latitude1 * (Math.PI/180)) * Math.cos(latitude2 * (Math.PI/180)) * Math.cos(theta * (Math.PI/180))
        );
        return Math.round(distance * 1.609344);
    }

    public EstadoDelPaquete obtenerEstado() {
        return estado;
    }

    public String obtenerCodigo() {
        return codigoTracking;
    }

    public double getVolumen() {
        return volumen;
    }

    public Usuario getRemitente() {
        return remitente;
    }

    public double getPeso() {
        return peso;
    }

    public Provincia getProvinciaDestino() {
        return provinciaDestino;
    }

    public String toString() {
        return "Paquete{" +
                "codigoTracking='" + codigoTracking + '\'' +
                ", volumen=" + volumen +
                ", peso=" + peso +
                ", contenido='" + contenido + '\'' +
                ", remitente=" + remitente +
                ", provinciaOrigen=" + provinciaOrigen +
                ", provinciaDestino=" + provinciaDestino +
                ", direccionDestino='" + direccionDestino + '\'' +
                ", estado=" + estado +
                ", distanciaEstimada=" + calcularDistancia() + " km" +
                '}';
    }
}
