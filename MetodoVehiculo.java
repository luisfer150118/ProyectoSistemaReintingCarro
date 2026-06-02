
import java.util.LinkedList;
import java.util.Scanner;

public class MetodoVehiculo {
    

   
    public LinkedList<Vehiculo> RegistrarVehiculo(Scanner sc, LinkedList<Vehiculo> vehiculos, Validaciones v) {
         if (vehiculos == null) {
        vehiculos = new LinkedList<>();
    }
     boolean pedir = true;
     while (pedir) {
        
     
    int tipo;
   
    while (true){
        System.out.println("Escoge tu carroceria");
        System.out.println("1. Sedan");
        System.out.println("2. SUV");
        tipo = v.ValidarEntero(sc);
        sc.nextLine();
        if (tipo==1 || tipo==2) {
            break;        
        }
    System.out.println("Opcion invalida. Ingrese 1 o 2.");
    }

    
    String placa;

while (true) {

    placa = v.validarPlaca("Placa: ", sc);

    boolean existe = false;

    for (Vehiculo ve : vehiculos) {
        if (ve.getPlaca().equalsIgnoreCase(placa)) {
            existe = true;
            break;
        }
    }

    if (!existe) {
        break; 
    }

    
    while (true) {
        System.out.print("La placa ya existe. ¿Desea ingresar otra placa? (S/N): ");
        String respuesta = sc.nextLine().trim();

        if (respuesta.equalsIgnoreCase("S")) {
            break; // vuelve a pedir placa
        } else if (respuesta.equalsIgnoreCase("N")) {
            return vehiculos; // salir del método
        } else {
            System.out.println("Ingrese solo S o N.");
        }
    }
}
   
       String marca = v.validarNombre("Marca: ", sc);
        int modelo = v.validarModelo("Modelo (Año): ", sc);
         float precio = v.validarFloat("Precio diario: ", sc);
    
        String estado = "Disponible";

    if (tipo == 1) {
        int opCombustible;
        while (true) {
            System.out.println("===== TIPO COMBUSTIBLE =====");
            System.out.println("1. Gasolina");
            System.out.println("2. Diesel");
            System.out.println("3. Electrico");
            opCombustible = v.ValidarEntero(sc);
            if (opCombustible >= 1 && opCombustible <= 3) break;
            System.out.println("Opción inválida. Ingrese 1, 2 o 3.");
        }

        String combustible = "";

        switch (opCombustible) {
            case 1:
                combustible = "Gasolina";
                break;
            case 2:
                combustible = "Diesel";
                break;
            case 3:
                combustible = "Electrico";
                break;
        }
        int opTransmision;
        while (true) {
        System.out.println("===== TRANSMISION =====");
        System.out.println("1. Manual");
        System.out.println("2. Automatica");
         opTransmision = v.ValidarEntero(sc);
           if (opTransmision >= 1 && opTransmision <= 2) break;
            System.out.println("Opción inválida. Ingrese 1 o 2.");
        }
        String transmision = "";
        switch (opTransmision) {
            case 1:
                transmision = "Manual";
                break;
            case 2:
                transmision = "Automatica";
                break;
                
        }
         CarroSedan sedan = new CarroSedan(placa, marca, modelo, precio, estado, combustible, transmision);
          vehiculos.add(sedan);
        
    } else if (tipo == 2) {
        int opTraccion;
        while (true) {
        System.out.println("===== TRACCION =====");
        System.out.println("1. 4x2");
        System.out.println("2. 4x4");
        opTraccion = v.ValidarEntero(sc);
           if (opTraccion >= 1 && opTraccion <= 2) break;
            System.out.println("Opción inválida. Ingrese 1 o 2.");
        }
        String traccion = "";
        switch (opTraccion) {
            case 1:
                traccion = "4x2";
                break;
            case 2:
                traccion = "4x4";
                break;
        }
         float capacidad = v.validarFloat("Capacidad maletero en litros: ",sc);
        CamionetaSUV suv = new CamionetaSUV(placa, marca, modelo, precio, estado, traccion, capacidad);
        vehiculos.add(suv);
    }

    System.out.println("Vehiculo registrado correctamente.");
    sc.nextLine();
       while (true) {
                System.out.print("¿Desea continuar? (S/N): ");
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("S")) {
                    break; // sigue el while principal
                } else if (respuesta.equalsIgnoreCase("N")) {
                    pedir = false; // termina el while principal
                    break;
                } else {
                    System.out.println("Ingrese solo S o N");
                }
            }
        }
    return vehiculos;
}

    public LinkedList<Vehiculo> ModificarVehiculo(Scanner sc, LinkedList<Vehiculo> vehiculos, Validaciones v) {

        System.out.print("Placa: ");
        String placa = sc.nextLine();

        for (Vehiculo ve : vehiculos) {

            if (ve.getPlaca().equalsIgnoreCase(placa)) {

                ve.setMarca(v.validarNombre("Marca: ", sc));
                ve.setModelo( v.validarModelo("Modelo (Año): ", sc));
                ve.setPrecioDiario( v.validarFloat("Precio diario: ", sc));
                

                System.out.println("Vehiculo modificado.");
                return vehiculos;
            }
        }

        System.out.println("Vehiculo no encontrado.");
        return vehiculos;
    }

    public LinkedList<Vehiculo> EliminarVehiculo(Scanner sc, LinkedList<Vehiculo> vehiculos) {

        System.out.print("Placa: ");
        String placa = sc.nextLine();

        boolean eliminado = vehiculos.removeIf(ve -> ve.getPlaca().equalsIgnoreCase(placa));

        if (eliminado) {
            System.out.println("Vehiculo eliminado.");
        } else {
            System.out.println("Vehiculo no encontrado.");
        }

        return vehiculos;
    }

    public LinkedList<Vehiculo> BuscarVehiculo(Scanner sc, LinkedList<Vehiculo> vehiculos) {

        System.out.print("Placa: ");
        String placa = sc.nextLine();

        for (Vehiculo ve : vehiculos) {

            if (ve.getPlaca().equalsIgnoreCase(placa)) {

                System.out.println("===== VEHICULO ENCONTRADO =====");
                System.out.println("Placa: " + ve.getPlaca());
                System.out.println("Marca: " + ve.getMarca());
                System.out.println("Modelo: " + ve.getModelo());
                System.out.println("Precio diario: " + ve.getPrecioDiario());
                System.out.println("Estado: " + ve.getEstado());
                return vehiculos;
            }
        }

        System.out.println("Vehiculo no encontrado.");
        return vehiculos;
    }

    public void MostrarVehiculos(LinkedList<Vehiculo> vehiculos) {
    if (vehiculos.isEmpty()) {
        System.out.println("No hay vehículos registrados.");
        return;
    }
    System.out.println("\n========== LISTADO DE VEHICULOS ==========");
    for (Vehiculo ve : vehiculos) {
        // Mostrar el tipo
        if (ve instanceof CarroSedan) {
            CarroSedan sedan = (CarroSedan) ve;
            System.out.println("Tipo: Sedan");
            System.out.println("Placa: " + sedan.getPlaca());
            System.out.println("Marca: " + sedan.getMarca());
            System.out.println("Modelo: " + sedan.getModelo());
            System.out.println("Precio diario: " + sedan.getPrecioDiario());
            System.out.println("Estado: " + sedan.getEstado());
            System.out.println("Combustible: " + sedan.getTipoCombustible());
            System.out.println("Transmision: " + sedan.getTransmision());
        } else if (ve instanceof CamionetaSUV) {
            CamionetaSUV suv = (CamionetaSUV) ve;
            System.out.println("Tipo: SUV");
            System.out.println("Placa: " + suv.getPlaca());
            System.out.println("Marca: " + suv.getMarca());
            System.out.println("Modelo: " + suv.getModelo());
            System.out.println("Precio diario: " + suv.getPrecioDiario());
            System.out.println("Estado: " + suv.getEstado());
            System.out.println("Traccion: " + suv.getTraccion());
            System.out.println("Capacidad en: " + suv.getCapacidadMaletero());
        }
        System.out.println("--------------------------------");
    }
    System.out.println("Total de vehículos: " + vehiculos.size());
    System.out.println();
}
}