package week1;

public class Day2_DesignHashSet {

    static class Node {
        int key;
        Node next;
        Node(int key) {
            this.key = key;
        }
    }
    private Node nodes[];

    Day2_DesignHashSet() {
        nodes = new Node[10000 + 11];
    }

    public int hash(int key) {
        return key % nodes.length;
    }

    public void add(int key) {
        int idx = hash(key);
        if (nodes[idx] == null)
            nodes[idx] = new Node(key);
        Node curr = nodes[idx];
        while (curr != null && curr.key != key) {
            curr = curr.next;
        }
        if (curr.key != key)
            curr = new Node(key);
    }

    public void remove(int key) {
        int idx = hash(key);

        if (nodes[idx] == null) return;
        else if (nodes[idx].key == key) nodes[idx] = nodes[idx].next;
        else {
            Node curr = nodes[idx]; Node pre = null;
            while (curr.next != null && curr.key != key) {
                pre = curr;
                curr = curr.next;
            }
            if (curr.key == key)
                pre.next = curr.next;
        }
    }

    public boolean contains(int key) {
        int idx = hash(key);
        Node curr = nodes[idx];
        while (curr != null && curr.key != key)
            curr = curr.next;
        return curr != null;
    }

    public static void main(String[] args) {
        Day2_DesignHashSet obj = new Day2_DesignHashSet();
        obj.add(10);
        obj.add(20);
        obj.add(30);
        obj.add(10);
        System.out.println(obj.contains(40));
        obj.remove(10);
        System.out.println(obj.contains(10));
    }

}
