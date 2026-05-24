class LFUCache {
    class Node{
        int key,value,cnt;
        Node next,prev;
        Node(int key,int value){
             this.key=key;
             this.value=value;
             cnt=1;
        }

    }
    class List{
        int size;
        Node head=new Node(-1,-1);
        Node tail=new Node(-1,-1);
        List(){
            head.next=tail;
            tail.prev=head;
            size=0;
        }
    public void addFront(Node node){
        node.next=head.next;
        node.prev=head;
        head.next.prev=node;
        head.next=node;
        size++;

    }
    public void remove(Node delNode){
        delNode.next.prev=delNode.prev;
        delNode.prev.next=delNode.next;
        size--;
    }
    }
    HashMap<Integer,Node> keyNode;
    HashMap<Integer,List> freqListMap;
    int maxSizeCache;
    int minFreq;
    int curSize;
    public LFUCache(int capacity) {
        keyNode = new HashMap<>();
        freqListMap = new HashMap<>();
        maxSizeCache=capacity;
        this.minFreq=0;
        this.curSize=0;
    }
    private void updateFreq(Node node) {
        int freq = node.cnt;
        List oldList = freqListMap.get(freq);
        oldList.remove(node);
        // update minFreq
        if (freq == minFreq && oldList.size == 0) {
            minFreq++;
        }
        node.cnt++;
        List newList = freqListMap.getOrDefault(node.cnt, new List());
        newList.addFront(node);
        freqListMap.put(node.cnt, newList);
    }
    
    public int get(int key) {
        if (!keyNode.containsKey(key)) {
            return -1;
        }
        Node node = keyNode.get(key);
        updateFreq(node);
        return node.value;
    }
    
    public void put(int key, int value) {
        if (maxSizeCache == 0) return;

        // already exists
        if (keyNode.containsKey(key)) {

            Node node = keyNode.get(key);

            node.value = value;

            updateFreq(node);

            return;
        }

        // full cache
        if (curSize == maxSizeCache) {

            List list = freqListMap.get(minFreq);

            Node nodeToRemove = list.tail.prev;

            list.remove(nodeToRemove);

            keyNode.remove(nodeToRemove.key);

            curSize--;
        }

        // insert new node
        curSize++;

        minFreq = 1;

        List listFreq = freqListMap.getOrDefault(1, new List());

        Node newNode = new Node(key, value);

        listFreq.addFront(newNode);

        freqListMap.put(1, listFreq);

        keyNode.put(key, newNode);
    }
} 


/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */