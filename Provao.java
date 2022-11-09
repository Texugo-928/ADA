import java.util.Scanner;

public class Provao {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Escolha o número que representa o tipo de temperatura a ser convertida:");
        System.out.println("1 --- Celcius");
        System.out.println("2 --- Fahrenheit");
        System.out.println("3 --- Kelvin");
        int escolha1 = scanner.nextInt();


        System.out.println("Escolha o número que representa o tipo de temperatura após a conversão:");
        System.out.println("1 --- Celcius");
        System.out.println("2 --- Fahrenheit");
        System.out.println("3 --- Kelvin");
        int escolha2 = scanner.nextInt();


        System.out.println("Informe a quantidade de temperaturas a serem transformadas:");
        int quantidadeTemperaturas = scanner.nextInt();

        double[] temperaturasIniciais = new double[quantidadeTemperaturas];

        for (int i = 0; i < temperaturasIniciais.length; i++) {
            int f = i + 1;

            System.out.printf("Informe a temperatura de número %d", f);
            temperaturasIniciais[i] = scanner.nextDouble();
        }

        if (escolha1 == 1 && escolha2 == 1) {

            for (int i = 0; i < temperaturasIniciais.length; i++) {
                int f = i + 1;

                System.out.printf("A temperatura de número %d informada foi %f Celcius e ", f, temperaturasIniciais[i]);
                System.out.printf("a temperatura resultante foi %f Celcius", temperaturasIniciais[i]);
            }

        }
        else if (escolha1 == 1 && escolha2 == 2) {

                for (int i = 0; i < temperaturasIniciais.length; i++) {
                    int f = i + 1;
                    double[] temperaturasFahrenheit = new double[temperaturasIniciais.length];
                    temperaturasFahrenheit[i] = temperaturasIniciais[i] * 1.8 + 32;

                    System.out.printf("A temperatura de número %d informada foi %f Celcius e ", f, temperaturasIniciais[i]);
                    System.out.printf("a temperatura resultante foi %f Fahrenheit", temperaturasFahrenheit[i]);
                }
            }
            else if (escolha1 == 1 && escolha2 == 3) {

                for (int i = 0; i < temperaturasIniciais.length; i++) {
                    int f = i + 1;
                    double[] temperaturasKelvin = new double[temperaturasIniciais.length];
                    temperaturasKelvin[i] = temperaturasIniciais[i] + 273.15;

                    System.out.printf("A temperatura de número %d informada foi %f Celcius e ", f, temperaturasIniciais[i]);
                    System.out.printf("a temperatura resultante foi %f Kelvin", temperaturasKelvin[i]);
                }
            }
            else if (escolha1 == 2 && escolha2 == 1) {

            for (int i = 0; i < temperaturasIniciais.length; i++) {
                int f = i + 1;
                double[] temperaturasCelcius = new double[temperaturasIniciais.length];
                temperaturasCelcius[i] = (temperaturasIniciais[i] - 32) / 1.8;

                System.out.printf("A temperatura de número %d informada foi %f Fahrenheit e ", f, temperaturasIniciais[i]);
                System.out.printf("a temperatura resultante foi %f Celcius", temperaturasCelcius[i]);
            }
        }
            else if (escolha1 == 2 && escolha2 == 2) {

            for (int i = 0; i < temperaturasIniciais.length; i++) {
                int f = i + 1;

                System.out.printf("A temperatura de número %d informada foi %f Fahrenheit e ", f, temperaturasIniciais[i]);
                System.out.printf("a temperatura resultante foi %f Fahrenheit", temperaturasIniciais[i]);
            }
        }
            else if (escolha1 == 2 && escolha2 == 3) {

            for (int i = 0; i < temperaturasIniciais.length; i++) {
                int f = i + 1;
                double[] temperaturasKelvin = new double[temperaturasIniciais.length];
                temperaturasKelvin[i] = (temperaturasIniciais[i] - 32) / 1.8;

                System.out.printf("A temperatura de número %d informada foi %f Fahrenheit e ", f, temperaturasIniciais[i]);
                System.out.printf("a temperatura resultante foi %f Kelvin", temperaturasKelvin[i]);
            }
        }
            else if (escolha1 == 3 && escolha2 == 1) {

                for (int i = 0; i < temperaturasIniciais.length; i++) {
                    int f = i + 1;
                    double[] temperaturasCelcius = new double[temperaturasIniciais.length];
                    temperaturasCelcius[i] = temperaturasIniciais[i] - 273.15;

                    System.out.printf("A temperatura de número %d informada foi %f Kelvin e ", f, temperaturasIniciais[i]);
                    System.out.printf("a temperatura resultante foi %f Celcius", temperaturasCelcius[i]);
                }
        }
        else if (escolha1 == 3 && escolha2 == 2) {
            for (int i = 0; i < temperaturasIniciais.length; i++) {
                int f = i + 1;
                double[] temperaturasFahrenheit = new double[temperaturasIniciais.length];
                temperaturasFahrenheit[i] = (temperaturasIniciais[i] - 273.15) * 1.8 + 32;

                System.out.printf("A temperatura de número %d informada foi %f Kelvin e ", f, temperaturasIniciais[i]);
                System.out.printf("a temperatura resultante foi %f Fahrenheit", temperaturasFahrenheit[i]);
            }
        }
        else if (escolha1 == 3 && escolha2 == 3) {

            for (int i = 0; i < temperaturasIniciais.length; i++) {
                int f = i + 1;

                System.out.printf("A temperatura de número %d informada foi %f Kelvin e ", f, temperaturasIniciais[i]);
                System.out.printf("a temperatura resultante foi %f Kelvin", temperaturasIniciais[i]);
            }
        }
        else {
            System.out.printf("Opção Invalida");
        }
    }
}