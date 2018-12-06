package FileCopy;


/**
 *  Класс где последовательно запускаются два потока
 *  и выводится время за которое выполняются эти два потока
 */
public class СonsequentFileCopy{
    public static void main(String[] args) {


        String[] firstThreadInfo = {"C:\\Test\\Test1\\3.txt", "C:\\Test\\Test1\\4new.txt"};
        String[] secondThreadInfo = {"C:\\Test\\Test1\\3.txt", "C:\\Test\\Test1\\5new.txt"};

        final long before = System.currentTimeMillis();

        createNStart("firstThread", firstThreadInfo);
        createNStart("secondThread", secondThreadInfo);

        final long after = System.currentTimeMillis();

        System.out.printf("Delta %d \n", (after - before));
        System.out.println("Программа закончила свою работу.");

    }

    /**
     * Метод для ожидания конца работы потока,
     * чтобы выполнение потоков было последовательным.
     */
    private static void sync(CopyFile thread){
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("Поток %s закончил свою работу. \n", thread.getName());
    }

    /**
     *  Метод вызывает sync()
     * для того, чтобы подождать, пока он закончится для последовательной работы потоков.
     */
    private static void createNStart(String name, String[] info){
        CopyFile copy = new CopyFile(name, info[0], info[1]);
        copy.start();
        sync(copy);
    }
}

