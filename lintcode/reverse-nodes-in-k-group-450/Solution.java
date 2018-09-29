/**
 * Definition for ListNode
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

 //450

public class Solution {
    /**
     * @param head: a ListNode
     * @param k: An integer
     * @return: a ListNode
     */
    public ListNode reverseKGroup(ListNode head, int k) {
        // write your code here
        int i=1;
        
        ListNode tempNode;
        ListNode startNode = head;
        ListNode beforeStartNode = null;
        ListNode endNode = null;
        boolean getHead = false;
        while(true){
            tempNode = startNode;
            for(i=1;i<=k;i++){
                if(tempNode == null)break;
                endNode = tempNode;
                tempNode = tempNode.next;
                                
            }    
            if(i<=k)break;
            if(!getHead){
                head= endNode;
                getHead = true;
            }
            
            endNode = startNode;
            for(i=1;i<k;i++){
                tempNode = endNode.next;
                endNode.next = tempNode.next;
                tempNode.next = startNode;
                
                startNode = tempNode;
            }
            if(beforeStartNode!=null)
                beforeStartNode.next = startNode;
            beforeStartNode = endNode;
            startNode = endNode.next;
            
        }
        return head;
    }
}