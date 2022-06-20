/****************************Link****************************
https://practice.geeksforgeeks.org/problems/reorder-list/1/#
************************************************************/

/***************************************Problem Statement***********************************************
Given a singly linked list: A0→A1→…→An-1→An, reorder it to: A0→An→A1→An-1→A2→An-2→…
For example: Given 1->2->3->4->5 its reorder is 1->5->2->4->3.

Note: It is recommended do this in-place without altering the nodes' values.
*******************************************************************************************************/


// { Driver Code Starts
import java.util.*;

class Node {
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}

  public class ReorderList {
    Node head; // head of lisl
    Node last; // last of linked list

    /* Linked list Node*/

    /* Utility functions */

    /* Inserts a new Node at front of the list. */
    public void addToTheLast(Node node) {

        if (head == null) {
            head = node;
            last = head;
        } else {
            // Node temp = head;
            // while (temp.next != null) temp = temp.next;

            last.next = node;
            last = last.next;
        }
    }
    /* Function to print linked list */
    void printList() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    /* Drier program to test above functions */
    public static void main(String args[]) {

        /* Constructed Linked List is 1->2->3->4->5->6->
           7->8->8->9->null */
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t > 0) {
            int n = sc.nextInt();
            ReorderList llist = new ReorderList();

            int a1 = sc.nextInt();
            Node head = new Node(a1);
            llist.addToTheLast(head);
            for (int i = 1; i < n; i++) {
                int a = sc.nextInt();
                llist.addToTheLast(new Node(a));
            }

            llist.head = new gfg().reorderlist(llist.head);

            llist.printList();

            t--;
        }
    }
}// } Driver Code Ends


/* Following is the Linked list node structure */

/*class Node
{
    int data;
    Node next;
    Node(int d) {
        data = d;
        next = null;
    }
}*/

class gfg {
    Node reorderlist(Node head) {
        // Your code here
       
      if(head == null || head.next == null) 
        return head;
        
        Node slow = head;
        Node fast = head;
        Node prev = head;

        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        prev.next = null;
        Node l1 = head;
        Node l2 = reverse(slow);
        merge(l1, l2);
        
        return l1;
        
     
    }
    
    public static Node reverse(Node l2){
        if(l2 == null) return null;
        Node prev = null;
        Node curr = l2;
        Node next = l2.next;
        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    
    public static void merge( Node l1, Node l2) {
        while (l2 != null) {
            Node next = l1.next;
            l1.next = l2;
            l1 = l2;
            l2 = next;
        }
    }
}

/*   
    if(head.next == null)
         return head;
         
    Node temp=head;
    int size=0;
    while(temp!=null)
    {
        size++;
        temp=temp.next;
    }
    // System.out.println(size);
    temp=head;
    Node tail=null, list=null, newhead=head;
    //int l=size/2;
    for(int i=0;i<size/2;i++)
    {
        int k=size - 2*i;
        
        
        tail = head;
        while(k>1)
        {
            tail =tail.next;
            k--;
        }
        // System.out.println( "tail -> " + tail.data );
        
        if(i==0)
        {
          list = head;
          head = head.next;
        }
        else
        {
          list.next = head;
          head = head.next;
          list = list.next;
        }
        
        list.next = tail;
        list = list.next;
        
    }
       // System.out.println( "head -> " + head.data );
    
    if(size%2==0)
     list.next = null;
    else
    {
     list.next = head;
     list.next.next = null;
    }
    return newhead;
    }
*/
