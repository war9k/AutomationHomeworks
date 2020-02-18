package Homework_01;
//пройти по массиву и поменять местами каждые 2 соседних элемента
import java.util.Scanner;

public class Task2_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = scanner.nextInt();
        int[] mas = new int[size];
        System.out.println("Array:");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 10);
            System.out.print(mas[i] + " ");
        }
        for (int i = 0; i < mas.length - 1; i = i + 2) {
            int a = mas[i];
            mas[i] = mas[i + 1];
            mas[i + 1] = a;
        }
        System.out.println("\nConverted array:");
        for (int i = 0; i < mas.length; i++) {
            System.out.print(mas[i] + " ");
        }
    }
}
