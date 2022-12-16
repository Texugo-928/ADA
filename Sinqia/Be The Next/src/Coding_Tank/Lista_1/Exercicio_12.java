package Coding_Tank.Lista_1;

import java.util.Scanner;

public class Exercicio_12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o preço de custo do produto");
        double preco = scanner.nextDouble();

        System.out.println("Informe o percentual de acréscimo do preço já informado (variando de 0 à 100)");
        double percentualAcrescimo = scanner.nextDouble();


        double venda = preco + (preco * percentualAcrescimo / 100.0);


        System.out.printf("O valor de venda do produto é de %.2f \n", venda);
    }
}
