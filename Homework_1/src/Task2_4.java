package Homework_01;
//найти количество нулевых элементов, вывести количество. если нулевых элементов нет - вывести сообщение, что их нет

import java.util.Scanner;

public class Task2_4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the size of the array");
        int size = scanner.nextInt();
        int[] mas = new int[size];
        int counter = 0;
        System.out.println("Array:");
        for (int i = 0; i < mas.length; i++) {
            mas[i] = (int) (Math.random() * 10);
            if (mas[i] == 0) {
                counter++;
            }
            System.out.print(mas[i] + " ");
        }
        System.out.println();
        if (counter == 0) {
            System.out.println("There are no zero elements");
        } else {
            System.out.println("Number of zero elements is: " + counter);

        }
    }
}
