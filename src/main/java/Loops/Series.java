package Loops;

import java.util.*;

public class Series {

    public static void main(String [] args){

        StringBuilder sb = new StringBuilder();

        int a = 0; int b = 0; int n = 0;

        Scanner in = new Scanner(System.in);

        int q = in.nextInt();
        if(!(q >= 0 && q <= 500))
            throw new InputMismatchException("input n should be q >= 0 && q <= 500");

        for(int i = 0; i < q; i++) {

             a = Integer.valueOf(in.next());
             if(!(a >= 0 && a <= 50))
                throw new InputMismatchException("input n should be a >= 0 && a <= 50");

             b = Integer.valueOf(in.next());
             if(!(b >= 0 && b <= 50))
                throw new InputMismatchException("input n should be b >= 0 && b <= 50");

             n = Integer.valueOf(in.next());
            if(!(n >= 1 && n <= 15))
                throw new InputMismatchException("input n should be n >= 1 && n <= 15");
            /*
             *  a = 0, b = 2, n = 10
             *  S0 = 0 + 1 * 2 = 2
             *  s1 = 0 + 1 * 2 + 2 * 2 = 6
             *  and so on
             * */
            int tmp = a;
            for(int j = 0; j < n; j++) {
                tmp  += (int)Math.pow(2.0, new Double(j)) * b;
                sb.append(tmp + " ");
            }
            sb.append("\n");
        }
        System.out.println(sb.toString());


        in.close();
    }

}
