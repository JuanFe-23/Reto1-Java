import java.util.Scanner;

public class Reto {
    public static void main(String[] args) throws Exception {

        System.out.println("===========================================");
        System.out.println("Vamos a otro planeta");
        System.out.println("----------------------------------------");

        Scanner sc = new Scanner(System.in);

        showMenu(sc);
        sc.close();

    }

    private static void showMenu(Scanner sc) {

        boolean continuee = true;
        String destination = "Ninguno";
        String transport = "No seleccionado";

        do {
            System.out.println("\nMenú principal");
            System.out.println("1. Selecionar destino (Planeta)");
            System.out.println("2. Modificar viaje");
            System.out.println("3. Confirmar y DESPEGAR");
            System.out.println("4. Salir");
            System.out.print("Elige un opción: ");
            int option = sc.nextInt();
            sc.nextInt();

            switch (option) {
                case 1:
                    System.out.println("\n---Planetas disponobles---");
                    System.out.println("1. Mercurio");
                    System.out.println("2. Venus");
                    System.out.println("3. Marte");
                    System.out.println("4. Júpiter");
                    System.out.println("5. Saturno");
                    System.out.println("6. Urano");
                    System.out.println("7. Neptuno");
                    System.out.println("8. Salir");
                    System.out.print("Selecciona el planeta al que deseas viajar: ");
                    int planetOption = sc.nextInt();
                    sc.nextLine();

                    switch (planetOption) {
                        case 1:
                            showPlanetData("Mercurio", 77.3, 50000);
                            break;
                        case 2:
                            showPlanetData("Venus", 41.4, 50000);
                            break;
                        case 3:
                            showPlanetData("Marte", 78.3, 50000);
                            break;
                        case 4:
                            showPlanetData("Júpiter", 628.7, 50000);
                            break;
                        case 5:
                            showPlanetData("Saturno", 1275.0, 50000);
                            break;
                        case 6:
                            showPlanetData("Urano", 2721.0, 50000);
                            break;
                        case 7:
                            showPlanetData("Neptuno", 4351.0, 50000);
                            break;
                         case 8:
                            System.out.println("Regresa cuando estes seguro de viajar a algun planeta");
                            break;

                        default:
                            System.err.println("Opción inválida");
                            break;
                    }

            }
        } while (continuee) ;

        /*
         * do {
         * 
         * 
         * 
         * 
         * 
         * }
         * 
         * } while (option != 8);
         */

    }

    private static void pressEnter(Scanner sc) {
        System.err.println("Presione ENTER para continuar");
        sc.nextLine();
    }

    private static void showPlanetData(String planetName, double distanceMillionsKm, double speedKmH) {

        var distanceKm = distanceMillionsKm * 1000000; // Convertir millones de km a km
        var timeHours = distanceKm / speedKmH; // Tiempo en horas
        var timeDays = timeHours / 24; // Convertir horas a días

        System.out.println("===========================================");
        System.out.println("Planeta seleccionado: " + planetName);
        System.out.println("Distancia desde la Tierra: " + distanceKm + " km");
        System.out.println("Velocidad de la nave: " + speedKmH + " km/h");
        System.out.println("Tiempo estimado de viaje: " + timeDays + " días");
        System.out.println("===========================================");
    }
}
