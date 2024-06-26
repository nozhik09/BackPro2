package HomeWorks.HomeWork1;

public class HomeWork_01 {
//    1.
//    Дан диапазон чисел: от 1 до 2_000_000 включительно. Задача: найти, сколько чисел из этого диапазона делятся нацело на 21 и при этом содержат цифру 3.
//
//    Решить данную задачу в один поток.
//    Решить данную задачу в два потока, разделив между потоками заданный диапазон чисел пополам.
//
//    Естественно, результаты должны совпадать.
//    Попробуйте решить самостоятельно, если не получается подсказка на след. странице


    public static void main(String[] args) {
        int rangeStart = 1;
        int rangeEnd = 2_000_000;
        int counter = 0;

        for (int i = rangeStart; i <= rangeEnd; i++) {


            if (testNumber(i)) {
                counter++;
            }
        }
        System.out.println("искомых чисел:" + counter);
    }
    private static boolean testNumber(int number) {
        return number % 21 == 0 && String.valueOf(number).contains("3");
    }
}
