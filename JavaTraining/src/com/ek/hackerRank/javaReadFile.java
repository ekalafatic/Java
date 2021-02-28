package com.ek.hackerRank;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class javaReadFile {
    public static void main(String[] args) {
        int counter = 0;
        try {
            File myObj = new File("hola.txt");
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                counter = counter+1;
                System.out.println(counter + " " + data);
            }
            myReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}