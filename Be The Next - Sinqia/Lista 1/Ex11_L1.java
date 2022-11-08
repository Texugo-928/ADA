package Lista_1;

import java.util.Scanner;

public class Ex11_L1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Informe o valor total da compra");
        double compra = scanner.nextDouble();


        double prestacao = compra / 5.0;


        System.out.printf("O total da compra é de %.2f \n", compra);
        System.out.printf("Ao dividir em 5 prestações, o valor de cada prestação será de %.2f \n", prestacao);
    }
}
