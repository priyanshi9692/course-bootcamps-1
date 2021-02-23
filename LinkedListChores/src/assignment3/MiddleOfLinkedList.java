package assignment3;
/*
1.	Given a Singly Linked List, print the data of the middle element of the list.
     If the given list is 1->2->3->4->5 then
     the output should be 3
 */
public class MiddleOfLinkedList {
    public static class ListNode{
        int val;
        ListNode next;

        ListNode(int value){
            val = value;
        }
    }
   /*
    To find out the middle of the linked list
    we can take two pointers one is slow and another is fast
    slow will move one by one and fast will move over the 2 elements at a time.
    so by this logic one can visualize is the fast will reach to the null i.e. end of the list,
    in that case our slow pointer will point to the middle one.
    */
    public static int middleOfLinkedList(ListNode head){
        ListNode slow = head;
        ListNode fast = head;
        while(fast!= null && fast.next!= null){
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.val;

    }
    public static String printList(ListNode head){
        StringBuilder result = new StringBuilder();

        ListNode node = head;
        while(node!= null){
            result.append(node.val);
            result.append("->");
            node = node.next;
        }
        return result.toString().substring(0, result.length()-2);

    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;
        System.out.println("LinkedList: "+ printList(head));
        System.out.println("middle element: "+middleOfLinkedList(head));
    }
}
