package LinkedList.Intersection_Of_Lists;

import LinkedList.ListNode;

public class Main {
    public static void main(String[] args) {
        Find_Intersection finder = new Find_Intersection();

        // Test 1: Lists intersect at node with value 6
        // list1: 1 -> 2 -> 3 \
        // -> 6 -> 7
        // list2: 4 -> 5 /
        ListNode common1 = new ListNode(6);
        common1.next = new ListNode(7);

        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(3);
        head1.next.next.next = common1;

        ListNode head2 = new ListNode(4);
        head2.next = new ListNode(5);
        head2.next.next = common1;

        ListNode result1 = finder.Find_Intersection_Lists(head1, head2);
        System.out.println("Test 1 - Expected 6, Got: " + (result1 != null ? result1.val : "null"));

        // Test 2: Lists intersect at the very first node of list2
        // list1: 10 -> 20 -> 30
        // list2: 30 (same node as list1's last)
        ListNode shared = new ListNode(30);

        ListNode h1 = new ListNode(10);
        h1.next = new ListNode(20);
        h1.next.next = shared;

        ListNode h2 = shared;

        ListNode result2 = finder.Find_Intersection_Lists(h1, h2);
        System.out.println("Test 2 - Expected 30, Got: " + (result2 != null ? result2.val : "null"));

        // Test 3: No intersection (separate lists)
        // list1: 1 -> 2
        // list2: 3 -> 4
        ListNode a1 = new ListNode(1);
        a1.next = new ListNode(2);

        ListNode a2 = new ListNode(3);
        a2.next = new ListNode(4);

        ListNode result3 = finder.Find_Intersection_Lists(a1, a2);
        System.out.println("Test 3 - Expected null, Got: " + (result3 != null ? result3.val : "null"));

        // Test 4: Both lists are the same (intersect at head)
        // list1 = list2: 5 -> 10 -> 15
        ListNode same = new ListNode(5);
        same.next = new ListNode(10);
        same.next.next = new ListNode(15);

        ListNode result4 = finder.Find_Intersection_Lists(same, same);
        System.out.println("Test 4 - Expected 5, Got: " + (result4 != null ? result4.val : "null"));

        // Test 5: Unequal length lists intersecting
        // list1: 1 -> 2 -> 3 -> 4 \
        // -> 8 -> 9
        // list2: 7 /
        ListNode common5 = new ListNode(8);
        common5.next = new ListNode(9);

        ListNode b1 = new ListNode(1);
        b1.next = new ListNode(2);
        b1.next.next = new ListNode(3);
        b1.next.next.next = new ListNode(4);
        b1.next.next.next.next = common5;

        ListNode b2 = new ListNode(7);
        b2.next = common5;

        ListNode result5 = finder.Find_Intersection_Lists(b1, b2);
        System.out.println("Test 5 - Expected 8, Got: " + (result5 != null ? result5.val : "null"));
    }
}
