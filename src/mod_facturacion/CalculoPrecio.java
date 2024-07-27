package mod_facturacion;

import mod_paquetes.Paquete;

public abstract class CalculoPrecio {
    protected double monto;

    public abstract double calcularValor(Paquete paquete);
    public abstract double calcularValorDependiente(double montoBase);
}
