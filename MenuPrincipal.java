import java.util.LinkedList;
import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        MenuCliente cliente = new MenuCliente();
        MenuContrato contrato = new MenuContrato();
        MenuVehiculo vehiculo = new MenuVehiculo();
        LinkedList<Cliente> lista = new LinkedList<>();
        LinkedList<Vehiculo> listaVehiculos = new LinkedList<>();
        LinkedList<ContratoRenting> listaContratos = new LinkedList<>();
        Validaciones v = new Validaciones();
        Importar imp = new Importar();
        lista = imp.importarArchivoCliente();
        listaVehiculos = imp.importarVehiculos();
        listaContratos = imp.importarArchivoContrato();
        boolean seguir = true;
        while (seguir) {
            System.out.println("*****************************************");
            System.out.println("**    SISTEMA DE RENTING DE CARROS     **");
            System.out.println("*****************************************");
            System.out.println("** 1. GESTIÓN DE CLIENTES              **");
            System.out.println("** 2. GESTIÓN DE VEHÍCULOS             **");
            System.out.println("** 3. GESTIÓN DE CONTRATOS DE RENTING  **");
            System.out.println("** 4. IMPRIMIR INFORME GENERAL         **");
            System.out.println("** 5. SALIR DEL SISTEMA                **");
            System.out.println("*****************************************");
            System.out.println("Ingrese una opcion: ");
            int opt = v.ValidarEntero(sc);
            sc.nextLine();
            switch (opt) {
                case 1:
                    cliente.GestionDeCliente();
                    break;
                case 2:
                    vehiculo.GestionVehiculo();
                    break;
                case 3:
                    contrato.GestionContrato();
                    break;
                case 4:
                    lista = imp.importarArchivoCliente();
                    listaVehiculos = imp.importarVehiculos();
                    listaContratos = imp.importarArchivoContrato();
                    InformeGeneral informe = new InformeGeneral(lista, listaVehiculos, listaContratos,
                            contrato.getHistorialContratos());
                    System.out.println(informe.informeGeneral());
                    break;
                case 5:
                    System.out.println("Estas saliendo del aplicativo..");
                    System.out.println("**************************************************");
                    System.out.println("** Creado por Edinson Gutierrez y Luis Silva... **");
                    System.out.println("**************************************************");
                    System.out.println();
                    seguir = false;
                    break;
                default:
                    System.out.println("opcion invalida ingresa del 1 al 5");
                    break;
            }
        }
    }
}
