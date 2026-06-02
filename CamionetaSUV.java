public class CamionetaSUV extends Vehiculo{
    private String traccion;
    private float CapacidadMaletero;
    public CamionetaSUV(String placa, String marca, int modelo, float precioDiario, String estado, String traccion,
            float capacidadMaletero) {
        super(placa, marca, modelo, precioDiario, estado);
        this.traccion = traccion;
        CapacidadMaletero = capacidadMaletero;
    }
    public CamionetaSUV(String traccion, float capacidadMaletero) {
        this.traccion = traccion;
        CapacidadMaletero = capacidadMaletero;
    }
    public String getTraccion() {
        return traccion;
    }
    public void setTraccion(String traccion) {
        this.traccion = traccion;
    }
    public float getCapacidadMaletero() {
        return CapacidadMaletero;
    }
    public void setCapacidadMaletero(float capacidadMaletero) {
        CapacidadMaletero = capacidadMaletero;
    }

    

}

