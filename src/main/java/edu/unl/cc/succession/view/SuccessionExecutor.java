package edu.unl.cc.succession.view;

import java.util.Scanner;

import edu.unl.cc.succession.business.*;
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
            System.out.println("        SISTEMA EJECUTOR DE SUCESIONES       ");
            System.out.println("=============================================");
            System.out.println("1. Numeros pares hasta un limite");
            System.out.println("2. Serie de primos al cubo hasta un limite");
            System.out.println("3. Serie de primos al cubo hasta N terminos");
            System.out.println("4. Serie de primos elevados por pares hasta un limite");
            System.out.println("5. Serie de primos elevados a impares hasta N terminos");
            System.out.println("6. Serie de primos elevados a la raiz de numeros pares hasta un limite");
            System.out.println("7. Serie de primos elevados a la raiz de numeros impares hasta N terminos");
            System.out.println("8. Serie de primos elevados a la raiz cubica hasta N terminos");
            System.out.println("9. Serie de primos elevados a la raiz cuadrada hasta un limite");
            System.out.println("10. Serie de primos hasta un limite");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opcion: ");

            int option = input.nextInt();
            Successionable serie = null;

            try {
                switch (option) {
                    case 1:
                        System.out.print("Ingrese el limite para la serie de numeros pares: ");
                        int evenLimit = input.nextInt();
                        serie = new EvenNumberCalculatorUpToLimit(evenLimit);
                        break;

                    case 2:
                        System.out.print("Ingrese el limite de valor para la serie de primos al cubo: ");
                        int cubicPrimeLimit = input.nextInt();
                        serie = new CubicPrimesSumUpToLimit(cubicPrimeLimit);
                        break;

                    case 3:
                        //Darío, editas el case 3 y case 4 acorde a como estén las clases implementadas

                        /**
                        System.out.print("Ingrese la cantidad de terminos (N) para la serie de primos al cubo: ");
                        int termsCount = input.nextInt();
                        serie = new CubedPrimeSeriesUpToNTerms(termsCount);
                        break;
                        **/

                    case 4:
                        /**
                        System.out.print("Ingrese el limite de valor para la serie de primos con potencias pares: ");
                        int evenPowerLimit = input.nextInt();
                        serie = new EvenPoweredPrimeSeriesUpToLimit(evenPowerLimit);
                        break;
                         **/

                    case 5:
                        System.out.print("Ingrese la cantidad de terminos (N) para la serie de primos con potencias impares: ");
                        int oddPowerTerms = input.nextInt();
                        serie = new PrimesOddPowerSumUpToNTerms(true, oddPowerTerms);
                        break;

                    case 6:
                        System.out.print("Ingrese el limite de valor para la serie de primos con raices pares: ");
                        int evenRootLimit = input.nextInt();
                        serie = new PrimesEvenRootSumUpToLimit(true, evenRootLimit);
                        break;

                    case 7:
                        System.out.print("Ingrese la cantidad de terminos (N) para la serie de primos con raices impares: ");
                        int oddRootTerms = input.nextInt();
                        serie = new PrimeNumberWithPowCalculatorWithTerm(oddRootTerms);
                        break;

                    case 8:
                        System.out.print("Ingrese la cantidad de terminos (N) para la serie de primos con raiz cubica: ");
                        int cubicRootTerms = input.nextInt();
                        serie = new PrimesCubicRootSumUpToNTerms(cubicRootTerms);
                        break;

                    case 9:
                        /**
                        System.out.print("Ingrese el limite de valor para la serie de primos elevados a la raiz cuadrada: ");
                        int sqrtPrimeLimit = input.nextInt();
                        serie = new PrimesSquareRootSumUpToLimit(sqrtPrimeLimit);
                        break;
                        */
                    case 10:
                        /**
                        System.out.print("Ingrese el limite de valor para la serie de primos: ");
                        int simplePrimeLimit = input.nextInt();
                        serie = new PrimesSumUpToLimit(simplePrimeLimit);
                        break;
                        **/
                    case 0:
                        System.out.println("Saliendo del sistema. ¡Hasta luego!");
                        exit = true;
                        break;

                    /*
                     * Desarrolladores NeoCores encargados: Completar la integracion en el menu
                     * para los casos restantes desde la serie 7 hasta la serie 10.
                     */
                    default:
                        System.out.println("Opcion invalida. Por favor, seleccione una opcion valida.");
                        break;
                }

                if (serie != null) {
                    Number result = serie.calculate();
                    System.out.println("\n--- Resultado ---");
                    System.out.println(((Printable) serie).print());
                    System.out.println("Suma Total = " + result);
                }

            } catch (IllegalArgumentException e) {
                System.out.println("\n[ERROR] " + e.getMessage());
            }
        }
        input.close();
    }
}