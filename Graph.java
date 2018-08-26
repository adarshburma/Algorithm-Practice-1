import java.lang.Math; 
import java.util.*;

public class Graph{
public int nvertices;
public ArrayList<LinkedList<Integer>> adj = new ArrayList<LinkedList<Integer>>();
public Graph(int vertices){
nvertices = vertices;
for(int i=0; i<vertices; i++){
adj.add(new LinkedList<Integer>());
}
}
public void add(int v, int w){
adj.get(v).add(w);
}
  
  public void BFS(int s){
boolean[] visited = new boolean[nvertices];
//BFS Queue
LinkedList<Integer> queue = new LinkedList<Integer>();
visited[s] = true;
queue.add(s);
while(queue.size() != 0){
s = queue.poll();
System.out.println(s + " ");
Iterator<Integer> i = adj.get(s).iterator();
while(i.hasNext()){
int ele = i.next();
if(visited[ele] != true){
visited[ele] = true;
queue.add(ele);
}
}
 }
}
  
  public void DFSUtil(int n, boolean[] visited){
  visited[n] = true;
    System.out.println(n + "\n");
    Iterator<Integer> i = adj.get(n).iterator();
    while(i.hasNext()){
      int ele = i.next();
      if(visited[ele] != true){
        DFSUtil(ele , visited);
      }
    }  
  }
  
  public void DFS(int s){
   	boolean[] visited = new boolean[nvertices];
    DFSUtil(s,visited);
  }  

}

 
public class Call{
public static void main(String args[]){
Graph g = new Graph(4);
g.add(0,1);
g.add(0,2);
g.add(1,3);
g.add(1,2);
g.add(2,3);
      
      for(LinkedList<Integer> i : g.adj){
      System.out.println(i + "\n");
      }
      
      g.BFS(0);
      g.DFS(0);
      
}
}
