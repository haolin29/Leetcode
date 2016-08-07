/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        List<Interval> result = new ArrayList<>();
        if(intervals == null || intervals.size() == 0) {
            return result;
        }
        
        Comparator<Interval> myComp = new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.start == i2.start) {
                    return i1.end - i2.end;
                }
                return i1.start - i2.start;
            }
        };
        
        Collections.sort(intervals, myComp);
        result.add(intervals.get(0));
        
        for(int i = 1; i < intervals.size(); i++) {
            // merge if have overlapping
            if(intervals.get(i).start <= result.get(result.size() - 1).end) {
                result.get(result.size() - 1).end = Math.max(intervals.get(i).end, result.get(result.size() - 1).end);
            } else {
                result.add(intervals.get(i));
            }
            
        }
        
        return result;
    }
}