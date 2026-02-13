package zadaniaDomowe.zad5;

import java.io.IOException;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class StreamDemo {
    public static void main(String[] args) {
        int shift = 3;

        try (
                FileInputStream fis = new FileInputStream("plain.txt");
                FileOutputStream fos = new FileOutputStream("encrypted.txt");
                CezarOutputStream cos = new CezarOutputStream(fos, shift)
            ) {
                int b;
                while((b = fis.read()) != -1) {
                cos.write(b);
                }

            } catch (IOException e) {
            e.printStackTrace();
        }

        try (
                FileInputStream fis = new FileInputStream("encrypted.txt");
                CezarInputStream cis = new CezarInputStream(fis, shift);
                FileOutputStream fos = new FileOutputStream("decrypted.txt")

            ) {
                int b;
                while((b = cis.read()) != -1) {
                    fos.write(b);
                }
            } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
