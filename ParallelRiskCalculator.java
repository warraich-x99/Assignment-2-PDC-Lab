import java.util.concurrent.RecursiveTask;

public class ParallelRiskCalculator extends RecursiveTask<Double> {
    private static final int THRESHOLD = 4;
    private double[] portfolioValues;
    private int start;
    private int end;

    public ParallelRiskCalculator(double[] portfolioValues, int start, int end) {
        this.portfolioValues = portfolioValues;
        this.start = start;
        this.end = end;
    }

    @Override
    protected Double compute() {
        if ((end - start) <= THRESHOLD) {
            double sum = 0.0;
            for (int i = start; i < end; i++) {
                // Simulating algorithmic risk/volatility computation
                sum += portfolioValues[i] * 1.05;
            }
            return sum;
        } else {
            int mid = start + (end - start) / 2;
            ParallelRiskCalculator leftTask = new ParallelRiskCalculator(portfolioValues, start, mid);
            ParallelRiskCalculator rightTask = new ParallelRiskCalculator(portfolioValues, mid, end);

            leftTask.fork();
            double rightResult = rightTask.compute();
            double leftResult = leftTask.join();

            return leftResult + rightResult;
        }
    }
}// JavaDoc update
