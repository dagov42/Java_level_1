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
        searchIntoFile("1.txt", "hello");
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
    public static void searchIntoFile(String fileName, String word) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(fileName);
        int symbol = 0;
        int index = 0;
        byte[] wordBytes = word.getBytes();
        do{
            symbol = fileInputStream.read();
            if (wordBytes[index] == symbol){
               index++;
               if (index == wordBytes.length){
                   System.out.println("The word was found");
                   break;
               }
            }else {
                index = 0;
            }
            } while (symbol != -1);
        }
    }

