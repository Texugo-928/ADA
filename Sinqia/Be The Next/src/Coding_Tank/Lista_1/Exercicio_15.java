package Coding_Tank.Lista_1;

import java.util.Scanner;

public class Exercicio_15 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a quantidade de cavalos comprados para um haras");
        int quantidadeCavalo = scanner.nextInt();


        int quantidadeFerradura = quantidadeCavalo * 4;


        System.out.println("A quantidade de ferraduras necessárias é de " + quantidadeFerradura);
    }
}
