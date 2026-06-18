package edu.unl.cc.succession.view;

import java.util.InputMismatchException;
import java.util.Scanner;

import edu.unl.cc.succession.business.*;
import edu.unl.cc.succession.model.Printable;
import edu.unl.cc.succession.model.Successionable;

/**
 * Menu interactivo blindado para ejecutar las diferentes sucesiones numericas
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

            int option = readSecureInt(input);
            if (option == -1) continue;

            Successionable serie = null;

            try {
                switch (option) {
                    case 1:
                        System.out.print("Ingrese el limite para la serie de numeros pares: ");
                        int evenLimit = readSecureInt(input);
                        if (evenLimit != -1) serie = new EvenNumberCalculatorUpToLimit(0, evenLimit);
                        break;

                    case 2:
                        System.out.print("Ingrese el limite de valor para la serie de primos al cubo: ");
                        int cubicPrimeLimit = readSecureInt(input);
                        if (cubicPrimeLimit != -1) serie = new CubicPrimesSumUpToLimit(2, cubicPrimeLimit);
                        break;

                    case 3:
                        System.out.println("Ingrese la cantidad de terminos (N), para la serie de primos elevados al cubo");
                        int NTermCubicPrime = readSecureInt(input);
                        if (NTermCubicPrime != -1) serie = new CubicPrimesSumUpToNTerms(2, NTermCubicPrime);
                        break;

                    case 4:
                        System.out.println("Ingrese el limite del valor para la serie de primos elevados a potencias pares hasta un limite");
                        int primePoweredToEven = readSecureInt(input);
                        if (primePoweredToEven != -1) serie = new PrimesEvenPowerSumUpToLimit(2, primePoweredToEven);
                        break;

                    case 5:
                        System.out.print("Ingrese la cantidad de terminos (N) para la serie de primos con potencias impares: ");
                        int oddPowerTerms = readSecureInt(input);
                        if (oddPowerTerms != -1) serie = new PrimesOddPowerSumUpToNTerms(true, oddPowerTerms);
                        break;

                    case 6:
                        System.out.print("Ingrese el limite de valor para la serie de primos con raices pares: ");
                        int evenRootLimit = readSecureInt(input);
                        if (evenRootLimit != -1) serie = new PrimesEvenRootSumUpToLimit(true, evenRootLimit);
                        break;

                    case 7:
                        System.out.print("Ingrese la cantidad de terminos (N) para la serie de primos con raices impares: ");
                        int oddRootTerms = readSecureInt(input);
                        if (oddRootTerms != -1) serie = new PrimeNumberWithPowCalculatorWithTerm(oddRootTerms);
                        break;

                    case 8:
                        System.out.print("Ingrese la cantidad de terminos (N) para la serie de primos con raiz cubica: ");
                        int cubicRootTerms = readSecureInt(input);
                        if (cubicRootTerms != -1) serie = new PrimesCubicRootSumUpToNTerms(cubicRootTerms);
                        break;

                    case 9:
                        System.out.print("Ingrese el limite de valor para la serie de primos elevados a la raiz cuadrada: ");
                        int sqrtPrimeLimit = readSecureInt(input);
                        if (sqrtPrimeLimit != -1) serie = new PrimesSquareRootSumUpToLimit(sqrtPrimeLimit);
                        break;

                    case 10:
                        System.out.print("Ingrese el limite de valor para la serie de primos: ");
                        int simplePrimeLimit = readSecureInt(input);
                        if (simplePrimeLimit != -1) serie = new PrimesSumUpToLimit(simplePrimeLimit);
                        break;

                    case 0:
                        System.out.println("\n[SISTEMA] Saliendo del sistema de sucesiones. ¡Hasta luego!");
                        exit = true;
                        break;

                    default:
                        showCustomError("OPCION INVALIDA", "La opcion seleccionada (" + option + ") no se encuentra en el menu.");
                        break;
                }

                if (serie != null) {
                    Number result = serie.calculate();
                    System.out.println("\n--- Resultado ---");
                    System.out.println(((Printable) serie).print());
                    System.out.println("Suma Total = " + result);
                }

            } catch (IllegalArgumentException e) {
                showCustomError("RESTRICCION DE NEGATIVOS", e.getMessage());
            }
        }
        input.close();
    }

    /**
     * Captura de forma segura un entero desde la consola, previniendo el ingreso de texto
     * @param scanner Instancia de entrada activa
     * @return El numero entero digitado, o -1 si ocurrio una excepcion de formato
     */
    private static int readSecureInt(Scanner scanner) {
        try {
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            showCustomError("ENTRADA NO VALIDA", "Se detecto texto o caracteres no numericos. Solo se permiten numeros enteros.");
            scanner.nextLine();
            return -1;
        }
    }

    /**
     * Muestra en consola un recuadro de alerta estructurado ante cualquier error del sistema
     */
    private static void showCustomError(String errorType, String message) {
        System.out.println("\n┌──────────────────────────────────────────────────────────────────────────────────────┐");
        System.out.println("  ERROR: " + errorType);
        System.out.println("  DETALLE: " + message);
        System.out.println("└──────────────────────────────────────────────────────────────────────────────────────┘");
    }
}