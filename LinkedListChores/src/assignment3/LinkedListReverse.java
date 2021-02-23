package assignment3;
// reverse a linked list
public class LinkedListReverse {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int value){
            val = value;
        }
    }
    /*
    Let's say the given list is 1->2->3->4->5->null

    let's take a prev with null value
    iterate over the list
    presently head is on 1 to reverse a linked list we need output like
    null<-1<-2<-3<-4<-5
    So, lets reverse pointers and let head point to null, this will give us the reversed linked list
    Let next list node = head.next which is (2)
    now head.next = null i.e 1 should point to null
    now join the list prev =  head and then head = next
    return prev as it will have reverse ordered list

     */
    public static ListNode reverseLinkedList(ListNode head){
        // initialize a pointer with null
        ListNode prev = null;
        // iterating over the list
        while(head!= null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }

    public static String printList(ListNode head){
        StringBuilder result = new StringBuilder();

        ListNode n = head;
        while(n!= null){
           result.append(n.val);
           result.append("->");
           n = n.next;
        }
        return result.toString().substring(0, result.length()-2);
    }

    public static void main(String[] args){
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth= new ListNode(4);
        ListNode fifth = new ListNode(5);
        // join
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = null;


        System.out.println(printList(reverseLinkedList(head)));

    }
}
