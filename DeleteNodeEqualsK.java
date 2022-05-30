public static Node deleteNode(Node head, int k)
    {
        Node p = head;
        if(p == null)
         return p;
        
        while(head!=null)
        {
            if(head.data == k)
             head = head.next;
            else 
             break;
            
            if(head == null)
             return head;
        }
        if(head == null)
             return head;
        Node prev_p = head;
        p=head.next;
        
        while(p!=null)
        {
            if(p.data==k)
            {
                prev_p.next = p.next;
                p=p.next;
            }
            else
            {
                prev_p = p;
                p=p.next;
            }
        }
        return head;
        
    }
