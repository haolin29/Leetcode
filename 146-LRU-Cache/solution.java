public class LRUCache {
    
    private class Node {
        int val;
        int key;
        Node prev;
        Node next;
        
        Node(int key, int val) {
            this.key = key;
            this.val = val;
            this.prev = null;
            this.next = null;
        }
        
    }
    
    private HashMap<Integer,Node> map = new HashMap<>();
    private int capacity;
    private Node head = new Node(-1,-1);
    private Node tail = new Node(-1,-1);
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        tail.prev = head;
        head.next = tail;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) {
            return -1;
        }
        
        // move to tail
        Node cur = map.get(key);
        if(cur.next != tail) {
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
        
            moveToTail(cur);
        }
        
        return map.get(key).val;
    }
    
    public void set(int key, int value) {
        if(get(key) != -1) {
            map.get(key).val = value;
            return;
        }
        
        if(map.size() == capacity) {
            // remove first one
            map.remove(head.next.key);
            head.next = head.next.next;
            head.next.prev = head;
        }
        
        Node newNode = new Node(key, value);
        map.put(key, newNode);
        moveToTail(newNode);
        
    }
    
    public void moveToTail(Node cur) {
        cur.prev = tail.prev;
        cur.next = tail;
        cur.prev.next = cur;
        tail.prev = cur;
    }
}