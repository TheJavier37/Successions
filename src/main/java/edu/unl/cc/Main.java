package edu.unl.cc;

import edu.unl.cc.succesions.bussines.EvenNumberCalculatorUpToLimit;
import edu.unl.cc.succesions.model.Printable;
import edu.unl.cc.succesions.model.Successionable;

import java.util.Scanner;

public class Main {

    private static void printMenu(){
        System.out.println("Menu");
        System.out.println("1. Print");

    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese el limite de la serie de numeros pares");
        int limit = input.nextInt();

        Successionable serie = new EvenNumberCalculatorUpToLimit(limit);
        Number result = serie.calculate();

        System.out.println(((Printable)serie).print());
        System.out.println("S = " + result);
    }
}