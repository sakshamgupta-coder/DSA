/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode odd=head;
        ListNode even=head.next;
        ListNode tEven=even;
        while(tEven!=null&&tEven.next!=null){
           odd.next=tEven.next;
           odd=odd.next;

           tEven.next=odd.next;
           tEven=tEven.next;
        }
        odd.next=even;
        return head;
    }
}