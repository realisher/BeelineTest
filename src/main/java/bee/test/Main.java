package bee.test;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {

        Scanner scanner = new Scanner(System.in);
        String input;

        // Чтение JSON файла
        ObjectMapper mapper = new ObjectMapper();
        JsonNode root = mapper.readTree(new File("menu.json"));

        // Инциализация данных клиента
        JsonNode clientData = root.get("client");
        Client client = new Client(
                clientData.get("name").asText(),
                clientData.get("balance").asInt(),
                clientData.get("internetTraffic").asLong()
        );

        // Инициализация даннх меню
        JsonNode menuData = root.get("menu");
        int balanceThreshold = menuData.get("conditions").get("balanceThreshold").asInt();

        // Создпние меню
        Menu mainMenu = new Menu("Главное меню");
        mainMenu.addAction("1", new BalanceAction(balanceThreshold));
        mainMenu.addAction("2", new InternetTrafficAction());
        mainMenu.addAction("3", new SpecialOffersAction());

        while (true) {
            mainMenu.display();
            System.out.println("Введите * для выхода.");

            input = scanner.nextLine();

            if (input.equals("*")) {
                System.out.println("Выход...");
                break;
            }
            mainMenu.executeAction(input, client);
        }
    }
}
