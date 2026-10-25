public class TelemetryThread extends Thread {
    public TelemetryThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 5; i++) {
                System.out.println("[" + getName() + "] Iteration " + i + " - CPU & Memory Health Updated. Thread: " + Thread.currentThread().getName());
                Thread.sleep(800);
            }
        } catch (InterruptedException e) {
            System.out.println("[" + getName() + "] Interrupted.");
        }
    }
}