package edu.unl.cc.succession.view;

import java.util.Scanner;
import edu.unl.cc.succession.business.EvenNumberCalculatorUpToLimit;
import edu.unl.cc.succession.business.CubedPrimeSeriesUpToLimit;
import edu.unl.cc.succession.business.CubedPrimeSeriesUpToNTerms;
import edu.unl.cc.succession.model.Printable;
import edu.unl.cc.succession.model.Successionable;

/**
 * Menu interactivo para ejecutar las diferentes sucesiones numericas
 * @author TheJavier37 (Javier Guarnizo)
 *
 */
public class SuccessionExecutor {

    public static void main(String[] conclus) {
        Scanner input = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n=============================================");
            System.out.println("          SUCCESSION EXECUTOR SYSTEM         ");
            System.out.println("=============================================");
            System.out.println("1. Even Numbers Up To Limit");
            System.out.println("2. Cubed Prime Series Up To Limit");
            System.out.println("3. Cubed Prime Series Up To N Terms");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");

            int option = input.nextInt();
            Successionable serie = null;

            try {
                switch (option) {
                    case 1:
                        System.out.print("Enter the limit for the even numbers series: ");
                        int evenLimit = input.nextInt();
                        serie = new EvenNumberCalculatorUpToLimit(evenLimit);
                        break;

                    case 2:
                        System.out.print("Enter the value limit for the cubed prime series: ");
                        int primeLimit = input.nextInt();
                        serie = new CubedPrimeSeriesUpToLimit(primeLimit);
                        break;

                    case 3:
                        System.out.print("Enter the number of terms (N) for the cubed prime series: ");
                        int termsCount = input.nextInt();
                        serie = new CubedPrimeSeriesUpToNTerms(termsCount);
                        break;

                    case 4:
                        System.out.println("Exiting the system. Goodbye!");
                        exit = true;
                        break;

                    default:
                        System.out.println("Invalid option. Please choose a number between 1 and 4.");
                        break;
                }

                if (serie != null) {
                    Number result = serie.calculate();
                    System.out.println("\n--- Result ---");
                    System.out.println(((Printable) serie).print());
                    System.out.println("Total Sum = " + result);
                }

            } catch (IllegalArgumentException e) {
                System.out.println("\n[ERROR] " + e.getMessage());
            }
        }
        input.close();
    }
}
