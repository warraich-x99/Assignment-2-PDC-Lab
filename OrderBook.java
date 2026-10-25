import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class OrderBook {
    private double bestBid = 1498.50;
    private double bestAsk = 1501.25;
    private final Lock lock = new ReentrantLock();

    public void executeTrade(String orderType, double price, int quantity) {
        lock.lock();
        try {
            System.out.println("[EXCHANGE] Processing " + orderType + " Order -> Price: " + price + ", Qty: " + quantity);
            if (orderType.equals("BUY") && price >= bestAsk) {
                System.out.println("[MATCHED] Buy order matched against Ask at " + bestAsk);
            } else if (orderType.equals("SELL") && price <= bestBid) {
                System.out.println("[MATCHED] Sell order matched against Bid at " + bestBid);
            } else {
                System.out.println("[QUEUED] Order added to market depth book.");
            }
        } finally {
            lock.unlock();
        }
    }
}