import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    private static final int MAX_NUMBER = 999;
    public static void main(String[] args) {
        Random random = new Random();
        int password = random.nextInt(MAX_NUMBER);
        Vault vault = new Vault(password);
        List<Thread> threadList = new ArrayList<Thread>();
        threadList.add(new AscendingThread(vault));
        threadList.add(new DescendingThread(vault));
        threadList.add(new PoliceThread());

        for(Thread thread: threadList){
            thread.start();
        }



    }
    private static class Vault{
        int password;
        public Vault(int password){
            this.password = password;
        }
        public boolean checkPassword(int password){
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return this.password == password;
        }
    }

    private static abstract class GenericThread extends Thread{
        protected Vault vault;
        public GenericThread(Vault vault){
            this.vault = vault;
            this.setPriority(10);
        }
        @Override
        public void start(){
            super.start();
        }
    }
    private static class AscendingThread extends GenericThread{

        public AscendingThread(Vault vault) {
            super(vault);
        }
        @Override
        public void run(){
            for(int i = 0;i< MAX_NUMBER;i++){
                if(vault.checkPassword(i)){
                    System.out.println("Ascending Thread guessed the password!");
                    System.exit(0);
                }
            }
        }
    }
    private static class DescendingThread extends GenericThread{
        public DescendingThread(Vault vault){
            super(vault);
        }

        @Override
        public void run(){
            for(int i = MAX_NUMBER; i>0;i--){
                if(vault.checkPassword(i)){
                    System.out.println("DescendingThread guessed the password!");
                    System.exit(0);
                }
            }
        }
    }
    private static class PoliceThread extends Thread{

        @Override
        public void run() {
            for(int time = 0; time<10; time++){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Catch!");
                System.exit(0);
            }
        }
    }
}