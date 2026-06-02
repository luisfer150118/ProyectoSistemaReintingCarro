public class Vehiculo {
    private String placa;
    private String Marca;
    private int Modelo;
    private float PrecioDiario;
    private String Estado;
    public Vehiculo(String placa, String marca, int modelo, float precioDiario, String estado) {
        this.placa = placa;
        Marca = marca;
        Modelo = modelo;
        PrecioDiario = precioDiario;
        Estado = estado;
    }
    public Vehiculo() {
    }
    public String getPlaca() {
        return placa;
    }
    public void setPlaca(String placa) {
        this.placa = placa;
    }
    public String getMarca() {
        return Marca;
    }
    public void setMarca(String marca) {
        Marca = marca;
    }
    public int getModelo() {
        return Modelo;
    }
    public void setModelo(int modelo) {
        Modelo = modelo;
    }
    public float getPrecioDiario() {
        return PrecioDiario;
    }
    public void setPrecioDiario(float precioDiario) {
        PrecioDiario = precioDiario;
    }
    public String getEstado() {
        return Estado;
    }
    public void setEstado(String estado) {
        Estado = estado;
    }

    
}



