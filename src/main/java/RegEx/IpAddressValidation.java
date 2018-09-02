package RegEx;

import java.util.Scanner;

public class IpAddressValidation {

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);

        while(in.hasNext()) {
            String ip = in.next();
            System.out.println(ip.matches(new MyRegex().pattern));
            System.out.println(new MyRegex().pattern);
        }
    }
}

class MyRegex {

    /*
    *  IP address is a string in the form "A.B.C.D",
    *  where the value of A, B, C,
    *  and D may range from 0 to 255.
    *  Leading zeros are allowed.
    *  The length of A, B, C, or D can't be greater than 3.
    * */
    final String reg = "(\\d{1,2}|(0|1)\\d{2}|2[0-4]\\d|25[0-5])";


    final String pattern = reg + "\\." + reg + "\\." + reg + "\\." + reg;
}
