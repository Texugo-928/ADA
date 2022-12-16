package Coding_Tank.Lista_2;

import java.util.Scanner;

public class Exercicio_2 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe seu nome completo");
        String nomeCompleto = scanner.nextLine();

        System.out.println("Informe o seu endereço");
        String endereco = scanner.nextLine();

        System.out.println("Informe o seu CEP");
        int cep = scanner.nextInt();

        System.out.println("Informe o seu telefone");
        int telefone = scanner.nextInt();


        System.out.println("Nome Completo: " + nomeCompleto);
        System.out.println("Endereço: " + endereco);
        System.out.printf("CEP: %d, Telefone: %d", cep, telefone);
    }
}
