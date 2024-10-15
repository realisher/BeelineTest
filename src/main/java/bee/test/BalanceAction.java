package bee.test;

public class BalanceAction implements MenuAction {
    private int threshold;

    public BalanceAction(int threshold) {
        this.threshold = threshold;
    }

    @Override
    public void execute(Client client) {
        if (client.getBalance() < threshold) {
            System.out.println("У Вас на счету меньше " + threshold + " тенге. Рекомендуем пополнить баланс.");
        } else {
            System.out.println("Ваш баланс: " + client.getBalance() + " тенге.");
        }
    }
}
