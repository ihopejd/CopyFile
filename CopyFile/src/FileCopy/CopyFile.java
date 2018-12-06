package FileCopy;

import java.io.*;
import java.lang.String;

public class CopyFile extends Thread {
    private String source;
    private String destination;
    CopyFile(String name, String source, String destination) {
        setName(name);
        this.source = source;
        this.destination = destination;
    }

    /**
     * Копирование файлов.
     */
    @Override
    public void run() {

        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(source);
            System.out.printf("%s \n", source);
            os = new FileOutputStream(destination);
            System.out.printf("%s \n", destination);
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        System.out.println("Поток закончил копирование. \n");
    }
}