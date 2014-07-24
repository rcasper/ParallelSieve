/**
 * This class serves as the entry point for the ParallelSieve program, which
 * uses a multi-threaded implementation of the Sieve of Eratosthenes to return
 * a list of prime numbers in a given range.
 * @author Ryan Kasprzyk
 */
public class Start {

    /**
     * Creates a small thread pool and begins verifying the primality of values
     * in the given range. If the range given is smaller than two, we return, as
     * there are no prime numbers smaller than two.
     * @param args
     * @throws InterruptedException 
     */
    public static void main(String[] args) throws InterruptedException {
        int cnt = 0;
        SieveThread[] pool = new SieveThread[10];
        int limit = Integer.parseInt(args[0]);
        if(limit < 2){
            System.out.println("No primes in this range");
            System.exit(0);
        }
        boolean[] arr = new boolean[limit + 1];
        arr[0] = true;
        arr[1] = true;
        for (int i = 2; i < arr.length; i++) {
            if (arr[i] != false) {
            } else {
                pool[cnt] = new SieveThread("" + cnt, arr, i);
                pool[cnt].run();
                //Thread.sleep(2000);
            }
        }
        int print = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != true) {
                System.out.print(i + "\t");
                print++;
            }
            if(print % 10 == 0){
                System.out.println("");
            }
        }
        System.out.println();
    }

}
