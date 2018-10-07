class LRUCache {
    
    static class Node{
        int key;
        int val;
        Node pre;
        Node next;
        
        Node(int key, int val){
            this.key = key;
            this.val = val;
        }
    }
    
    HashMap<Integer, Node> map = new HashMap<>();
    int capacity;
    Node head;
    Node end;

    public LRUCache(int capacity) {
         this.capacity = capacity;
    }
    
    public void remove(Node n){
        if(n.pre != null){
            n.pre.next = n.next;
        }else{
            head = n.next;
        }
        
        if(n.next != null){
            n.next.pre = n.pre;
        }else{
            end = n.pre;
        }
    }
    
    public void setHead(Node n){
        n.next = head;
        n.pre = null;
        if(head != null){
            head.pre = n;
        }
        head = n;
        if(end == null){
            end = head;
        }
    }
    
     public int get(int key) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            remove(n);
            setHead(n);
            return n.val;
        } 
        return -1;
     }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node n = map.get(key);
            n.val = value;
            remove(n);
            setHead(n);
        }else{
            Node created = new Node(key,value);
            if(map.size() >= capacity){
                map.remove(end.key);
                remove(end);
                setHead(created);
            } else {
                setHead(created);
            }
            map.put(key, created);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
