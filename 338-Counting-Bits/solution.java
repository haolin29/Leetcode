public class Solution {
    public int[] countBits(int num) {
        int[] result = new int[num + 1];
        int last = 1;
        int pow = 1;
        
        for (int i = 1; i <= num; i++) {
            if(i == pow) {
                pow <<= 1;
                last = result[i] = 1;
            } else {
                result[i] = result[last] + 1;
                last++;
            }
        }
        
        
        return result;
        
    }
}