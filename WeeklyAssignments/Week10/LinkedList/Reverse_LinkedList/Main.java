package LinkedList.Reverse_LinkedList;

import LinkedList.LinkedList;

public class Main {

    public static void main(String[] args) {

        Reverse_LinkedList reverser = new Reverse_LinkedList();

        LinkedList list1 = LinkedList.fromArray(new int[] { 1, 2, 3, 4, 5 });
        list1.printList();
        list1.head = reverser.Reverse_List_Recurssion(list1.head);
        list1.printList();
    }
}