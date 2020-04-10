package dz;

import java.io.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class Result {
    private int count = 0;
    private File result = new File("D:\\result\\result.txt");

    public Result(File first, File second) {
        createFile(first, second);
    }

    private void createFile(File first, File second) {
        if (!first.exists() || !second.exists()) {
            System.out.println("Error! No files.");
            return;
        } else {
            StringBuilder sb = new StringBuilder();;
            for (int i = 0; i < getText(second).length; i++) {
                for (int j = 0; j < getText(first).length; j++) {
                    if (getText(first)[j].equalsIgnoreCase(getText(second)[i])) {
                        sb.append(getText(first)[j]);
                        sb.append(" ");
                        count++;
                    }
                }
            }
            try (PrintWriter pw = new PrintWriter(result)) {
                result.createNewFile();
                pw.println(sb.toString());
                System.out.println(count + " words were copied!");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private String[] getText(File file) {
        String[] array = null;
        try (BufferedReader bf = new BufferedReader(new FileReader(file))) {
            array = bf.readLine().split(" ");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        return array;
    }
}
