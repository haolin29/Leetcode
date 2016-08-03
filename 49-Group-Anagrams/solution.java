public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        HashMap<String, List<String>> map = new HashMap<>();
        
        for(String str : strs) {
            String sortedStr = getSortedStr(str);
            if(!map.containsKey(sortedStr)) {
                List<String> list = new ArrayList<>();
                
                map.put(sortedStr, list);
            }
            
            map.get(sortedStr).add(str);
        }
        
        for(List<String> list : map.values()) {
            Collections.sort(list);
            result.add(list);
        }
        return result;
    }
    
    public String getSortedStr(String s) {
        char[] chars = s.toCharArray();
        Arrays.sort(chars);
        return new String(chars);
    }
}