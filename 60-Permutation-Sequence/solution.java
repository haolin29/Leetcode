public class Solution {
    public String getPermutation(int n, int k) {
        if(n <= 0 || n > 9) {
            return "";
        }
        
        k--; // base 0
        int factorial = 1;
        StringBuilder sb = new StringBuilder();
        ArrayList<Integer> list = new ArrayList<>();
        
        // (n - 1)!
        for(int i = 2; i < n; i++) {
            factorial *= i;
        }
        
        for(int i = 1; i <= n; i++) {
            list.add(i);
        }
        
        // 多少位
        int round = n - 1;
        
        while(round >= 0) {
            int i = k / factorial;
            k %= factorial;
            sb.append(list.get(i));
            list.remove(i);
            if(round > 0) {
                factorial /= round;
            }
            round--;
        }
        
        return sb.toString();
        
        
    }
}