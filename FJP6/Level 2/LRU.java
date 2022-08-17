class LRUCache {
    class Node{
        int key,val;
        Node next,prev;
        Node(int k,int v){
            key = k;
            val = v;
        }
    }
    Node head,tail;
    int size;
    
    public void addFirst(Node node){
        if(head == null && tail ==  null){
            head = tail = node;
        }else{
            node.next = head;
            head.prev = node;
            head = node;
        }
        size++;
    }
    public void removeNode(Node node){
        if(node.next == null && node.prev == null){
            head = tail = null;
        }else if(size > 1){
            if(node.next == null){ // tail
                tail = node.prev;
                tail.next = node.prev = null;
            }else if(node.prev == null){ // head
                head = node.next;
                head.prev = node.next = null;
            }else{ 
                Node pnode = node.prev;
                Node nnode = node.next;
                
                pnode.next = nnode;
                nnode.prev = pnode;
                nnode.next = nnode.prev = null;
            }
        }
        size--;
    }
    public void moveToFront(Node node){
        removeNode(node);
        addFirst(node);
    }
    HashMap<Integer,Node> cache;
    int cap;
    public LRUCache(int capacity) {
        head = tail = null;
        size = 0;
        cache = new HashMap<>();
        cap = capacity;
    }
    
    public int get(int key) {
        Node node = cache.get(key);
        if(node == null){
            return -1;
        }else{
            moveToFront(node);
            return node.val;
        }
    }
    
    public void put(int key, int value) {
        Node node = cache.get(key);
        if(node != null){
            node.val = value; // update
            moveToFront(node);
        }else{
            Node nnode = new Node(key,value);
            if(size == cap){
                Node lrunode = tail;
                removeNode(lrunode);
                cache.remove(lrunode.key);
            }
            cache.put(key,nnode);
            addFirst(nnode);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */