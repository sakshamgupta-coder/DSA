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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        ListNode list = new ListNode(-1);
        ListNode temp = list;
        mergeList(list1, list2, temp);

        return list.next;
    }

    public void mergeList(ListNode l1,ListNode l2,ListNode list){
      
        if(l1==null){
        list.next=l2;
        return;
        }

        if(l2==null){
        list.next=l1;
        return;
        }

       if(l1.val<=l2.val){
         list.next=new ListNode(l1.val);
         mergeList(l1.next,l2,list.next);
       }
       else {
            list.next=new ListNode(l2.val);;
       mergeList(l1,l2.next,list.next);
       }
      
         
       }
}