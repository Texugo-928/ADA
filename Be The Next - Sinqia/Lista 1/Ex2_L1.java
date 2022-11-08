package Lista_1;

import java.util.Scanner;

public class Ex2_L1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe a Massa em quilogramas");
        double massa = scanner.nextDouble();
        System.out.println("Informe a Altura em metros");
        double altura = scanner.nextDouble();
        System.out.println("Informe o Tempo em segundos");
        double tempo = scanner.nextDouble();


        double cavalos = (massa * altura / tempo) / 745.6999;


        System.out.println("Quantidade de cavalos: " + cavalos);
    }
}