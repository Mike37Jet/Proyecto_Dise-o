package mod_facturacion;

import mod_administracion.Usuario;
import mod_paquetes.Paquete;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Factura {
    private String id;
    private Precio precio;
    private String fechaEmision;
    private Usuario cliente;

    public Factura(Paquete paquete, Precio precio) {
        this.precio = precio;
        LocalDateTime myDateObj = LocalDateTime.now();
        DateTimeFormatter myFormatObj = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
        fechaEmision = myDateObj.format(myFormatObj);
        this.cliente = paquete.getRemitente();
    }

    public void consultarDatos() {

    }
}
