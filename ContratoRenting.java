public class ContratoRenting {
    private String IdContrato;
    private String CedulaCliente;
    private String PlacaVehiculo;
    private String FechaInicio;
    private String FechaFin;
    private int TotalDias;
    private float ValorTotal;
    private boolean activo;
    public ContratoRenting(String idContrato, String cedulaCliente, String placaVehiculo, String fechaInicio,
            String fechaFin, int totalDias, float valorTotal) {
        IdContrato = idContrato;
        CedulaCliente = cedulaCliente;
        PlacaVehiculo = placaVehiculo;
        FechaInicio = fechaInicio;
        FechaFin = fechaFin;
        TotalDias = totalDias;
        ValorTotal = valorTotal;
        activo=true;
    }
    public ContratoRenting() {
    }
    public String getIdContrato() {
        return IdContrato;
    }
    public void setIdContrato(String idContrato) {
        IdContrato = idContrato;
    }
    public String getCedulaCliente() {
        return CedulaCliente;
    }
    public void setCedulaCliente(String cedulaCliente) {
        CedulaCliente = cedulaCliente;
    }
    public String getPlacaVehiculo() {
        return PlacaVehiculo;
    }
    public void setPlacaVehiculo(String placaVehiculo) {
        PlacaVehiculo = placaVehiculo;
    }
    public String getFechaInicio() {
        return FechaInicio;
    }
    public void setFechaInicio(String fechaInicio) {
        FechaInicio = fechaInicio;
    }
    public String getFechaFin() {
        return FechaFin;
    }
    public void setFechaFin(String fechaFin) {
        FechaFin = fechaFin;
    }
    public int getTotalDias() {
        return TotalDias;
    }
    public void setTotalDias(int totalDias) {
        TotalDias = totalDias;
    }
    public float getValorTotal() {
        return ValorTotal;
    }
    public void setValorTotal(float valorTotal) {
        ValorTotal = valorTotal;
    }
    public boolean isActivo() {
        return activo;
    }
    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    
}




