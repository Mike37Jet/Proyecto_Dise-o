package mod_transporte;

import mod_paquetes.Provincia;

public class Vehiculo {
    private String numeroPlaca;
    private double capacidad;   // 35 a 45 m3
    private Provincia ubicacion;
    private LineaDeEntrega lineaDeEntrega;

    public Vehiculo(String numeroPlaca, double capacidad, Provincia ubicacion) {
        this.numeroPlaca = numeroPlaca;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
    }

    public void asignarLineaDeEntrega(LineaDeEntrega lineaDeEntrega) {
        this.lineaDeEntrega = lineaDeEntrega;
    }

    public double getCapacidad() {
        return capacidad;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "numeroPlaca='" + numeroPlaca + '\'' +
                '}';
    }
}
