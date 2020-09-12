import java.util.LinkedList;

public class RemoveLoopInLinkedList {
    class LinkedListNode
    {
        int a;
        LinkedListNode next;
        LinkedListNode(int a)
        {
           this.a=a;
           next=null;
        }
    }

    public void removeLoop(LinkedListNode n)
    {
        if(n.next==null)
            return;
        LinkedListNode slow=n;
        LinkedListNode fast=n;
      while(fast.next!=null&&fast.next.next!=null)
      {
          slow=slow.next;
          fast=fast.next.next;
          if(slow==fast)
              break;
      }
      if(slow!=fast)
          return;
      int counter=0;
      while(slow.next!=fast) {
          slow = slow.next;
          counter++;

      }
      int i=0;
      fast=n;
      while(i++<counter&&fast!=null)
          fast=fast.next;
      while(fast!=slow)
      {
          fast=fast.next;
          slow=slow.next;
      }
      while(slow.next!=fast)
          slow=slow.next;
      slow.next=null;
    }

}
