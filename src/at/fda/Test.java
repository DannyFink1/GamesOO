package at.fda;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FilterOutputStream;
import java.io.IOException;

public class Test {

    public static void main(String[] args){
        String text = "";
        try {
            FileReader fr=new FileReader("C://File/scores.txt");


            char[]result = new char[10];
            int size = fr.read(result,0,5);
            System.out.println(result);

            fr.close();




        } catch (IOException e) {
            System.out.println("no");
            throw new RuntimeException(e);
        }
    }
}
