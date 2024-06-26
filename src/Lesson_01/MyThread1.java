package Lesson_01;

public class MyThread1 extends Thread{

    @Override
    public void run() {
        System.out.println("start Thread");
        for (int i = 1; i <100 ; i++) {

            System.out.println("Thread1" +i);

            try {
                Thread.sleep(200);
            }catch (InterruptedException e){
                throw new RuntimeException(e);
            }


        }
        System.out.println("finish Thread");

    }
}
