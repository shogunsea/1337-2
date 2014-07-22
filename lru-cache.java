// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and set.

// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// set(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.


public class LRUCache {
    private class Node{
    	int key;
    	int value;
    	Node next;
    	Node pre;
    	Node(int key, int value){
    		this.key = key;
    		this.value = value;
    	}
    }

    int capacity;
    Node head;
    Node tail;
    HashMap<Integer, Node> map;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<Integer, Node>();
    }
    
    public int get(int key) {
        if(map.containsKey(key)){
        	Node target = map.get(key);
        	// modify the order in the queue
        	if(target.next == null){
        		if(target.pre == null){
        			// single
        		}else{
        			// target is tail
        			tail = target.pre;
        			target.pre.next = null;
        			head.pre = target;
        			target.next = head;
        			target.pre = null;
        			head = target;
        		}
        	}else{
        		if(target.pre == null){
        			// target is the head
        		}else {
        			// target is in the middle
        			target.next.pre = target.pre;
        			target.pre.next = target.next;
        			head.pre = target;
        			target.next = head;
        			target.pre = null;
        			head = target;
        		}
        	}

        	return target.value;
        }else{
        	return -1;
        }
    }
    
    public void set(int key, int value) {
        if(map.containsKey(key)){
        	// update the node, update position in the list
        	Node oldNode = map.get(key);
        	oldNode.value = value;
        	// modify the order in the queue
        	get(key);
        }else{
    		Node newNode = new Node(key, value);
        	// insert new node
        	if(map.size() >= capacity){
        		// remove tail
        		Node lru = tail;
        		map.remove(lru.key);
        		if(tail.pre == null){
        			// single elem
        			tail = null;
        			head = null;
        		}else{
        			tail = tail.pre;
        			tail.next = null;
        		}
        		// append new node to head
        		map.put(key, newNode);

        		if(head == null){
        			head = newNode;
        			tail = newNode;
        		}else{
        			head.pre = newNode;
        			newNode.next = head;
        			head = newNode;
        		}
        	}else{
        		// append new node to head
        		map.put(key, newNode);
        		if(head == null){
        			// tail is also null
        			head = newNode;
        			tail = newNode;
        		}else{
        			newNode.next = head;
        			head.pre = newNode;
        			head = newNode;
        		}
        	}
        }
    }
}