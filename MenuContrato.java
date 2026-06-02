import java.util.LinkedList;
import java.util.Scanner;
import java.util.Stack;

public class MenuContrato {
    LinkedList<ContratoRenting> contrato = new LinkedList<>();
    private Stack<ContratoRenting> historialContratos = new Stack<>();

    public void GestionContrato() {
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;
        MetodoContratoRenting m = new MetodoContratoRenting();
        LinkedList<ContratoRenting> contrato = new LinkedList<>();
        LinkedList<Cliente> cliente = new LinkedList<>();
        LinkedList<Vehiculo> vehiculos = new LinkedList<>();
        Importar imp = new Importar();
        cliente = imp.importarArchivoCliente();
        vehiculos = imp.importarVehiculos();
        contrato = imp.importarArchivoContrato();
        Validaciones v = new Validaciones();
        while (seguir) {
            System.out.println("********************************");
            System.out.println("****  GESTIÓN DE CONTRATO   ****");
            System.out.println("* 1. Registrar Contrato        *");
            System.out.println("* 2. Mostrar Contrato          *");
            System.out.println("* 3. Modificar Contrato        *");
            System.out.println("* 4. Finalizar Contrato        *");
            System.out.println("* 5. Buscar Contrato           *");
            System.out.println("* 6. Volver al menú principal  *");
            System.out.println("********************************");
            System.out.println("Por favor Seleccione una opcion");
            int opt = v.ValidarEntero(sc);
            sc.nextLine();
            switch (opt) {
                case 1:
                    contrato = m.registrarContrato(sc, cliente, vehiculos, contrato, new LinkedList<>(), v);
                    break;
                case 2:
                    m.mostrarContratos(contrato);
                    break;
                case 3:
                    contrato = m.modificarContrato(sc, contrato, vehiculos, v);
                    break;
                case 4:
                    m.finalizarContrato(sc, contrato, vehiculos, historialContratos);
                    break;
                case 5:
                    m.buscarContrato(sc, contrato,v);
                    break;
                case 6:
                    System.out.println("Estas saliendo del aplicativo");
                    Exportar e = new Exportar();
                    e.exportarArchivoContrato(contrato);
                    seguir = false;
                    break;
                default:
                    System.out.println("Esta opcion no es valida");
                    System.out.println("Ingresa un numero en el rango del 1 al 6");
                    break;
            }
        }
    }

    public Stack<ContratoRenting> getHistorialContratos() {
        return historialContratos;
    }
}
