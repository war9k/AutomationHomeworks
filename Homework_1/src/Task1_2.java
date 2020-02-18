package Homework_01;
//Используя for вывести каждое четное число от 2 до 20 включительно
public class Task1_2 {
    public static void main(String[] args) {
        for (int a = 2; a <= 20; a++) {
            if (a % 2 == 0) {
                System.out.print(a + " ");
            }
        }
    }
}
