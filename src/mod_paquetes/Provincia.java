package mod_paquetes;

public enum Provincia {
    PICHINCHA(-0.1464,  -78.4751),
    AZUAY(-2.90055, -79.00453),
    CHIMBORAZO(-1.6709800, -78.6471200),
    GUAYAS(-2.2058400, -79.9079500);

    private double latitud;
    private double longitud;

    Provincia(double latitud, double longitud) {
        this.latitud = latitud;
        this.longitud = longitud;
    }

    public double getLatitud() {
        return latitud;
    }

    public double getLongitud() {
        return longitud;
    }
}
