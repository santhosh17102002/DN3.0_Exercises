package exercise7;

public class MobileApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("Mobile App: Stock " + stockName + " updated to $" + price);
    }
}
