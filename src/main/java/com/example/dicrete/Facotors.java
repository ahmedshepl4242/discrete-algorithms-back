package com.example.dicrete;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Facotors {
    public  ArrayList<primeFact> list_1;



    public  void factorization(Long n) {
        list_1 = new ArrayList<>();
        int q = 2;
        while (n != 1) {

            Long temp = n;
            int count = 0;

            while (n % q == 0) {
                count++;
                n = n / q;
            }
            if (temp % q == 0) {
                primeFact fac = new primeFact(q, count);
                list_1.add(fac);
            }
            q++;
        }
        System.out.print("{ ");

        for (int itr = 0; itr < list_1.size(); itr++) {
            if (itr == list_1.size() - 1) {
                System.out.print(list_1.get(itr).value + "^" + list_1.get(itr).pow + " ");
                break;
            }
            System.out.print(list_1.get(itr).value + "^" + list_1.get(itr).pow + "  ,");
        }
        System.out.println("}");
    }


}