
import java.util.LinkedList;
import java.util.Scanner;

public class MenuVehiculo {
    public void GestionVehiculo() {
        Scanner sc = new Scanner(System.in);
        boolean seguir = true;
        MetodoVehiculo m = new MetodoVehiculo();
        LinkedList<Vehiculo> vehiculos = new LinkedList<>();
        Validaciones v = new Validaciones();
        Importar imp = new Importar();
        vehiculos = imp.importarVehiculos();
        while (seguir) {
            System.out.println("********************************");
            System.out.println("****  GESTIÓN DE VEHICULO   ****");
            System.out.println("* 1. Ingresar Vehiculo         *");
            System.out.println("* 2. Mostrar Vehiculo          *");
            System.out.println("* 3. Modificar Vehiculo        *");
            System.out.println("* 4. Eliminar Vehiculo         *");
            System.out.println("* 5. Volver al menú principal  *");
            System.out.println("********************************");
            System.out.println("Por favor Seleccione una opcion");
            int opt = v.ValidarEntero(sc);
            sc.nextLine();
            switch (opt) {
                case 1:
                    vehiculos = m.RegistrarVehiculo(sc, vehiculos,v);
                    break;
                case 2:
                    m.MostrarVehiculos(vehiculos);
                    break;
                case 3:
                    vehiculos = m.ModificarVehiculo(sc, vehiculos,v);
                    break;
                case 4:
                    vehiculos = m.EliminarVehiculo(sc, vehiculos);
                    break;
                case 5:
                    System.out.println("Estas saliendo del aplicativo");
                    Exportar e = new Exportar();
                    e.exportarVehiculos(vehiculos);
                    seguir = false;
                    break;
                default:
                    System.out.println("Esta opcion no es valida");
                    System.out.println("Ingresa un numero en el rango del 1 al 6");
                    break;
            }
        }
    }
}
