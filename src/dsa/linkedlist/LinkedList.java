package dsa.linkedlist;

public class LinkedList {

    private Node head;

    static class Node {

        int val;
        Node next;

        public Node(int val) {
            this.val = val;
        }
    }

    public void add(int val) {
        if(null == head) {
            head = new Node(val);
        } else {
            Node curr = head;
            Node prev = null;
            while (curr != null) {
                prev = curr;
                curr = curr.next;
            }
            if (prev != null) {
                prev.next = new Node(val);
            }
        }
    }

    public void print() {
        Node curr = head;
        while(curr != null) {
            if(curr.next != null) {
                System.out.print(curr.val + " -> ");
            } else {
                System.out.print(curr.val + " -> NULL");
            }
            curr = curr.next;
        }
        System.out.println();
    }

    // 1 -> 2 -> 3 -> 4 -> 5


    //
    public void reverse() {
        Node reverseHead = this.reverse(head);
        head = reverseHead;
    }

    public Node reverse(Node head) {
        Node reversedHead = head;
        Node curr = head;
        while(curr != null) {
            if(curr.next != null) {
                Node back = curr.next.next;
                curr.next.next = reversedHead;
                reversedHead = curr.next;
                curr.next = back;
            } else {
                break;
            }
        }
        return reversedHead;
    }

    // 1 -> 2 -> 3 -> 4 -> 5 -> NULL
    // 2 -> 1 -> 4 -> 3 -> 5 -> NULL


    public void reverseKBlocks(int k) {
        if(k == 1) {
            return;
        }

        Node newHead = null;
        Node prevHead = null;
        Node curr = head;
        Node headToReverse = head;

        int count = 0;
        while(curr != null) {
            count++;
            if(count%k == 0) {
                Node backup = curr.next;
                curr.next = null;
                if(prevHead != null) {
                    prevHead.next = null;
                }
                Node reversedHead = reverse(headToReverse);
                if(newHead == null) {
                    newHead = reversedHead;
                    prevHead = headToReverse;
                    headToReverse = backup;
                } else {
                    prevHead.next = reversedHead;
                    prevHead = headToReverse;
                    headToReverse = backup;
                }
                prevHead.next = backup;
                curr = backup;
            } else {
                curr = curr.next;
            }
        }
        head = newHead;


    }


    public static void main(String[] args) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.add(5);

        linkedList.print();

        linkedList.reverse();

        linkedList.print();

        linkedList.reverseKBlocks(3);

        linkedList.print();
    }

}
