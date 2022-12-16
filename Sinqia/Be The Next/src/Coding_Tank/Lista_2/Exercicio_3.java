package Coding_Tank.Lista_2;

import java.util.Scanner;

public class Exercicio_3 {
    /**
     * Escreva um programa que produza a seguinte saída na tela:
     */
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);

        String[] students = new String[4];
        double[] grades = new double[4];

        setNamesAndGrades(scan, students, grades);
        showNamesAndGrades(students, grades);
    }

    public static void setNamesAndGrades(Scanner scan, String[] students, double[] grades) {
        for(int i = 0; i < 4; i++) {
            System.out.printf("Student %d - Name: ", i+1);
            students[i] = scan.nextLine();
            System.out.printf("Student %d - Grade: ", i+1);
            grades[i] = scan.nextDouble();
            scan.nextLine();
        }
    }

    public static void showNamesAndGrades(String[] students, double[] grades){
        String format = "%-15s %5s\n";
        System.out.println("\n------ OUTPUT --------\n");

        System.out.format(format, "STUDENT", "GRADE");
        System.out.format(format, "=======","=====");

        for(int i = 0; i < 4; i++) {
            System.out.format(format, students[i].toUpperCase(), grades[i]==10?"TEN":Double.toString(grades[i]));
        }

    }
}