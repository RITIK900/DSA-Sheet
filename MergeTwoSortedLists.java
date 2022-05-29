/*******************Link******************************
https://leetcode.com/problems/merge-two-sorted-lists/
*****************************************************/

/**********************************Problem Statement***************
You are given the heads of two sorted linked lists list1 and list2.

Merge the two lists in a one sorted list. The list should be made 
by splicing together the nodes of the first two lists.

Return the head of the merged linked list.
*******************************************************************/


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
        
        if(list1==null && list2==null)
            return null;
        else if(list1 == null)
            return list2;
        else if(list2==null)
            return list1;
        
        ListNode ans, temp;
        
        if(list1.val <= list2.val)
        {
            ans = list1;
            list1 = list1.next;
        }
        else
        {
            ans = list2;
            list2 = list2.next;
        }
        temp = ans;
        
        while(list1!=null && list2!=null)
        {
            if(list1.val <= list2.val)
            {
                temp.next = list1;
                temp= temp.next;
                list1 = list1.next;
            }
            else
            {
                temp.next = list2;
                temp=temp.next;
                list2 = list2.next;
            }
            
        }
        
        if(list1 == null)
            temp.next = list2;
        else if(list2 == null)
            temp.next = list1;
        
        return ans;
        
    }
}
