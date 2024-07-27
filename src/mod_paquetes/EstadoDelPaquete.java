package mod_paquetes;

public abstract class EstadoDelPaquete {
    protected Paquete paquete;

    public EstadoDelPaquete(Paquete paquete) {
        this.paquete = paquete;
    }

    public abstract void iniciarEnvio();
    public abstract void completarEnvio();
}