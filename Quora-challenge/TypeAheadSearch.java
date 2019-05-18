/*

The search bar at the top of every page on Quora allows you to search the most up-to-date people, topics and questions on our site.  

We want to quickly return the most relevant results that match the search query entered into the input text field.  Every time a new user, question or topic is added (or old ones deleted), subsequent queries must reflect those changes immediately.  We currently use a fast in-memory service to handle this. 

Input comes into the service as the following commands:
ADD <type> <id> <score> <data string that can contain spaces>
Adds the following <type> of item (user | topic | question | board) with the unique <id> string and <score> float, corresponding to the <data string> that would be used to match queries.
DEL <id>
Deletes the item specified by unique identifier <id>.
QUERY <number of results> <query string that can contain spaces>
Queries for the specified integer number of results (up to 20) that match a given query string.  For a data item to be considered a matching result to a query, each token in the query must be found in the data string as a case-insensitive prefix to any token in the data string. The results are ranked in descending order of score, and we only take the top few results as specified. When there is a tie in the score, newer items (more recently added) should be ranked higher.  If there are no results, just output the empty string on that line.
WQUERY <number of results> <number of boosts> (<type>:<boost>)* (<id>:<boost>)* <query string that can contain spaces>
Same as QUERY, except that instead of using the raw input score specified by ADD for the particular item, the scores are weighted by the optional number of boosting factors.  The boosts are floats that should be multiplied to the raw score, and affect either whole types, or specific items with the given <id>s.  If there are multiple boosts applicable, they each are multiplied commutatively to the raw score.

Your task will be to write an equivalent service as a standalone program, with input files that correspond to the queries and updates to the data, and expected output files that correspond to the results obtained for each query.

Input format (read from STDIN):
Your program will be given an integer N on the first line of stdin, followed by N lines of the form:

<command> <command data>

The input commands are: ADD | DEL | QUERY | WQUERY
Types are: user | topic | question | board
Ids are alphanumeric strings without spaces or punctuation and will not include the same strings used for types.
Data strings can be any ASCII character, but are delimited by spaces or tabs. We will not be using anything special unprintable characters or \r and \n in the data string.

Command data for each command is as specified above.  For example:

15
ADD user u1 1.0 Adam D’Angelo
ADD user u2 1.0 Adam Black
ADD topic t1 0.8 Adam D’Angelo
ADD question q1 0.5 What does Adam D’Angelo do at Quora?
ADD question q2 0.5 How did Adam D’Angelo learn programming?
QUERY 10 Adam
QUERY 10 Adam D’A
QUERY 10 Adam Cheever
QUERY 10 LEARN how
QUERY 1 lear H
QUERY 0 lea
WQUERY 10 0 Adam D’A
WQUERY 2 1 topic:9.99 Adam D’A
DEL u2
QUERY 2 Adam


Output format (write to STDOUT):
For each QUERY and WQUERY command, you should output the following line:

<sorted result ids>

Where each line contains the <id>s in descending score order, up to the required number of results, as specified above according to the QUERY and WQUERY commands.  If there are no matches, output the empty line.  For example:

u2 u1 t1 q2 q1
u1 t1 q2 q1
 
q2
q2
 
u1 t1 q2 q1
t1 u1
u1 t1

*/

package org.practice.courses.courseapi.practice12;

import java.util.*;

public class TypeAheadSearch {
   static class TrieNode {
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;

        TrieNode() {}
        TrieNode(char c){
            this.c = c;
        }
    }

    static class Trie{
       TrieNode root;

       Trie(){
           root = new TrieNode();
       }

       void insert(String str){
           HashMap<Character, TrieNode> children = root.children;
           TrieNode t = null;
           for(int i = 0 ; i < str.length(); i++){
               char c = str.charAt(i);
               if(children.containsKey(c)){
                   t = children.get(c);
               } else {
                   t = new TrieNode(c);
                   children.put(c, t);
               }

               children = t.children;
               if(i == str.length()){
                   t.isEnd = true;
               }
           }
       }

        TrieNode searchNode(String str){
           HashMap<Character, TrieNode> children = root.children;
           TrieNode t = null;
           for(int i = 0; i < str.length(); i++){
               char c = str.charAt(i);
               if(children.containsKey(c)){
                   t = children.get(c);
               } else {
                   return null;
               }

               children = t.children;
           }

           return t;
       }

       boolean search(String str){
           TrieNode t = searchNode(str);
           return t != null;
       }
    }

    static class Node{
       String type;
       float score;
       Trie trie;
       String label;

       Node(){}

