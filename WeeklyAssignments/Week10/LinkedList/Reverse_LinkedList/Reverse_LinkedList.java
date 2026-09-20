package LinkedList.Reverse_LinkedList;

import LinkedList.ListNode;

public class Reverse_LinkedList {
    public ListNode Reverse_List_Recurssion(ListNode head) {
        if (head == null || head.next == null)
            return head;

        ListNode mainHead = Reverse_List_Recurssion(head.next);
        head.next.next = head;
        head.next = null;
        return mainHead;
    }
}