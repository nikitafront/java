package com.nikita.progs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


//////////////////////////////////
//servise`s decision/////////////
////////////////////////////////

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        ArrayList<String> strings = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            String string = reader.readLine();
            strings.add(string);
        }

        String bugString = strings.get(0);

        for (int i = 1; i < 10; i++) {
            if (strings.get(i).length() >= bugString.length()) {
                bugString = strings.get(i);
            } else {
                System.out.println(i);
                break;
            }
        }
    }
}
//////////////////////////////////
//my decision////////////////////
////////////////////////////////
public class Solution {
    public static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<String>();
        for (int i = 0; i < 4; i++) {
            list.add(scan.nextLine());
        }
        for (int i = 0; i < list.size() - 1; i++) {
            if (list.get(i).length() < list.get(i + 1).length())
                break;
            else
                System.out.println(i + 1);
        }
    }
}
