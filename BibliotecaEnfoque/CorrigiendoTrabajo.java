package apps.BibliotecaEnfoque;
/*
    Nos piden un programa que solicite al usuario la introducción de 10 números enteros por teclado.
    Una vez obtenidos, el programa deberá realizar dos tareas:
    primero, mostrar los números ordenados de menor a mayor;
    y segundo, distinguir cuántos números son pares (aquellos cuyo resto al dividir por dos es cero)
    y cuántos son impares.
     */

import java.util.Scanner;

// El nombre de la clase tiene que coincidir con el nombre del archivo.
public class CorrigiendoTrabajo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // Declaramos el array y las variables; nos basta con dos
        // y tenemos que darles un valor ("0" porque es un contador).
        int[] numeros = new int[10];
        int pares = 0 , impares = 0;

        // El bucle "for" es mejor cuando iteramos sobre un array y
        // cuando sabemos cuántas veces se debe ejecutar el código.
        // Rellenamos el array con los números del scanner.
        System.out.println("Introducir 10 números enteros");
        for (int i = 0; i < 10; i++){
            System.out.println("Número " + (i + 1) + ": ");
            numeros[i] = scanner.nextInt();
        }

        //Primero vamos a contar nuestros números, pares o impares, y después los ordenaremos.
        // Utilizamos de nuevo "for" porque nos permite recorrer nuestro array.
        // Ahora sí, necesitamos "if" y "else".
        // Si al dividir entre dos cualquiera de los números introducidos el resto es 0, significa que es par,
        // de lo contrario será impar
        for (int i = 0; i < 10; i++){
            if (numeros[i] % 2 == 0){
                pares++;
            } else {
                impares++;
            }

        }

        //https://www.youtube.com/watch?v=tGJNlb3HbLE
        // Para ordenar de menor a mayor necesitamos dos bucles,
        // uno recorrerá el array mientras que el otro compara elementos de dos en dos y decide su posición
        for (int i = 0; i < numeros.length - 1; i++) {
            //ordenamiento burbuja https://www.youtube.com/watch?v=HWMTdikOAUE
            for (int j = 0; j < numeros.length - 1 - i; j++) {
                if (numeros[j] > numeros [j + 1]) {
                    //utilizamos "aux" para hacer un intercambio de valores sin pérdida de datos
                    //si no lo usas, se sobreescribe
                    int aux = numeros[j];
                    numeros [j] = numeros [j + 1];
                    numeros [j + 1] = aux;
                }
            }
        }
        System.out.println("\n--- RESULTADOS ---");
        System.out.print("Lista ordenada: ");
        for (int n : numeros) {
            System.out.print(n + " ");
        }

        System.out.println("\nCantidad de pares: " + pares);
        System.out.println("Cantidad de impares: " + impares);

    }

}
