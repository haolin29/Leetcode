public class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new ArrayList<>();
        if(n < 0) return result;
        
        if(n == 0) {
            result.add(0);
            return result;
        }
        
        result.add(0);
        result.add(1);
        
        for(int i = 2; i <= n; i++) {
            int size = result.size();
            for(int j = size - 1; j >= 0; j--) {
                result.add(result.get(j) + (1 << (i - 1)));
            }
        }
        
        return result;
    }
}