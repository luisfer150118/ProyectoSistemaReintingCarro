import java.util.LinkedList;
import java.util.Scanner;

public class MenuCliente {
    public void GestionDeCliente() {
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;
        MetodoCliente m = new MetodoCliente();
        LinkedList<Cliente> lista = new LinkedList<>();
        Validaciones v = new Validaciones();
        Importar imp = new Importar();
        lista = imp.importarArchivoCliente();
        while (seguir) {
            System.out.println("********************************");
            System.out.println("****  GESTIÓN DE CLIENTES   ****");
            System.out.println("* 1. Ingresar Cliente          *");
            System.out.println("* 2. Mostrar Cliente           *");
            System.out.println("* 3. Modificar Cliente         *");
            System.out.println("* 4. Eliminar Cliente          *");
            System.out.println("* 5. Volver al menú principal  *");
            System.out.println("********************************");
            System.out.println("Por favor Seleccione una opcion");
            int opt = v.ValidarEntero(sc);
            sc.nextLine();
            switch (opt) {
                case 1:
                    lista = m.LLenarCliente(lista, sc);
                    break;
                case 2:
                    m.MostrarCliente(lista);
                    break;
                case 3:
                    lista = m.ModificarClientes(lista, v, sc);
                    break;
                case 4:
                    lista = m.Eliminar(lista, v, sc);
                    break;
                case 5:
                    System.out.println("Estas saliendo del aplicativo");
                    Exportar e = new Exportar();
                    e.exportarArchivoCliente(lista);
                    seguir = false;
                    break;
                default:
                    System.out.println("Esta opcion no es valida");
                    System.out.println("Ingresa un numero en el rango del 1 al 5");
                    break;
            }
        }
    }
}
