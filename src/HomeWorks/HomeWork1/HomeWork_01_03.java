package HomeWorks.HomeWork1;

public class HomeWork_01_03 {
    private static int counter = 0;


    public static void main(String[] args) {
        MyThread3 thread1 = new MyThread3(1, 1_000_000);
        MyThread3 thread2 = new MyThread3(1_000_000, 2_000_000);
        thread1.start();
        thread2.start();

        try {
            thread1.join();
            thread2.join();
        }catch (InterruptedException e){
            throw new RuntimeException(e);

        }
        System.out.println("Искомых чисел " + counter);
    }


    public static boolean testNumber(int number) {
        return number % 21 == 0 && String.valueOf(number).contains("3");
    }

    public static  void  incrementCounter() {
        counter++;
    }

}

class MyThread3 extends Thread {

    private final int rangeStart;
    private final int rangeEnd;

    public MyThread3(int rangeStart, int rangeEnd) {
        this.rangeStart = rangeStart;
        this.rangeEnd = rangeEnd;

    }


    @Override
    public void run() {
        for (int i = rangeStart; i < rangeEnd; i++) {
            if (HomeWork_01_03.testNumber(i)) {
                HomeWork_01_03.incrementCounter();
            }

        }
    }
}



