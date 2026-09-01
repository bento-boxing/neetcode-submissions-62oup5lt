class MyHashMap {
    private class MapNode {
        private MapNode prev;
        private int key;
        private int value;
        private MapNode next;

        private MapNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private MapNode[] map = new MapNode[10000];

    public MyHashMap() {}
    
    public void put(int key, int value) {
        MapNode node = map[hashFunction(key)];
        MapNode newNode = new MapNode(key, value);

        if(node == null) {
            map[hashFunction(key)] = newNode;
        } else {
            while(node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                } else {
                    node = node.next;
                }
            }

            node = map[hashFunction(key)];
            node.prev = newNode;
            newNode.next = node;
            map[hashFunction(key)] = newNode;
        }
    }
    
    public int get(int key) {
        MapNode node = map[hashFunction(key)];
        if(node == null) {
            return -1;
        }

        while(node != null) {
            if (node.key == key) {
                return node.value;
            } else {
                node = node.next;
            }
        }

        return -1;
    }
    
    public void remove(int key) {
        MapNode node = map[hashFunction(key)];
        if(node == null) {
            return;
        }

        while(node != null) {
            if (node.key == key) {
                if(node.prev == null && node.next == null) {
                    map[hashFunction(key)] = null;
                } else if(node.prev == null && node.next != null) {
                    map[hashFunction(key)] = node.next;
                } else if (node.prev != null && node.next == null) {
                    node.prev.next = null;
                    node.prev = null;
                } else {
                    node.prev.next = node.next;
                    node.next.prev = node.prev;
                }
                return;
            } else {
                node = node.next;
            }
        }
    }

    private int hashFunction(int key) {
        return key % 10000;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */