package dz;

import java.io.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File folder1 = new File("D:\\A");
        folder1.mkdir();

        File folder2 = new File("D:\\B");
        folder2.mkdir();
        System.out.println(folder2.getAbsoluteFile());

        MyFileFilter mFF = new MyFileFilter("doc");
        File folder = new File("D:\\A");
        File[] fileList = folder.listFiles(mFF);
        for (File file : fileList) {
            System.out.println(file.getAbsoluteFile());
            copyFile(file, new File(folder2, file.getName()));
        }

    }

    public static void copyFile(File in, File out) throws IOException {
        try (InputStream is = new FileInputStream(in); OutputStream os = new FileOutputStream(out)) {

            byte[] buffer = new byte[100];
            int readByte = 0;

            for (; (readByte = is.read(buffer)) > 0;) {
                os.write(buffer, 0, readByte);
            }

        } catch (IOException e) {
            throw e;
        }
    }
}
