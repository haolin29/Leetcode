// 3:00 - 3:24
public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null || strs.length == 0) 
            return result;
        
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        
        for (int i = 0; i < strs.length; i++) {
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String t = String.valueOf(arr);
            if (!map.containsKey(t)) {
                ArrayList<String> list = new ArrayList<>();
                list.add(strs[i]);
                map.put(t, list);
            } else {
                map.get(t).add(strs[i]);
            }
        }
        
        for (ArrayList<String> list: map.values()) {
            Collections.sort(list);
            result.add(list);
        }
        return result;
        
    }
}