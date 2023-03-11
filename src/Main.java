import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int operation = 0;   // номер операции
        List<String> c = new LinkedList<>();


        while (true) {
            System.out.println("\n" + "Выберите операцию: ");
            String input = scanner.nextLine();

            if ("end".equals(input)) {
                System.out.println("Программа завершена!");
                break;
            } else {
                operation = Integer.parseInt(input);
            }

            switch (operation) {
                case 1:
                    System.out.println("Какую покупку хотите добавить?");
                    String purchaseStr = scanner.nextLine();

                    // добавляем продукт в массив
                    c.add(purchaseStr);
                    System.out.println("Итого в списке покупок: " + c.size());
                    break;
                case 2:
                    if (!message(c)) {
                        break;
                    }
                    System.out.println("Список покупок: ");
                    // выводим элементы массива
                    arrayОutput(c);

                    break;
                case 3:
                    if (!message(c)) {
                        break;
                    }

                    System.out.println("Список покупок: ");
                    // выводим элементы массива
                    arrayОutput(c);

                    System.out.println("Какую хотите удалить? Введите номер или название: ");
                    purchaseStr = scanner.nextLine();

                    // найти покупку по номеру/названию и удалить
                    try {
                        int purchase = Integer.parseInt(purchaseStr);
                        c.remove(c.get(purchase - 1));
                    } catch (Exception e) {
                        c.remove(c.indexOf(purchaseStr));
                    }

                    System.out.println("Покупка удалена, список покупок:");
                    // вывод обновленного массива
                    arrayОutput(c);

                    break;
                case 4:
                    if (!message(c)) {
                        break;
                    }
                    System.out.println("Введите текст для поиска:");
                    purchaseStr = scanner.nextLine();
                    for (int i = 0; i < c.size(); i++) {
                        String itemLower = c.get(i).toLowerCase();
                        String queryLower = purchaseStr.toLowerCase();
                        if (itemLower.contains(queryLower)) {
                            System.out.println(i + 1 + ". " + c.get(i));
                        }
                    }
                    break;
                default:
                    System.out.println("Такой операции нет");
            }
        }
    }
    private static void arrayОutput( List<String>  c) {
        for (int i = 0; i < c.size(); i++) {
            System.out.println(i + 1 + ". " + c.get(i));
        }
    }

    private static boolean message( List<String>  c) {
        if (c.size() == 0) {
            System.out.println("Операция не возможна! Заполните список.");
            return false;
        } else {
            return true;
        }
    }
}