       Node(String type, String score, List<String> content, String label){
           this.type = type;
           this.score = Float.parseFloat(score);
           this.trie = new Trie();
           for(String s : content){
               this.trie.insert(s.toLowerCase());
           }
           this.label = label;
       }
    }

    static void add(String[] split){
       List<String> content = new ArrayList<>();
       for(int i = 4 ; i < split.length; i++){
           content.add(split[i]);
       }
       String label = split[2];
       Node node = new Node(split[1], split[3], content ,label);
       cache.put(node, label);

    }

    static TreeMap<Node, String> cache = new TreeMap<>(new Comparator<Node>() {
        @Override
        public int compare(Node o1, Node o2) {
            if(o1.score > o2.score){
                return -1;
            } else {
                return 1;
            }
        }
    });

   static void delete(String label){
       TreeMap<Node, String> newCache = new TreeMap<>(new Comparator<Node>() {
           @Override
           public int compare(Node o1, Node o2) {
               if(o1.score > o2.score){
                   return -1;
               } else {
                   return 1;
               }
           }
       });
       for(Node node : cache.keySet()){
           if(node.label.equals(label)){
               continue;
           }
           newCache.put(node, node.label);
       }

       cache.clear();
       cache = newCache;
   }

   static List<String> query(int count, String[] queryStrings){
       List<String> labels = new ArrayList<>();
       for(Node node : cache.keySet()){
           int strCount = 0;
           for(String s : queryStrings){
               if(node.trie.search(s.toLowerCase())){
                   strCount++;
               }
           }

           if(strCount == queryStrings.length && labels.size() < count) {
               labels.add(node.label);
           }
       }

       return labels;
   }

   static class WeightedNode{
       String type;
       float score;
       Trie trie;
       String label;

       WeightedNode(){}

       WeightedNode(String type, float score, Trie trie, String label){
           this.type = type;
           this.score = score;
           this.trie = trie;
           this.label = label;
       }
   }
   static List<String> weightedQuery(int count, String topic, float weight, String[] queryStrings){
       List<String> labels = new ArrayList<>();
       TreeMap<WeightedNode, String> weightedCache = new TreeMap<>(new Comparator<WeightedNode>() {
           @Override
           public int compare(WeightedNode o1, WeightedNode o2) {
               if(o1.score < o2.score){
                   return 1;
               } else {
                   return -1;
               }
           }
       });

       for(Node node : cache.keySet()){
           WeightedNode wn = new WeightedNode(node.type, node.score, node.trie, node.label);
           if(node.type.equals(topic)){
               wn.score  = wn.score * weight;
               weightedCache.put(wn, wn.label);
           } else {
               weightedCache.put(wn, wn.label);
           }
       }

       for(WeightedNode node : weightedCache.keySet()){
           int strCount = 0;
           for(String s : queryStrings){
               if(node.trie.search(s.toLowerCase())){
                   strCount++;
               }
           }

           if(strCount == queryStrings.length && labels.size() < count) {
               labels.add(node.label);
           }
       }
       return labels;
   }

    static void printTrie(Trie trie){
        HashMap<Character, TrieNode> children = trie.root.children;
        TrieNode t;
        LinkedList<TrieNode> queue = new LinkedList<>();
        queue.addLast(trie.root);
        while(!queue.isEmpty()){
            TrieNode pop = queue.removeFirst();
            System.out.println(pop.c);
            for(char c : pop.children.keySet()){
                queue.addFirst(pop.children.get(c));
            }
        }
    }

   public static void main(String[] args){
       String[] add1 = "ADD user u1 1.0 Adam D’Angelo".split(" ");
       add(add1);
       String[] add2 = "ADD user u2 1.0 Adam Black".split(" ");
       add(add2);
       String[] add3 = "ADD topic t1 0.8 Adam D’Angelo".split(" ");
       add(add3);
       String[] add4 = "ADD question q1 0.5 What does Adam D’Angelo do at Quora?".split(" ");
       add(add4);
       String[] add5 = "ADD question q2 0.5 How did Adam D’Angelo learn programming?".split(" ");
       add(add5);

       System.out.println(query(10, new String[] {"Adam"}));
       System.out.println(query(10, new String[] {"Adam" , "D’A"}));
       System.out.println(query(10, new String[] {"Adam" , "Cheever"}));
       System.out.println(query(10, new String[] {"LEARN" , "how"}));
       System.out.println(query(1, new String[] {"lear" , "H"}));
       System.out.println(query(0, new String[] {"lea"}));

       // static List<String> weightedQuery(int count, String topic, float weight, String[] queryStrings){
       System.out.println(weightedQuery(2, "topic", 9.99f, new String[] {"Adam", "D’A"} ));
       delete("u2");
       System.out.println(query(2, new String[]{"Adam"}));
   }

}

