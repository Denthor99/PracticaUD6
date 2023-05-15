package org.ieslosremedios.daw1.prog.ut6.practica6.ejer1;
import java.io.*;
public class Ejer1Main {
    public static void main(String[] args) {
        // Este ejercicio consiste en realizar una división, y controlaremos las excepciones.
        // En mi caso, el divisor no debe ser menor que 3, y el dividendo nunca menor a 7
        int dividendo=9;
        int divisor=3;
        try {
            int resultado = division(dividendo, divisor);
            System.out.println("El resultado de la división "+ dividendo + " / " + divisor + " es " + resultado);
        }
        catch (ExcepcionDanie miExp){
            System.err.println("Error: " + miExp.getMessage());
            System.err.println("Revisa los valores introducidos en la operación");
        }
        catch (ArithmeticException aExp) {
            System.err.println("Error: " + aExp.getMessage());
            System.err.println("Revisa los valores introducidos en la operación");
        }
        catch (Exception exep){
            System.err.println("Error: " + exep.getMessage());
        }

    }
    public static int division(int dividendo, int divisor) throws Exception {
        if (dividendo <= 0 || divisor <= 0) {
            throw new ArithmeticException("No se puede dividir entre cero, ni valores negativos.");
        }
        else if (divisor < 3 || dividendo < 7) {
            throw new ExcepcionDanie("Queda prohibido dividir por un numero menor a 3. Así mismo, el divisor no puede ser menor que 7");
        }
        else {
            return dividendo / divisor;
        }
    }


}