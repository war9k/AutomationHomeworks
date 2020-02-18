package Homework_01;
//циклически сдвинуть все элементы вправо на 2 позиции (1-й элемент станет 3-м, 2-й стент 4-м и т.д.)
import java.util.Scanner;

public class Task2_12 {
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

        int[] newMas = new int[size];
        System.arraycopy(mas, 0, newMas, 2, mas.length - 2);
        System.arraycopy(mas, mas.length - 2, newMas, 0, 2);
        System.out.println();
        System.out.println("Converted array:");
        for (int newMa : newMas) {
            System.out.print(newMa + " ");
        }
    }
}

