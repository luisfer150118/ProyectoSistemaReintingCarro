import java.util.Scanner;

public class MenuPrincipal {
     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        boolean continuar = true;
        while (continuar) {
            System.out.println("Bienvenidos a la practica de estructuras");
            System.out.println("que desea realizar 1: , 2: 3: 4: salir");
            int menu = sc.nextInt();
            switch (menu) {
                case 1:
                    System.out.println("Aplictivo en Mantenimiento");
                    break;
                case 2:
                    System.out.println("Aplictivo en Mantenimiento");
                    break;
                case 3:
                    System.out.println("Aplictivo en Mantenimiento");
                    break;
                case 4:
                    System.out.println("Saliendo del aplicativo");
                    continuar = false;
                    break;

                default:
                    break;
            }
        }
    }
}
