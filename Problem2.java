import java.util.PriorityQueue;

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
//TC : Nlog(K) k is the number of linked list
//SC : k
class Problem2 {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a,b)->a.val-b.val);
        for(ListNode node : lists){
            //add all heads to the min heap
            if(node!=null){
                pq.offer(node);
            }

        }
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        while(!pq.isEmpty()){
            ListNode minNode = pq.poll();
            curr.next = minNode;
            curr = curr.next;
            if(minNode.next!=null){
                pq.offer(minNode.next);
            }


        }
        return dummy.next;
    }
}
}