package org.practice.courses.courseapi.practice12;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class AutoComplete {

     class Node{
        String prefix;
        HashMap<Character, Node> children;
        boolean isWord;

        Node(String prefix){
            this.prefix = prefix;
            children = new HashMap<>();
        }
    }

    private Node trie;
    public AutoComplete(String[] dict){
        trie = new Node("");
        for(String s : dict){
            insertWord(s)   ;
        }
    }

    private void insertWord(String word){
        Node curr = trie;
        for(int i = 0 ; i < word.length(); i++){
            if(!curr.children.containsKey(word.charAt(i))) {
                curr.children.put(word.charAt(i), new Node(word.substring(0,i+1)));
            }
            curr = curr.children.get(word.charAt(i));
            if(i == word.length()-1){
                curr.isWord = true;
            }
        }
    }

    private List<String> getWordsForPrefix(String pre){
        List<String> results = new ArrayList<>();
        Node curr = trie;
        for(char c : pre.toCharArray()){
            if(curr.children.containsKey(c)){
                curr = curr.children.get(c);
            } else {
                return results;
            }
        }

        findAllWords(curr, results);
        return results;
    }

    private void findAllWords(Node curr, List<String> results){
        if(curr.isWord) {
            results.add(curr.prefix);
        }

        for(char c : curr.children.keySet()){
            findAllWords(curr.children.get(c), results);
        }
    }

    public static void main(String[] args){
        String[] dictionary = new String[] {"abc", "acd", "bcd", "def", "a", "aba"};
        AutoComplete autoComplete = new AutoComplete(dictionary);
        System.out.print(autoComplete.getWordsForPrefix("a"));
    }
}
