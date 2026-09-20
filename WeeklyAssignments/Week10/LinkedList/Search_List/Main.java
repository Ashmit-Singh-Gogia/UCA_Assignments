package LinkedList.Search_List;

import LinkedList.LinkedList;

public class Main {
    public static void main(String[] args) {
        Search_List_In_List searcher = new Search_List_In_List();

        LinkedList list1 = LinkedList.fromArray(new int[] { 1, 2, 3, 4 });
        LinkedList list2 = LinkedList.fromArray(new int[] { 1, 2, 2, 1, 2, 3 });

        System.out.println(searcher.Search_List(list1.head, list2.head));

        LinkedList list3 = LinkedList.fromArray(new int[] { 1, 2 });
        LinkedList list4 = LinkedList.fromArray(new int[] { 1, 2, 2, 1, 2, 3 });

        System.out.println(searcher.Search_List(list3.head, list4.head));

        LinkedList list5 = LinkedList.fromArray(new int[] { 2, 3 });
        LinkedList list6 = LinkedList.fromArray(new int[] { 1, 2, 2, 1, 2, 3 });

        System.out.println(searcher.Search_List(list5.head, list6.head));

    }
}
