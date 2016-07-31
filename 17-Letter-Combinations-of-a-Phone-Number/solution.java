public class Solution {
    char[][] letters = {
        {'a', 'b', 'c'},
        {'d', 'e', 'f'},
        {'g', 'h', 'i'},
        {'j', 'k', 'l'},
        {'m', 'n', 'o'},
        {'p', 'q', 'r', 's'},
        {'t', 'u', 'v'},
        {'w', 'x', 'y', 'z'}
    };
    
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        StringBuilder sb = new StringBuilder();
        
        if(digits == "" || digits.length() == 0) {
            return result;
        }
        
        dfs(digits, result, sb);
        
        return result;
    }
    
    public void dfs(String digits, List<String> result, StringBuilder sb) {
        if(sb.length() == digits.length()) {
            result.add(sb.toString());
            return;
        }
        
        int number = Character.getNumericValue(digits.charAt(sb.length()));
        for(int i = 0; i < letters[number - 2].length; i++) {
            if(number >= 2 && number <= 9) {
                sb.append(letters[number - 2][i]);
                dfs(digits, result, sb);
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }
}