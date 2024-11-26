import java.util.Scanner;

public class Reto {

    private static String destination = "Ninguno";
    private static String transport = "No seleccionada";
    private static double distanceMKm = 0;
    private static double speedKmH = 0;

    public static void main(String[] args) throws Exception {

        System.out.println("===========================================");
        System.out.println("---- Simulacion ----");
        System.out.println("Vamos a otro planeta !!");
        System.out.println("===========================================");

        Scanner sc = new Scanner(System.in);
        boolean continuee = true;

        while (continuee) {
            showMainMenu();
            int option = sc.nextInt();
            sc.nextLine(); // Limpia el buffer

            switch (option) {
                case 1 -> selectPlanet(sc);
                case 2 -> modifyTrip(sc);
                case 3 -> calculateTrip();

                // default:

            }

        }

    }

    private static void showMainMenu() {
        System.out.println("\n---- Menú Principal ----");
        System.out.println("1. Selecionar destino (PLANETA)");
        System.out.println("2. Modificar viaje");
        System.out.println("3. Calcular viaje");
        System.out.println("4. Despegar");
        System.out.println("5. Salir");
        System.out.print("Elige una opción: ");

    }

    private static void selectPlanet(Scanner sc) {
        System.out.println("\n---- Planetas disponibles ----");
        System.out.println("1. Mercurio (91.7 millones de km)");
        System.out.println("2. Venus (42.4 millones de km)");
        System.out.println("3. Marte (78.3 millones de km)");
        System.out.println("4. Júpiter (628.9 millones de km)");
        System.out.println("5. Saturno (1284.4 millones de km)");
        System.out.println("6. Urano (2721.4 millones de km)");
        System.out.println("7. Neptuno (4345.4 millones de km)");
        System.out.print("Selecciona tu destino: ");
        int planet = sc.nextInt();
        sc.nextLine();

        switch (planet) {
            case 1 -> {
                destination = "Mercurio";
                distanceMKm = 91.7; // En millones kilómetros
            }
            case 2 -> {
                destination = "Venus";
                distanceMKm = 42.4; // En millones kilómetros
            }
            case 3 -> {
                destination = "Marte";
                distanceMKm = 78.3; // En millones kilómetros
            }
            case 4 -> {
                destination = "Júpiter";
                distanceMKm = 628.9; // En millones kilómetros
            }
            case 5 -> {
                destination = "Saturno";
                distanceMKm = 1284.4; // En millones kilómetros
            }
            case 6 -> {
                destination = "Urano";
                distanceMKm = 2721.4; // En millones kilómetros
            }
            case 7 -> {
                destination = "Neptuno";
                distanceMKm = 4345.4; // En millones kilómetros
            }
            default -> {
                System.err.println("Opción no válida");
                return;
            }

        }
        System.out.println("\nDestino seleccionado: " + destination);
    }

    private static void modifyTrip(Scanner sc) {
        if (destination.equals("Ninguno")) {
            System.out.println("Primero decide a donde ir");
            return;
        }

        System.out.println("\n--- Modificar viaje ---");
        System.out.println("1. Cambiar el destino");
        System.out.println("2. Seleccionar tipo de nave");
        System.out.print("Elige una opción: ");
        int modify = sc.nextInt();
        sc.nextLine(); // Limpiar el buffer

        switch (modify) {
            case 1 -> resetDestination();
            case 2 -> selectShip(sc);
            default -> System.err.println("Opción no válida");
        }

    }

    private static void resetDestination() {
        destination = "Ninguno";
        distanceMKm = 0;
        System.out.println("Destino reiniciado");

    }

    private static void selectShip(Scanner sc) {
        System.out.println("\n---- Tipos de nave ----");
        System.out.println("1. Nave Espacial (Velocidad: 28,000 km/h - Nivel de comodidad: Alta) ");
        System.out.println("2. Cohete (Velocidad: 40,000 km/h - Nivel de comodidad: Baja)");
        System.out.print("Selecciona el tipo de nave: ");
        int ship = sc.nextInt();

        switch (ship) {
            case 1 -> {
                transport = "Nave espacial";
                speedKmH = 28_000; // En km/h
            }
            case 2 -> {
                transport = "Cohete";
                speedKmH = 40_000; // En km/h
            }
            default -> {
                System.err.println("Opción inválida");
                return;
            }

        }

    }

    private static boolean calculateTrip() {
        System.out.println("\n---- Confirmar y calcular tiempo ----");
        System.out.println("Destino: " + destination);
        System.out.println("Tipo de nave: " + transport);

        if (destination.equals("Ninguno") || transport.equals("No seleccionada")) {
            System.out.println("Selecciona un destino y la nave antes de confirmar viaje");
            return true;
        }

        // Cálculo de distancia
        double distanceKm = distanceMKm * 1_000_000; // Conversion de millones de km a solo km

        // Cálculo de tiempo en horas
        double timeHours = distanceKm / speedKmH;

        // Cálculo en días
        double timeDays = timeHours / 24;

        System.out.printf("Distancia al destino: %.2f millones de km\n", distanceKm);
        System.out.printf("Velocidad de la nave: %.2f km/h\n", speedKmH);
        System.out.printf("Tiempo estimado de viaje: %.2f días\n", timeDays);

        return false; // Se sale del while

    }

}
