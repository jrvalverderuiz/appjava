package apps.TorresColores;

//escribe texto en el archivo de guardado
import java.io.PrintWriter;
import java.io.FileNotFoundException;
//Gestiona la grabación de la partida en un fichero

public class GestorArchivos {

    private PrintWriter escritor;

    //Abre el fichero y prepara la escritura
    //ruta = partida_guardada.txt
    public void iniciarGrabacion(String ruta) {
        // Crea un PrintWriter asociado al archivo indicado por la ruta.
        // Si el archivo no existe, se crea automáticamente.
        // Si ya existe, se sobrescribe.
        try {
            escritor = new PrintWriter(ruta);
            System.out.println("Grabación iniciada en: " + ruta);

            // Se ejecuta si ocurre un error al intentar crear o abrir el archivo
        } catch (FileNotFoundException e) {
            System.out.println("Error al crear el fichero");
        }
    }


    //Recibe un String y lo escribe en el fichero
    public void escribir(String texto) {
        // Comprueba que el archivo esté abierto antes de escribir
        if (escritor != null) {
            escritor.println(texto);
        }

    }

    //Cierra el fichero y libera recursos
    public void detenerGrabacion() {

        if (escritor != null) {
            // Cierra el flujo de escritura para asegurar que todos los datos se guardan
            escritor.close();
            System.out.println("Grabación finalizada");
        }
    }
}

