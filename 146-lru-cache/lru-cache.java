import java.util.*;

class LRUCache {

    class ListNode {
        int key, value;
        ListNode prev, next;

        ListNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    int capacity;
    HashMap<Integer, ListNode> map;

    ListNode head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new ListNode(-1, -1); // dummy head
        tail = new ListNode(-1, -1); // dummy tail

        head.next = tail;
        tail.prev = head;
    }

    // remove node from DLL
    private void deleteNode(ListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // insert right after head (MRU position)
    private void insertFront(ListNode node) {
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    // get value
    public int get(int key) {
        if (!map.containsKey(key)) return -1;

        ListNode node = map.get(key);

        deleteNode(node);
        insertFront(node);

        return node.value;
    }

    // put value
    public void put(int key, int value) {

        if (map.containsKey(key)) {
            ListNode node = map.get(key);
            node.value = value;

            deleteNode(node);
            insertFront(node);
            return;
        }

        if (map.size() == capacity) {
            ListNode lru = tail.prev;

            deleteNode(lru);
            map.remove(lru.key);
        }

        ListNode newNode = new ListNode(key, value);
        insertFront(newNode);
        map.put(key, newNode);
    }
}