import java.util.ArrayList;

public class BitMagic {

    public boolean check_kth_bit_setOrNot(int n, int k){
        return (n & (1 << (k-1))) != 0;
    }

    public int count_set_bits1(int n){
        int res = 0;
        while(n > 0){
            res = res + (n & 1);
            n = (n >> 1);
        }
        return res;
    }

    // Brian Kerningam's Algorithm
    public int count_set_bits2(int n){
        int res = 0;
        while(n > 0){
            n = (n & (n-1));
            res++;
        }
        return res;
    }

    //Lock up table mehod for 32-bit number
    public int count_set_bits3(int n){
        int[] table = new int[256];
        table[0] = 0;
        for(int i = 1 ; i < 256; i++){
            table[i] = (i & 1) + table[i/2];
        }
        int res = table[n & 0xff];
        n = n >> 8;
        res = res + table[n & 0xff];
        n = n >> 8;
        res = res + table[n & 0xff];
        n = n >> 8;
        res = res + table[n & 0xff];
        return res;

    }

    public boolean power_of_two_or_not(int n){
        if (n == 0) return false;
        return (n & (n-1)) == 0;
    }

    public int one_odd_occuring(int[] arr){
        int xor = 0;
        for (int i= 0 ; i < arr.length; i++){
            xor = xor ^ arr[i];
        }
        return xor;
    }

    // Given an array of n numbers that has values in range[1...n+1]. Every number appears exactly once. One no. is missing.
    // Find the missing no.
    public int missing_no_in_consecutive_numbers(int[] arr){
        int xor = 0;
        for (int i = 0 ; i < arr.length; i++){
            xor = xor ^ arr[i];
        }
        for (int i = 1 ; i <= arr.length+1; i++){
            xor = xor ^ i;
        }
        return xor; 
    }

    public int[] two_odd_occuring(int[] arr){
        int n = arr.length;
        int xor = 0; int res1 = 0; int res2 = 0;
        for (int i = 0; i < n; i++){
            xor = xor ^ arr[i];
        }
        int rmsb = xor & ~(xor - 1);
        for (int i = 0 ; i < n; i++){
            if ((arr[i] & rmsb) != 0)
            res1 = res1 ^ arr[i];
            else
            res2 = res2 ^ arr[i];
        }
        return new int[]{res1,res2};
    }

    public ArrayList<String> power_set_using_bitwise_operator(String s){
        ArrayList<String> list = new ArrayList<String>();
        int n = s.length();
        int power_size = (int)Math.pow(2,n);
        for (int counter = 0 ; counter < power_size; counter++){
            String res = "";
            for (int j = 0 ; j < n; j++){
                if ((counter & (1 << j)) != 0){
                    res += s.charAt(j);
                }
                
            }
            list.add(res);
        }
        return list;
    }

    // Detect if two integers have opposite sign
    public boolean oppositeSigns(int x, int y)
    {
        return ((x ^ y) < 0);
    }

    // Swap Two numbers using the fact that x ^ x = 0

    public void swap(int x, int y){
        x = x ^ y;
        y = x ^ y;
        x = x ^ y;
    }

    public void swap(int a, int b, int c){
        a = a ^ b ^ c;
        b = a ^ b ^ c;
        c = a ^ b ^ c;
        a = a ^ b ^ c;
    }

    // Add two numbers without arithmetic operators

    public int add(int x, int y){
        while (y > 0){
            int carry = x & y;
            x = x ^ y;
            y = carry << 1;
        }
        return x;
    }
    // This can also be done recursively:

//    public int add(int x, int y){
//            int keep = (x & y) << 1;
//            res = x ^ y;
//            if (keep == 0) return res;
//        return add(keep,res);
//    }

    // Add one to a number (using the fact ~x = - (x +1)

    public int addOne(int x){
        return (-(~x));
    }

    // Subtract two numbers without using Arithmetic operators:

    public int subtract(int x , int y){
        while (y > 0) {
            int carry = (~x) & y;
            x = x ^ y;
            y = carry << 1;
        }
        return x;
    }

    // This can also be done recursively:
     /*
    public int subtract(int x, int y)
    {

        if (y == 0)
            return x;

        return subtract(x ^ y, (~x & y) << 1);
    }

      */

    // Turn off the rightmost set bit

    public int turnOffRightmostSetBit(int n){
        return n ^ (n & ~(n - 1)); // return n & (n - 1)
    }

