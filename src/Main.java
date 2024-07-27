import mod_administracion.Cliente;
import mod_administracion.Conductor;
import mod_administracion.Recepcionista;
import mod_administracion.Usuario;
import mod_facturacion.Cotizacion;
import mod_paquetes.Inventario;
import mod_paquetes.Paquete;
import mod_paquetes.Provincia;
import mod_transporte.Asignacion;
import mod_transporte.Vehiculo;

import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Vehiculo vehiculo = new Vehiculo("ABC123", 30, Provincia.PICHINCHA);
        Recepcionista recepcionista = new Recepcionista("Esteban G", "1600734825", "Calle Principal 32", "1234567890", "juanperez@example.com");
        Cliente cliente = new Cliente("Maria M", "1600734824", "Calle Principal 34", "1234567890", "juanperez@example.com");
        Conductor conductor1 = new Conductor("Juanito Pérez", "12345678A", "Calle Principal 123", "1234567890", "juanperez@example.com", "B1234567");
        ArrayList<Conductor> conductores = new ArrayList<>();
        conductores.add(conductor1);
        ArrayList<Vehiculo> vehiculos = new ArrayList<>();
        vehiculos.add(vehiculo);

        Usuario remitente1 =
                new Cliente("Juan Pérez", "12345678A", "Calle Principal 123", "1234567890", "juanperez@example.com");
        Paquete paquete1 =
                new Paquete("TRACK123", 5, 0.2, "Libros", remitente1, Provincia.PICHINCHA, Provincia.AZUAY, "Calle Mayor, 12");
        Paquete paquete2 = new Paquete("TRACK456", 2.0, 5.0, "Electrodomésticos", remitente1, Provincia.AZUAY, Provincia.PICHINCHA, "Avenida Amazonas, Quito");
        Paquete paquete3 = new Paquete("TRACK789", 25.0, 5.0, "Cajas", remitente1, Provincia.PICHINCHA, Provincia.GUAYAS, "Avenida Amazonas, Quito");

        Asignacion asignacion = Asignacion.obtenerInstancia(conductores, vehiculos);
        Inventario inventario = Inventario.obtenerInstancia();
        inventario.agregarPaquete(paquete1);
        inventario.agregarPaquete(paquete2);
        inventario.agregarPaquete(paquete3);
        asignacion.asignarConductorAVehiculo(conductor1);
        asignacion.asignarPaquetesAVehiculo(vehiculo);
        ArrayList<Paquete> paquetes = conductor1.consultarPaquetesAsignados();
    }
}