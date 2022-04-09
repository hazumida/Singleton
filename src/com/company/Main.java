package com.company;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    
    public static int numbers(Scanner scanner, int number, Logger logger) {
        while (true) {
            if (scanner.hasNextInt()) {
                number = scanner.nextInt();
                if (number > 0) {
                    break;
                } else {
                    logger.log("Число должно быть больше 0");
                }
            } else {
                logger.log("Введите число");
            }
            scanner.nextLine();
        }
        scanner.nextLine();
        return number;
    }
    
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        List<Integer> integerList = new ArrayList<>();

        logger.log("Запускаем программу");
        logger.log("Просим пользователя ввести входные данные для списка");
        logger.log("Введите размер списка: ");

        int size = numbers(scanner, -1, logger);

        logger.log("Введите верхнюю границу для значений: ");
        int upSize = numbers(scanner, -1, logger);

        logger.log("Создаём и наполняем список");
        for (int i = 0; i < size; i++) {
            integerList.add(random.nextInt(upSize + 1));
        }

        String resultString = integerList
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        logger.log("Вот случайный список:" + resultString);

        logger.log("Просим пользователя ввести входные данные для фильтрации");
        logger.log("Введите порог для фильтра: ");
        int downSize = numbers(scanner, -1, logger);

        logger.log("Запускаем фильтрацию");
        Filter filter = new Filter(downSize);
        List<Integer> resultList = filter.filterOut(integerList);

        logger.log("Выводим результат на экран");
        String filteredList = resultList
                .stream()
                .map(Object::toString)
                .collect(Collectors.joining(" "));
        logger.log("Отфильтрованный список:" + filteredList);

        logger.log("Завершаем программу");

    }
}
