/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> merge(List<Interval> intervals) {
        
        //result list ...
        List<Interval> mergedList = new ArrayList<>();
        
        if(intervals.size() > 0){
            //intervals sorted by start times.
            List<Interval> sortedIntervals = new ArrayList<>();

            //Priority queue to sort intervals by start times.

            PriorityQueue<Interval> queue = new PriorityQueue<Interval>(new Comparator<Interval>(){
                public int compare(Interval i1, Interval i2){
                    return i1.start - i2.start;
                }
            });

            //Add all intervals to queue.

            for(Interval i: intervals){
                queue.offer(i);
            }

            //pop all sorted intervals in ascending order from queue.

            while(!queue.isEmpty()){
                sortedIntervals.add(queue.poll());
            }

            mergedList.add(sortedIntervals.get(0));

            for(int i = 1 ; i < sortedIntervals.size(); i++){
                Interval current = sortedIntervals.get(i);
                Interval lastMerged = mergedList.get(mergedList.size()-1);
                if(current.start >= lastMerged.start && current.start <= lastMerged.end){
                    if(current.end > lastMerged.end){
                        lastMerged.end = current.end;
                    } 
                } else {
                    mergedList.add(current);
                }
            }
        }
  
        return mergedList;
    }
}
