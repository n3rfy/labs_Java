public class Primes {
    public static void main(String[] args) {
        ///the main function starts a cycle of numbers from 2 to 100
        for (int i=2; i<100; i++)
            if(isPrime(i))
                System.out.println(i);
    }


    public static boolean isPrime(int n){
        ///checks a number for primes
        for (int i=2; i<n; i++)
            if(n%i ==0)
                return false;
            return true;
    }
}
