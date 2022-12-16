package Coding_Tank.Lista_2;

import java.util.Scanner;


public class Exercicio_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o nome do aluno");
        String nomeAluno = scanner.nextLine();

        System.out.println("Informe a que turma ele pertence");
        String turma = scanner.nextLine();

        System.out.println("Digite a primeira nota");
        double nota1 = scanner.nextDouble();

        System.out.println("Digite a segunda nota");
        double nota2 = scanner.nextDouble();

        System.out.println("Digite a terceira nota");
        double nota3 = scanner.nextDouble();


        double media = (nota1 + nota2 + nota3)/3.0;


        System.out.println("Nome: " + nomeAluno);
        System.out.println("Turma: " + turma);
        System.out.println("Nota 1: " + nota1);
        System.out.println("Nota 2: " + nota2);
        System.out.println("Nota 3: " + nota3);
        System.out.printf("Média: %.2f \n", media);
    }
}