class SharedResource{
    //volatile is added to ensure visibility keyword
    private volatile boolean flag = false;

    //OR use "synchronized" for the below 2 functions
    public void setFlag(boolean flag) { this.flag = flag; }

    public boolean getFlag() { return flag; }
}

public class threadsVisibilitywithVolatile {
    
    public static void main(String[] args) {
        SharedResource sr = new SharedResource();

        new Thread(() -> {
            System.out.println("Thread 1 started");
            try {
                System.out.println("Thread 1 logic started");
                Thread.sleep(1000);
                System.out.println("Thread 1 logic completed");
                sr.setFlag(true);
                System.out.println("Flag set to True by Thread 1");
            } 
            catch(InterruptedException e)
            {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println("Thread 2 started");
            while(!sr.getFlag())
            {
                //loop to run until the flag is set to true by Thread 1
            }
            System.out.println("Thread 2 logic started");
        }).start();
    }
}
