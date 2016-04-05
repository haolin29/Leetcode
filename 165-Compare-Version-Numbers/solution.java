public class Solution {
    public int compareVersion(String version1, String version2) {
        String[] list1 = version1.split("\\.");
        String[] list2 = version2.split("\\.");
        
        int length = Math.max(list1.length, list2.length);
        
        for (int i = 0; i < length; i++) {
            Integer v1 = i < list1.length ? Integer.parseInt(list1[i]) : 0;
            Integer v2 = i < list2.length ? Integer.parseInt(list2[i]) : 0;
            
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
            
        }
        return 0;
        
    }
}