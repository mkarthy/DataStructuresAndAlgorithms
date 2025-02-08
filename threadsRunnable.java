class abc {
    private  int count;

    public void incrementAbc()
    {
        count++;
    }

    public int getAbc()
    {
        return count;
    }
}

public class threadsRunnable {
    public static void main(String[] args) throws Exception {
        
        abc objAbc = new abc();

        Runnable runObj = () -> {
            System.out.println("Thread created\n");
            try {
                objAbc.incrementAbc();
                Thread.sleep(1000);
                objAbc.incrementAbc();
                Thread.sleep(1000);
                objAbc.incrementAbc();
                Thread.sleep(1000);
            } catch(InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            System.out.println("Thread1 completed\n");
        };

        System.out.println("Before thread1 Start");
        Thread thread1 = new Thread(runObj);
        thread1.setDaemon(true);
        thread1.setName("First Thread");
        thread1.start();
        System.out.println("After thread1 Start");

        new Thread(() -> {
            System.out.println("Thread2 created");
            try {
                System.out.println("Abc count" + objAbc.getAbc());
                Thread.sleep(4000);
                System.out.println("Abc count" + objAbc.getAbc());
            } catch(InterruptedException e)
            {
                throw new RuntimeException(e);
            }
            System.out.println("Thread2 completed\n");
        }).start();

        System.out.println("After thread2 Start");
    }
}
