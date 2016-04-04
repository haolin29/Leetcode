public class Solution {
    public int countPrimes(int n) {
        // Sieve of Eratosthenes 
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
            isPrime[i] = true;
        }
        
        for (int i = 2; i * i < n; i++ ) {
            if (!isPrime[i]) continue; // such as we can skip 4
            for (int j = i*i; j < n; j+=i) {
                isPrime[j] = false;
            }
        }
        int count = 0;
        for (int i = 2; i < n;i++) {
            if (isPrime[i]) {
                count++;
            }
        }
        
        return count;
        
    }
}