import java.util.Random;
import java.util.Scanner;

public class Reto {

    private static String destination = "Ninguno";
    private static String transport = "No seleccionada";
    private static double distanceMKm = 0;
    private static double speedKmH = 0;
    private static boolean continuee = true;

    public static void main(String[] args) throws Exception {

        System.out.println("\n===========================================");
        System.out.println("---- Simulación ----");
        System.out.println("Vamos a otro planeta !!");
        System.out.println("===========================================");

        Scanner sc = new Scanner(System.in);
        

        while (continuee) {
            showMainMenu();
            int option = sc.nextInt();
            sc.nextLine(); // Limpia el buffer

            switch (option) {
                case 1 -> selectPlanet(sc);
                case 2 -> modifyTrip(sc);
                case 3 -> calculateTrip();
                case 4 -> manageResources(sc);
                case 5 -> simulateTrip(sc);
                case 6 -> finish();

                default-> System.err.println("Opción inválida");

            }

        }

    }

    private static void showMainMenu() {
        System.out.println("\n---- Menú Principal ----\n");
        System.out.println("1. Selecionar destino (PLANETA)");
        System.out.println("2. Seleciona el tipo de nave y/o modificar el viaje ");
        System.out.println("3. Calcular viaje");
        System.out.println("4. Gestionar recursos de la nave");
        System.out.println("5. Despegar");
        System.out.println("6. Salir de la simulación");
        System.out.print("Elige una opción: ");

    }

    private static void selectPlanet(Scanner sc) {

        if (destination != "Ninguno") {
            System.out.println("\nTu destino es: " + destination);
            System.out.println("Debes modificar tu viaje si deseas cambiar de destino (Opción 2)");
            return;
            
        } 
        System.out.println("\n---- Planetas disponibles ----\n");
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

        System.out.println("\n--- Modificar viaje ---\n");
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
        System.out.println("\nDestino reiniciado");

    }

    private static void selectShip(Scanner sc) {
        System.out.println("\n---- Tipos de nave ----\n");
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

        System.out.println("\nNave seleccionada: " + transport);

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

        System.out.printf("Distancia al destino: %.2f de km\n", distanceKm);
        System.out.printf("Velocidad de la nave: %.2f km/h\n", speedKmH);
        System.out.printf("Tiempo estimado de viaje: %.2f días\n", timeDays);

        return false; // Se sale del while

    }

    private static void simulateTrip(Scanner sc) {
        
        if (destination == "Ninguno" || transport == "No seleccionada") {
            System.out.println("¡Error! Primero selecciona un destino y una nave.");
            return; // Detiene el despegue si no se ha seleccionado destino o nave
        }

        System.out.println("\n---- Preparación para el despegue ----");
        System.out.println("\n¡Iniciando cuenta regresiva!");
        // Cuenta regresiva
        for (int i = 5; i > 0; i--) {
            System.out.println(i + "....");
        }
        System.out.println("\n¡Despegue exitoso!\n");

        // Simulación del viaje
        for (int progress = 0; progress <= 100; progress += 20) {

            System.out.println("Progreso: " + progress + "%");

            if (progress == 0) {
                System.out.println("\n¡Inicio del viaje!");
            } else if (progress == 40) {
                System.out.println("¡Vamos por la mitad del camino!");
                randomEvent(sc);
            } else if (progress == 100) {
                System.out.println("¡Haz llegado a tu destino!");
                continuee = false;
            }

        }

    }

