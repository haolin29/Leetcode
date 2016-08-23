public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(s == null || s.length() == 0 || words == null || words.length == 0) {
            return result;
        }
        
        Map<String, Integer> map = new HashMap<>();
        for(String word : words) {
            if(!map.containsKey(word)) {
                map.put(word, 1);
            } else {
                map.put(word, map.get(word) + 1);
            }
        }
        
        for(int i = 0; i < words[0].length(); i++) {
            int step = words[0].length();
            int count = 0;
            int left = i;
            
            HashMap<String, Integer> track = new HashMap<>();
            
            for(int j = i; j <= s.length() - step; j += step) {
                String word = s.substring(j, j + step);
                if(map.containsKey(word)) {
                    if(!track.containsKey(word)) {
                        track.put(word, 1);   
                    } else {
                        track.put(word, track.get(word) + 1);
                    }
                    
                    if(track.get(word) <= map.get(word)) {
                        count++;
                    } else {
                        // move left pointer
                        while(track.get(word) > map.get(word)) {
                            
                            String str = s.substring(left, left + step);
                            
                            if(track.containsKey(str)) {
                                track.put(str, track.get(str) - 1);
                                if(track.get(str) < map.get(str)) {
                                    count--;
                                }
                            }
                            
                            left += step;
                        }
                    }
                    
                    if(count == words.length) {
                        result.add(left);
                        
                        String str = s.substring(left, left + step);
                        if(track.containsKey(str)) {
                            track.put(str, track.get(str) - 1);
                            left += step;
                            count--;
                        }
                    }
                    
                } else {
                    track.clear();
                    left = j + step;
                    count = 0;
                }
                
            }
        }
        
        
        return result;
    }
}