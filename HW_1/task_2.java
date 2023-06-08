package Homework.HW_1;

/**
 * Посмотрите на код, и подумайте сколько разных типов исключений вы тут сможете получить?
 */
public class task_2 {
    public static void main(String[] args) {
        String[][] s = new String[][] {{"1","2","3"}, {"4","5","6"}, {"8","9","1"}};
        int sum = sum2d(s);
        System.out.println(sum);
    }

    public static int sum2d(String[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < 5; j++) {                   // ArrayIndexOutOfBounds. Обращение к несуществующему индексу. Выход за границы массива.
                int val = Integer.parseInt(arr[i][j]);      // NumberFormatException. Преобразование символа или буквы в число
                sum += val;                                 // IntegerNumberTooLarge. Выход за пределы int (2^32)
            }
        }
        return sum;
    }
}
