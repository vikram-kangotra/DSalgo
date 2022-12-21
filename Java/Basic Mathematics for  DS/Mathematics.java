import java.util.ArrayList;
import java.util.Arrays;


class Mathematics {
    
    public int no_of_digits(long n){
        if (n == 0) return 0;
        return 1 + no_of_digits(n/10);
    }

    public int factorial(int n){
        if (n == 0) return 1;
        return n * factorial(n-1);
    }

    public int trailing_zeros_in_factorial(int n){
        int res = 0 ;
        for (int i = 5 ; i <= n; i *= 5){
            res += n/i;
        }
        return res;
    }

    public ArrayList<Integer> find_divisors(int n){
        ArrayList<Integer> result = new ArrayList<>();
        int i = 1;
        for (i = 1 ; i * i < n; i++){
            if(n % i == 0) result.add(i);
        }
        for (; i >= 1 ; i--){
            if (n % i == 0) result.add(n/i);
        }

        return  result;
    }

    public int find_gcd(int a, int b){ // Time complexity is log(min(a,b))
        if (b == 0) return a;
        return find_gcd(b, a % b);
    }

    public int find_lcm(int a, int b) {
        return (a * b) / find_gcd(a,b);
    }

    public boolean isPrime(int n){
        if (n == 1) return  false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i = i + 6){
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    public ArrayList<Integer> getPrimeFactors(int n){
        if (n <= 1) return new ArrayList<>();
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2 ; i * i <= n; i++){
            while(n % i == 0) {
                list.add(i);
                n = n/i;
            }
        }
        if (n > 1) list.add(n);
        return list;
    }

    // Sieve of Eratosthenes algorithm

    public ArrayList<Integer> sieve1(int n){
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr,true);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2 ; i * i <= n; i++){
            if (arr[i]){
                for (int j =  2 * i ; j <= n; j = j + i){
                    arr[j] = false;
                }
            }
        }
        for (int i = 2 ; i <= n ; i++){
            if (arr[i]) list.add(i);
        }
        return list;
    }
    public ArrayList<Integer> sieve2(int n){
        boolean[] arr = new boolean[n+1];
        Arrays.fill(arr,true);
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 2 ; i <= n; i++){
            if(arr[i]) {
                list.add(i);
                for (int j = 2 * i; j <= n; j = j + i)
                    arr[j] = false;
            }
        }
        return list;
    }

    // Finding power(x,n) ----->
    // if n is even then power(x,n) = power(x, n/2) * power(x, n/2)
    // else power(x,n) = power(x, n-1) * x

    public int power1(int x, int n){
        if (n == 0) return 1;
        int temp = power1(x,n/2);
        temp = temp * temp;
        if (n % 2 == 0) return  temp;
        else return temp * x;
    }

    // More optimized way to calculate power(x,n)------>
    // We know that Every number can be written as sum of powers of 2 (set bits in binary representation)
    // Also, we can traverse through all the bits of a number from LSB to MSB in O(log n) time.

    public int power2(int x, int n){
        int res = 1;
        while(n > 0){
            if (n % 2 != 0) res = res * x;
            x = x * x;
            n = n / 2;
        }
        return  res;
    }

    public long sumUnderModulo(long a, long b , long M) { return ((a%M) + (b%M))%M; }

}