import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.LinkedList;

public class Exportar {
    public void exportarArchivoCliente(LinkedList<Cliente> lista) {
        if (lista.isEmpty()) {
            System.out.println("La lista esta vacia no se puede exportar el archivo");
            return;
        } else {
            try (FileWriter e = new FileWriter("Cliente.txt")) {
                for (Cliente obj : lista) {
                    e.write("Cedula: " + obj.getCedula() + "\n");
                    e.write("Nombre: " + obj.getNombre() + "\n");
                    e.write("Apellido: " + obj.getApellido() + "\n");
                    e.write("Telefono: " + obj.getTelefono() + "\n");
                    e.write("Direccion: " + obj.getDireccion() + "\n");
                    e.write("Licencia: " + obj.getLicenciaConduccion() + "\n");
                    e.write("------------------------------------------------------ \n");

                }
                //System.out.println("Archivo exportado correctamente de cliente ");

            } catch (IOException e) {
                // TODO: handle exception
                e.printStackTrace();
            }
        }
    }
    public void exportarVehiculos(LinkedList<Vehiculo> vehiculos) {

    try {

        PrintWriter pw = new PrintWriter(new FileWriter("Vehiculos.txt"));

        for (Vehiculo v : vehiculos) {

            pw.println("------------------------------------------------------");

            if (v instanceof CarroSedan) {

                CarroSedan sedan = (CarroSedan) v;

                pw.println("Tipo: Sedan");
                pw.println("Placa: " + sedan.getPlaca());
                pw.println("Marca: " + sedan.getMarca());
                pw.println("Modelo: " + sedan.getModelo());
                pw.println("Precio Diario: " + sedan.getPrecioDiario());
                pw.println("Estado: " + sedan.getEstado());
                pw.println("Combustible: " + sedan.getTipoCombustible());
                pw.println("Transmision: " + sedan.getTransmision());

            } else if (v instanceof CamionetaSUV) {

                CamionetaSUV suv = (CamionetaSUV) v;

                pw.println("Tipo: SUV");
                pw.println("Placa: " + suv.getPlaca());
                pw.println("Marca: " + suv.getMarca());
                pw.println("Modelo: " + suv.getModelo());
                pw.println("Precio Diario: " + suv.getPrecioDiario());
                pw.println("Estado: " + suv.getEstado());
                pw.println("Traccion: " + suv.getTraccion());
                pw.println("Capacidad Maletero: " + suv.getCapacidadMaletero());
            }
        }

        pw.println("------------------------------------------------------");

        pw.close();

       

    } catch (IOException e) {

        System.out.println("Error al exportar: " + e.getMessage());
    }
}

public void exportarArchivoContrato(LinkedList<ContratoRenting> contrato) {

    if (contrato.isEmpty()) {
        System.out.println("La lista esta vacia no se puede exportar el archivo");
        return;
    } else {

        try (FileWriter e = new FileWriter("Contrato.txt")) {

            for (ContratoRenting obj : contrato) {

                e.write("Id Contrato: " + obj.getIdContrato() + "\n");
                e.write("Cedula Cliente: " + obj.getCedulaCliente() + "\n");
                e.write("Placa Vehiculo: " + obj.getPlacaVehiculo() + "\n");
                e.write("Fecha Inicio: " + obj.getFechaInicio() + "\n");
                e.write("Fecha Fin: " + obj.getFechaFin() + "\n");
                e.write("Total Dias: " + obj.getTotalDias() + "\n");
                e.write("Valor Total: " + obj.getValorTotal() + "\n");
                e.write("Estado Contrato: " + (obj.isActivo() ? "Activo" : "Finalizado") + "\n");
                e.write("------------------------------------------------------ \n");
            }

            //System.out.println("Archivo exportado correctamente de contrato");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
}
