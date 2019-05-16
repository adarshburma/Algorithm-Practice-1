package com.iheartmedia.inventory.cassandra.exception;

/*

Design a system that allows for fast searches of questions under topics. There are 𝑁 topics, 𝑀 questions, and 𝐾 queries, given in this order. Each query has a desired topic as well as a desired string prefix. For each query, return the number of questions that fall under the queried topic and begin with the desired string. When considering topics, we want to include all descendants of the queried topic as well as the queried topic itself. In other words, each query searches over the subtree of the topic.

The topic ontology is given in the form of a flattened tree of topic names, where each topic may optionally have children. If a topic has children, they are listed after it within parentheses, and those topics may have children of their own, etc. See the sample for the exact input format. The tree is guaranteed to have a single root topic.

For ease of parsing, each topic name will be composed of English alphabetical characters, and each question and query text will be composed of English alphabetical characters, spaces, and question marks. Each question and query text will be well behaved: there will be no consecutive spaces or leading/trailing spaces. All queries, however, are case sensitive.

Constraints
For 100% of the test data, 1≤𝑁,𝑀,𝐾≤105 and the input file is smaller than 5MB
For 50% of the test data, 1≤𝑁,𝑀,𝐾≤2⋅104 and the input file is smaller than 1MB

Input Format
Line 1: One integer 𝑁
Line 2: 𝑁 topics arranged in a flat tree (see sample)
Line 3: One integer 𝑀
Line 4...M+3: Each line contains a topic name, followed by a colon and a space, and then the question text.
Line M+4: One integer 𝐾
Line M+5...M+K+4: Each line contains a topic name, followed by a space, and then the query text.

Output Format
Line 1...K: Line 𝑖 should contain the answer for the 𝑖th query.

Sample Input
6
Animals ( Reptiles Birds ( Eagles Pigeons Crows ) )
5
Reptiles: Why are many reptiles green?
Birds: How do birds fly?
Eagles: How endangered are eagles?
Pigeons: Where in the world are pigeons most densely populated?
Eagles: Where do most eagles live?
4
Eagles How en
Birds Where
Reptiles Why do
Animals Wh


Sample Output
1
2
0
3

*/



import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class Ontology {

    static HashMap<String, List<TopicNode>> topics = new HashMap<>();
    static TopicNode root;
    static class TopicNode{
        String topic;
        Trie topicTrie;
        HashMap<String,  TopicNode> children = new HashMap<>();

        TopicNode(String topic) {
            this.topic = topic;
        }
    }

    static void addTopic(String parent, String topic){
        if(root == null){
            root = new TopicNode(topic);
        }

        if(root.topic.equals(parent)){
            root.children.put(topic, new TopicNode(topic));
        } else {
            TopicNode parentNode = bfs(parent);
            if(parentNode != null){
                parentNode.children.put(topic, new TopicNode(topic));
            }

        }
    }

    static int findQuery(String topic, String query) {
        int level = 0;
        TopicNode searchRoot = bfs(topic);
        LinkedList<TopicNode> queue = new LinkedList<>();
        queue.addLast(searchRoot);
        while(!queue.isEmpty()){
            TopicNode pop = queue.removeFirst();
            System.out.println("topic : " + pop.topic + " search query: " + (pop.topicTrie != null ? pop.topicTrie.searchString(query) : "null"));
            if(pop.topicTrie != null && pop.topicTrie.searchString(query)){
                level++;
            }
            for(String topicKey : pop.children.keySet()){
                queue.addLast(pop.children.get(topicKey));
            }
        }

        return level;
    }

    static Trie getTrie(String topic){
        return bfs(topic).topicTrie;
    }

    static void addTrie(String topic, String str){
        TopicNode node = bfs(topic);
        if(node != null){
            if(node.topicTrie == null){
                node.topicTrie = new Trie();
                node.topicTrie.insert(str);
            } else {
                node.topicTrie.insert(str);
            }
        }
    }

    static TopicNode bfs(String node){
        LinkedList<TopicNode> queue = new LinkedList<>();
        queue.addLast(root);
        while(! queue.isEmpty()){
            TopicNode pop = queue.removeFirst();
            if(pop.topic.equals(node)){
                return pop;
            } else {
                if(pop.children.size() > 0) {
                    if(pop.children.containsKey(node)){
                        return pop.children.get(node);
                    } else {
                        for(String topicKey : pop.children.keySet()){
                            queue.addLast(pop.children.get(topicKey));
                        }
                    }
                }

            }
        }

        return null;
    }

    static class TrieNode{
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isEnd;

        TrieNode(){}

        TrieNode(char c) {
            this.c = c;
        }
    }

    static class Trie{
         TrieNode root;

        Trie(){
            root = new TrieNode();
        }

         void insert(String str){
            HashMap<Character,TrieNode> children = root.children;
            TrieNode t;
            for(int i = 0 ; i < str.length(); i++){
                char c = str.charAt(i);
                if(children.containsKey(c)){
                    t = children.get(c);

                } else {
                    t = new TrieNode(c);
                    children.put(c, t);
                }
                children = t.children;

                if(i == str.length()-1){
                    t.isEnd = true;
                }
            }
        }

         TrieNode searchNode(String str){
            HashMap<Character, TrieNode> children = root.children;
            TrieNode t = null;
            for(int i = 0 ;i < str.length(); i++){
                char c = str.charAt(i);
                if(children.containsKey(c)){
                    t = children.get(c);
                    children = t.children;
                } else {
                    return null;
                }
            }

            return t;
        }

         boolean searchString(String str){
            return searchNode(str) != null;
        }

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
        //add topics
        addTopic(null, "animals");
        addTopic("animals", "reptiles");
        addTopic("animals", "birds");
        addTopic("birds", "eagles");
        addTopic("birds", "pigeons");
        addTopic("birds", "crows");

        //populate tries
        addTrie("reptiles", "Why are many reptiles green?");
        addTrie("birds", "How do birds fly?");
        addTrie("eagles", "How endangered are eagles?");
        addTrie("pigeons", "Where in the world are pigeons most densely populated?");
        addTrie("eagles", "Where do most eagles live?");


        // fire queries
        System.out.println(findQuery("eagles", "How en"));
        System.out.println(findQuery("birds", "Where"));
        System.out.println(findQuery("reptiles", "Why do"));
        System.out.println(findQuery("animals", "Wh"));

        printTrie(getTrie("eagles"));


    }
}
