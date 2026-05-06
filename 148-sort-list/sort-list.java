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
    static ListNode findMiddle(ListNode head){
        ListNode slow=head;
        ListNode fast=head.next;
        while(fast!=null&&fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;

    }
    static ListNode merge(ListNode list1, ListNode list2) {
        if(list1==null)
        return list2;
        if(list2==null)
        return list1;
        ListNode list=new ListNode(-1);
        ListNode temp=list; 
        while(list1!=null&&list2!=null){
            if(list1.val<list2.val){
                temp.next=list1;
                list1=list1.next;
            }
            else{
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if(list1!=null){
            temp.next=list1;
        }
        else
        temp.next=list2;

        return list.next;
        
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null){
            return head;
        }
            ListNode middle=findMiddle(head);
            ListNode rHead=middle.next;
            middle.next=null;
            ListNode lHead=head;
             lHead=sortList(lHead);
             rHead=sortList(rHead);
        return merge(lHead,rHead);
    }
}