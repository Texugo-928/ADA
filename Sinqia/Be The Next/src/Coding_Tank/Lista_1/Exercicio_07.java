package Coding_Tank.Lista_1;

import java.util.Scanner;

public class Exercicio_07 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o primeiro número");
        double numero1 = scanner.nextDouble();

        System.out.println("Informe o segundo número");
        double numero2 = scanner.nextDouble();


        double soma = numero1 + numero2;
        double subtracao = numero1 - numero2;
        double multiplicacao = numero1 * numero2;
        double divisao = numero1 / numero2;


        System.out.printf("O valor da Soma (%f + %f) é %f \n", numero1, numero2, soma);
        System.out.printf("O valor da Subtração (%f - %f) é %f \n", numero1, numero2, subtracao);
        System.out.printf("O valor da Multiplicação (%f * %f) é %f \n", numero1, numero2, multiplicacao);
        System.out.printf("O valor da Divisão (%f / %f) é %f \n", numero1, numero2, divisao);
    }
}