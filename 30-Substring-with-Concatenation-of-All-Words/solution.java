public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        HashMap<String,Integer> map = new HashMap<>();
        HashMap<String,Integer> scan = new HashMap<>();
        
        for (String word: words) {
            if (!map.containsKey(word)) {
                map.put(word,1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        
        int m = words.length, n = words[0].length();
        
        for (int i = 0; i <= s.length() - m * n;i++) {
            scan.clear();
            int j = 0;
            for (; j < m; j++) {
                int k = i + j * n;
                String ss = s.substring(k, k + n);
                if (!map.containsKey(ss) ) break;
                if (!scan.containsKey(ss)) {
                    scan.put(ss,1);
                } else {
                    scan.put(ss, scan.get(ss) + 1);
                }
                if (scan.get(ss) > map.get(ss) ) break;
            }
            
            if (j == m) result.add(i);
        }
        
        return result;
        
        
        
    }
}