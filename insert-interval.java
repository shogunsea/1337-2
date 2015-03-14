// Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary).

// You may assume that the intervals were initially sorted according to their start times.

// Example 1:
// Given intervals [1,3],[6,9], insert and merge [2,5] in as [1,5],[6,9].

// Example 2:
// Given [1,2],[3,5],[6,7],[8,10],[12,16], insert and merge [4,9] in as [1,2],[3,10],[12,16].

// This is because the new interval [4,9] overlaps with [3,5],[6,7],[8,10].

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
    	if(newInterval == null) return intervals;
    	if(intervals.size() == 0){
    		intervals.add(newInterval);
    		return intervals;
    	}

    	List<Interval> list = new ArrayList<Interval>();

    	int pos = 0;

    	for(Interval i : intervals){
    		if(i.end < newInterval.start){
    			list.add(i);
    			pos++;
    		}else if(i.start > newInterval.end){
    			list.add(i);
    		}else{
    			newInterval.start = Math.min(newInterval.start, i.start);
    			newInterval.end = Math.max(newInterval.end, i.end);
    		}
    	}

    	list.add(pos, newInterval);

    	return list;
	}
}



        // handle base case, that is new interval is at the head or tail
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
        if (newInterval == null) {
            return intervals;
        }

        boolean inserted = false;
        int size = intervals.size();

        if (size == 0) {
            intervals.add(newInterval);
            return intervals;
        }

        List<Interval> res = new ArrayList<Interval>();

        for (int i = 0; i < size; i++) {
            Interval current = intervals.get(i);

            if (inserted) {
                // newinterval inserted, just add current.
                res.add(current);
                continue;
            }

            if (!hasIntersection(current, newInterval)) {
                if (current.start < newInterval.start) {
                    res.add(current);
                } else {
                    res.add(newInterval);
                    i--;
                    inserted = true;
                }
            } else {
                newInterval.start = Math.min(newInterval.start, current.start);
                newInterval.end = Math.max(newInterval.end, current.end);
            }
        }

        if (!inserted) {
            res.add(newInterval);
        }

        return res;
    }

    public boolean hasIntersection(Interval a, Interval b) {
        boolean conditionA = b.end >= a.start && b.end <= a.end;
        boolean conditionB = b.start >= a.start && b.start <=a.end;
        boolean conditionC = b.start <= a.start && b.end >= a.end;
        boolean intersection = conditionA || conditionB || conditionC;
        return intersection;
    }
}