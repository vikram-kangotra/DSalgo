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

}