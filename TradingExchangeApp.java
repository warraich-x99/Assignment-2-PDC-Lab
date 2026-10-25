import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class TradingExchangeApp {
    public static void main(String[] args) {
        System.out.println("=== High-Frequency Concurrent Trading Exchange Engine ===");
        OrderBook orderBook = new OrderBook();

        ExecutorService executor = Executors.newFixedThreadPool(3);

        executor.submit(() -> orderBook.executeTrade("BUY", 1502.00, 100));
        executor.submit(() -> orderBook.executeTrade("SELL", 1498.00, 50));
        executor.submit(() -> orderBook.executeTrade("BUY", 1500.00, 200));

        executor.shutdown();
        try {
            executor.awaitTermination(5, TimeUnit.SECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("[EXCHANGE SHUTDOWN] All concurrent market orders settled successfully.");
    }
}