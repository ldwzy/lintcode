class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }
  }
  
public class nodeTest{
    //��ӡ����
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
    
    //�����򡣻���˼·��һ��������ͷ�ڵ㣬�ӵڶ����ڵ㿪ʼ�嵽ͷ�ڵ�ǰ�����Ѿ��������������ͷ�ڵ�ͽ����ڵ㣬�����ڵ����ӵ���δ����������֡�
    //ѭ������ֱ���������β��
    //��ʱ�ڵ�����һ��Ҫ�嵽ͷ���ǰ�Ľڵ㣬��һ��ժ������Ȼ������ڵ��ǰ��ڵ����ϣ�������ڵ����һ���ڵ�ָ��ͷ��㡣�ٽ�����ڵ㸳ֵ��ͷ���ָ�롣
    //�����ǿ��ڵ��nextָ��������һ��ġ�node.next����ֵ���ı�node�ڵ�ָ�뱾��ָ��Ľڵ㣬��Ҫ������
    //ע����node.next �Ƿ�Ϊnull�����ж��Ƿ�β��
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
    
    //��Ϊ��ת��Ԫ���Ǹ����ģ��ȱ����ж����µ�����ڵ����Ƿ���Ҫ��ת��������ֱ��������ѭ����
    //���յ�����ͷ����ǵ�һ�η�תǰ�ĵ�K���ڵ㡣
    //���򲿷�˼·ͬ�ϡ�
    //��Ϊ��ε�����ת��Ҫ�ӵ���һ���ѷ�ת�����ϣ����˸��ڵ�洢ͷ�ڵ��ǰһ���ڵ㡣
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
        //����reverseNode()�������ܺͺ�reverseKGroup()����ͬʱʹ�ã���ΪreverseNode()Ҳ��ı�node1ָ��Ľڵ㡣
        t.printNode(t.reverseNode(node1));        
        //t.printNode(t.reverseNode(node6));        
        t.printNode(t.reverseKGroup(node6, 2));        
    }
}