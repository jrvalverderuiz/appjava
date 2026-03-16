package apps.TorresColores;
//Contiene la lógica del juego, reglas y gestión del historial de movimientos
public class JuegoColores {
    private final String[][]varillas; //Colores en cada varilla
    private final int[]tamanosVarillas; //Número de bloques por varilla
    private final int capacidadMaxima = 4;

    private final String [][][]historial; //Guarda estados anteriores
    private int contadorHistorial;
    private final int maxHistorial = 100;

    //Inicializa el juego con un estado cargado o predeterminado
    public JuegoColores(String[][] estadoInicial){
        this.varillas = new String[3][capacidadMaxima];

        for (int i = 0; i < 3; i++){
            for (int j = 0; j < capacidadMaxima; j++){
                this.varillas[i][j] = estadoInicial[i][j];
            }
        }
        this.tamanosVarillas = new int[3];
        //el bucle exterior recorre horizontalmente todas las varillas i=(0:primera, 1:segunda, 2:tercera)
        for (int i = 0; i < 3; i++) {
            int contador = 0;
            //el bucle interior analiza verticalmente cada una de las varillas por separado
            //revisa cada nivel de la varilla buscando bloques, si los hay los suma al contador
            for (int j = 0; j < capacidadMaxima; j++) {
                if (varillas[i][j]!= null) {
                    contador++;
                }
            }
            //anota el resultado de cada varilla antes de pasar a la siguiente
            this.tamanosVarillas[i] = contador;
        }
        this.historial = new String[maxHistorial][3][capacidadMaxima]; // Para saber cuántos bloques había en cada turno
        this.contadorHistorial = 0;
    }

    //Muestra el estado actual de las varillas
    public void mostrarEstado() {
        System.out.println("Estado del Juego");
        //recorre los pisos desde arriba hasta abajo
        for (int piso = capacidadMaxima - 1; piso >= 0; piso--) {
            //recorre las 3 varillas
            for (int v = 0; v < 3; v++) {
                String bloque = this.varillas[v][piso];

                //Si está vacío(null) o si hay color
                if (bloque == null) {
                    System.out.print("[ ]");
                } else {
                    System.out.print("[" + bloque + "]");
                }
            }
            System.out.println(); // Salto de línea para el siguiente piso
        }
        System.out.println(" V1 V2 V3");

       /* //alternativa horizontal
        for (int v = 0; v < 3; v++) {
        System.out.print("V" + (v + 1) + " ");

        for (int piso = 0; piso < capacidadMaxima; piso++) {
            String bloque = this.varillas[v][piso];
            System.out.print(bloque == null ? "[ ]" : "[" + bloque + "]");
        }
        System.out.println();
    } */

    }
    //Comprueba si el jugador ha ganado
    public boolean juegoCompletado() {
        for (int i = 0; i < 3; i++) {
            if (tamanosVarillas[i] == 0) {
                continue;
            }

            if (!todosIguales(i)) {
                    return false;
            }
        }
        return true;
    }

