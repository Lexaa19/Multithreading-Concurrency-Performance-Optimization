package thread.data_races;

public class Main {
    public static void main(String[] args) {
        SharedClass sharedClass = new SharedClass();
        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedClass.increment();
            }
        });
        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < Integer.MAX_VALUE; i++) {
                sharedClass.checkForDataRace();
            }
        });
        thread1.start();
        thread2.start();
    }

    public static class SharedClass {
        /*
        Unless making these fields volatile, the data race will be detected.

        By making these variables volatile, we make sure the code is executed in the exact order it is written.

        Otherwise, for optimization reasons, the compiler and CPU might increment y for example first and then increment x, which will lead to unexpected results.
         */
        private volatile int x = 0;
        private volatile int y = 0;

        public void increment() {
            x++;
            y++;
        }

        public void checkForDataRace() {
            if (y > x) {
                System.out.println("y > x - Data Race is detected");
            }
        }
    }
}

