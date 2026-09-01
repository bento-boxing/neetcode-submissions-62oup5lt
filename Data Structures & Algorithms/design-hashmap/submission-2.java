class MyHashMap {
    private class MapNode {
        private int key;
        private int value;
        private MapNode next;

        private MapNode(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }
    private MapNode[] map = new MapNode[1000];

    public MyHashMap() {
        for(int i = 0; i < map.length; i++) {
            map[i] = new MapNode(-1, -1);
        }
    }
    
    public void put(int key, int value) {
        MapNode node = map[hashFunction(key)];
        MapNode startNode = map[hashFunction(key)];
        MapNode newNode = new MapNode(key, value);

            while(node != null) {
                if (node.key == key) {
                    node.value = value;
                    return;
                } else {
                    node = node.next;
                }
            }

            newNode.next = startNode.next;
            startNode.next = newNode;
    }
    
    public int get(int key) {
        MapNode node = map[hashFunction(key)];

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
        MapNode prev = null;

        while(node != null) {
            if (node.key == key) {
                prev.next = node.next;
                node.next = null;
                return;
            } else {
                prev = node;
                node = node.next;
            }
        }
    }

    private int hashFunction(int key) {
        return key % map.length;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */