package com.nikita.progs;

import java.util.Scanner;

public class CallerID {
    static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        long number = scan.nextLong();
        char[] numInChars = Long.toString(number).toCharArray();
        int operatorCode = Integer.parseInt("" + numInChars[1] + numInChars[2] + numInChars[3]);
        if (operatorCode == 982 || operatorCode == 912 || operatorCode == 919) {
            System.out.println("This abonent operator is MTS");
        } else if (operatorCode == 951 || operatorCode == 961 || operatorCode == 964) {
            System.out.println("This abonent operator is Beeline");
        } else if (operatorCode == 952 || operatorCode == 900 || operatorCode == 904) {
            System.out.println("This abonent operator is Tele2");
        } else {
            System.out.println("We don`t know, what is this operator :(");
        }
    }
}
