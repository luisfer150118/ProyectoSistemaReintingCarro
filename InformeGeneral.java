import java.util.LinkedList;
import java.util.Stack;

public class InformeGeneral {

    private LinkedList<Cliente> clientes;
    private LinkedList<Vehiculo> vehiculos;
    private LinkedList<ContratoRenting> contratos;
    
    public InformeGeneral(
            LinkedList<Cliente> clientes,
            LinkedList<Vehiculo> vehiculos,
            LinkedList<ContratoRenting> contratos,
            Stack<ContratoRenting> historialContratos) {
        this.clientes = clientes;
        this.vehiculos = vehiculos;
        this.contratos = contratos;
    }

    public String informeGeneral() {
        StringBuilder info = new StringBuilder();
        float totalIngresos = 0;
        info.append("\n");
        info.append("==========================================\n");
        info.append("==         INFORME GENERAL RENTING      ==\n");
        info.append("==========================================\n");
        info.append("\n========== CLIENTES ==========\n");
        if (clientes == null || clientes.isEmpty()) {
            info.append("No hay clientes registrados.\n");
        } else {
            for (Cliente c : clientes) {
                info.append("-----------------------------------\n");
                info.append("Cedula    : ").append(c.getCedula()).append("\n");
                info.append("Nombre    : ").append(c.getNombre())
                        .append(" ")
                        .append(c.getApellido()).append("\n");
                info.append("Telefono  : ").append(c.getTelefono()).append("\n");
                info.append("Direccion : ").append(c.getDireccion()).append("\n");
            }
        }

        info.append("\n========== VEHICULOS ==========\n");
        if (vehiculos == null || vehiculos.isEmpty()) {
            info.append("No hay vehiculos registrados.\n");
        } else {
            for (Vehiculo v : vehiculos) {
                info.append("-----------------------------------\n");
                info.append("Placa  : ").append(v.getPlaca()).append("\n");
                info.append("Marca  : ").append(v.getMarca()).append("\n");
                info.append("Modelo : ").append(v.getModelo()).append("\n");
                info.append("Estado : ").append(v.getEstado()).append("\n");
            }
        }


        info.append("\n====== CONTRATOS ACTIVOS ======\n");
        boolean hayActivos = false;
        if (contratos != null && !contratos.isEmpty()) {
            for (ContratoRenting c : contratos) {
                if (c.isActivo()) {
                    hayActivos = true;
                    info.append("-----------------------------------\n");
                    info.append("Contrato : ").append(c.getIdContrato()).append("\n");
                    info.append("Cliente  : ").append(c.getCedulaCliente()).append("\n");
                    info.append("Vehiculo : ").append(c.getPlacaVehiculo()).append("\n");
                    info.append("Fecha Ini: ").append(c.getFechaInicio()).append("\n");
                    info.append("Fecha Fin: ").append(c.getFechaFin()).append("\n");
                    info.append("Dias     : ").append(c.getTotalDias()).append("\n");
                    info.append("Valor    : $").append(c.getValorTotal()).append("\n");
                    info.append("Estado   : Activo\n");
                    totalIngresos += c.getValorTotal();
                }
            }
        }
        if (!hayActivos) {
            info.append("No hay contratos activos.\n");
        }

        info.append("\n==== CONTRATOS FINALIZADOS ====\n");
        boolean hayFinalizados = false;
        if (contratos != null && !contratos.isEmpty()) {
            for (ContratoRenting c : contratos) {
                if (!c.isActivo()) {
                    hayFinalizados = true;
                    info.append("-----------------------------------\n");
                    info.append("Contrato : ").append(c.getIdContrato()).append("\n");
                    info.append("Cliente  : ").append(c.getCedulaCliente()).append("\n");
                    info.append("Vehiculo : ").append(c.getPlacaVehiculo()).append("\n");
                    info.append("Valor    : $").append(c.getValorTotal()).append("\n");
                    info.append("Estado   : Finalizado\n");
                    totalIngresos += c.getValorTotal();
                }
            }
        }
        if (!hayFinalizados) {
            info.append("No hay contratos finalizados.\n");
        }
       
        info.append("\n=========================================\n");
        info.append("TOTAL INGRESOS GENERADOS: $")
                .append(totalIngresos)
                .append("\n");
        info.append("=========================================\n");
        return info.toString();
    }
}