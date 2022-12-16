package Logica_de_Programacao_I;

import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Prova_1_Exercicio_2 {
    public static void main(String args[]) {
        Scanner input = new Scanner(System.in);


        System.out.println("Informe o valor para a: ");
        double a = input.nextDouble();
        System.out.println("Informe o valor para b: ");
        double b = input.nextDouble();
        System.out.println("Informe o valor para c: ");
        double c = input.nextDouble();


        double delta = calcularDelta(a, b, c);
        String primeiraRaiz = calcularPrimeiraRaiz(a, b, delta);
        String segundaRaiz = calcularSegundaRaiz(a, b, delta);


        if (primeiraRaiz.equalsIgnoreCase(segundaRaiz)) {
            System.out.println(primeiraRaiz);
        } else {
            System.out.println(primeiraRaiz);
            System.out.println(segundaRaiz);
        }
    }

    private static double calcularDelta(double a, double b, double c) {
        double delta = (b*b) + ((-4)*a*c);

        return delta;
    }

    private static String calcularPrimeiraRaiz(double a, double b, double delta) {
        double primeiraRaiz = 0;
        String mensagem;

        if (delta >= 0) {
            primeiraRaiz = ((-b) + sqrt(delta)) / (2*a);
            mensagem = "A primeira raiz vale " + primeiraRaiz;
        } else {
            mensagem = "O delta é negativo. Equação não possui raízes reais.";
        }
        return mensagem;
    }

    private static String calcularSegundaRaiz(double a, double b, double delta) {
        double segundaRaiz = 0;
        String mensagem;

        if (delta >= 0) {
            segundaRaiz = ((-b) - sqrt(delta)) / (2*a);
            mensagem = "A segunda raiz vale " + segundaRaiz;
        } else {
            mensagem = "O delta é negativo. Equação não possui raízes reais.";
        }
        return mensagem;
    }
}