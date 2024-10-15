package bee.test;
import java.util.HashMap;
import java.util.Map;

public class Menu {
    private String title;
    private Map<String, MenuAction> actions;

    public Menu(String title) {
        this.title = title;
        this.actions = new HashMap<>();
    }

    public void addAction(String option, MenuAction action) {
        actions.put(option, action);
    }

    public void display() {
        System.out.println(title);
        for (String key : actions.keySet()) {
            System.out.println(key + ". " + getActionName(actions.get(key)));
        }
    }

    public void executeAction(String option, Client client) {
        MenuAction action = actions.get(option);
        if (action != null) {
            action.execute(client);
        } else {
            System.out.println("Неверный ввод. Пожалуйста, попробуйте снова.");
        }
    }

    private String getActionName(MenuAction action) {
        if (action instanceof BalanceAction) {
            return "Баланс";
        } else if (action instanceof InternetTrafficAction) {
            return "Интернет трафик";
        } else if (action instanceof SpecialOffersAction) {
            return "Специальные предложения";
        }
        return "Неизвестная команда";
    }
}
