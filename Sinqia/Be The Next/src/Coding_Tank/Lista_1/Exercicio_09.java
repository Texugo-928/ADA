package Coding_Tank.Lista_1;

import java.util.Scanner;

public class Exercicio_09 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o nome do aluno");
        String nomeAluno = scanner.nextLine();

        System.out.println("Informe a nota da primeira prova");
        double primeiraProva = scanner.nextDouble();

        System.out.println("Informe a nota da segunda prova");
        double segundaProva = scanner.nextDouble();

        System.out.println("Informe a nota da terceira prova");
        double terceiraProva = scanner.nextDouble();


        double media = (primeiraProva + segundaProva + terceiraProva) / 3.0;


        System.out.print("O aluno " + nomeAluno);
        System.out.printf(" está com a média igual a %.2f \n", media);
    }
}