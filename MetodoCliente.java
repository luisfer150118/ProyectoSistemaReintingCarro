import java.util.LinkedList;
import java.util.Scanner;

public class MetodoCliente {
    public LinkedList<Cliente> LLenarCliente(LinkedList<Cliente> l, Scanner sc) {
        if (l == null) {
            l = new LinkedList<>();
        }
        boolean pedir = true;
        Validaciones v = new Validaciones();
        while (pedir) {
            Cliente o = new Cliente();
            while (true) {
                System.out.print("Ingrese la cédula (solo números, de 7 a 10 digitos): ");
                String cedulaAux = sc.nextLine();
                // Validar formato de cédula
                if (v.ValidarCedula(cedulaAux)) {
                    // Verificar si la cédula ya existe
                    boolean existe = false;
                    for (Cliente c : l) {
                        if (c.getCedula().equals(cedulaAux)) {
                            existe = true;
                            break;
                        }
                    }
                    if (existe) {
                        System.out.println("(!) Error: Cliente ya existe con esa cédula.");
                    } else {
                        o.setCedula(cedulaAux);
                        break; // sale del while porque la cédula es válida y no repetida
                    }
                } else {
                    System.out.println("(!) Error: Cédula inválida, solo numeros. Minimo 7 digitos");
                }
            }
            while (true) {
                System.out.print("Ingrese el nombre del cliente: ");
                String NomAux = sc.nextLine().trim();
                if (v.ValidarTexto(NomAux)) {
                    o.setNombre(NomAux);
                    break;
                } else {
                    System.out.println("(!) Error: El nombre contiene caracteres no permitidos.");
                }
            }
            while (true) {
                System.out.print("Ingrese el apellido del cliente: ");
                String ApeAux = sc.nextLine().trim();
                if (v.ValidarTexto(ApeAux)) {
                    o.setApellido(ApeAux);
                    break;
                } else {
                    System.out.println("(!) Error: El apellido contiene caracteres no permitidos.");
                }
            }
            while (true) {
                System.out.print("Ingrese el numero de teléfono (solo 10 digitos): ");
                String TelAux = sc.nextLine();
                if (v.ValidarTelefono(TelAux)) {
                    o.setTelefono(TelAux);
                    break;
                } else {
                    System.out.println("(!) Error: Teléfono inválido.");
                }
            }
            while (true) {
                System.out.print("Ingrese la dirección del cliente: ");
                String dirAux = sc.nextLine().trim();

                if (!dirAux.isEmpty()) {
                    o.setDireccion(dirAux);
                    break;
                } else {
                    System.out.println("(!) Error: La dirección no puede estar vacía.");
                }
            }
            while (true) {
                System.out.print("Ingrese la licencia de conducción: ");
                String licAux = sc.nextLine().trim();
                if (!licAux.isEmpty()) {
                    o.setLicenciaConduccion(licAux);
                    break;
                } else {
                    System.out.println("(!) Error: La licencia no puede estar vacía.");
                }
            }
            l.add(o);
            System.out.println("Cliente registrado con éxito.");
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
        return l;
    }

    public void MostrarCliente(LinkedList<Cliente> l) {
        if (l == null || l.isEmpty()) {
            System.out.println("La lista de clientes está vacía o no ha sido inicializada.");
            return;
        }
        System.out.println("\n========== LISTADO DE CLIENTES ==========");
        for (Cliente o : l) {
            System.out.println("Cédula:      " + o.getCedula());
            System.out.println("Nombre:      " + o.getNombre());
            System.out.println("Apellido:    " + o.getApellido());
            System.out.println("Teléfono:    " + o.getTelefono());
            System.out.println("Dirección:   " + o.getDireccion());
            System.out.println("Licencia:    " + o.getLicenciaConduccion());
            System.out.println("-----------------------------------------");
        }
        System.out.println("Total de clientes: " + l.size());
    }

    public LinkedList<Cliente> Eliminar(LinkedList<Cliente> l, Validaciones v, Scanner sc) {
        boolean continuar = true;
        while (continuar) {
            String cedula = "";
            while (true) {
                System.out.print("Ingrese la cédula a eliminar: ");
                cedula = sc.nextLine();
                if (v.ValidarNumero(cedula)) {
                    break;
                } else {
                    System.out.println("(!) Error: Ingrese solo números.");
                }
            }
            String cedulaFinal = cedula;
            boolean eliminado = l.removeIf(x -> x.getCedula().equals(cedulaFinal));
            if (eliminado) {
                System.out.println("Cliente eliminado correctamente.");
            } else {
                System.out.println("No se encontró la cédula.");
            }
            boolean respuestaValida = false;
            while (!respuestaValida) {
                System.out.print("¿Desea eliminar otro cliente? (S/N): ");
                String respuesta = sc.nextLine();
                if (respuesta.equalsIgnoreCase("S")) {
                    respuestaValida = true;
                } else if (respuesta.equalsIgnoreCase("N")) {
                    continuar = false;
                    respuestaValida = true;
                } else {
                    System.out.println("Ingrese solo S o N.");
                }
            }
        }
        return l;
    }

    public LinkedList<Cliente> ModificarClientes(LinkedList<Cliente> l, Validaciones v, Scanner sc) {
        System.out.println("Por favor ingrese la cédula a modificar");
        String cedula = sc.nextLine().trim();
        for (Cliente o : l) {
            if (o.getCedula().equals(cedula)) {
                while (true) {
                    System.out.print("Ingrese el nombre del cliente: ");
                    String NomAux = sc.nextLine().trim();
                    if (v.ValidarTexto(NomAux)) {
                        o.setNombre(NomAux);
                        break;
                    } else {
                        System.out.println("(!) Error: El nombre contiene caracteres no permitidos.");
                    }
                }
                while (true) {
                    System.out.print("Ingrese el apellido del cliente: ");
                    String ApeAux = sc.nextLine().trim();
                    if (v.ValidarTexto(ApeAux)) {
                        o.setApellido(ApeAux);
                        break;
                    } else {
                        System.out.println("(!) Error: El apellido contiene caracteres no permitidos.");
                    }
                }
                while (true) {
                    System.out.print("Ingrese el numero de teléfono (solo 10 digitos): ");
                    String TelAux = sc.nextLine();
                    if (v.ValidarTelefono(TelAux)) {
                        o.setTelefono(TelAux);
                        break;
                    } else {
                        System.out.println("(!) Error: Teléfono inválido.");
                    }
                }
                while (true) {
                    System.out.print("Ingrese la dirección del cliente: ");
                    String dirAux = sc.nextLine().trim();

                    if (!dirAux.isEmpty()) {
                        o.setDireccion(dirAux);
                        break;
                    } else {
                        System.out.println("(!) Error: La dirección no puede estar vacía.");
                    }
                }
                while (true) {
                    System.out.print("Ingrese la licencia de conducción: ");
                    String licAux = sc.nextLine().trim();
                    if (!licAux.isEmpty()) {
                        o.setLicenciaConduccion(licAux);
                        break;
                    } else {
                        System.out.println("(!) Error: La licencia no puede estar vacía.");
                    }
                }
                System.out.println("Cliente modificado con éxito.");
            }
        }
        return l;
    }
}
