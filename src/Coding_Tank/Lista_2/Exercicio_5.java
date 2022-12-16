package Coding_Tank.Lista_2;

import java.util.Scanner;

public class Exercicio_5 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o tempo gasto na viagem em horas");
        double tempoViagem = scanner.nextDouble();

        System.out.println("Informe a velocidade média da viagem em quilometros por hora");
        double velocidadeMediaViagem = scanner.nextDouble();


        double distanciaTotalPercorrida = tempoViagem * velocidadeMediaViagem;
        double litrosUsados = distanciaTotalPercorrida / 12.0;


        System.out.printf("Para percorrer %.2f Km em sua viagem, ", distanciaTotalPercorrida);
        System.out.printf("será necessário %.2f litros de combustível", litrosUsados);
    }
}

