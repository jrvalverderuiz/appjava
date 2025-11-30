void main() {
    Scanner scanner = new Scanner(System.in);
    final String ERROR_INVALIDO = "?";

    System.out.println("A: ¡Ése era tu plan! ¡Le has traído para que me mate!");
    System.out.println("P: ¡No!");
    System.out.println("OW: ¡Suéltala, Anakin!");
    System.out.println("P: Anakin…");

    String resuelverespuesta1;
    do {

        System.out.println("OW: ...");
        System.out.println("1 ¡Te he dicho que la sueltes!");
        System.out.println("2 ¡Soltála perkin culiao!");
        System.out.println("3 ¡Qué rica cachibamba!");

        if (scanner.hasNextInt()) {
            int respuesta1 = scanner.nextInt();

            resuelverespuesta1 = switch (respuesta1) {
                case 1 -> "¡Te he dicho que la sueltes!";
                case 2 -> "¡Soltála perkin culiao!";
                case 3 -> "¡Que rica cachibamba!";
                default -> ERROR_INVALIDO;
            };
            System.out.println("OW: " + resuelverespuesta1);
        }else{
            System.out.println("Error");
            resuelverespuesta1 = ERROR_INVALIDO;
            scanner.next();
            }

    } while (resuelverespuesta1.equals(ERROR_INVALIDO));

    System.out.println("A: ¡Tú la has vuelto contra mí!");
    System.out.println("OW: Eso es algo que has hecho tú mismo.");
    System.out.println("A: ¡No vas a arrebatármela!");
    System.out.println("""       
            OW: Tu ira, y tus ansias de poder ya lo han conseguido.\s
            Has permitido que ese Lord Tenebroso corrompa tu mente y ahora...""");
do {

    System.out.println("OW: ...");
    System.out.println("1 ahora te has convertido precisamente en lo que juraste destruir.");
    System.out.println("2 ahora te has destruido juradamente en lo que precisaste convertir.");
    System.out.println("3 ahora escucha sera mejor, hay algo de esa plaga entera brígida que tenei que saber weon.");
    if (scanner.hasNextInt()) {
        int respuesta2 = scanner.nextInt();


    String resuelverespuesta2 = switch (respuesta2) {
        case 1 -> "ahora te has convertido precisamente en lo que juraste destruir.";
        case 2 -> "ahora te has destruido juradamente en lo que precisaste convertir.";
        case 3 -> "ahora escucha sera mejor, hay algo de esa plaga entera brígida que tenei que saber weon.";
        default -> ERROR_INVALIDO;
    };
    System.out.println("OW: " + resuelverespuesta2);
    }else{
        System.out.println("Error");
        resuelverespuesta1 = ERROR_INVALIDO;
        scanner.next();
    }
} while (resuelverespuesta1.equals(ERROR_INVALIDO));

    System.out.println("""
            A: Ahórrate el sermón, Obi-Wan. Conozco todas las mentiras de los jedi.\s
            No tengo miedo al Lado Oscuro como tú.\s
            ¡He traído la paz, la libertad, la justicia... y la seguridad a mi nuevo Imperio!""");

    System.out.println("OW: ¿Tu nuevo Imperio?");
    System.out.println("A: No me obligues a matarte.");
    System.out.println("OW: Anakin, yo le debo lealtad a la República, ¡a la Democracia!");
    System.out.println("A: Si no estás conmigo, eres mi enemigo.");

do {

    System.out.println("OW: ...");
    System.out.println("1 Sólo un sith es tan extremista. Cumpliré con mi deber.");
    System.out.println("2 Terrible de maricón diciendo tu rey. Cumpliré con mi deber.");
    System.out.println("3 Sólo un sith tan extremista es. Con mi deber cumpliré.");
    if (scanner.hasNextInt()) {
        int respuesta3 = scanner.nextInt();


    String resuelverespuesta3 = switch (respuesta3) {
        case 1 -> "Sólo un sith es tan extremista. Cumpliré con mi deber.";
        case 2 -> "Sólo un sith es tan extremista. Terrible de maricón diciendo tu rey.";
        case 3 -> "Sólo un sith tan extremista es. Con mi deber cumpliré.";
        default -> ERROR_INVALIDO;
    };
    System.out.println("OW: " + resuelverespuesta3);
    }else{
        System.out.println("Error");
        resuelverespuesta1 = ERROR_INVALIDO;
        scanner.next();
    }
} while (resuelverespuesta1.equals(ERROR_INVALIDO));

    System.out.println("A: Lo intentarás...");

    System.out.println("(...)");

    System.out.println("OW: Te he fallado, Anakin, te he fallado.");
    System.out.println("A: ¡Debí intuir que los jedi intentarían hacerse con el poder!");
    System.out.println("OW: ¡Anakin, el Canciller Palpatine es el mal!");
    System.out.println("A: ¡Desde mi punto de vista, los jedi son el mal!");

do {

    System.out.println("OW ...");
    System.out.println("1 ¡Ya estás perdido!");
    System.out.println("2 Te he follado, Anakin, te he follado.");
    System.out.println("3 ¡Anakin, el Canciller Pálpame es el mal!");
    if (scanner.hasNextInt()) {
        int respuesta4 = scanner.nextInt();

    String resuelverespuesta4 = switch (respuesta4) {
        case 1 -> "¡Ya estás perdido!";
        case 2 -> "Te he follado, Anakin, te he follado.";
        case 3 -> "¡Anakin, el Canciller Pálpame perkin culiao";
        default -> ERROR_INVALIDO;
    };
    System.out.println("OW: " + resuelverespuesta4);
    }else{
        System.out.println("Error");
        resuelverespuesta1 = ERROR_INVALIDO;
        scanner.next();
    }
} while (resuelverespuesta1.equals(ERROR_INVALIDO));

    System.out.println("A: Éste es tu final, mi Maestro.");
    System.out.println("OW: ¡Se acabó, Anakin, la altura me da ventaja!");
    System.out.println("A: ¡No oses despreciar mi poder!");

do {

    System.out.println("OW ...");
    System.out.println("1 No lo intentes...");
    System.out.println("2 Aweonao...");
    System.out.println("3 Te pasaste perkin culiao...");

    if (scanner.hasNextInt()) {
        int respuesta5 = scanner.nextInt();

    String resuelverespuesta5 = switch (respuesta5) {
        case 1 -> "No lo intentes...";
        case 2 -> "Aweonao...";
        case 3 -> "Te pasaste perkin culiao...";
        default -> ERROR_INVALIDO;
    };
    System.out.println("OW: " + resuelverespuesta5);
    }else{
        System.out.println("Error");
        resuelverespuesta1 = ERROR_INVALIDO;
        scanner.next();
    }
} while (resuelverespuesta1.equals(ERROR_INVALIDO));

    System.out.println("(...)");
    System.out.println("""
            OW:¡Tú eras el Elegido! ¡El que destruiría los sith, no el que se uniría a ellos!" \s
            "¡El que vendría a traer el equilibrio a la Fuerza, no a hundirla en la Oscuridad!""");

    System.out.println("A: ¡¡TE ODIOOOO!!");

do {

    System.out.println("OW ...");
    System.out.println("1 Tú eras mi hermano, Anakin. Yo te quería.");
    System.out.println("2 De todas formas ni te pesco,¡chupala con mayo!");
    System.out.println("3 Lo siento weon, te pasaste de aweonao.");
    if (scanner.hasNextInt()) {
        int respuesta6 = scanner.nextInt();

    String resuelverespuesta6 = switch (respuesta6) {
        case 1 -> "Tú eras mi hermano, Anakin. Yo te quería.";
        case 2 -> "De todas formas ni te pesco,¡chupala con mayo!";
        case 3 -> "Lo siento weon, te pasaste de aweonao.";
        default -> ERROR_INVALIDO;
    };
    System.out.println("OW: " + resuelverespuesta6);
    }else{
        System.out.println("Error");
        resuelverespuesta1 = ERROR_INVALIDO;
        scanner.next();
    }
} while (resuelverespuesta1.equals(ERROR_INVALIDO));


}