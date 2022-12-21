package Logica_de_Programacao_I;

import java.util.Scanner;
import static java.lang.Math.sqrt;

public class Prova_1_Exercicio_2 {
    private static final Scanner input = new Scanner(System.in);

    // TODO Tratar entrada de dados inválidos

    public static void main(String args[]) {
        double[] entradas = receberEntradas();
        double delta = calcularDelta(entradas[0], entradas[1], entradas[2]);
        String[] mensagemRaiz = calcularRaiz(entradas[0], entradas[1], delta);
        saida(mensagemRaiz[0], mensagemRaiz[1]);
    }

    private static void saida(String mensagemPrimeiraRaiz, String mensagemSegundaRaiz) {
        if (mensagemPrimeiraRaiz.equalsIgnoreCase(mensagemSegundaRaiz)) {
            System.out.println(mensagemPrimeiraRaiz);
        } else {
            System.out.println(mensagemPrimeiraRaiz);
            System.out.println(mensagemSegundaRaiz);
        }
    }

    private static String[] calcularRaiz(double a, double b, double delta) {
        double primeiraRaiz = 0;
        double segundaRaiz = 0;
        String[] mensagem = new String[2];

        if (delta >= 0) {
            primeiraRaiz = ((-b) + sqrt(delta)) / (2*a);
            segundaRaiz = ((-b) - sqrt(delta)) / (2*a);
            mensagem[0] = "A primeira raiz vale " + primeiraRaiz;
            mensagem[1] = "A segunda raiz vale " + segundaRaiz;
        } else {
            mensagem[0] = "O delta é negativo. Equação não possui raízes reais.";
            mensagem[1] = "O delta é negativo. Equação não possui raízes reais.";
        }

        return mensagem;
    }

    private static double calcularDelta(double a, double b, double c) {
        return (b*b) + ((-4)*a*c);
    }

    private static double[] receberEntradas() {
        System.out.println("Informe o valor para a: ");
        double a = input.nextDouble();
        System.out.println("Informe o valor para b: ");
        double b = input.nextDouble();
        System.out.println("Informe o valor para c: ");
        double c = input.nextDouble();

        return new double[]{a, b, c};
    }

}