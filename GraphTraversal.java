package org.practice.courses.courseapi;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class GraphTraversal {
    static class Graph{
        int V;
        List<List<Integer>> adj;

        Graph(int v){
            this.V = v;
            adj = new ArrayList<>();
            for(int i = 0; i< V; i++){
                adj.add(new ArrayList<>());
            }
        }

        void addEdge(int v, int e){
            adj.get(v).add(e);
        }

        void print(){
            for(List<Integer> list : adj){
                System.out.println(list);
            }
        }

        List<Integer> getAdjacentChildren(int v){
            return adj.get(v);
        }

    }

    public void DFS(Graph g, int v, boolean[] visited){
        if(visited[v] == true){
            return;
        }

        visited[v] = true;
        System.out.print(v + " -> ");
        List<Integer> children = g.getAdjacentChildren(v);
        for(int child: children){
            DFS(g, child, visited);
        }

    }

    public void BFS(Graph g, int v, int V){
        boolean[] visited = new boolean[V];
        List<Integer> queue = new LinkedList<>();
        visited[v] = true;
        queue.add(v);
        while(queue.size()!= 0){
            int ele = ((LinkedList<Integer>) queue).poll();
            System.out.print(ele + " -> ");
            for(Integer child : g.getAdjacentChildren(ele)){
                if(!visited[child]){
                    visited[child] = true;
                    queue.add(child);
                }
            }
        }
    }

    public void topologicalSort(Graph g){
        List<Integer> queue = new LinkedList<>();
        HashMap<Integer, Integer> map = getInDegree(g);

            for(int v : map.keySet()){
                if(map.get(v) == 0) {
                    queue.add(v);
                }
            }

            List<Integer> result = new ArrayList<>();
            int ctr = 0;
            while(queue.size() != 0){
                int ele = ((LinkedList<Integer>) queue).poll();
                result.add(ele);
                for(int child: g.getAdjacentChildren(ele)){
                    int indegree = map.get(child);
                    if(--indegree == 0){
                        queue.add(child);
                    }
                }
                ctr++;
            }

            if(ctr < g.V){
                System.out.println("Cycle exists .... ");
                return;
            }

            for(int i : result){
                System.out.println(i + " -> ");
            }
    }





    public HashMap<Integer,Integer> getInDegree(Graph g){
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i < g.V; i++){
            int indegree = 0;
            for(List<Integer> ele: g.adj){
                if(ele.contains(i)){
                    indegree++;
                }
            }
            if(!map.containsKey(i)){
                map.put(i, indegree);
            }
        }
        return map;
    }


    public static void main(String args[]){

        GraphTraversal.Graph graph = new Graph(5);
        graph.addEdge(0,1);
        graph.addEdge(0,2);
        graph.addEdge(1,4);
        graph.addEdge(2,3);
       

        graph.print();
        boolean[] visited = new boolean[5];
        for(boolean b: visited){
            b = false;
        }
        GraphTraversal graphTraversal = new GraphTraversal();
        graphTraversal.DFS(graph, 0, visited);
        System.out.println();
        graphTraversal.BFS(graph, 0, 5);
        System.out.println();
        System.out.println("Topological sort: ");
        graphTraversal.topologicalSort(graph);
    }
}
