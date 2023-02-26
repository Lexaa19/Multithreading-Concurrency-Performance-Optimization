package thread.coordination.interrupt;

//Example of a thread that is blocking the app. How to handle such cases (Check Main2.java)
public class Main {
    public static void main(String [] args) {
        Thread thread = new Thread(new BlockingTask());

        thread.start();
    }
    private static class BlockingTask implements Runnable{

        @Override
        public void run() {
            try{
                Thread.sleep(5000000);
            }catch(InterruptedException e){
                System.out.println("Existing blocking thread");
            }
        }
    }
}
