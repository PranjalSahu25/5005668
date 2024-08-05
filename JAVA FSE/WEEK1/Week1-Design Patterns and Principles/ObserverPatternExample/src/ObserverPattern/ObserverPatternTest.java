package ObserverPattern;

import java.util.Scanner;

public class ObserverPatternTest {
    public static void main(String[] args) {
        StockMarket googleStock = new StockMarket("Google");

        Observer mobileApp1 = new MobileApp("MobileApp1");
        Observer mobileApp2 = new MobileApp("MobileApp2");
        Observer webApp1 = new WebApp("WebApp1");

        googleStock.registerObserver(mobileApp1);
        googleStock.registerObserver(mobileApp2);
        googleStock.registerObserver(webApp1);

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter new stock price for Google (or -1 to exit): ");
            double price = scanner.nextDouble();
            
            if (price == -1) {
                break;
            }

            googleStock.setStockPrice(price);
        }

        scanner.close();
    }
}
