package algo.linkedlist;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class DisjoinSet<T> {

    Map<T,Set<T>> nodeMap = new HashMap<>();

    static class Set<T> {
        Node<T> head;
        Node<T> tail;
        int size;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Set<?> set = (Set<?>) o;
            return head.equals(set.head);
        }

        @Override
        public int hashCode() {
            return Objects.hash(head);
        }

        @Override
        public String toString() {
            return "Set{" +
                    "head=" + head.val + ", size " + size +
                    '}';
        }
    }

    static class Node<T> {
        final T val;
        Node next;
        Node head;

        Node(T val) {
            this.val = val;
        }
    }

    public Set<T> makeSet(T val) {
        if(!nodeMap.containsKey(val)) {
            Node<T> node = new Node<>(val);
            Set<T> set = new Set<>();
            set.head = node;
            set.tail = node;
            node.head = node;
            set.size = 1;
            nodeMap.put(val, set);
            return set;
        }
        return nodeMap.get(val);
    }

    public Set<T> findSet(T val) {
        return nodeMap.get(val);
    }

    public Set<T> union(T v1, T v2) {
        if(nodeMap.containsKey(v1) && nodeMap.containsKey(v2)) {
            Set<T> v1Set = nodeMap.get(v1);
            Set<T> v2Set = nodeMap.get(v2);

            Set<T> out = null;
            if(v1Set.size >= v2Set.size) {
                out = append(v1Set, v2Set);
                nodeMap.put(v2,out);
            } else {
                out = append(v2Set, v1Set);
                nodeMap.put(v1,out);
            }
            return out;
        }
        return null;
    }

    public Set<T> unionSet(Set<T> v1Set, Set<T> v2Set) {
        Set<T> out = null;
        if(v1Set.size >= v2Set.size) {
            out = append(v1Set, v2Set);
        } else {
            out = append(v2Set, v1Set);
        }
        return out;
    }

    private Set<T> append(Set<T> first, Set<T> second) {
        Node<T> tail = first.tail;
        tail.next = second.head;
        Node<T> curr = second.head;
        while(curr != null) {
            first.size = first.size + 1;
            curr.head = first.head;
            if(curr.next == null) {
                first.tail = curr;
            }
            curr = curr.next;
        }
        return first;
    }

    public static void main(String[] args) {
        DisjoinSet<Integer> disjoinSet = new DisjoinSet();
        disjoinSet.makeSet(1);
        disjoinSet.makeSet(2);
        disjoinSet.makeSet(3);
        disjoinSet.makeSet(4);
        disjoinSet.makeSet(5);
        disjoinSet.makeSet(6);

        System.out.println(disjoinSet.findSet(1));
        System.out.println(disjoinSet.findSet(2));

        System.out.println(disjoinSet.union(1,2));

        System.out.println(disjoinSet.union(5,6));

        System.out.println(disjoinSet.findSet(1));
        System.out.println(disjoinSet.findSet(2));

        System.out.println(disjoinSet.findSet(5));
        System.out.println(disjoinSet.findSet(6));

        System.out.println(disjoinSet.union(2,6));

        System.out.println(disjoinSet.findSet(1));
        System.out.println(disjoinSet.findSet(6));

        System.out.println(disjoinSet.union(2,3));
        System.out.println(disjoinSet.findSet(1));
        System.out.println(disjoinSet.findSet(3));

    }

}
