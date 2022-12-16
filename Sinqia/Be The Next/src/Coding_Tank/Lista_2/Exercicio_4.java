package Coding_Tank.Lista_2;

import java.util.Scanner;

public class Exercicio_4 {
    /**
     * Um hotel quer fazer um levantamento das praias da cidade para uma
     * programação turística. Sabendo-se que cada praia tem um nome e uma
     * distância (em Km) do hotel, escreva um programa que forneça os
     * seguintes dados:
     *
     * - O nome da praia mais distante.
     * - Quantas praias estão a mais de 10km e a menos de 15km.
     * - A distância média das praias.
     *
     * // Para cada praia deverá ser informado seu nome e a distância em Km
     * do hotel.
     *
     * Você deve receber 5 praias;
     * Você deve armazenar o nome das 5 praias em um array;
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        String[] beaches = new String[5];
        double[] distanceInKm = new double[5];

        setBeaches(scan, beaches, distanceInKm);
        String furthestBeach = findFurthestBeach(beaches, distanceInKm);
        int beachesOver10Under15km = findOver10Under15Km(distanceInKm);
        double averageDistance = findAverageDistance(distanceInKm);

        showInfo(beaches, distanceInKm, furthestBeach, beachesOver10Under15km, averageDistance);
    }

    public static void setBeaches(Scanner scan, String[] beaches, double[] distanceInKm){
        for(int i = 0; i < beaches.length; i++) {
            System.out.printf("Beach %d - Name: ", i+1);
            beaches[i] = scan.nextLine();
            System.out.printf("Beach %d - Distance in Km: ", i+1);
            distanceInKm[i] = scan.nextDouble();
            scan.nextLine();
        }
    }

    public static String findFurthestBeach(String[] beaches, double[] distanceInKm){
        String beach = "";
        double distance = 0;

        for(int i = 0; i < beaches.length; i++){
            if(distanceInKm[i]>distance){
                distance = distanceInKm[i];
                beach = beaches[i];
            }
        }

        return beach;
    }

    public static int findOver10Under15Km(double[] distanceInKm){
        int over10Under15Km = 0;

        for (double d : distanceInKm) {
            if (d > 10 && d < 15) {
                over10Under15Km++;
            }
        }

        return over10Under15Km;
    }

    public static double findAverageDistance(double[] distanceInKm){
        double totalDistance = 0;

        for(double d : distanceInKm){
            totalDistance += d;
        }

        return  totalDistance/distanceInKm.length;
    }

    public static void showInfo(
            String[] beaches, double[] distanceInKm, String furthestBeach, int beachesOver10Under15km, double averageDistance)
    {
        String format = "%-15s %5s\n";
        System.out.println("\n------ OUTPUT --------\n");

        System.out.format(format, "BEACH", "DISTANCE");
        System.out.format(format, "=====","========");

        for(int i = 0; i < beaches.length; i++) {
            System.out.format(format, beaches[i].toUpperCase(), distanceInKm[i]+"km");
        }

        System.out.printf("\nFurthest beach: %s\n", furthestBeach);
        System.out.printf("Beaches between 10 and 15km away: %d\n", beachesOver10Under15km);
        System.out.printf("Average distance between beaches and the hotel: %.1fkm\n", averageDistance);
    }
}
