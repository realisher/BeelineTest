package bee.test;

public class InternetTrafficAction implements MenuAction {
    @Override
    public void execute(Client client) {

        long trafficBytes = client.getInternetTraffic();
        long gb = trafficBytes / (1024 * 1024 * 1024);
        long mb = (trafficBytes % (1024 * 1024 * 1024)) / (1024 * 1024);

        System.out.println("Ваш интернет трафик: " + gb + " ГБ " + mb + " МБ.");
    }
}
