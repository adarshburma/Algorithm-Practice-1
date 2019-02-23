package com.iheartmedia.programmatic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class BoggleBoard {
    static TrieNode root ;

    static class TrieNode{
        char c;
        HashMap<Character, TrieNode> children = new HashMap<>();
        boolean isWord;

        public TrieNode(){}

        public TrieNode(char c){
            this.c = c;
            this.isWord = false;
        }
    }

    public static void dfs(char[][] board, int i, int j, boolean[][] visited, Trie trie, StringBuilder sb, List<String> res) {

        TrieNode t = trie.searchNode(sb.toString());
        if (t != null && t.isWord && !res.contains(sb.toString())) {
            res.add(sb.toString());
        }

        if (isValid(i, j, board, visited)) {
            visited[i][j] = true;
            sb.append(board[i][j]);
            if (isValid(i + 1, j + 1, board, visited)) {
                dfs(board, i + 1, j + 1, visited, trie, sb, res);
            }

            if (isValid(i, j + 1, board, visited)) {
                dfs(board, i, j + 1, visited, trie, sb, res);
            }

            if (isValid(i - 1, j + 1, board, visited)) {
                dfs(board, i - 1, j + 1, visited, trie, sb, res);
            }

            if (isValid(i + 1, j, board, visited)) {
                dfs(board, i + 1, j, visited, trie, sb, res);
            }

            if (isValid(i + 1, j - 1, board, visited)) {
                dfs(board, i + 1, j - 1, visited, trie, sb, res);
            }

            if (isValid(i, j - 1, board, visited)) {
                dfs(board, i, j - 1, visited, trie, sb, res);
            }

            if (isValid(i - 1, j - 1, board, visited)) {
                dfs(board, i - 1, j - 1, visited, trie, sb, res);
            }

            if (isValid(i - 1, j, board, visited)) {
                dfs(board, i - 1, j, visited, trie, sb, res);
            }
            visited[i][j] = false;
            sb.deleteCharAt(sb.length()-1);
        }
    }




    public static boolean isValid(int i, int j, char[][] board, boolean[][] visited){
        return i >= 0 && j >= 0 && i < board.length && j < board[0].length && !visited[i][j];

    }

    public static List<String> boggleSearch(List<String> dict, char[][] boggle, Trie trie){

        List<String> res = new ArrayList<>();

        for(String word : dict){
            trie.insertWord(word);
        }

        int rows = boggle.length;
        int cols = boggle[0].length;
        boolean[][] visited = new boolean[rows][cols];
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < rows; i++){
            for(int j = 0 ; j < cols; j++){
                dfs(boggle, i, j, visited, trie, sb, res);
                sb.setLength(0);
            }
        }

        return res;
    }

    public static class Trie{


        public Trie(){
            root = new TrieNode();
        }

        public void insertWord(String str){
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

                if(i == str.length()-1){
                    t.isWord = true;
                }
            }
        }

        public TrieNode searchNode(String str){
            TrieNode t = null;
            HashMap<Character, TrieNode> children = root.children;
            for(int i = 0 ; i< str.length(); i++){
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

        public boolean searchPartialString(String str){
            TrieNode t = searchNode(str);

            if(t != null){
                return true;
            }
            return false;
        }

        public boolean searchString(String str){
            TrieNode t = searchNode(str);
            if(t == null){
                return false;
            }
            return t.isWord;
        }


    }

    public static void main(String[] args){
        Trie trie = new Trie();
        List<String> dict = Arrays.asList(new String[] {"GEEKS", "FOR", "QUIZ", "GO"});
        char[][] boggle = { {'G','I','Z'},
                            {'U','E','K'},
                            {'Q','S','E'}
                          };

        for(String word : boggleSearch(dict, boggle, trie)){
            System.out.print(word + " ");
        }
    }
}
