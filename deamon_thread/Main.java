package thread.deamon_thread;

import java.math.BigInteger;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new LongComputationTask(new BigInteger("200000"), new BigInteger("100000000")));
        thread.setDaemon(true);
        thread.start();
        Thread.sleep(100);
        thread.interrupt();
    }

    private static class LongComputationTask implements  Runnable{
        private BigInteger base;
        private BigInteger power;

        public LongComputationTask(BigInteger base, BigInteger power) {
            this.base = base;
            this.power = power;
        }
        @Override
        public void run() {
            System.out.println(base + "^" + power + " = " + pow(base, power));
        }

        private BigInteger pow(BigInteger base, BigInteger power){
            BigInteger result = BigInteger.ONE;
            for(BigInteger i =BigInteger.ZERO; i.compareTo(power) !=0; i = i.add(BigInteger.ONE)){
                //handle the interruption. This was before the deamon thread creation. If you don't want to use the interrupt(), set the thread to deamon.
               //if(Thread.currentThread().isInterrupted()){
                  //  System.out.println("Prematurely interrupted computation");
                 //   return BigInteger.ZERO;
                //}

                result =result.multiply(base);
            }
            return result;
        }

    }
}
