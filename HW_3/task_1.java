package Homework.HW_3;

import java.util.Scanner;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/*
 * Напишите приложение, которое будет запрашивать у пользователя следующие
 * данные в произвольном порядке, разделенные пробелом:
 * ФИО, дата рождения, номер телефона, пол
 * 
 * Форматы данных:
 * фамилия, имя, отчество - строки
 * дата рождения - строка формата dd.mm.yyyy
 * номер телефона - целое беззнаковое число без форматирования
 * пол - символ латиницей f или m.
 * <Фамилия> <Имя> <Отчество> <дата рождения> <номер телефона> <пол>
 * 
 * Приложение должно проверить введенные данные по количеству. Если количество
 * не совпадает с требуемым, вернуть код ошибки, обработать его и показать
 * пользователю сообщение, что он ввел меньше или больше данных, чем требуется.
 * 
 * Приложение должно попытаться распарсить полученные значения и выделить из них
 * требуемые параметры. Если форматы данных не совпадают, нужно бросить
 * исключение, соответствующее типу проблемы. Можно использовать встроенные типы
 * java или создать свои. Исключение должно быть корректно обработано,
 * пользователю выведено сообщение с информацией, что именно неверно.
 * 
 * Если всё введено и обработано верно, должен создаться файл с названием,
 * равным фамилии, в него в одну строку должны записаться полученные данные,
 * вида
 * 
 * Однофамильцы должны записаться в один и тот же файл, в отдельные строки.
 * Не забудьте закрыть соединение с файлом.
 * При возникновении проблемы с чтением-записью в файл, исключение должно быть
 * корректно обработано, пользователь должен увидеть стектрейс ошибки.
 */
public class task_1 {

    public static void main(String[] args){
        
        String[] data = validInfo();
        writeFile(data);
        try {
            
            readFile(data[0]);
        } catch (Exception e) {
            // TODO: handle exception
        }
    }

    // Получение данных от пользователя
    public static String[] getInfoFromUser() {
        String[] text;
        System.out.println("Введите данные: ");
        try (Scanner scanner = new Scanner(System.in)) {
            text = scanner.nextLine().split(" ");
            scanner.close();
        }
        return text;
    }

    // Печать данных
    public static void printInfo(String[] info) {
        for (String string : info) {
            System.out.println(string);
        }
    }

    // Проверка правильности ввода данных
    public static String[] validInfo() {
        boolean flag = true;
        String[] arr = null;
        int exc;
        while (flag) {
            arr = getInfoFromUser();
            exc = 0;
            if (checkEmpty(arr) == false) {
                exc++;
                throw new RuntimeException("Неверное количество данных. Повторите ввод.");
            }
            if (checkQuantity(arr) == false) {
                exc++;
                throw new RuntimeException("Неверное количество данных. Повторите ввод.");
            }
            if (checkValidFIO(arr) == false) {
                exc++;
                throw new RuntimeException("Неверно ввдено ФИО. Повторите ввод.");
            }
            if (checkValidDateOfBirth(arr) == false) {
                exc++;
                throw new RuntimeException("Неверно ввдена дата рождения. Повторите ввод.");
            }
            if (checkValidNumberPhone(arr) == false) {
                exc++;
                throw new RuntimeException("Неверно ввден номер телефона. Повторите ввод.");
            }
            if (checkValidGender(arr) == false) {
                exc++;
                throw new RuntimeException("Неверно ввден пол. Повторите ввод.");
            }
            if (exc == 0) {
                System.out.println("Данные введены корректно.");
                flag = false;
                return arr;
            }
        }
        return arr;
    }

    // Проверка на пустую строку
    public static boolean checkEmpty(String[] arr) {
        if (arr != null)
            return true;
        return false;
    }

    // Проверка на количество элементов
    public static boolean checkQuantity(String[] arr) {
        if (arr.length == 6)
            return true;
        return false;
    }

    // Проверка ФИО
    public static boolean checkValidFIO(String[] arr) {
        if ((arr[0].matches("[a-zA-Z]+")) && (arr[1].matches("[a-zA-Z]+")) &&
                (arr[2].matches("[a-zA-Z]+")) && (arr[0].length() > 1) &&
                (arr[1].length() > 1) && (arr[2].length() > 1))
            return true;
        return false;
    }

    // Проверка даты рождения
    public static boolean checkValidDateOfBirth(String[] arr) {
        String[] dateOfBirth = arr[3].split("\\.");
        if (((dateOfBirth[0].length() == 1) || (dateOfBirth[0].length() == 2)) && (dateOfBirth[0].matches("[0-9]+")) &&
                ((dateOfBirth[1].length() == 1) || (dateOfBirth[1].length() == 2)) && (dateOfBirth[1].matches("[0-9]+"))
                &&
                (dateOfBirth[2].length() == 4) && (dateOfBirth[2].matches("[0-9]+")))
            return true;
        return false;
    }

    // Проверка номера телефона
    public static boolean checkValidNumberPhone(String[] arr) {
        if ((arr[4].length() >= 6) && (arr[4].length() <= 11) && (arr[4].matches("[0-9]+")))
            return true;
        return false;
    }

    // Проверка пола
    public static boolean checkValidGender(String[] arr) {
        if (arr[5].matches("[f,F,m,M]"))
            return true;
        return false;
    }

    // Запись в файл
    public static void writeFile(String[] arr) {
        String fileName = arr[0] + ".txt";
        String dataToString = String.join(", ", arr);
        try {
            FileWriter writer = new FileWriter(fileName, true);
            BufferedWriter bufferWriter = new BufferedWriter(writer);
            bufferWriter.write(dataToString);
            bufferWriter.write("\n");
            bufferWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    // Чтение из файла
    public static void readFile(String fileName) throws IOException {
        fileName += ".txt";
        Path path = Paths.get(fileName);
        try (Stream<String> text = Files.lines(path, StandardCharsets.UTF_8)) {
            text.forEach(System.out::println);
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден.");
            e.printStackTrace();
        }
    }
}