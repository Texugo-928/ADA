package Coding_Tank.Lista_1;

import java.util.Scanner;

public class Exercicio_13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o custo de fábrica");
        double custoFabrica = scanner.nextDouble();


        final double PORCENTAGEM_DISTRIBUIDOR = 0.28;
        final double IMPOSTOS = 0.45;


        double custoParcial = custoFabrica + (custoFabrica * PORCENTAGEM_DISTRIBUIDOR);
        double custoFinal = custoParcial + custoParcial * IMPOSTOS;


        System.out.printf("O custo ao consumidor final de um carro novo é de %.2f \n", custoFinal);
    }
}