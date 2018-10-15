package com.iheartmedia.salesforce.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class GraphImpl {
    static class GraphNode{
        int vertices;
        LinkedList<Integer>[] adj;

        GraphNode(int vertices){
            this.vertices = vertices;
            adj = new LinkedList[vertices];

            for(int i = 0 ; i < vertices; i++){
                adj[i] = new LinkedList<>();
            }
        }
    }

    static int[] getInDegreesOfAllVertices(GraphNode g){
        int[] indegree = new int[g.vertices];
        for(int i= 0 ; i < g.vertices; i++){
            indegree[i] = getDegree(i, g);
        }

        return indegree;
    }

    static int getDegree(int v, GraphNode g){
        int degree = 0;
        for(LinkedList list: g.adj){
            if(list.contains(v)){
                degree++;
            }
        }
        return degree;
    }

    static void addEdge(int v, int e, GraphNode g){
        g.adj[v].add(e);
    }

    static LinkedList<Integer> getNeighbours(int v, GraphNode g){
        return g.adj[v];
    }

    static LinkedList<Integer>[] getAdjacencyMatrix(GraphNode g){
        return g.adj;
    }

    static void BFSHelper(int vertex, boolean[] visited, LinkedList<Integer>[] adj){
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(vertex);
        visited[vertex] = true;
        while(!queue.isEmpty()){
            int ele = queue.poll();
            System.out.print(ele + " -> ");
            for(int listEle : adj[ele]){
                if(!visited[listEle]){
                    queue.add(listEle);
                    visited[listEle] = true;
                }
            }
        }
    }

    static void BFS(int vertex, GraphNode g){
        boolean[] visitedBFS = new boolean[g.vertices];
        for(int i = 0 ; i < g.vertices; i++){
            visitedBFS[i] = false;
        }
        BFSHelper(vertex, visitedBFS, g.adj);
    }

    static void DFSHelper(int vertex, boolean[] visited, LinkedList<Integer>[] adj){
        visited[vertex] = true;
        System.out.print(vertex + " -> ");
        LinkedList<Integer> list = adj[vertex];
        for(int i : list){
            if(!visited[i]){
                DFSHelper(i, visited, adj);
            }
        }
    }

    static void printPathsBetweenNodes(int u, int d, GraphNode g){
        boolean[] visited = new boolean[g.vertices];
        ArrayList<Integer> path = new ArrayList<>();
        path.add(u);
        printPathsBetweenHelper(0,3, visited, g.adj, path);
    }

    static void printPathsBetweenHelper(Integer u, Integer d, boolean[] visited, LinkedList<Integer>[] adj, ArrayList<Integer> path){
        visited[u] = true;

        if(u.equals(d)){
            System.out.println(path);
        }

        for (Integer ele : adj[u]){
            if(!visited[ele]){
                path.add(ele);
                printPathsBetweenHelper(ele, d, visited, adj, path);
                path.remove(ele);
            }
        }


        visited[u] = false;
    }


    static public void printAllPaths(int s, int d, GraphNode g)
    {
        boolean[] isVisited = new boolean[g.vertices];
        ArrayList<Integer> pathList = new ArrayList<>();

        //add source to path[]
        pathList.add(s);

        //Call recursive utility
        printAllPathsUtil(s, d, isVisited, pathList, g);
    }

    // A recursive function to print
    // all paths from 'u' to 'd'.
    // isVisited[] keeps track of
    // vertices in current path.
    // localPathList<> stores actual
    // vertices in the current path
    static private void printAllPathsUtil(Integer u, Integer d,
                                   boolean[] isVisited,
                                   List<Integer> localPathList, GraphNode g) {

        // Mark the current node
        isVisited[u] = true;

        if (u.equals(d))
        {
            System.out.println(localPathList);
        }

        // Recur for all the vertices
        // adjacent to current vertex
        for (Integer i : g.adj[u])
        {
            if (!isVisited[i])
            {
                // store current node
                // in path[]
                localPathList.add(i);
                printAllPathsUtil(i, d, isVisited, localPathList, g);

                // remove current node
                // in path[]
                localPathList.remove(i);
            }
        }

        // Mark the current node
        isVisited[u] = false;
    }

    static void DFS(GraphNode g, int vertex){
        boolean[] visited = new boolean[g.vertices];
        for(int i = 0 ; i < g.vertices; i++){
            visited[i] = false;
        }

        DFSHelper(vertex, visited, g.adj);
    }

    static void printElementsBetweenNodes(int s, int d, GraphNode g){
        boolean[] visited = new boolean[g.vertices];
        ArrayList<Integer> path = new ArrayList<>();
        path.add(s);
        printElementsHelper(s,d,visited,g.adj,path);
    }

    static void printElementsHelper(Integer s, Integer d, boolean[] visited, LinkedList<Integer>[] adj, ArrayList<Integer> path){
        visited[s] = true;
        if(s.equals(d)){
            System.out.println(path);
        }

        for(Integer ele : adj[s]){
            if(!visited[ele]){
                path.add(ele);
                printPathsBetweenHelper(s,d,visited, adj, path);
                path.remove(ele);
            }
        }

        visited[s] = false;
    }



    public static void main(String[] args){
        GraphNode g = new GraphNode(4);
        addEdge(0,1, g);
        addEdge(0,2, g);
        addEdge(0,3, g);
        addEdge(2,0, g);
        addEdge(2,1, g);
        addEdge(1,3, g);

        for(LinkedList<Integer> list : getAdjacencyMatrix(g)){
            System.out.println(list);
        }

        int ctr = 0;
        for(int indegree: getInDegreesOfAllVertices(g)){
            System.out.println(ctr + " : " + indegree);
            ctr++;
        }

        System.out.println("DFS traversal :");
        DFS(g,0);

        System.out.println("BFS traversal :");
        BFS(0, g);

        System.out.println("Print paths between nodes");
        printElementsBetweenNodes(2,3, g);
    }
}
