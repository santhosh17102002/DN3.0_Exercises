package exercise7;
public class WebApp implements Observer {
    @Override
    public void update(String stockName, double price) {
        System.out.println("Web App: Stock " + stockName + " updated to $" + price);
    }
}

