package ru.geekbrains.java_one.lesson_f.SixthPractical;

import java.io.*;
import java.util.Random;

public class Main {
    static String Symbols = "ABCDEFGHJKLMNOPQRSTUXYZ0123456789";
    static Random random = new Random();

    public static void main(String[] args) throws IOException {

        makeFile("1.txt" , makeString(100));
        makeFile("2.txt", makeString(100));
        gumFiles(new String[]{"1.txt", "2.txt"});
    }

    private static void gumFiles(String[] names) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream("3.txt");
        for (String name:names) {
            FileInputStream fileInputStream = new FileInputStream(name);
            int i;
            do {
                i = fileInputStream.read();
                if (i != -1) {
                    fileOutputStream.write(i);
                }
            } while (i != -1);
        }
    }

    public static String makeString(int length){
        StringBuilder stringBuilder = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            stringBuilder.append(Symbols.charAt(random.nextInt(Symbols.length())));
        }
        return stringBuilder.toString();
    }
    public static void makeFile(String fileName, String text){
        try{
        PrintWriter printWriter = new PrintWriter(fileName);
        printWriter.write(text);
        printWriter.close();
        } catch (FileNotFoundException e){
            e.printStackTrace();
        }
    }
}

