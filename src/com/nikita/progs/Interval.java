package com.nikita.progs;

import java.util.Scanner;

public class Interval {
    public void calcInter(String leftPart, String rightPart, boolean inside) {
        int lpl = leftPart.length();
        int rpl = rightPart.length();

        if (Integer.parseInt(leftPart) > Integer.parseInt(rightPart)) {
            if (inside) {
                System.out.println(addSpace(14 + lpl) + addSpace(lpl) + "//////");
            } else {
                System.out.println("///////" + addSpace(3) + addSpace(lpl, rpl) + addSpace(5) + "///");
            }
            System.out.println("------(" + rightPart + ")-----(" + leftPart + ")--->");
        } else if (Integer.parseInt(leftPart) < Integer.parseInt(rightPart)) {
            if (inside) {
                System.out.println(addSpace(13) + addSpace(rpl) + "//////");
            } else {
                System.out.println("///////" + addSpace(3) + addSpace(lpl, rpl) + addSpace(5) +"///");
            }
            System.out.println("------(" + leftPart + ")-----(" + rightPart + ")--->");
        }
    }

    public String addSpace(int spaces) {
        String str = "";
        for (int i = 0; i < spaces; i++)
            str += new String(" ");
        return str;

    }

    public String addSpace(int spaces1, int spaces2) {
        String str = "";
        for (int i = 0; i < spaces1 + spaces2; i++)
            str += new String(" ");
        return str;
    }

    public static void main(String[] args) throws Exception {
        Scanner scan = new Scanner(System.in);
        Interval interval = new Interval();

        interval.calcInter(scan.nextLine(), scan.nextLine(), scan.nextBoolean());
    }
}