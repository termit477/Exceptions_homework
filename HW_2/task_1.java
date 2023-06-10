package Homework.HW_2;

import java.util.Scanner;

/**
 * Реализуйте метод, который запрашивает у пользователя ввод дробного числа
 * (типа float), и возвращает введенное значение. Ввод текста вместо числа не
 * должно приводить к падению приложения, вместо этого, необходимо повторно
 * запросить у пользователя ввод данных.
 */

public class task_1 {
    public static void main(String[] args) {
        System.out.println("Введено корректное значение - " + getFloatNumber());
    }

    public static Float getFloatNumber() {
        Float num = null;
        boolean flag = true;
        System.out.println("Введите дробное число: ");
        try (Scanner scanner = new Scanner(System.in)) {
            while (flag) {
                String text = scanner.nextLine();
                String[] splitString = text.split("\\.");
                if (splitString.length > 2 || splitString.length == 1 ||
                        !splitString[0].matches("[0-9]+") || !splitString[1].matches("[0-9]+"))
                    System.out.println("Некорректное значение.");
                else {
                    scanner.close();
                    flag = false;
                    num = Float.parseFloat(text);
                }
            }
        }
        return num;
    }
}
