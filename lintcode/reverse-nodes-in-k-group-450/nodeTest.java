class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
  
public class nodeTest{
    //打印链表
    public void printNode(ListNode head){
        while(true){
            System.out.print(head.val);
            if(head.next == null)
                break;
            System.out.print(" -> ");
            head = head.next;
        }   
        System.out.println();
    }
    
    //链表反向。基本思路是一条链表有头节点，从第二个节点开始插到头节点前。则已经反向的链表部分有头节点和结束节点，结束节点链接到还未反向的链表部分。
    //循环操作直到到链表结尾。
    //暂时节点是下一个要插到头结点前的节点，第一步摘出来。然后将这个节点的前后节点连上，将这个节点的下一个节点指向头结点。再将这个节点赋值给头结点指针。
    //链表是靠节点的next指针链接在一起的。node.next被赋值不改变node节点指针本身指向的节点，不要混淆。
    //注意检查node.next 是否为null，来判断是否到尾。
    public ListNode reverseNode(ListNode head){
        ListNode startNode = head;
        ListNode endNode;
        ListNode  tempNode;
        int i;
        
        endNode = startNode;
        while(true){
            tempNode = endNode.next;
            
            endNode.next = tempNode.next;
            tempNode.next = startNode;
            startNode = tempNode;
            if(endNode.next ==null)break;
            //endNode = tempNode;
        }
        //startNode = endNode;
        
        return startNode;
    }
    
    //因为翻转的元素是给定的，先遍历判断余下的链表节点数是否需要翻转，不需则直接跳出大循环。
    //最终的链表头结点是第一次翻转前的第K个节点。
    //反向部分思路同上。
    //因为这段的链表翻转后要接到上一段已翻转链表上，加了个节点存储头节点的前一个节点。
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
    
    
    public static void main(String[] args){
        ListNode node1 = new ListNode(1);    
        ListNode node2 = new ListNode(2);    
        ListNode node3 = new ListNode(3);    
        ListNode node4 = new ListNode(4);    
        ListNode node5 = new ListNode(5);    
        ListNode node6 = new ListNode(6);
        node1.next = node2;        
        node2.next = node3;        
        node3.next = node4;        
        node4.next = node5;        
        node5.next = node6;  
        nodeTest t = new nodeTest();

        t.printNode(node1);
        //如下reverseNode()方法不能和和reverseKGroup()方法同时使用，因为reverseNode()也会改变node1指向的节点。
        t.printNode(t.reverseNode(node1));        
        //t.printNode(t.reverseNode(node6));        
        t.printNode(t.reverseKGroup(node6, 2));        
    }
}