import java.util.concurrent.ForkJoinPool;

public class PortfolioEngineApp {
    public static void main(String[] args) {
        System.out.println("=== Fork/Join Parallel Portfolio Risk Assessment Engine ===");

        double[] portfolio = { 1000.0, 2500.5, 4300.2, 1200.0, 3100.8, 5600.0, 2300.4, 4100.1 };

        ForkJoinPool pool = new ForkJoinPool();
        ParallelRiskCalculator task = new ParallelRiskCalculator(portfolio, 0, portfolio.length);

        double totalRiskScore = pool.invoke(task);

        System.out.println("[PARALLEL COMPUTATION COMPLETE] Total Portfolio Risk Score: " + totalRiskScore);
    }
}// JavaDoc update
