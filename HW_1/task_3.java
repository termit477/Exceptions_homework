package Homework.HW_1;

import java.util.Arrays;

/**
 * 3. Реализуйте метод, принимающий в качестве аргументов два целочисленных
 * массива, и возвращающий новый массив, каждый элемент которого равен частному
 * элементов двух входящих массивов в той же ячейке. Если длины массивов не
 * равны, необходимо как-то оповестить пользователя. Важно: При выполнении
 * метода единственное исключение, которое пользователь может увидеть -
 */
public class task_3 {

    public static void main(String[] args) {
        int[] array1 = new int[] { 54, 38, 173, 29, 95 };
        int[] array2 = new int[] { 1, 4, 3, 4, 5 };
        System.out.println("Первый массив:" + Arrays.toString(array1));
        System.out.println("Второй массив:" + Arrays.toString(array2));
        int[] result = getDivisionArray(array1, array2);
        System.out.println("Результат:" + Arrays.toString(result));

    }

    public static int[] getDivisionArray(int[] arr1, int[] arr2) {
        int[] result = new int[arr1.length];
        if (arr1.length == arr2.length) {
            for (int i = 0; i < result.length; i++) {
                if (arr2[i] == 0)
                    throw new RuntimeException("Деление на ноль.");
                else
                    result[i] = arr1[i] / arr2[i];
            }
        } else
            throw new RuntimeException("Разные длины массивов.");
        return result;
    }
}