    // Bit Rotation: A rotation (or circular shift) is an operation similar to shift except that the bits that fall off at one end are put back to the other end.
    //In left rotation, the bits that fall off at left end are put back at right end.
    //In right rotation, the bits that fall off at right end are put back at left end.

    public int leftRotate(int n, int d) {
        int INT_BITS = 32;
        return (n << d) | (n >> (INT_BITS - d));
    }

    public int rightRotate(int n, int d){
        int INT_BITS = 32;
        return (n >> d) | (n << (INT_BITS - d));
    }

    // count number of bits to be flipped to convert A to B
    public int flippedCount(int a, int b) {
        return count_set_bits2(a ^ b);
    }

    // Function to convert decimal to binary number

    public void bin(int n){
        if (n >= 1) {
            bin(n >> 1 ); // or n/2
            System.out.printf("%d", n & 1);// or n % 2
        }
    }

    // convert fractional decimal to binary number
    public String decimalToBinary(double num, int k_prec)
    {
        StringBuilder binary = new StringBuilder();
        // Fetch the integral part of decimal number
        int Integral = (int) num;
        // Fetch the fractional part decimal number
        double fractional = num - Integral;
        // Conversion of integral part to
        // binary equivalent
        while (Integral > 0)
        {
            int rem = Integral % 2;
            // Append 0 in binary
            binary.append((char)(rem + '0'));
            Integral /= 2;
        }
        // Reverse string to get original binary
        // equivalent
        binary.reverse();
        // Append point before conversion of
        // fractional part
        binary.append('.');

        // Conversion of fractional part to
        // binary equivalent
        while (k_prec-- > 0)
        {
            // Find next bit in fraction
            fractional *= 2;
            int fract_bit = (int) fractional;

            if (fract_bit == 1)
            {
                fractional -= fract_bit;
                binary.append((char)(1 + '0'));
            }
            else
            {
                binary.append((char)(0 + '0'));
            }
        }

        return binary.toString();
    }

    public int swapNibblesInAByte(int n ){
        return ((n & 0x0F) << 4 | (n & 0xF0) >> 4);
    }

    public boolean areSame(int a, int b){
        return (a ^ b) == 0;
    }

    // check if a number has bits in alternate patterns:
    public boolean alternateBits(int n){
        return (n & (n >> 1)) == 0;
    }

    // Given a string, write a function that returns toggle case of a string using the bitwise operators in place.
    public String toggleCase(char[] a)
    {
        for (int i=0; i<a.length; i++) {
            // Bitwise EXOR with 32
            a[i]^=32;
        }
        return new String(a);
    }

    // Java implementation to toggle bits in  the given range

    public int toggleBitsFromLToR(int n, int L, int R){
        int res = n;
        for (int i = L; i <= R; i++) {
            // Set bit
            if ((n & (1 << (i - 1))) != 0) {

                // XOR will set 0 to already set
                // bits(a^a=0)
                res = res ^ (1 << (i - 1));
            }
            // unset bits
            else {
                // OR will set'0'bits to 1
                res = res | (1 << (i - 1));
            }
        }
        return res;
    }

    // Java implementation to find the largest number with n set and m unset bits

    public int largeNumWithNSetAndMUnsetBits(int n, int m){
        int num = (1 << (n + m)) - 1;
        int temp = (1 << m) - 1;
        return (num ^ temp);
    }

    //Function to swap adjacent bits of a given number

    /*

    The idea is to separate bits present at even positions with bits present at odd positions using mask 0xAAAAAAAA and 0x55555555, respectively.
    Mask 0xAAAAAAAA has all its even bits set, and its bitwise AND with n will separate bits present at even positions in n.
    Similarly, mask 0x55555555 has all its odd bits set, and its bitwise AND with n will separate bits present at odd positions in n.
     */
    public int swapAdjacentBits(int n) {
        return (((n & 0xAAAAAAAA) >> 1) | ((n & 0x55555555) << 1));
    }


    public int toggleAllEvenBits(int n){
        int numOfBits = 1 + (int)(Math.log(n) / Math.log(2));
        int mask = 0xAAAAAAAA & ((1 << numOfBits) - 1);
        return n ^ mask;
    }

    public int toggleAllOddBits(int n){
        int numOfBits = 1 + (int)(Math.log(n) / Math.log(2));
        int mask = 0x55555555 & ((1 << numOfBits) - 1);
        return n ^ mask;
    }

}