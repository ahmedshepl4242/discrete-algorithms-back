package com.example.dicrete;

import java.util.ArrayList;

public class chinese {

    public Long answer;
    private long x;
    private long y;


    public long gcd(long a, long b) {
        if (b == 0) {
            x = 0;
            y = 1;
            return a;
        }

        long gcd_num = gcd(b, a % b);

        long prev_x = x;


        x = y - (a / b) * x;
        y = prev_x;

        return gcd_num;

    }


    public long mod_inv(long a, long m) {
        long g = gcd(m, a);
        long res;
        if (g != 1) {
            return 0;
        } else {
            res = (x % m + m) % m;

        }

        return res;
    }


    public void chinese_theorem_remainders(ArrayList<congrence_eq> cong) {
        try {


            long M = 1;
            for (int i = 0; i < cong.size(); i++) {
                M *= cong.get(i).m;
            }
            long sol = 0;
            for (int i = 0; i < cong.size(); i++) {

                long a_i = cong.get(i).a;
                long M_i = M / cong.get(i).m;
                long y_i = mod_inv(M_i, cong.get(i).m);

                sol = (sol + a_i * M_i % M * y_i) % M;
            }
            answer = (sol % M + M) % M;


        }catch (Exception e){
            answer= 0L;
        }
    }

}