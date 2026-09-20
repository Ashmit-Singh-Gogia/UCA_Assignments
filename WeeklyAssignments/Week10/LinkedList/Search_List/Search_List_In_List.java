package LinkedList.Search_List;

import LinkedList.ListNode;

public class Search_List_In_List {

    public boolean Search_List(ListNode list1, ListNode list2) {
        if (list1 == null)
            return true;
        ListNode curr1 = list1, curr2 = list2;

        while (curr1 != null && curr2 != null) {
            if (curr1.val == curr2.val) {
                curr1 = curr1.next;
            } else {
                curr1 = list1;
            }
            curr2 = curr2.next;
        }
        return curr1 == null;
    }
}
