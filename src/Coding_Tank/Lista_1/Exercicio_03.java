package Coding_Tank.Lista_1;

import java.util.Scanner;

public class Exercicio_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor do Emprestimo");
        double emprestimo = scanner.nextDouble();

        System.out.println("Informe quantas Parcelas Mensais");
        int parcelasMensais = scanner.nextInt();

        final double TAXA_JUROS = 0.02;
        double jurosComposto = 1;
        int contador = 0;


        while (contador < parcelasMensais) {
            contador++;
            jurosComposto *= (1 + TAXA_JUROS);
        }


        double valorFinal = emprestimo * jurosComposto;


        System.out.printf("O valor a ser pago após a aplicação do juros será %.2f", valorFinal);
    }

}

