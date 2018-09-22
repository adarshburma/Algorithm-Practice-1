package com.iheartmedia.salesforce.config.handler;

import java.util.ArrayList;
import java.util.List;

public class CyclesInDirectedAcyclicGraph {
    enum Color {GRAY, BLACK, WHITE};
    static List<List<Integer>> adj;
    static class Graph{
        int V;


        Graph(int V){
            this.V = V;
            adj = new ArrayList<>();
            for(int i = 0 ; i < V; i++){
                adj.add(new ArrayList<>());
            }
        }
    }

    static void insert(int v, int e){
        if(adj.get(v) != null)
            adj.get(v).add(e);
    }

    static List<Integer> getNeighbours(int v){
        if(adj.get(v) != null)
            return adj.get(v);
        return null;
    }

    static void print(){
        System.out.println(adj);
    }

    static boolean DfsUtil(int v, Color[] color){
        color[v] = Color.GRAY;
        for(int ele: adj.get(v)){
            if (color[ele] == Color.WHITE && DfsUtil(ele, color)){
                return true;
            }

            if(color[ele] == Color.GRAY){
                return true;
            }
        }
        color[v] = Color.BLACK;
        return false;
    }

    static boolean detectExists(Graph g){
        CyclesInDirectedAcyclicGraph.Color[] color = new Color[g.V];
        for(int i = 0 ; i< g.V; i++){
            color[i] = Color.WHITE;
        }

        for(int i=0 ; i < g.V; i++){
            if(DfsUtil(i, color) == true){
                return true;
            }
        }
        return false;
    }

    public static void main(String args[]){
        Graph g = new Graph(4);
        insert(0,2);
        insert(0,1);
        insert(1,2);
        insert(2,3);

        print();

        System.out.println("Cycle Exists ? : " + detectExists(g));
    }
}