    private static void randomEvent(Scanner sc) {
        Random rm = new Random();

        String[] problems  = {
            "¡Tenemos una falla en el sistema! :O",
            "¡Se aproxima una lluvia de asteroides! ¿Qué hacemos? O.o",
            "¡La nave se está desviando! Debemos volver al curso"
        };

        String [][] options = {
            {"1. Reiniciar el sistema y ejecutar un análisis para encontrar el problema", "2. Revisar los instrumentos y volver a calibrarlos", "3. Tomar el control manual de la nave"},
            {"1. Reiniciar el sistema y ejecutar un análisis para encontrar el problema", "2. Revisar los instrumentos y volver a calibrarlos", "3. Tomar el control manual de la nave\""},
            {"1. Reiniciar el sistema y ejecutar un análisis para encontrar el problema", "2. Revisar los instrumentos y volver a calibrarlos", "3. Tomar el control manual de la nave"}
        };

        int[] correctAnswers = {1,3,2};

        int event = rm.nextInt(problems.length); // Creación del evento aleatorio

        System.out.println("\n¡Poseemos un problema!\n");
        System.out.println(problems[event]);

        for (String option : options[event]) {
            System.out.println(option);
        }
        System.out.println("\n--- Debes arreglar el problema !!!! ---\n");
        System.out.print("Seleccina la opción para solucionar el problema: ");
        int answer = sc.nextInt();

        if (answer - 1 == correctAnswers[event]) {
            System.out.println("Muy bien!! Problema resueldo");
            System.out.println("Podemos continuar el viaje");
        } else {
            System.out.println("Te has equivocado y el viaje fue un desaste");
            finish();   
        }        
        
    }

    private static double availableFuel = 5000; // En litros
    private static double availableOxygen = 200; // En horas
    private static double requiredFuel = 0; // Combustible necesario para el viaje
    private static double requiredOxygen = 0; // Oxígeno necesario para el viaje

    private static void manageResources(Scanner sc) {

        if (destination == "Ninguno") {
            System.out.println("\n¡Error! Primero debes seleccionar un destino.");
            return; // Sale del método si no se ha seleccionado un destino
        }

        System.out.println("\n---- Gestión de Recursos ----");

        double distanceKm = distanceMKm * 1_000_000;

        requiredFuel = distanceKm * 0.05; // Combustible necesario: 0.05 litros por km
        requiredOxygen = distanceMKm * 24; // Oxígeno necesario: 24 horas por cada millón de km

        // Mostrar los recursos necesarios y los disponibles

        System.out.printf("Combustible necesario: %.2f litros\n", requiredFuel);
        System.out.printf("Oxígeno necesario: %.2f horas\n", requiredOxygen);
        System.out.printf("Combustible disponible: %.2f litros\n", availableFuel);
        System.out.printf("Oxígeno disponible: %.2f horas\n", availableOxygen);

        // Verificar si los recursos son suficientes

        while (requiredFuel > availableFuel || requiredOxygen > availableOxygen) {
            System.out.println("\n¡Atención! NO tienes suficientes recursos para el viaje.\n");
            System.out.println("1. Reabastecer combustible");
            System.out.println("2. Reabastecer oxígeno");
            System.out.print("Elige una opción: ");

            int option = sc.nextInt();

            switch (option) {
                case 1 -> {
                    System.out.print("\n¿Cuántos litros de combustible deseas añadir?: ");
                    double fuelToAdd = sc.nextDouble();
                    availableFuel += fuelToAdd;
                    System.out.println("Combustible reabastecido. Combustible disponible: " + availableFuel
                            + " litros.");
                }
                case 2 -> {
                    System.out.print("\n¿Cuántas horas de oxígeno deseas añadir?: ");
                    double oxygenToAdd = sc.nextDouble();
                    availableOxygen += oxygenToAdd;
                    System.out.println("Oxígeno reabastecido. Oxígeno disponible: " + availableOxygen + " horas.");
                }
                default -> System.err.println("Opción no válida.");
            }

            System.out.printf("Combustible necesario: %.2f litros\n", requiredFuel);
            System.out.printf("Oxígeno necesario: %.2f horas\n", requiredOxygen);
            System.out.printf("Combustible disponible: %.2f litros\n", availableFuel);
            System.out.printf("Oxígeno disponible: %.2f horas\n", availableOxygen);
        }

        System.out.println("\n¡Todo listo! Tienes suficientes recursos para el viaje.");

    }

    private static void finish(){
        System.out.println("\nVuelve cuando quieras realizar otra simulación\n");
        continuee = false;
    }
}
