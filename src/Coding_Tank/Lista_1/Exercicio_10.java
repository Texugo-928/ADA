package Coding_Tank.Lista_1;

import java.util.Scanner;

public class Exercicio_10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor que foi depositado na poupança");
        double deposito = scanner.nextDouble();

        final double JUROS_POUPANCA = 0.007;


        double rendimento = deposito * JUROS_POUPANCA;

        double valorAtual = deposito + rendimento;


        System.out.printf("O valor depositado é de %.2f \n", deposito);
        System.out.printf("O rendimento no primeiro mes será de %.2f \n", rendimento);
        System.out.printf("O valor acumulado no primeiro mes será de %.2f \n", valorAtual);
    }
}