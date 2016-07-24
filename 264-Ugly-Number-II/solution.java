public class Solution {
    public int nthUglyNumber(int n) {
        if(n <= 1) return n;
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.add(1);
        int two = 0;
        int three = 0;
        int five = 0;
        
        while (list.size() < n) {
            int min1 = list.get(two) * 2, min2 = list.get(three) * 3, min3 = list.get(five) * 5;
            int min = Math.min(min1, Math.min(min2, min3));
            
            if(min == min1) two++;
            if(min == min2) three++;
            if(min == min3) five++;
            
            list.add(min);
        }
        
        return list.get(list.size() - 1);
        
    }
}