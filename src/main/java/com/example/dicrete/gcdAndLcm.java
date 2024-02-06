package com.example.dicrete;

import java.util.*;

public class gcdAndLcm {

    static List<primeFact> list_1;

    static List<primeFact> list_2;

    public static class primeFact {


        private int value;
        private int pow;

        public primeFact(int value, int pow) {
            this.value = value;
            this.pow = pow;
        }
    }


    public static void factorization(int n, boolean flag) {
        int q = 2;
        while (n != 1) {

            int temp = n;
            int count = 0;

            while (n % q == 0) {
                count++;
                n = n / q;
            }
            if (temp % q == 0) {
//                System.out.print(q + " ");
                primeFact fac = new primeFact(q, count);
                if (flag) {
                    list_1.add(fac);
                } else {
                    list_2.add(fac);
                }
            }
            q++;
        }

    }

    public static int gcdFact(int a, int b) {
        int itr1 = 0;
        int itr2 = 0;
        int gcd = 1;

        for (int itr = 0; itr < Math.max(list_1.size(), list_2.size()); itr++) {
            if (list_2.size() == itr2 || list_1.size() == itr1) {
                break;
            }
            if (list_2.get(itr2).value == list_1.get(itr1).value) {
//                System.out.println(list2.get(itr2).value + " " + list2.get(itr2).pow);
                gcd *= (int) Math.pow((list_1.get(itr1).value), Math.min(list_1.get(itr1).pow, list_2.get(itr2).pow));
                itr1++;
                itr2++;

            } else if (list_2.get(itr2).value < list_1.get(itr1).value) {
                itr2++;
            } else if (list_2.get(itr2).value > list_1.get(itr1).value) {
                itr1++;
            }
        }

        return gcd;

    }

    public static int gcdEcludian(int a, int b) {
        if (a % b == 0) {
            return b;
        }

        return gcdEcludian(b, a % b);

    }

    public static int lcm(int a, int b) {
        Map<Integer, Integer> primeFactors = primeFactors(a);
        for (Map.Entry<Integer, Integer> entry : primeFactors(b).entrySet()) {
            primeFactors.put(entry.getKey(), Math.max(entry.getValue(), primeFactors.getOrDefault(entry.getKey(), 0)));
        }

        int lcm = 1;
        for (Map.Entry<Integer, Integer> entry : primeFactors.entrySet()) {
            lcm *= (int) Math.pow(entry.getKey(), entry.getValue());
        }

        return lcm;
    }

    public static Map<Integer, Integer> primeFactors(int n) {
        Map<Integer, Integer> factors = new HashMap<>();

        for (int i = 2; i <= n; i++) {
            while (n % i == 0) {
                factors.put(i, factors.getOrDefault(i, 0) + 1);
                n /= i;
            }
        }

        return factors;
    }

    public static int lcmEcludian(int a, int b) {

        return (a / (gcdEcludian(b, a))) * b;

    }


    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        Main mn=new Main();


        while (true) {

            list_1 = new ArrayList<>();
            list_2 = new ArrayList<>();

            int number1;
            int number2;

            System.out.print("Enter Number 1: ");
            number1 = in.nextInt();
            factorization(number1, true);
            System.out.print("Enter Number 2: ");
            number2 = in.nextInt();
            factorization(number2, false);

            if (number1 == 0 || number2 == 0) {
                System.out.println("It is not possible");
                continue;
            }

            System.out.println("the gcd of " + number1 + "  and " + number2 + " is : " + gcdFact(number1, number2) + "(   using Factors )");
            System.out.println("the lcm of " + number1 + "  and " + number2 + " is : " + lcm(number1, number2) + "(   using Factors )");


            System.out.println("the gcd of " + number1 + "  and " + number2 + " is : " + gcdEcludian(number1, number2) + "(   using Ecludian )");
            System.out.println("the lcm of " + number1 + "  and " + number2 + " is : " + lcmEcludian(number1, number2) + "(   using Ecludian )");

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