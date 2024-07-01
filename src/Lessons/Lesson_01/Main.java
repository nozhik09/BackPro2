package Lessons.Lesson_01;

public class Main {


    public static void main(String[] args) {
        System.out.println("start main ");

        MyThread1 myThread1 =new MyThread1();
        myThread1.run();

        for (int i = 0; i < 10; i++) {

            System.out.println("main" + i);

        }

        System.out.println("finish main ");





    }
}
