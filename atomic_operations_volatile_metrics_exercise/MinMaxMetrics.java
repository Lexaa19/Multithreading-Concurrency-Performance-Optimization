package thread.atomic_operations_volatile_metrics_exercise;

import java.util.concurrent.ThreadLocalRandom;

public class MinMaxMetrics {

    private volatile long minimum;
    private volatile long maximum;

    private Object lockObject = new Object();

    /**
     * Initializes all member variables
     */
    public MinMaxMetrics() {
        minimum = ThreadLocalRandom.current().nextLong(0, Long.MAX_VALUE);
        maximum = ThreadLocalRandom.current().nextLong(Long.MIN_VALUE, 0);
    }

    /**
     * Adds a new sample to our metrics.
     */
    public void addSample(long newSample) {
        synchronized (lockObject) {
            this.minimum = Math.min(newSample, this.minimum);
            this.maximum = Math.max(newSample, this.maximum);
        }
        System.out.println("Min is: " + this.minimum);
        System.out.println("Max is: " + this.maximum);
    }

    /**
     * Returns the smallest sample we've seen so far.
     */
    public long getMin() {
        return this.minimum;
    }

    /**
     * Returns the biggest sample we've seen so far.
     */
    public long getMax() {
        return this.maximum;
    }
}

