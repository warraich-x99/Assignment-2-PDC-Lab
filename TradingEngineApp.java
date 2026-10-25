public class TradingEngineApp {
    public static void main(String[] args) {
        System.out.println("=== FIX & Reuters Event Dispatcher Architecture ===");

        TradeEvent event1 = new FIXOrderEvent("FIX_GW_01", System.currentTimeMillis(), 1500.0, "CL_ORD_9981");
        TradeEvent event2 = new ReutersQuoteEvent("REUTERS_Q_01", System.currentTimeMillis(), 1500.0, 1498.50, 1501.25);

        // Polymorphic message passing and dynamic method overriding
        event1.dispatch();
        event2.dispatch();
    }
}