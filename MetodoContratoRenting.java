import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class MetodoContratoRenting {
    public LinkedList<ContratoRenting> registrarContrato(Scanner sc, LinkedList<Cliente> clientes,LinkedList<Vehiculo> vehiculos, LinkedList<ContratoRenting> contratos, Queue<ContratoRenting> colaContratos,Validaciones v) {
        if (contratos == null) {
            contratos = new LinkedList<>();
        }
       String id;
    while (true) {

        System.out.print("Id contrato: ");
        id = sc.nextLine();

        boolean existe = false;

        for (ContratoRenting c : contratos) {
            if (c.getIdContrato().equalsIgnoreCase(id)) {
                existe = true;
                break;
            }
        }

        if (!existe) {
            break;
        }

        System.out.println("El contrato ya existe.");
        System.out.println("1. Intentar nuevamente");
        System.out.println("2. Salir");

        int opcion = v.ValidarEntero(sc);

        if (opcion == 2) {
            return contratos;
        }
    }

    // ================= CEDULA CLIENTE =================
    String cedula;

    while (true) {

        System.out.print("Cedula cliente: ");
        cedula = sc.nextLine();

        boolean clienteExiste = false;

        for (Cliente c : clientes) {
            if (c.getCedula().equalsIgnoreCase(cedula)) {
                clienteExiste = true;
                break;
            }
        }

        if (!clienteExiste) {
            System.out.println("Cliente no encontrado.");
            System.out.println("1. Intentar nuevamente");
            System.out.println("2. Salir");

            int opcion = v.ValidarEntero(sc);
            sc.nextLine();

            if (opcion == 2) {
                return contratos;
            }

            continue;
        }

        // Validar contrato activo
        boolean tieneContratoActivo = false;

        for (ContratoRenting c : contratos) {
            if (c.getCedulaCliente().equalsIgnoreCase(cedula)
                    && c.isActivo()) {

                tieneContratoActivo = true;
                break;
            }
        }

        if (tieneContratoActivo) {
            System.out.println("El cliente ya tiene contrato activo.");
            System.out.println("1. Intentar otra cedula");
            System.out.println("2. Salir");

            int opcion = v.ValidarEntero(sc);
            sc.nextLine();

            if (opcion == 2) {
                return contratos;
            }

            continue;
        }

        break;
    }

    // ================= PLACA VEHICULO =================
    Vehiculo vehiculo = null;
    String placa;

    while (true) {

        System.out.print("Placa vehiculo: ");
        placa = sc.nextLine();

        vehiculo = null;

        for (Vehiculo ve : vehiculos) {
            if (ve.getPlaca().equalsIgnoreCase(placa)) {
                vehiculo = ve;
                break;
            }
        }

        if (vehiculo == null) {
            System.out.println("Vehiculo no encontrado.");
            System.out.println("1. Intentar nuevamente");
            System.out.println("2. Salir");

            int opcion = v.ValidarEntero(sc);
            sc.nextLine();

            if (opcion == 2) {
                return contratos;
            }

            continue;
        }

        if (vehiculo.getEstado().equalsIgnoreCase("Alquilado")) {

            System.out.println("Vehiculo alquilado.");
            System.out.println("1. Intentar otra placa");
            System.out.println("2. Salir");
            
            int opcion = v.ValidarEntero(sc);
            sc.nextLine();
            if (opcion == 2) {
                return contratos;
            }

            continue;
        }

        break;
    }

    // ================= FECHAS =================
    String fechaInicio = v.validarFecha("Fecha inicio (dd/MM/yyyy): ", sc);
    String fechaFin = v.validarFecha("Fecha fin (dd/MM/yyyy): ", sc);

    while (!v.fechaPosterior(fechaInicio, fechaFin)) {
        System.out.println("La fecha final debe ser posterior.");
        fechaFin = v.validarFecha("Fecha fin: ", sc);
    }

    LocalDate inicio = LocalDate.parse(
            fechaInicio,
            DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    LocalDate fin = LocalDate.parse(
            fechaFin,
            DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    int dias = (int) ChronoUnit.DAYS.between(inicio, fin);
    dias++;

    float total = dias * vehiculo.getPrecioDiario();

    ContratoRenting contrato = new ContratoRenting(id,cedula,placa,fechaInicio,fechaFin,dias, total);

    contratos.add(contrato);
    colaContratos.add(contrato);

    // Cambiar estado vehículo
    vehiculo.setEstado("Alquilado");

    Exportar e = new Exportar();
    e.exportarVehiculos(vehiculos);

    System.out.println("Contrato registrado correctamente.");

    return contratos;
}

    public LinkedList<ContratoRenting> modificarContrato(Scanner sc, LinkedList<ContratoRenting> contratos,LinkedList<Vehiculo> vehiculos, Validaciones v) {
        System.out.print("Id contrato: ");
        String id = sc.nextLine();
        for (ContratoRenting c : contratos) {
            if (c.getIdContrato().equalsIgnoreCase(id)) {
                c.setFechaInicio(v.validarFecha("Nueva fecha inicio (dd/MM/yyyy): ", sc));
                c.setFechaFin(v.validarFecha("Nueva fecha fin (dd/MM/yyyy): ", sc));
                while (!v.fechaPosterior( c.getFechaInicio(),c.getFechaFin())) {
                    System.out.println("La fecha final debe ser posterior.");
                    c.setFechaFin(v.validarFecha("Nueva fecha fin: ", sc));
                }
                LocalDate inicio = LocalDate.parse(c.getFechaInicio(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                LocalDate fin = LocalDate.parse(c.getFechaFin(),DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                int dias = (int) ChronoUnit.DAYS.between(inicio, fin);
                dias++;
                c.setTotalDias(dias);
                for (Vehiculo ve : vehiculos) {
                    if (ve.getPlaca().equalsIgnoreCase(c.getPlacaVehiculo())) {
                        c.setValorTotal(dias * ve.getPrecioDiario());
                    }
                }
                System.out.println("Contrato modificado.");
                return contratos;
            }
        }
        System.out.println("Contrato no encontrado.");
        return null;
    }

    public LinkedList<ContratoRenting> finalizarContrato(Scanner sc,LinkedList<ContratoRenting> contratos,LinkedList<Vehiculo> vehiculos,Stack<ContratoRenting> historialContratos) {
        System.out.print("Id contrato: ");
        String id = sc.nextLine();
        for (ContratoRenting c : contratos) {
            if (c.getIdContrato().equalsIgnoreCase(id)
                    && c.isActivo()) {
                c.setActivo(false);
                historialContratos.push(c);
                for (Vehiculo ve : vehiculos) {
                    if (ve.getPlaca().equalsIgnoreCase(
                            c.getPlacaVehiculo())) {
                        ve.setEstado("Disponible");
                        break;
                    }
                }
                Exportar e = new Exportar();
                e.exportarVehiculos(vehiculos);
                e.exportarArchivoContrato(contratos);
                System.out.println("Contrato finalizado.");
                return contratos;
            }
        }
        System.out.println("Contrato no encontrado.");
        return contratos;
    }

    public LinkedList<ContratoRenting> buscarContrato(Scanner sc, LinkedList<ContratoRenting> contratos, Validaciones v) {
        int continuar = 1;
        while (continuar == 1) {
            System.out.print("Id contrato: ");
            String id = sc.nextLine().trim();
            boolean encontrado = false;
            for (ContratoRenting c : contratos) {
                if (c.getIdContrato().equalsIgnoreCase(id)) {
                    System.out.println("\n===== CONTRATO =====");
                    System.out.println("Id contrato: " + c.getIdContrato());
                    System.out.println("Cedula cliente: " + c.getCedulaCliente());
                    System.out.println("Placa vehiculo: " + c.getPlacaVehiculo());
                    System.out.println("Fecha inicio: " + c.getFechaInicio());
                    System.out.println("Fecha fin: " + c.getFechaFin());
                    System.out.println("Total dias: " + c.getTotalDias());
                    System.out.println("Valor total: " + c.getValorTotal());
                    encontrado = true;
                    break;
                }
            }
            if (!encontrado) {
                System.out.println("Contrato no encontrado.");
            }
            
            while (true) {

            System.out.println("\n¿Deseas buscar otro contrato o salir?");
            System.out.println("1. Buscar otro contrato");
            System.out.println("2. Salir");    
            continuar = v.ValidarEntero(sc);
            sc.nextLine();
            if (continuar==1 || continuar==2) {
            break;        
           }
             System.out.println("Opcion invalida. Ingrese 1 o 2.");
            }
        }
        return contratos;
    }

    public void mostrarContratos(
            LinkedList<ContratoRenting> contratos) {
        if (contratos.isEmpty()) {
            System.out.println("No hay contratos registrados.");
            return;
        }
        for (ContratoRenting c : contratos) {
            System.out.println("\n===== CONTRATO =====");
            System.out.println("Id contrato: " + c.getIdContrato());
            System.out.println("Cedula cliente: " + c.getCedulaCliente());
            System.out.println("Placa vehiculo: " + c.getPlacaVehiculo());
            System.out.println("Fecha inicio: " + c.getFechaInicio());
            System.out.println("Fecha fin: " + c.getFechaFin());
            System.out.println("Total dias: " + c.getTotalDias());
            System.out.println("Valor total: " + c.getValorTotal());
            System.out.println("Estado contrato: " + (c.isActivo() ? "Activo" : "Finalizado"));
            System.out.println("----------------------");
        }
        System.out.println("Total de contratos: " + contratos.size());
        System.out.println();
    }
}
