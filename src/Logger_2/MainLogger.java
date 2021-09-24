package Logger_2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class MainLogger {
    static final Scanner SC = new Scanner(System.in);

    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        System.out.println("\n");
        logger.log("Запуск задачи №2");
        System.out.println("""
                \t\tЗадача 2: Логгер
                """);
        List<Integer> list;
        logger.log("Хочет поздороваться");
        System.out.println("Приветствую Вас в программе Logger!");
        int listSize = requestNumber("размер списка");
        int maxValue = requestNumber("верхнюю границу значений");
        list = getRandomList(listSize, maxValue);
        System.out.println("Для Вас сгенерирован список:"
                + list.toString().replaceAll("[^\\d]", " "));
        int filterInt = requestNumber("нижний порог фильтрации");
        Filter filter = new Filter(filterInt);
        System.out.println("Ваш конечный список после фильтрации:"
                + filter.filterOut(list).toString().replaceAll("[^\\d]", " "));
        SC.close();
    }

    private static List<Integer> getRandomList(int size, int maxValue) {
        Logger logger = Logger.getInstance();
        logger.log("Составляю список");
        List<Integer> result = new ArrayList<>();
        Random rnd = new Random();
        for (int i = 0; i < size; i++) {
            int r = rnd.nextInt(maxValue);
            logger.log("В список добавляется число " + r);
            result.add(r);
        }
        logger.log("Список составлен");
        return result;
    }

    private static int requestNumber(String request) {
        int target = 0;
        Logger.getInstance().log("Просит " + request);
        while (true) {
            System.out.print("Введите " + request + ":\r\n>> ");
            String input = SC.nextLine().trim();
            try {
                target = Integer.parseInt(input);
            } catch (NumberFormatException e) {
                Logger.getInstance().log("Некорректный ввод. Введено не число");
                System.out.println("Некорректный ввод. Введено не число");
            }
            if (target > 0) break;
        }
        return target;
    }
}
