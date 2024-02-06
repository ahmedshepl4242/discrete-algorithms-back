package com.example.dicrete;

import java.util.Arrays;
import java.util.Scanner;

public class Sive {

    public static boolean SeivePrime(int n) {
        boolean arr[] = new boolean[n + 1];

        Arrays.fill(arr, true);
        arr[0] = false;
        arr[1] = false;

        for (int itr = 2; (itr * itr) <= n; itr++) {
            if (arr[itr]) {
                for (int it = itr * itr; it <= n; it += itr) {
                    arr[it] = false;
                }

            }
        }

        if (arr[n]) {
            return true;
        }
        return false;


    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);


        while (true) {

            int number;
            System.out.println("Enter number");
            try {
                number = in.nextInt();
            } catch (Exception e) {
                System.out.println("Invalid input ");
                in.nextLine();
                continue;
            }

            if (SeivePrime(number)) {
                System.out.println("YES It Is Prime Number");
            } else {
                System.out.println("NO It Is Not Prime Number");

            }

            System.out.println("Exit: 0");
            System.out.println("Continue OtherWise");

            int flag;
            flag = in.nextInt();
            if (flag == 0) {
                break;
            }
            System.out.println("----------------------------------");
        }


    }
}