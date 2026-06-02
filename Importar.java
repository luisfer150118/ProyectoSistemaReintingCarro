import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.Scanner;

public class Importar {

    public LinkedList<Cliente> importarArchivoCliente() {
        LinkedList<Cliente> lista = new LinkedList<>();
        try (BufferedReader br = new BufferedReader(new FileReader("Cliente.txt"))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                if (linea.trim().isEmpty() || linea.startsWith("---")) {
                    continue;
                }
                Cliente obj = new Cliente();
                obj.setCedula(linea.split(": ")[1]);
                linea = br.readLine();
                obj.setNombre(linea.split(": ")[1]);
                linea = br.readLine();
                obj.setApellido(linea.split(": ")[1]);
                linea = br.readLine();
                obj.setTelefono(linea.split(": ")[1]);
                linea = br.readLine();
                obj.setDireccion(linea.split(": ")[1]);
                linea = br.readLine();
                obj.setLicenciaConduccion(linea.split(": ")[1]);
                br.readLine();
                lista.add(obj);
            }
        } catch (FileNotFoundException e) {
        System.out.println();
    } catch (Exception e) {
        e.printStackTrace();
    }
        return lista;
    }

    public LinkedList<Vehiculo> importarVehiculos() {
    LinkedList<Vehiculo> lista = new LinkedList<>();
    try (BufferedReader br = new BufferedReader(new FileReader("Vehiculos.txt"))) {
        String linea;
        while ((linea = br.readLine()) != null) {
           if (linea.trim().isEmpty() || linea.startsWith("---")) {
                continue;
            }
            String tipo = linea.split(": ")[1];
            linea = br.readLine();
            String placa = linea.split(": ")[1];
            linea = br.readLine();
            String marca = linea.split(": ")[1];
            linea = br.readLine();
            int modelo = Integer.parseInt(linea.split(": ")[1]);
            linea = br.readLine();
            float precio = Float.parseFloat(linea.split(": ")[1]);
            linea = br.readLine();
            String estado = linea.split(": ")[1];
            if (tipo.equalsIgnoreCase("Sedan")) {
                linea = br.readLine();
                String combustible = linea.split(": ")[1];
                linea = br.readLine();
                String transmision = linea.split(": ")[1];
                CarroSedan sedan = new CarroSedan(placa,marca,modelo,precio,estado,combustible,transmision);
                lista.add(sedan);
            } else if (tipo.equalsIgnoreCase("SUV")) {
                linea = br.readLine();
                String traccion = linea.split(": ")[1];
                linea = br.readLine();
                float capacidad = Float.parseFloat(linea.split(": ")[1]);
                CamionetaSUV suv = new CamionetaSUV(placa,marca,modelo,precio,estado,traccion,capacidad);
                lista.add(suv);
            }
            br.readLine(); 
        }
    } catch (FileNotFoundException e) {
        System.out.println();
    } catch (Exception e) {
        e.printStackTrace();
    }

    return lista;
}
public LinkedList<ContratoRenting> importarArchivoContrato() {
    LinkedList<ContratoRenting> lista = new LinkedList<>();
    File archivo = new File("Contrato.txt");
    try (Scanner leer = new Scanner(archivo)) {
        while (leer.hasNextLine()) {
            String idContrato = leer.nextLine().replace("Id Contrato: ", "").trim();
            String cedulaCliente = leer.nextLine().replace("Cedula Cliente: ", "").trim();
            String placaVehiculo = leer.nextLine().replace("Placa Vehiculo: ", "").trim();
            String fechaInicio = leer.nextLine().replace("Fecha Inicio: ", "").trim();
            String fechaFin = leer.nextLine().replace("Fecha Fin: ", "").trim();
            int totalDias = Integer.parseInt(leer.nextLine().replace("Total Dias: ", "").trim());
            float valorTotal = Float.parseFloat(leer.nextLine().replace("Valor Total: ", "").trim());
            String estadoTexto = leer.nextLine().replace("Estado Contrato: ", "").trim();
            boolean activo = estadoTexto.equalsIgnoreCase("Activo");
            if (leer.hasNextLine()) {
                leer.nextLine();
            }
            ContratoRenting contrato = new ContratoRenting(idContrato,cedulaCliente, placaVehiculo,fechaInicio,fechaFin,totalDias,valorTotal);
            // Asignar estado activo/finalizado
            contrato.setActivo(activo);
            lista.add(contrato);
        }
    } catch (FileNotFoundException e) {
        System.out.println();
    } catch (Exception e) {
        e.printStackTrace();
    }
    return lista;
}

}