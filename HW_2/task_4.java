package Homework.HW_2;

import java.util.Scanner;

/**
 * Разработайте программу, которая выбросит Exception, когда пользователь вводит
 * пустую строку. Пользователю должно показаться сообщение, что пустые строки
 * вводить нельзя. Далее запросить повторный ввод строки
 */
public class task_4 {
    public static void main(String[] args) {
        System.out.println("Введена корректная строка - " + getInputString());
    }

    public static String getInputString() {
        String text = "";
        boolean flag = true;
        System.out.println("Введите строку: ");
        try (Scanner scanner = new Scanner(System.in)) {
            while (flag) {
                text = scanner.nextLine();
                if (text == "")
                    System.out.println("Некорректное значение.");
                else {
                    scanner.close();
                    flag = false;
                
                }
            }
        }
        return text;
    }
}
