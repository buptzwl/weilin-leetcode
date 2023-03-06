package hot100;

public class LRU {
    // 设计一个lru
    // 什么是lru
    // lru是一种缓存淘汰策略
    // 当缓存满了的时候，会淘汰最近最少使用的数据
    // 也就是说，如果数据最近被访问过，那么将来被访问的几率也更高
    // 所以我们可以用一个队列来存储缓存
    // 当缓存满了的时候，我们就把队列的头部删除
    // 然后把新的数据放到队列的尾部
    // 这样就可以保证队列的头部是最近最少使用的数据
    // 当我们访问一个数据的时候，我们就把这个数据放到队列的尾部
    // 这样就可以保证队列的尾部是最近最常使用的数据
    // 这样我们就可以用一个队列来实现lru缓存淘汰策略
    // 但是这样的话，我们就需要遍历队列来判断数据是否存在
    // 这样的话时间复杂度就是O(n)
    // 我们可以用一个哈希表来存储数据和数据在队列中的位置
    // 这样我们就可以在O(1)的时间复杂度内判断数据是否存在
    // 但是这样的话，我们就需要维护两个数据结构
    // 一个是队列，一个是哈希表
    private int capacity;
    private int size;
    private Node head;
    private Node tail;
    private Map<Integer,Node> map;
    private class Node{
        int key;
        int value;
        Node prev;
        Node next;
        public Node(int key,int value){
            this.key = key;
            this.value = value;
        }
    }
    public LRU(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        this.head.next = tail;
        this.tail.prev = head;
        this.map = new HashMap<>();
    }
    public int get(int key){
        if(!map.containsKey(key)){
            return -1;
        }
        Node node = map.get(key);
        moveToTail(node);
        return node.value;
    }
    public void put(int key,int value){
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.value = value;
            moveToTail(node);
        }else{
            Node node = new Node(key,value);
            map.put(key,node);
            addToTail(node);
            size++;
            if(size>capacity){
                Node head = removeHead();
                map.remove(head.key);
                size--;
            }
        }
    }
    private void moveToTail(Node node){
        removeNode(node);
        addToTail(node);
    }
    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    private void addToTail(Node node){
        node.prev = tail.prev;
        node.next = tail;
        tail.prev.next = node;
        tail.prev = node;   
    }
    private Node removeHead(){
        Node node = head.next;
        removeNode(node);
        return node;
    }
}
