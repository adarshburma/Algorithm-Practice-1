/*

For the purposes of this problem, suppose Quora has 𝑁 questions, and question 𝑖(1≤𝑖≤𝑁) takes 𝑇𝑖 time to read. There exists exactly one path from any question to another, and related questions form undirected pairs between themselves. In other words, the graph of related questions is a tree.

Each time Steve reads a question, he will see a list of related questions and navigate to one that he hasn't read yet at random. Steve will stop reading once there are no unread related questions.

Which question should we show first to Steve so that we minimize his total expected reading time? It is guaranteed that there is one unique question that is optimal.

Input Format
Line 1: A single integer, 𝑁
Line 2: 𝑁 integers, 𝑇𝑖
Line 3...𝑁+1: Each line contains two integers 𝐴, 𝐵 indicating that question A and B are related

Output Format
Line 1: A single integer, 𝑋, the best question to show first.

Constraints
1≤𝑁≤105
1≤𝑇𝑖≤106

Sample Input
5
2 2 1 2 2
1 2
2 3
3 4
4 5


Sample Output
3

*/

package org.practice.courses.courseapi.practice12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class RelatedTopics {
    static int dfs(int src, boolean[] visited, HashMap<Integer, Integer> time,
            HashMap<Integer, List<Integer>> adj){
        int sum = 0;
        Stack<Integer> st = new Stack<>();
        visited[src] = true;
        st.push(src);
        while(! st.isEmpty()){
            int poped =st.pop();
            sum += time.get(poped);
            List<Integer> children = adj.get(poped);
            if(children.size() > 0){
                for(int i : children){
                    if(!visited[i]){
                        visited[i] = true;
                        st.push(i);
                    }
                }
            }
        }
        return sum;
    }

    static int cost(int src, HashMap<Integer, Integer> time, HashMap<Integer,
            List<Integer>> adj){
        int cost = Integer.MIN_VALUE;
        boolean[] visited = new boolean[adj.size()];
        visited[src] = true;
        List<Integer> children = adj.get(src);
        if(children.size() > 0){
            for(int i : children){
                int sum = dfs(i, visited, time, adj);
                cost = Math.max(cost , sum);
            }
        }

        return cost + time.get(src);
    }

    static int minCost(HashMap<Integer, Integer> time, HashMap<Integer, List<Integer>> adj) {
        int minCost = Integer.MAX_VALUE;
        int minTopic = -1;

        for(int i = 0 ; i  < adj.size(); i++){
            int cost = cost(i, time, adj);
            System.out.println(i + " : " + cost);
            if(cost < minCost){
                minCost = cost;
                minTopic = i;
            }
        }

        return minTopic;
    }

    public static void main(String[] args){
        HashMap<Integer, Integer> time = new HashMap<>();
        HashMap<Integer, List<Integer>> adj = new HashMap<>();

        time.put(0, 2);
        time.put(1, 2);
        time.put(2, 1);
        time.put(3, 2);
        time.put(4, 2);

        adj.put(0, new ArrayList<>());
        adj.put(1, new ArrayList<>());
        adj.put(2, new ArrayList<>());
        adj.put(3, new ArrayList<>());
        adj.put(4, new ArrayList<>());

        adj.get(0).add(1);
        adj.get(1).add(0);
        adj.get(1).add(2);
        adj.get(2).add(1);
        adj.get(2).add(3);
        adj.get(3).add(2);
        adj.get(3).add(4);
        adj.get(4).add(3);

        for(int i = 0; i < adj.size(); i++){
            System.out.println(adj.get(i)) ;
        }

        System.out.println("min cost" + minCost(time, adj));

    }
}
