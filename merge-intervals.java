// Given a collection of intervals, merge all overlapping intervals.

// For example,
// Given [1,3],[2,6],[8,10],[15,18],
// return [1,6],[8,10],[15,18].

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
    	if(intervals == null || intervals.size() == 0) return intervals;

    	List<Interval> list = new ArrayList<Interval>();

    	Collections.sort(intervals, new Comparator<Interval>(){
    		public int compare(Interval a, Interval b){
    			if(a.start > b.start) return 1;
    			else if(a.start == b.start) return 0;
    			else return -1;
    		}
    	});

    	Interval last = intervals.get(0);

    	for(int i = 1; i < intervals.size(); i++){
    		Interval current = intervals.get(i);
    		if(current.start <= last.end){
    			last.end = Math.max(last.end, current.end);
    		}else{
    			list.add(last);
    			last = current;
    		}
    	}

    	list.add(last);

    	return list;
    }
}


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
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval a, Interval b) {
                // a - b : min heap.
                // b - a : max heap.
                return a.start - b.start;
            }
        });

        int size = intervals.size();

        if (size == 0) {
            return intervals;
        }

        List<Interval> res = new ArrayList<Interval>();
        Interval last = intervals.get(0);

        for (int i = 1; i < size; i++) {
            Interval current = intervals.get(i);
            if (hasIntersection(last, current)) {
                last = merge(last, current);
            } else {
                res.add(last);
                last = new Interval(current.start, current.end);
            }
        } 

        res.add(last);

        return res;
    }

    public boolean hasIntersection(Interval a, Interval b) {
        // boolean left = a.end >= b.start && a.end <= b.end;
        // boolean right = a.start >= b.start && a.start <= b.end;
        // boolean cover = a.start <= b.start && a.end >= b.end;
        // return left || right || cover;
        return b.start <= a.end;
    }

    public Interval merge(Interval a, Interval b) {
        a.start = Math.min(a.start, b.start);
        a.end = Math.max(a.end, b.end);
        return a;
    }
}