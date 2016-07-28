public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        // bfs, find the adjacent word
        wordList.add(beginWord);
        wordList.add(endWord);
        
        Queue<String> q = new LinkedList<>();
        HashSet<String> set = new HashSet<>();
        q.add(beginWord);
        set.add(beginWord);
        
        int step = 1;
        
        while(!q.isEmpty()) {
            int size = q.size();
            step++;
            for (int i = 0; i < size; i++) {
                String curWord = q.poll();
                ArrayList<String> adjacentWord = getNextWord(curWord, wordList);
                for(String nextWord:adjacentWord) {
                    if(nextWord.equals(endWord)) {
                        return step;
                    } 
                    if(!set.contains(nextWord)) {
                        q.offer(nextWord);
                        set.add(nextWord);
                    }
                }
            }
            
        }
        
        return 0;
        
        
    }
    
    public ArrayList<String> getNextWord(String word, Set<String> wordList) {
        ArrayList<String> result = new ArrayList<>();
        
        for(int i = 0; i < word.length(); i++) {
            for(char c = 'a'; c <= 'z'; c++) {
                String next = word.substring(0, i) + c + word.substring(i + 1);
                if(wordList.contains(next)) {
                    result.add(next);
                }
            }
        }
        
        return result;
    }
}