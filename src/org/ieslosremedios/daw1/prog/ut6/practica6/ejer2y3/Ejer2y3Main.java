package org.ieslosremedios.daw1.prog.ut6.practica6.ejer2y3;

public class Ejer2y3Main {
    public static void main(String[] args) {
        /**
         * Enunciado ejercicio 2:
         * El juego de las torres de Hanoi es un rompecabezas que esencialmente consiste en mover
         * un conjunto de discos, de tamaño decreciente y apilados en orden, de una torre a otra,
         * utilizando una tercera torre como ayuda, siguiendo las siguientes reglas:
         * - Solo se puede mover un disco a la vez.
         * - Un disco solo se puede mover si está en la parte superior de una torre.
         * - Un disco solo se puede mover a una torre vacía o a la parte superior de otra torre, si
         * y solo si su tamaño es menor que el disco en la parte superior de esa torre.
         * El objetivo del juego es mover todos los discos a la tercera torre en el mismo orden en que
         * estaban en la primera torre.
         *
         *El resultado que deberás mostrar es imprimir las instrucciones para resolverlo, ejemplo:
         * Mover disco 1 desde A hasta C
         * Mover disco 2 desde A hasta B
         * */

        // Lo primero que haremoos es declarar "los discos". Como en el ejemplo ofrecido en la práctica contamoos con tres discos, realizaremos el mismo ejemplo. Se sobreentiende que los discos se han introducido ordenados.
        int numDiscos = 2; // número de discos actuales

        // Invocación al método que realizará lo que se nos pide en el enunciado
        torreHanoi(numDiscos, 'A', 'C', 'B');
    }

    /**
     * Creamos un metodo llamado "torreHanoi", que recibirá como parametros el número de discos (un entero) y las posiciones de origen, destino y apoyo (todas siendo tipo caracter). apoyo será la representación de la torre
     * intermedia, que nos servirá como medio para los intercambios de posiciones (algo así como una variable intermedia).
     * Como podemos ver a simple vista, en este método emplearemos recursividad. Como hemos mencionado a lo largo del tema, empleamos este recurso pues el problema de las Torres de Hanoi es algo complejo de resolver en conjunto, pero se puede dividir en subproblemas más pequeños.
     * 1. Si n(representando el primer disco) es igual a 1, significa que solo hay un disco que se debe mover desde "origen" hasta "destino". Nos devuelve por pantalla que se ha realizado el movimiento y salimos del metodo en ejecución
     * 2. Si n es mayor que 1, entonces el método llama a sí mismo recursivamente tres veces:
     * - En la primera llamada, se mueven n-1 discos de la torre "origen" a la torre "de apoyo".
     * - En la segunda llamada, se mueve el disco más grande desde la torre "origen" hasta la torre "destino".
     * - En la tercera llamada, se mueven los n-1 discos que se habían movido previamente a la torre "apoyo" hacia la torre "destinoo", utilizando la torre "origen" como ayuda.
     * Una vez terminado, se nos muestra por pantalla todos los movimientos realizados
     */
    public static void torreHanoi(int n, char torreOrigen, char torreDestino, char torreApoyo) {
        if (n == 1) { //1.*
            System.out.println("Mover disco 1 de la torre " + torreOrigen + " a la torre " + torreDestino);
            return;
        }
        torreHanoi(n - 1, torreOrigen, torreApoyo, torreDestino); // 2.*
        System.out.println("Mover disco " + n + " de la torre " + torreOrigen + " a la torre " + torreDestino);
        torreHanoi(n - 1, torreApoyo, torreDestino, torreOrigen);
    }
}
    /**
     * Enunciado ejercicio 3:
     * Analiza el algoritmo del ejercicio anterior y calcula cuál sería su complejidad utilizando la
     * notación Big-O. Debes indicar claramente el procedimiento que has utilizado y no sólo la
     * solución.
     * */

    /**
     * Como comentamos en otros ejercicios anteriores a la práctica, encontramos varios tipos de complejidad logaritmica distintas. En el caso del ejercicio anterior, estamos moviendo una cantidad relativamente controlable
     * de discos. Si por ejemplo, introducimos 4 discos, se realizarán más movimientos para poder realizar lo que se nos pide, y estos movimientos irán incrementando de forma considerable a medida que se introducen más discos.
     *  Este algoritmo emplea recursividad para resolver el problema planteado. El número de operaciones necesarias para mover n discos se puede expresar como una ecuación de recurrencia: T(n) = 2T(n-1) + 1. La solución a esta ecuación es T(n) = 2^n - 1, lo que significa que se necesitan 2^n - 1 operaciones para mover n discos.
     *  Por tanto, nos estamos refiriendo a un algoritmo cuya notación Big O es de tipo exponencial O(2^n), lo que significa que el tiempo de ejecución aumenta de forma exponencial con el número de discos.
     *  Esto hace que el algoritmo sea bastante lento para un gran número de discos, ya que el tiempo de ejecución aumenta exponencialmente con el número de discos.
     * Por lo tanto, si se necesita mover un gran número de discos, es recomendable utilizar un algoritmo más eficiente.
     */