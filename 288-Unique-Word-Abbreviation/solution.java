public class ValidWordAbbr {

    Map<String, String> map;
    public ValidWordAbbr(String[] dictionary) {
        map = new HashMap<>();
        for(String word : dictionary) {
            String t = word;
            if(word.length() > 2) {
                word = word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
            }
            if(!map.containsKey(word)) {
                map.put(word, t);
            } else {
                if(!map.get(word).equals(t)) {
                    map.put(word, "");
                }
            }
        }
        
    }

    public boolean isUnique(String word) {
        String t = word;
        if(word.length() > 2) {
            word = word.charAt(0) + String.valueOf(word.length() - 2) + word.charAt(word.length() - 1);
        }
        return !map.containsKey(word) || map.get(word).equals(t);
        
        
    }
}


// Your ValidWordAbbr object will be instantiated and called as such:
// ValidWordAbbr vwa = new ValidWordAbbr(dictionary);
// vwa.isUnique("Word");
// vwa.isUnique("anotherWord");