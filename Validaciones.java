import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class Validaciones {
    public int ValidarEntero(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Por favor Ingrese un digito Numérico");
            sc.nextLine();
        }
        return sc.nextInt();
    }

    public boolean ValidarDimension(String opt) {
        while (opt.length() > 1) {
            System.out.println("Solo puede agregar Y or N");
            return false;

        }
        return true;

    }

    public boolean ValidarTexto(String texto) {
        return texto.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+");
    }
   
    public boolean ValidarNumero(String texto) {
        return texto.matches("^[0-9]+$");
    }

    public boolean ValidarTelefono(String telefono) {
        return telefono.matches("\\d{10}");
    }

    public boolean ValidarSN(String respuesta) {
        return respuesta.equalsIgnoreCase("S") ||
                respuesta.equalsIgnoreCase("N");
    }

public boolean ValidarCedula(String cedulaAux) {
    cedulaAux = cedulaAux.trim();
    if (!cedulaAux.matches("[0-9]+")) {
        return false;
    }
    if (cedulaAux.length() < 7 || cedulaAux.length() > 11) {
        return false;
    }
    return true;
}
public String validarPlaca(String msg, Scanner sc) {

        System.out.print(msg);
        String dato = sc.nextLine().trim();
        ;

        if (!dato.matches("[a-zA-Z0-9]+")) {

            System.out.println("No se permiten caracteres especiales.");
            return validarPlaca(msg, sc);
        }

        return dato;
    }
    public int validarModelo(String msg, Scanner sc) {
        System.out.print(msg);
    int modelo = ValidarEntero(sc);
    sc.nextLine(); // limpiar Enter pendiente

    if (modelo < 1000 || modelo > 9999) {
        System.out.println("El modelo debe tener 4 dígitos positivos.");
        return validarModelo(msg, sc);
    }

    return modelo;
}

  
        public float validarFloat(String msg, Scanner sc) {

           while (true) {
             System.out.print(msg);
           String linea = sc.nextLine().trim();
            
            try {
                float n = Float.parseFloat(linea);
                if (n <= 0) {
                    System.out.println("Ingrese un valor positivo.");
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                System.out.println("Ingrese un decimal valido.");
            }
        }
    }
       
        
    public String validarFecha(String mensaje, Scanner sc) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        while (true) {

            System.out.print(mensaje);
            String fecha = sc.nextLine();

            try {
                LocalDate.parse(fecha, formato);
                return fecha;

            } catch (DateTimeParseException e) {
                System.out.println("Fecha inválida. Formato correcto: dd/MM/yyyy");
            }
        }
    }

    public boolean fechaPosterior(String fechaInicio, String fechaFin) {

        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");

        LocalDate inicio = LocalDate.parse(fechaInicio, formato);
        LocalDate fin = LocalDate.parse(fechaFin, formato);

        return fin.isAfter(inicio);
    }
    public String validarTextoNoVacio(String mensaje, Scanner sc) {
    String texto;

    do {
        System.out.print(mensaje);
        texto = sc.nextLine().trim();

        if (texto.isEmpty()) {
            System.out.println("No puede estar vacío o contener solo espacios.");
        }

    } while (texto.isEmpty());

    return texto;
}
String validarMarca(String msg, Scanner sc) {
    String marca;
    do {
        System.out.print(msg);
        marca = sc.nextLine().trim();
        if (marca.isEmpty()) {
            System.out.println("La marca no puede estar vacía.");
        } else if (!marca.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ ]+")) {
            System.out.println("Solo letras.");
            marca = "";
        }
    } while (marca.isEmpty());
    return marca;
}
    public String validarNombre(String msg, Scanner sc) {

        System.out.print(msg);

        String dato = sc.nextLine().trim();

        dato = dato.replaceAll("\\s+", " ");

        String[] partes = dato.split(" ");

        if (partes.length > 2) {

            System.out.println("Nombre invalido.");

            return validarNombre(msg, sc);
        }

        if (!dato.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ]+( [a-zA-ZáéíóúÁÉÍÓÚñÑ]+)?")) {

            System.out.println("Solo letras.");

            return validarNombre(msg, sc);
        }

        return dato;
    }

}