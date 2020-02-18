public class Methods {
    //Найти минимальное число из 2 чисел, вернуть минимальное
    public int getMinNumber(int a, int b) {
        return a < b ? a : b;
    }
    //Проверить четное число или нечетное, вернуть boolean результат
    public boolean isEven(int a) {
        return a % 2 == 0;
    }
    //Возвести число в квадрат, вернуть результат возведения
    public int square(int a) {
        return a * a;
    }
    //Возвести число в куб, вернуть результат возведения
    public int cube(int a) {
        return a * a * a;
    }


}
