package Coding_Tank.Lista_1;

import java.util.Scanner;

public class Exercicio_14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o raio do círculo em centimetros");
        double raio = scanner.nextDouble();


        double area = Math.PI * raio * raio;


        System.out.printf("O valor da área é de %f centimetros quadrados",  area);
    }
}
