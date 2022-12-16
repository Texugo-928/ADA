package Coding_Tank.Lista_1;

import java.util.Scanner;

public class Exercicio_04 {
    public static void main(String[] args) {
        int idade, meses, dias, diasVividos;
        Scanner leia = new Scanner(System.in);


        System.out.print("Entre com a idade em anos: ");
        idade = leia.nextInt();

        System.out.print("\nQuantos meses completos se passaram do seu ultimo aniversário: ");
        meses = leia.nextInt();

        System.out.print("\nQuantos dias faltam para o seu mesversário: ");
        dias = leia.nextInt();

        meses *=30;

        idade *=365;

        diasVividos = idade + meses + dias;

        System.out.print("Dias vividos: "+diasVividos);

        leia.close();
    }
}

