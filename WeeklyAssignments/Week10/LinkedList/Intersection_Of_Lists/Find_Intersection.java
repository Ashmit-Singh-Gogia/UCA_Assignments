package LinkedList.Intersection_Of_Lists;

import LinkedList.ListNode;

public class Find_Intersection {
    public ListNode Find_Intersection_Lists(ListNode list1, ListNode list2) {
        ListNode temp1 = list1, temp2 = list2;
        while (temp1 != temp2) {
            if (temp1 == null)
                temp1 = list2;
            if (temp2 == null)
                temp2 = list1;
            if (temp1 == temp2)
                return temp1;
            temp1 = temp1.next;
            temp2 = temp2.next;
        }
        return temp1;
    }
}