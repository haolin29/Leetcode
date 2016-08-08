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
    public int minMeetingRooms(Interval[] intervals) {
        // sort 
        if(intervals == null || intervals.length == 0) {
            return 0;
        }
        
        Comparator<Interval> comp = new Comparator<Interval>() {
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.start == i2.start) {
                    return i1.end - i2.end;
                }
                
                return i1.start - i2.start;
            }
        };
        
        Arrays.sort(intervals, comp);
        
        PriorityQueue<Interval> pq = new PriorityQueue<Interval>(intervals.length,new Comparator<Interval>() {
           public int compare(Interval i1, Interval i2) {
               return i1.end - i2.end;
           } 
        });
        
        pq.offer(intervals[0]);
        
        for(int i = 1; i < intervals.length; i++) {
            // find the eariliest end meeting
            Interval meeting = pq.poll();
            
            // the first starting meeting after end
            if(meeting.end <= intervals[i].start) {
                meeting.end = intervals[i].end;
            } else {
                pq.offer(intervals[i]);
            }
            
            // don't forget to put meeting back
            pq.offer(meeting);
        }
        
        return pq.size();
    }
}