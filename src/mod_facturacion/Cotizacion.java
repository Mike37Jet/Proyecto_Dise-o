package mod_facturacion;

import mod_paquetes.Inventario;
import mod_paquetes.Paquete;

import java.util.ArrayList;

public final class Cotizacion {
    private static Cotizacion instancia;
    private ArrayList<Factura> facturas;

    private Cotizacion() {
        facturas = new ArrayList<>();
    }

    public static Cotizacion obtenerInstancia() {
        if (instancia == null) {
            instancia = new Cotizacion();
        }
        return instancia;
    }

    public static double obtenerPrecioPaquete(Paquete paquete) {
        Precio precio = new Precio(
                paquete, new PrecioPaquete(5, 5), new PrecioDistancia(0.2), new Impuesto(0.12));
        return precio.getPrecioTotalPaquete();
    }

    public void emitirFacturaPaquete(Paquete paquete) {
        Precio precio = new Precio(
                paquete, new PrecioPaquete(5, 5), new PrecioDistancia(0.2), new Impuesto(0.12));
        facturas.add(new Factura(paquete, precio));
    }
}
