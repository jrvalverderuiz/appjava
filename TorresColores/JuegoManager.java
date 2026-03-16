package apps.TorresColores;

import java.util.Scanner;
//Gestiona la interacción con el jugador
public class JuegoManager {

    private final Scanner sc;
    //Representa el estado del juego
    private final JuegoColores juego;
    private final GestorArchivos gestor;

    // Inicializa el juego con un estado cargado o el predeterminado
    public JuegoManager(Scanner sc, String[][] estadoInicial, GestorArchivos gestor) {
        this.sc = sc;
        this.juego = new JuegoColores(estadoInicial);
        this.gestor = gestor;
    }

 //Ejecuta el bucle principal mostrando el estado y procesando comandos
    public void iniciarJuego() {

        mostrarBienvenida();

        boolean salir = false;

        while (!salir) {
            juego.mostrarEstado();

            if (verificarVictoria()) {
                System.out.println("Has completado el juego");
                break;
            }

            salir = procesarComando();
        }
    }
//Muestra instrucciones iniciales
    private void mostrarBienvenida() {
        System.out.println("--- Juego de Torres de Colores ---");
        System.out.println("Mueve los bloques entre las varillas");
        System.out.println("Consigue que cada varilla tenga bloques de un solo color");
        System.out.println("Comandos:");
        System.out.println("1-3 -> selecciona varilla; D -> deshacer; S -> salir");

    }
//Comprueba su el juego ha sido completado
    private boolean verificarVictoria() {

        return juego.juegoCompletado();
    }
//Interpreta la acción del jugador (S, D, o movimiento)
    private boolean procesarComando() {

        System.out.println("Selecciona varilla origen (1-3, D=deshacer, S=salir):");

        String comando = sc.nextLine();

        if (comando.equalsIgnoreCase("S")) {
            gestor.escribir(juego.estadoGuardar());
            return true;
        }

        if (comando.equalsIgnoreCase("D")) {
            juego.deshacer();
            return false;
        }

        procesarMovimiento(comando);
        return false;
    }
//Llama a juegoColores.mover() tras leer el destino
    private void procesarMovimiento(String comandoOrigen) {
        //intenta ejecutar el código,
        // si ocurre un error, se activa "catch"
        try {
            //convierte el texto escrito por el usuario en número entero
            int origen = Integer.parseInt(comandoOrigen);
            //comprueba que los números introducidos estén dentro del rango adecuado
            //si no es así, nos avisará y reinicia el bucle
            if (origen < 1 || origen > 3) {
                System.out.println("La varilla debe estar entre 1 y 3");
                return;
            }

            System.out.println("Selecciona varilla destino (1-3)");
            int destino = Integer.parseInt(sc.nextLine());

            if (destino < 1 || destino > 3) {
                System.out.println("La varilla destino debe estar entre 1 y 3");
                return;
            }
            // Ejecuta el movimiento en el juego
            juego.mover(origen,destino);

        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida");
        }

    }
}
