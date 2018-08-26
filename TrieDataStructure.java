import java.util.*;
import java.text.*;
import java.math.*;

public class TrieNode{
  
  char c;
  boolean isLeaf = false;
  HashMap<Character, TrieNode> children = new HashMap<Character, TrieNode>();
  
  TrieNode(){}
  
  TrieNode(char c){
  this.c = c;
  }
  
}

public class Trie{
  TrieNode root;
  
  Trie(){
  root = new TrieNode();
  }
  
  public void insert(String word){
  HashMap<Character, TrieNode> children = root.children;
    
    for(int i=0; i< word.length(); i++){
      char c = word.charAt(i);
      
      TrieNode t;
      if(children.containsKey(c)){
      t = children.get(c);
      }else{
      t = new TrieNode(c);
      children.put(c,t);
      }
      
      children = t.children;
      
      if(i == word.length()-1){
      t.isLeaf = true;
      }
    
    }
  }
  
  public boolean search(String word) {
        TrieNode t = searchNode(word);
 
        if(t != null && t.isLeaf) 
            return true;
        else
            return false;
    }
 
    
  public boolean startsWith(String prefix) {
    if(searchNode(prefix) == null) 
      return false;
    else
      return true;
  }
  
  public TrieNode searchNode(String word){
  HashMap<Character, TrieNode> children = root.children;
    
    TrieNode t = null;
    for(int i=0; i<word.length(); i++){
      char c = word.charAt(i);
      if(children.containsKey(c)){
      t = children.get(c);
        children = t.children;
      }else{
      return null;
      }
    }
    
    return t;
  }

}

public class call{

  public static void main(String args[]){
  Trie t = new Trie();
    t.insert("http://localhost/adarsh");
    t.insert("http://localhost/ashutosh");
    t.insert("http://localhost/ashruddha");
    System.out.println(t.search("http://localhost/ashruddha"));
  
  }

}
