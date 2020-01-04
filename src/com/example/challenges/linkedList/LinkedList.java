package com.example.challenges.linkedList;

public class LinkedList {
    public static void main(String[] args) {
        // NOTE: The following input values will be used for testing your solution.
        // head = 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
        Node current = new Node(1, null);
        for (int i = 2; i < 8; i++) {
            current = new Node(i, current);
        }
        Node head = current;

        // head2 = 1 -> 2 -> 3 -> 4 -> (null)
        Node current2 = new Node(4, null);
        for (int i = 3; i > 0; i--) {
            current2 = new Node(i, current2);
        }
        Node head2 = current2;

        System.out.println(nthFromLast(head, 1)); // should return 1.
        System.out.println(nthFromLast(head, 5)); // should return 5.
        System.out.println(nthFromLast(head2, 2)); // should return 3.
        System.out.println(nthFromLast(head2, 4)); // should return 1.
        System.out.println(nthFromLast(head2, 5)); // should return null.
        System.out.println(nthFromLast(null, 1)); // should return null.
    }

    // Implement your function below.
    public static Node nthFromLast(Node head, int n) {
        if(head == null) {
            return null;
        }
        Node p1 = head;
        Node p2 = head;
        int c = 0;
        while(p2.next != null) {
            p2 = p2.next;
            c++;
            if(c >= n) {
                p1 = p1.next;
            }
        }
        if(c+1 < n) {
            return null;
        }
        return p1;
    }

    //  NOTE: Feel free to use the following function for testing.
    //  It converts the given linked list into an easy-to-read string format.
    //  Example: 7 -> 6 -> 5 -> 4 -> 3 -> 2 -> 1 -> (null)
    public static String linkedListToString(Node head) {
        Node current = head;
        StringBuilder sb = new StringBuilder();
        while (current != null) {
            sb.append(String.valueOf(current.value));
            sb.append(" -> ");
            current = current.next;
        }
        sb.append("(null)");
        return sb.toString();
    }
}
