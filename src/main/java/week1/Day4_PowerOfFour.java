package week1;

public class Day4_PowerOfFour {

    public boolean isPowerOfFour(int n) {
        double d = Math.log(n) / Math.log(4);
        return d == Math.floor(d) && !Double.isInfinite(d);
    }

    // NOTE - 0x55555555 set all odd bits to 1 ex.  - 01010101
    //        0xAAAAAAAA set all even bits to 1 ex. - 10101010
    public boolean isPowerOfFourEfficient(int n) {
        return (n > 0) && (n & (n-1)) == 0 && (n & 0x55555555) != 0;
    }

    public static void main(String[] args) {
        int n=40;
        System.out.println(n^(n & (n-1)));
        double t = Math.log(n) / Math.log(4);
        if (t == Math.floor(t) && !Double.isInfinite(t))
            System.out.println("power of 4 exist");
        else System.out.println("OOPS");
        System.out.println((n & (n-1)) == 0);
    }
}
