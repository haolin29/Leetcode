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
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new ArrayList<>();
        if(intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }
        
        int index = 0;
        while(index < intervals.size() && intervals.get(index).end < newInterval.start) {
            result.add(intervals.get(index));
            index++;
        }
        
        
        
        while(index < intervals.size() && intervals.get(index).start <= newInterval.end) {
            newInterval.start = Math.min(intervals.get(index).start, newInterval.start);
            newInterval.end = Math.max(intervals.get(index).end, newInterval.end);
            index++;
        }
        
        result.add(newInterval);
        
        while(index < intervals.size()) {
            result.add(intervals.get(index));
            index++;
        }
        
        return result;
    }
}