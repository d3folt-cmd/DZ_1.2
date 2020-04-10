package dz;

import java.io.File;

public class Main {

    public static void main(String[] args) {
        File first = new File("D:\\result\\first.txt");
        File second = new File("D:\\result\\second.txt");
        Result create = new Result(first, second);

    }
}
