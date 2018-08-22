package data_structures_algorithms;

public class GCD_algorithm {

    /**
     * Greatest Common Divider (GCD) of 2 positive integers
     * 1. Divide m by n and let the reminder to be r
     * 2. if r == 0 the algorithm ends, n is GCD
     * 3. set m -> n, n -> r, go back to step 1 until r == 0
     */
    public static void main(String... args) {
       System.out.println("GCD is " + findGCD(25, 5));
    }

    public static int findGCD(int m, int n) {
        if(m <= n) throw new RuntimeException("'m' should be greater then 'n'");
        if(n == 0) return m;
        return findGCD(n, m%n);
    }
}
