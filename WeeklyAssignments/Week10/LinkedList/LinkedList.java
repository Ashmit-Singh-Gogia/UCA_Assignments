package LinkedList;

public class LinkedList {
    public ListNode head;
    public int size;

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

    // Insert a value at the end of the list
    public void insertAtEnd(int value) {
        ListNode newNode = new ListNode(value);
        if (head == null) {
            head = newNode;
        } else {
            ListNode curr = head;
            while (curr.next != null) {
                curr = curr.next;
            }
            curr.next = newNode;
        }
        size++;
    }

    // Build a list from an array of values
    public static LinkedList fromArray(int[] values) {
        LinkedList list = new LinkedList();
        for (int val : values) {
            list.insertAtEnd(val);
        }
        return list;
    }

    // Print the list
    public void printList() {
        ListNode curr = head;
        while (curr != null) {
            System.out.print(curr.val);
            if (curr.next != null) {
                System.out.print(" -> ");
            }
            curr = curr.next;
        }
        System.out.println();
    }
}
