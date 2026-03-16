package apps.TorresColores;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class VarillasMain {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        GestorArchivos gestor = new GestorArchivos();

        //estado por defecto si no se carga partida
        String[][] estadoInicial = {
                {null, null, null, null}, // Varilla 1
                {null, null, null, null}, // Varilla 2
                {null, null, null, null}  // Varilla 3
        };

        estadoInicial[0] = new String[]{"R", "V", "A", null};
        estadoInicial[1] = new String[]{"A", "R", "V", null};
        estadoInicial[2] = new String[]{"V", "A", "R", null};

        String deseas = "¿Deseas cargar una partida desde un fichero?(S/N)";
        System.out.println(deseas);
        String cargar = scanner.nextLine();

        while (!(cargar.equalsIgnoreCase("s") || cargar.equalsIgnoreCase("n"))) {
            System.out.println("Entrada no válida. " + deseas);
            cargar = scanner.nextLine();
        }

            if (cargar.equalsIgnoreCase("s")) {
                System.out.println("Introduce el nombre del fichero");
                String nombreFichero = scanner.nextLine();

                try (Scanner lectorFichero = new Scanner(new File(nombreFichero))) {
                    int fila = 0;
                    while (lectorFichero.hasNextLine() && fila < 3) {
                        //limpia la información de la varilla para no mezclar con la nueva
                        for(int j=0; j<4; j++) estadoInicial[fila][j] = null;
                        //lee la línea, corta donde hay uno o más espacios
                        //y convierte en piezas individuales (bloques de colores)
                        String[] colores = lectorFichero.nextLine().split("\\s+");
                        for (int i = 0; i < colores.length && i < 4; i++) {
                            //guardamos las piezas en "estadoInicial", cada una en su hueco
                            estadoInicial[fila][i] = colores[i];
                        }
                        //pasa a la siguiente varilla
                        fila++;
                    }
                    System.out.println("Estado cargado con éxito.");
                } catch (FileNotFoundException e) {
                    System.out.println("Error: No se encuentra el archivo. Se usará el estado por defecto.");
                }

            } else {
                System.out.println("Nueva partida");
                gestor.iniciarGrabacion("partida_guardada.txt");
            }
        JuegoManager manager = new JuegoManager(scanner, estadoInicial, gestor);

            manager.iniciarJuego();

            gestor.detenerGrabacion();
    }
}
