public class LogProcessorTask implements Runnable {
    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("[Log-Worker] Iteration " + i + " - Log metrics processed. Thread: " + Thread.currentThread().getName());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            System.out.println("[Log-Worker] Interrupted.");
        }
    }
}// JavaDoc update
