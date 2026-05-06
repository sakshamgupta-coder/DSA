/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {
        if(head==null)return null;
        Node curr=head;
        while(curr!=null){
            if(curr.child!=null){
                Node nextN=curr.next;
                Node childT=curr.child;
                while(childT.next!=null){
                    childT=childT.next;
                }
                if(nextN!=null){
                    childT.next=nextN;
                    nextN.prev=childT;
                }
                curr.next=curr.child;
                curr.child.prev=curr;
                curr.child=null;
            }
            curr=curr.next;
        }
        return head;
    }
}