void main() {
/*
El entorno tiene la opción de compactar "void main" toda la cabecera
que define el archivo "public class HelloWorld{ public static void main
(String[] args){ }}
 */
    String name = "Val";
    String askName = "¿Cuál es tu nombre?";
    System.out.println(askName);
    System.out.println(name);
    String ASCII = ":)";
    System.out.println(ASCII);

    /*
sumamos a y b
 */

    int a = 13;
    double b = 2.5;

    System.out.println(a + b); // (+, -, *, /)
    System.out.println(a % b); //módulo (el resto de la división)
/*
Un par de pruebas con las variables y testeamos el scanner
 */
    Scanner scanner = new Scanner(System.in);
    System.out.println("How are you, boy?");
    String mood = scanner.nextLine();

    System.out.println("Im glad to hear it," + " " + "how old are you?");
    int age = scanner.nextByte();
/*
if y else integrados en el scanner
 */
    if (age >= 18) {
        System.out.println("You are a big boy then");
    }else{
            System.out.println("You must not be here alone");
        }


}
