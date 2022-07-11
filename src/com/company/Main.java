package com.company;


import com.company.HuffmanCode.HuffmanCode;

import java.io.*;
import java.util.Map;
import java.util.Scanner;


public class Main {

    public static void main(String[] args) throws FileNotFoundException {
	// write your code here
//        String file = args[1];
        String file = "scratch_2.txt";

        InputStream obj = new FileInputStream("C:\\Users\\Himanish\\IdeaProjects\\HuffmanEncodingProject\\src\\com\\company\\" + file);
        InputStream obj1 = new FileInputStream("C:\\Users\\Himanish\\IdeaProjects\\HuffmanEncodingProject\\src\\com\\company\\" + file);

        Scanner sc = new Scanner(obj);

        StringBuilder text = new StringBuilder();

        while (sc.hasNextLine()) {
            String data = sc.nextLine();
            text.append(data);
        }

        System.out.println(text);

        HuffmanCode hc = new HuffmanCode();
        hc.frequencyFromText(text.toString());
        hc.buildHuffmanTree();
        hc.buildLookUpTable();
        for (Map.Entry<Character, String> entry: hc.getLookUpTable().entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }

        StringBuilder sb1 = new StringBuilder(file);
        sb1.insert(file.length() - 4, "encoded");

        try {
            File output = new File("C:\\Users\\Himanish\\IdeaProjects\\HuffmanEncodingProject\\src\\com\\company\\" + sb1.toString());
            if (output.createNewFile()) {
                System.out.println("File created: "
                        + output.getName());
            }
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }

        Scanner sc1 = new Scanner(obj1);

        try {
            FileWriter Writer
                    = new FileWriter("C:\\Users\\Himanish\\IdeaProjects\\HuffmanEncodingProject\\src\\com\\company\\" + sb1.toString());

            while(sc1.hasNextLine()){
                String line = sc1.nextLine();

                for (char c: line.toCharArray()) {
                    Writer.write((byte) Integer.parseInt(hc.getLookUpTable().get(c)));
                }

            }

            Writer.close();
            System.out.println("Successfully written.");
        }
        catch (IOException e) {
            System.out.println("An error has occurred.");
            e.printStackTrace();
        }



    }
}
