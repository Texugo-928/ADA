package Coding_Tank.Lista_1;

import java.util.Scanner;


public class Exercicio_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor em Reais");
        double valorReal = scanner.nextDouble();


        final double VALOR_REAL_DOLAR = 5.05;
        final double VALOR_REAL_EURO = 5.0;
        final double VALOR_REAL_LIBRA = 5.74;


        double valorDolar = valorReal / VALOR_REAL_DOLAR;
        double valorEuro = valorReal / VALOR_REAL_EURO;
        double valorLibra = valorReal / VALOR_REAL_LIBRA;


        System.out.printf("O valor em Dolar é %.2f \n", valorDolar);
        System.out.printf("O valor em Euro é %.2f \n", valorEuro);
        System.out.printf("O valor em Libra é %.2f \n", valorLibra);
    }
}
