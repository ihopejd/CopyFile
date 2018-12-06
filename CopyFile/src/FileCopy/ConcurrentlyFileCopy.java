package FileCopy;


/**
 *  Класс где паралельно запускаются два потока
 *  и выводится время за которое выполняются эти два потока
 */
public class ConcurrentlyFileCopy {
    public static void main(String[] args) {


        String[] firstThreadInfo = {"C:\\Text\\Files\\text.txt", "C:\\Text\\Files\\1newText.txt"};
        String[] secondThreadInfo = {"C:\\Text\\Files\\text.txt", "C:\\Text\\Files\\2newtText.txt"};


        final long before = System.currentTimeMillis();

        createNStart("firstThread", firstThreadInfo);
        createNStart("secondThread", secondThreadInfo);

        final long after = System.currentTimeMillis();


        System.out.printf("Delta %d \n", (after - before));
        System.out.println("Программа закончила свою работу.");

    }


    /**
     * Метод создает и запускает поток.
     */
    private static void createNStart(String name, String[] info) {
        CopyFile copy = new CopyFile(name, info[0], info[1]);
        copy.start();
    }

}