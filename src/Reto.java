import java.util.Scanner;

public class Reto {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);

        showMenu(sc);
        sc.close();

    }

    private static void showMenu (Scanner sc){

        int option;

        do {

            System.out.println("===========================================");
            System.out.println("Vamos a otro planeta");
            System.out.println("----------------------------------------");
            System.out.println("1. Mercurio");
            System.out.println("2. Venus");
            System.out.println("3. Marte");
            System.out.println("4. Júpiter");
            System.out.println("5. Saturno");
            System.out.println("6. Urano");
            System.out.println("7. Neptuno");
            System.out.println("8. Salir");
            System.out.print("Selecciona el planeta al que deseas viajar: ");
            option = sc.nextInt();
            sc.nextLine(); 
            switch (option) {
                case 1:
                    //Método que muestre los datos Mercurio
                    break;
                case 2:
                    //Método que muestre los datos Venus
                    break;
                case 3:
                    //Método que muestre los datos Marte
                    break;
                case 4:
                    //Método que muestre los datos Júpiter
                    break;
                case 5:
                    //Método que muestre los datos Saturno
                    break;
                case 6:
                    //Método que muestre los datos Urano
                    break;
                case 7:
                    //Método que muestre los datos Neptuno
                    break;
                case 8:
                    System.out.println("Regresa cuando estes seguro de viajar a algun planeta");
                    break;
            
                default:
                System.err.println("Opción inválida");
                    break;
            }
            if (option !=8) {
                pressEnter(sc);
                
            }
            
        } while (option !=8);

        
        
    }

    private static void pressEnter (Scanner sc){
        System.err.println("Presione ENTER para continuar");
        sc.nextLine();
    }
}
