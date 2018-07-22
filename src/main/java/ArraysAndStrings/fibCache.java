public class fibCache {

    /** Prepare the cache values for recursion */
    public static int fib(int n) {
        int[] cache = new int[n+1];
        for (int i = 0; i < n+1; i++) {
            cache[i] = -1;
        }
        cache[0] = 0;
        cache[1] = 1;
        return fib(cache, n);
    }

    /** Compute the nth fib val */
    public static int fib(int[] cache, int n) {
        if (cache[n] < 0) {
            cache[n] = fib(cache, n-1) + fib(cache, n-2);
        }
        return cache[n];
    }

    // Fibonacci Driver
    public static void main (String[] args) {
        System.out.println(fib(30));
    }
}
