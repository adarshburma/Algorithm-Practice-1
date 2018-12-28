package org.practice.courses.courseapi.practice12;

import java.util.*;

public class ShortestPath {
    static class Node{
        int val;
        List<Node> next;
        Node(int val){
            next = new ArrayList<>();
            this.val = val;
        }
    }

    static List<Node> shortestPath(Node a, Node b){
        if(a == null || b == null){
            return null;
        }

        List<Node> res = new ArrayList<>();
        Queue<Node> toVisit = new LinkedList<>();
        HashMap<Node, Node> parents = new HashMap<>();
        toVisit.add(a);
        parents.put(a, null);

        while(!toVisit.isEmpty()){
            Node curr = toVisit.remove();

            if(b == curr){
                break;
            }

            for(Node n : curr.next){
                if(!parents.containsKey(n)){
                    toVisit.add(n);
                    parents.put(n, curr);
                }
            }
        }

        if(parents.get(b) == null){
            return null;
        }
        Node curr = b;
        while(curr != null) {
            res.add(0, curr);
            curr = parents.get(curr);
        }
        return res;
    }

    public static void main(String[] args){
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        Node node5 = new Node(5);

        // define node connections
        node1.next.addAll(Arrays.asList(node2, node3));
        node2.next.addAll(Arrays.asList(node5));
        node4.next.addAll(Arrays.asList(node1, node3));
        node5.next.addAll(Arrays.asList(node4));

        List<Node> res = shortestPath(node2, node3);
        for(Node n : res){
            System.out.print(n.val + " -> ");
        }
    }
}
