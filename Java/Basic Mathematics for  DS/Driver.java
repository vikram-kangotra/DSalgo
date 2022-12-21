public class Driver{
    public static void main(String[] args) {
        Mathematics m = new Mathematics(); 
        System.out.println(m.no_of_digits(1255632));
        System.out.println(m.trailing_zeros_in_factorial(100));
        System.out.println(m.find_divisors(100));
        System.out.println(m.find_gcd(6,4));
        System.out.println(m.find_lcm(6,4));
        System.out.println(m.isPrime(29));
        System.out.println(m.getPrimeFactors(450));
        System.out.println(m.sieve1(100));
        System.out.println(m.sieve2(100));
        System.out.println(m.power1(2,4));
        System.out.println(m.power2(2,5));
    }
}