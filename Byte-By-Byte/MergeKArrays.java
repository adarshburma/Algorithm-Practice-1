/*
Time Complexity O(kn * log(k))

k- number of arrays
n- elements in each of k arrays.
*/

package org.practice.courses.courseapi.practice12;


import java.util.PriorityQueue;

public class MergeKArrays {

    static class QueueNode implements Comparable<QueueNode> {
        int arrayIndex;
        int index;
        int value;

        QueueNode(int arrayIndex, int index, int value){
            this.arrayIndex = arrayIndex;
            this.index = index;
            this.value = value;
        }

        @Override
        public int compareTo(QueueNode o) {
            if(value > o.value){
                return 1;
            }
            if(value < o.value){
                return -1;
            }
            return 0;
        }
    }

    static int[] merge(int[][] arrays){
        PriorityQueue<QueueNode> pq = new PriorityQueue<>();
        int size = 0;
        for(int i = 0; i < arrays.length; i++){
            size += arrays[i].length;
            pq.offer(new QueueNode(i, 0, arrays[i][0]));
        }

        int[] res = new int[size];

        for(int i = 0; !pq.isEmpty(); i++){
            QueueNode q = pq.poll();
            int newIndex = q.index+1;
            res[i] = q.value;
            if( newIndex < arrays[q.arrayIndex].length){
                pq.offer(new QueueNode(q.arrayIndex, newIndex, arrays[q.arrayIndex][newIndex]));
            }
        }
        return res;
    }

    public static void main(String[] args){
        int[][] arrays = {
                {1, 4, 7}, {2, 5, 8}, {3, 6, 9}
        };

       for(int i : merge(arrays)) {
           System.out.print(i + " ");
       }
    }
}