    //aplica las reglas para mover bloques
    public void mover(int origen, int destino) {
        //el array empieza en 0
        int o = origen - 1;
        int d = destino -1;
        //comprueba que las varillas existen
        if (o < 0 || o >= 3 || d < 0 || d >= 3) {
            System.out.println("Varilla inválida");
            return;
        }
        //si el movimiento es imposible o no hay nada que mover, no avanza
        if (o == d) {
            System.out.println("No puedes mover a la misma varilla");
            return;
        }

        if (tamanosVarillas[o] == 0) {
            System.out.println("La varilla origen está vacía");
            return;
        }
        //guarda antes de avanzar para que "deshacer" funcione
        guardarEstado();
        //Mira el color del bloque que está arriba
        String colorArriba = varillas[o][tamanosVarillas[o] - 1];

        int cuantosMover = 0;
        //recorre los pisos buscando cuantos son del mismo color
        for (int i = tamanosVarillas[o] - 1; i >= 0; i--) {
            if (varillas[o][i].equals(colorArriba)) {
                cuantosMover++;
            } else {
                //si no hay color distinto, para de contar
                break;
            }
        }
        //cuántas piezas caben
        int espacioLibre = capacidadMaxima - tamanosVarillas[d];
        //si no hay sitio no continúa
        if (espacioLibre == 0) {
            System.out.println("Varilla destino llena");
            return;
        }
        //Compara variables y elige la más pequeña.
        //así, nunca va a mover más piezas de las que caben
        int cantidadFinal = Math.min(cuantosMover, espacioLibre);
        //se ejecuta hasta que mueva todas las piezas que le pidamos
        for (int i = 0; i < cantidadFinal; i++) {
            //en la varilla de destino, busca el primer hueco vacío arriba y coloca el bloque
            varillas[d][tamanosVarillas[d]] = colorArriba;
            //anota que hay un bloque más
            tamanosVarillas[d]++;
            //en la varilla de origen, busca el bloque de arriba y deja el espacio vacío
            varillas[o][tamanosVarillas[o] - 1] = null;
            //anota que hay un bloque menos
            tamanosVarillas[o]--;
        }


    }

    //Revierte el último movimiento
    public void deshacer() {
        //comprueba si hay un movimiento anterior y vuelve a él
        if (contadorHistorial > 0) {
            contadorHistorial--;

            for (int i = 0; i < 3; i++) {
                int bloquesVarilla = 0;
                for (int j = 0; j < capacidadMaxima; j++) {
                    varillas[i][j] = historial[contadorHistorial][i][j];

                    // Si el hueco no está vacío, lo cuenta
                    if (varillas[i][j] != null) {
                        bloquesVarilla++;
                    }
                }
                // Actualiza el tamaño de la varilla
                tamanosVarillas[i] = bloquesVarilla;
            }

            System.out.println("Movimiento deshecho");

        } else {

            System.out.println("No hay más movimientos para deshacer");
        }
    }

    //guarda el estado actual antes de cada movimiento
    private void guardarEstado() {
        //comprobamos si queda espacio en el historial
        if (contadorHistorial < maxHistorial) {
            //recorremos cada varilla y cada piso, identificando colores y número de bloques
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < capacidadMaxima; j++) {
                    historial[contadorHistorial][i][j] = varillas[i][j];
                }
            }
            //cada vez que lo usemos hará un nuevo guardado
            contadorHistorial++;
        }
    }

    //Comprueba si todos los bloques de una varilla son del mismo color
    private boolean todosIguales(int indiceVarilla) {
        //si la varilla está vacía no puede tener elementos iguales
        if (tamanosVarillas[indiceVarilla] == 0) {
            return false;
        }
        //el primer elemento de la varilla seleccionada es la referencia para comparar a los demás
        String color = varillas[indiceVarilla][0];
        //empieza a buscar desde la segunda posición, ya sabemos la primera,
        // recorre los espacios ocupados y compara el color, si hay uno diferente se detiene
        for (int i = 1; i < tamanosVarillas[indiceVarilla]; i++) {
            if (!varillas[indiceVarilla][i].equals(color)) {
                return false;
            }
        }
        //si no se detiene antes es que son todos iguales
        return true;
    }
    //convierte el tablero en texto para poder guardarlo en un archivo
    public String estadoGuardar() {
        //nos permite ir añadiendo texto con ".append()"
        StringBuilder resultado = new StringBuilder();

        //recorremos las varillas
        for (int i = 0; i < 3; i++) {
            //recorremos sus posiciones
            for (int j = 0; j < capacidadMaxima; j++) {
                //si en esa posición hay un bloque, se añade al resultado
                if (varillas[i][j] != null) {
                    resultado.append(varillas[i][j]).append(" ");
                }

            }
            //añade un salto de línea después de cada varilla
            resultado.append("\n");
        }
        //devuelve el Estado convertido en String
        return resultado.toString();
    }
}

