/*************************Link**********************************
https://www.geeksforgeeks.org/sort-biotonic-doubly-linked-list/
***************************************************************/

/*******************************Problem Statement********************************

Sort the given biotonic doubly linked list. A biotonic doubly linked list is a 
doubly linked list which is first increasing and then decreasing. A strictly 
increasing or a strictly decreasing list is also a biotonic doubly linked list.

********************************************************************************/


/****************************
*****************************
*****************************
This code is not compiled...
*****************************
*****************************
****************************/


static Node Sort(Node head)
{
  if(head == null || head.next == null)
    return head;
  
  Node temp = head, tail =head, newhead=null;
  int size=1;
  while(tail.next != null)
  {
    tail = tail.next;
    size++;
  }
  
  if(head.data > tail.data)
  {
    newhead = tail;
    tail = tail.prev;
    newhead.prev = null;
  }
  else
  {
    newhead = temp;
    temp = temp.next;
  }
  
  tempNew = newhead;
  
  int l=size;
  while(l>2)
  {
    if(temp.data > tail.data)
    {
      tempNew.next = tail;
      tail = tail.prev;
      tempNew = tempNew.next
    }
    else
    {
      tempNew.next = temp;
      temp = temp.next;
      tempNew = tempNew.next;
    }
    l--;
    
    if(temp == tail)
    {
      tempNew.next = temp;
      tempNew.next.next = null;
      return newhead;
    }
  }
  
  return newhead;
}
