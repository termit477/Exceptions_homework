package Homework.HW_1;

/**
 * 1. Реализуйте 3 метода, чтобы в каждом из них получить разные исключения
 */
public class task_1 {
    public static void main(String[] args) {
        int[] array = new int[] { 4, 1, 5, 1, 43, 12, 87, 33 };
        System.out.println("Обращение к несуществующему индексу. Выход за границы массива.");
        int sumOfArray = getArrayIndexOutOfBounds(array);

        System.out.println("Синтаксическая ошибка.");
        getSintaxError();
        
        System.out.println("Переполнение стека.");
        getStackOverflowError(1);
    }

    public static int getArrayIndexOutOfBounds(int[] arr) {
        int sum = 0;
        for (int i = 0; i <= arr.length; i++) {
            sum += arr[i];
        }
        return sum;
    }

    public static void getSintaxError (){
        int sum = 0;
        for (int i = 0; i < 10; i++ {
            sum += i;
        }
    }

    public static void getStackOverflowError(int n){
        System.out.println(n);
        n++;
        getStackOverflowError(n);
    }
}