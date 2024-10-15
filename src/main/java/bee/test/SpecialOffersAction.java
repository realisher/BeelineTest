package bee.test;

import java.util.Scanner;

public class SpecialOffersAction implements MenuAction {
    @Override
    public void execute(Client client) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Безлимитный интернет");
        System.out.println("2. Скидка 50%");
        String input = scanner.nextLine();

        switch (input) {
            case "1":
                System.out.println("Успейте подключить до 1 июня и получите безлимитный интернет.");
                break;
            case "2":
                System.out.println("Получите скидку 50% на Абонентскую плату на 3 месяца.");
                break;
            default:
                System.out.println("Неверный ввод. Пожалуйста, попробуйте снова.");
        }
    }
}
