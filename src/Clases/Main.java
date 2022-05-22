package Clases;

import java.util.Objects;//para verificar si el valor de la opción es igual a alguno de los símbolos
import java.util.Scanner;//utilidad para escanear entradas por consola


/**

 * Este código es la clase main y junto a la clase Calculadora hacen parte del taller final para sofka U, canteras nivel 1

 * @author: Jonathan Daniel Pinilla Forero

 * @version: 22/05/2022/final

 * @see <a href="https://github.com/JonathanPinilla/TallerFinal_Java"> Directorio git donde se encuentra el programa </a></a>

 */

public class Main {
    static Scanner num = new Scanner(System.in);//scanner para números
    static Scanner text = new Scanner(System.in);//scanner para textos
    static double valor;//Es el valor que se ingresa después de seleccionar la operación
    static double resultado;//guarda el resultado que hay hasta el momento en memoria
    static String mResultado;//Variable para mostrar los resultados con formato
    static boolean primeraOp = true;//booleano para verificar si el programa está en su primera ejecución o si ya se realizó una ejecución

    public static void main(String[] args) {//Clase main, solo llama al método menú
        menu();
    }

    public static void menu() {//metodo que controla toda la "Interfaz" y solicita los datos para las operaciones
        String opcion;
        do {//ciclo del menú
            if (primeraOp) {//Solo se activa si es la primera operación o ejecución
                System.out.print("""
                                                
                        Calculadora
                        Ingrese un número:""");
                resultado = num.nextDouble();
                primeraOp = false;
                mResultado = esEntero(resultado);
                System.out.print(mResultado.replaceAll("\\.",",") + """
                                                
                        Calculadora
                        Ingrese solo el símbolo sin los paréntesis
                        (+) (-) (*)
                        (/) (%) (off)
                        ¿Que desea realizar?:""");
            } else {// si no es la primera ejecución solo muestra esta opción
                System.out.print("""
                                                
                        Calculadora
                        Ingrese solo el símbolo sin los paréntesis
                        (+) (-) (*)
                        (/) (%) (off)
                        ¿Que desea realizar?:""");
            }
            opcion = text.nextLine();

            //el if verifica si es una operación valida, si lo es permite leer el nuevo valor para la operación, si no se va directo al switch
            if (Objects.equals(opcion, "+") || Objects.equals(opcion, "-") || Objects.equals(opcion, "*") || Objects.equals(opcion, "/") || Objects.equals(opcion, "%")) {
                System.out.print("\n" + mResultado.replaceAll("\\.",",") + " " + opcion + " ");
                valor = num.nextDouble();
            }

            switch (opcion) {//cada caso llama a los metodos de la clase calculadora según la operación solicitada por el usuario
                case "+":
                    resultado = Calculadora.sumar(valor, resultado);//Para todos se debe enviar el valor para hacer la operación y el resultado que se tiene hasta el momento
                    break;
                case "-":
                    resultado = Calculadora.restar(valor, resultado);
                    break;
                case "*":
                    resultado = Calculadora.multiplicar(valor, resultado);
                    break;
                case "/":
                    resultado = Calculadora.dividir(valor, resultado);
                    break;
                case "%":
                    resultado = Calculadora.modulo(valor, resultado);
                    break;
                case "off"://Si la opción es off solo muestra un mensaje para avisar que va a salir del programa
                    System.out.println("Saliendo...");
                    break;
                default://Si la opción no corresponde con ninguna muestra que la opción es incorrecta
                    System.out.println("Opción incorrecta");
                    break;
            }

            if (!opcion.equals("off")) {//Si la opción no es "off" es decir salir, muestra el resultado
                mResultado = esEntero(resultado);//llama al método esEntero para formatear el texto, si es entero se muestra sin los decimales, este metodo retorna un String
                System.out.print(" = " + mResultado.replaceAll("\\.",","));
            }

        } while (!opcion.equals("off"));//verifica si el usuario quiere salir, si no continua dentro del ciclo
    }

    private static String esEntero(double valor) {//método para verificar si es entero y formatear el texto
        if (valor % 1 == 0) {//si el valor modulo de 1 es 0, esto quiere decir que es un entero, si lo es se convierte el valor a entero para quitar los decimales y luego a String para imprimir
            int a = (int) valor;
            return String.valueOf(a);
        } else {
            return String.valueOf(valor);//si no es entero simplemente se retorna el valor como un String
        }
    }
}
