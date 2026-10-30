import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear parqueadero con espacios iniciales
        Parqueadero parqueadero = new Parqueadero("Parqueadero UTA - Grupo 6");
        parqueadero.agregarEspacio("A1");
        parqueadero.agregarEspacio("A2");
        parqueadero.agregarEspacio("A3");
        parqueadero.agregarEspacio("B1");
        parqueadero.agregarEspacio("B2");

        int opcion;
        do {
            System.out.println("\n╔════════════════════════════════════════╗");
            System.out.println("║     PARQUEADERO INTELIGENTE – UTA      ║");
            System.out.println("╠════════════════════════════════════════╣");
            System.out.println("║ 1. Registrar vehículo                  ║");
            System.out.println("║ 2. Agregar espacio                     ║");
            System.out.println("║ 3. Registrar entrada                   ║");
            System.out.println("║ 4. Registrar salida y cobrar           ║");
            System.out.println("║ 5. Ver ocupación del parqueadero       ║");
            System.out.println("║ 6. Ver historial de registros          ║");
            System.out.println("║ 7. Ver vehículos registrados           ║");
            System.out.println("║ 0. Salir                               ║");
            System.out.println("╚════════════════════════════════════════╝");
            System.out.print(" Seleccione una opción: ");

            // Validar que la entrada sea un entero
            while (!scanner.hasNextInt()) {
                System.out.print(" Opción inválida. Ingrese un número: ");
                scanner.next();
            }
            opcion = scanner.nextInt();
            scanner.nextLine(); // limpiar buffer

            switch (opcion) {
                case 1: // Registrar vehículo
                    System.out.print(" Placa del vehículo: ");
                    String placa = scanner.nextLine().trim();
                    System.out.print(" Tipo (AUTO / MOTO / CAMIONETA): ");
                    String tipo = scanner.nextLine().trim();
                    System.out.println(" " + parqueadero.registrarVehiculo(placa, tipo));
                    break;

                case 2: // Agregar espacio
                    System.out.print(" ID del nuevo espacio (ej: C1): ");
                    String idEspacio = scanner.nextLine().trim();
                    System.out.println(" " + parqueadero.agregarEspacio(idEspacio));
                    break;

                case 3: // Registrar entrada
                    System.out.print(" Placa para entrada: ");
                    String placaEntrada = scanner.nextLine().trim();
                    System.out.println(" " + parqueadero.registrarEntrada(placaEntrada));
                    break;

                case 4: // Registrar salida
                    System.out.print(" Placa para salida: ");
                    String placaSalida = scanner.nextLine().trim();
                    System.out.print(" Duración en horas (ej: 2.1667 para 2h 10min): ");
                    while (!scanner.hasNextDouble()) {
                        System.out.print(" Valor inválido. Ingrese horas: ");
                        scanner.next();
                    }
                    double horas = scanner.nextDouble();
                    scanner.nextLine(); // limpiar buffer
                    System.out.println(" " + parqueadero.registrarSalida(placaSalida, horas));
                    break;

                case 5: // Ocupación
                    parqueadero.mostrarOcupacion();
                    break;

                case 6: // Historial
                    parqueadero.mostrarRegistros();
                    break;

                case 7: // Vehículos
                    parqueadero.mostrarVehiculos();
                    break;

                case 0:
                    System.out.println("\n ¡Hasta luego! Sistema cerrado.");
                    break;

                default:
                    System.out.println(" Opción no válida. Intente de nuevo.");
            }
        } while (opcion != 0);

        scanner.close();
    }
}
