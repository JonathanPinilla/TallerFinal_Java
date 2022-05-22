package Clases;

/**

 * Este código es la clase Calculadora y junto a la clase Main hacen parte del taller final para sofka U, canteras nivel 1

 * @author: Jonathan Daniel Pinilla Forero

 * @version: 22/05/2022/final

 * @see <a href="https://github.com/JonathanPinilla/TallerFinal_Java"> Directorio git donde se encuentra el programa </a></a>

 */

public class Calculadora {//clase que contiene los metodos de la calculadora

    public static double sumar(double valor, double resultado) {//Todos los métodos reciben dos valores, el valor para la operación y el resultado hasta el momento de entrar al método
        resultado += valor;//realiza la operación
        resultado = Math.round(resultado * 100.0) / 100.0;//redondea el resultado para que no tenga más de 2 decimales
        return resultado;//retorna el resultado
    }

    public static double restar(double valor, double resultado) {
        resultado -= valor;
        resultado = Math.round(resultado * 100.0) / 100.0;
        return resultado;
    }

    public static double multiplicar(double valor, double resultado) {
        resultado = resultado * valor;
        resultado = Math.round(resultado * 100.0) / 100.0;
        return resultado;
    }

    public static double dividir(double valor, double resultado) {
        if (valor == 0) {//para la división se sabe que la operación sobre 0 es incorrecta, por lo que se verifica si el valor a operar es 0, si es así imprime que es incorrecto y no se puede hacer la operación, si no realiza la operación
            System.out.println("No se puede dividir entre 0");
        } else {
            resultado = resultado / valor;
            resultado = Math.round(resultado * 100.0) / 100.0;
        }
        return resultado;
    }

    public static double modulo(double valor, double resultado) {
        resultado = resultado % valor;
        resultado = Math.round(resultado * 100.00) / 100.00;
        return resultado;
    }

}
