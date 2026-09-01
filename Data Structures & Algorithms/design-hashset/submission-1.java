class MyHashSet {
    private static class ListNode {
        private ListNode prev;
        private int value;
        private ListNode next;

        private ListNode(int value) {
            prev = null;
            this.value = value;
            next = null;
        }

        private void setPrev(ListNode prev) {
            this.prev = prev;
        }

        private void setNext(ListNode next) {
            this.next = next;
        }

        private boolean hasNext() {
            return next != null;
        }
    }

    ListNode[] set = new ListNode[10000];

    public MyHashSet() {}

    public void add(int key) {
        ListNode node = set[hashFunction(key)];
        ListNode newNode = new ListNode(key);

        if (node == null) {
            set[hashFunction(key)] = newNode;
        } else {
            while(node != null) {
                if(node.value == key) {
                    return;
                } else {
                    node = node.next;
                }
            }

            node = set[hashFunction(key)];
            node.setPrev(newNode);
            newNode.setNext(node);
            set[hashFunction(key)] = newNode;
        }
    }

    public void remove(int key) {
        ListNode node = set[hashFunction(key)];

        while (node != null) {
            if (node.value == key) {
                ListNode prev = node.prev;
                ListNode next = node.next;

                if (prev == null && next == null) {
                    set[hashFunction(key)] = null;
                } else if (prev != null && next == null) {
                    prev.next = null;
                    prev = null;
                } else if (prev == null && next != null) {
                    set[hashFunction(key)] = next;
                    next = null;
                } else {
                    prev.next = next;
                    next.prev = prev;
                    next = null;
                    prev = null;
                }

                return;
            } else {
                node = node.next;
            }
        }
    }

    public boolean contains(int key) {
        ListNode node = set[hashFunction(key)];

        if (node == null) {
            return false;
        }

        while (node != null) {
            if (node.value == key) {
                return true;
            } else {
                node = node.next;
            }
        }

        return false;
    }

    private int hashFunction(int key) {
        return key % 10000;
    }
}

/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */