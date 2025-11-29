void main() {
    System.out.println("Wena wea weón");

    Scanner scanner = new Scanner(System.in);
    String paso = "¿Deseáis atravesar el paso del wangocho, weón?";
    System.out.println(paso);
    System.out.println("1.Sí, conchetumare / 2.No, estoy aweonao");
    String weon = scanner.nextLine();
    String puertas = "Las puertas de la montaña se abrirán solo ante el más perrón";

    if (weon.equals("1") || weon.equalsIgnoreCase("si")) {
        System.out.println(puertas);
    } else {
        System.out.println("Salta palau weon o wea, ¿qué te pasa?");

        do {
            System.out.println(paso);
            weon = scanner.nextLine();
        } while (!(weon.equals("1")|| weon.equalsIgnoreCase("si")));
        System.out.println("A ver, que wea culiao? Controlai ese tonito o te saco la chucha perkin");
    }

    String cocos = "¿Tenéis los cocos grandesitos o sois un aweonao?";
    System.out.println(cocos);
    System.out.println("1.Cállate perkin culiao/ 2.Me pasé de aweonao");
    String aweonao = scanner.nextLine();
    String nombre = "Decidme, ¿cuál es vuestro nombre?";

    if (aweonao.equals("1")) {
        System.out.println(nombre);
    }else{
        System.out.println("Y más encima terrible de maricón");
        do {
            System.out.println(cocos);
            aweonao = scanner.nextLine();
        }while (!aweonao.equals("1"));
        System.out.println(nombre);
    }

    System.out.println("1.Me llamo Reporonga HellScream/ 2.Maraca culiá/ 3.Chucha perkin");
    String decidme = scanner.nextLine();
    String reporonga = "Os mostráis digno, Reporonga";

    if (decidme.equals("1")){
        System.out.println(reporonga);
    }else{System.out.println("Me la puedes chupar entera");
    do {
        System.out.println(nombre);
        decidme = scanner.nextLine();

    }while (!decidme.equals("1"));
    System.out.println(reporonga);
    }

    System.out.println("El paso a la cachibamba se abrirá ante vuestra magnificencia");
    String cachibambo = scanner.nextLine();
    System.out.println("¿Qué chucha weon?");
    String cachibamba = scanner.nextLine();
    System.out.println("Saaaable culiao, no se te ocurre una mejor idea, perkin culiao?");
    System.out.println("Adelante, es la hora del piko");
}