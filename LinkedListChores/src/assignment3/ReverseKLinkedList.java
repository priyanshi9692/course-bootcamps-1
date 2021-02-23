package assignment3;

/*
3.	Given a linked list of size N. The task is to reverse every k nodes (where k is an input to the function)
in the linked list
Example 1:
Input: LinkedList: 1->2->2->4->5->6->7->8
K = 4
Output: 4 2 2 1 8 7 6 5
Explanation: The first 4 elements 1,2,2,4 are reversed first and then the next 4 elements 5,6,7,8.
Hence, the resultant linked list is 4->2->2->1->8->7->6->5.
*/
public class ReverseKLinkedList {

    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int value){
            val = value;
        }
    }
    /*
    We can solve this problem recursively, one can write one method to reverse the linked list
    and then the method which splits the linked list in two k parts and then reverse and join them

    Reverse k nodes and get the newLinkedList, newLinkedList is the head of the final linked list.
     */

    public static ListNode reverseKLinkedList(ListNode head, int k){
        ListNode ptr = head;
        ListNode kTail = null;

        ListNode newLinkedList = null;

        while(ptr!= null){
            int count = 0;

            ptr = head;
            while(count<k && ptr!= null){
                ptr = ptr.next;
                count++;
            }

            if(count == k){
                ListNode revList1 = reverseLinkedList(head, k);

                if(newLinkedList  == null){
                    newLinkedList = revList1;
                }

                if(kTail!= null){
                    kTail.next = revList1;
                }

                kTail = head;
                head = ptr;
            }
        }

        if(kTail!= null){
            kTail.next = head;
        }
        return newLinkedList == null ? head: newLinkedList;
    }

    public static ListNode reverseLinkedList(ListNode head, int k ){
        ListNode prev = null;
        ListNode ptr = head;

        while(k>0){
            ListNode next = ptr.next;
            ptr.next = prev;
            prev = ptr;
            ptr = next;
            k--;
        }

        return prev;
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
        // LinkedList: 1->2->2->4->5->6->7->8
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(2);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);
        ListNode sixth = new ListNode(6);
        ListNode seventh = new ListNode(7);
        ListNode eight = new ListNode(8);
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        fifth.next = sixth;
        sixth.next = seventh;
        seventh.next = eight;
        eight.next = null;

        System.out.println(printList(reverseKLinkedList(head, 4)));


    }
}
