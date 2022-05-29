/************************Link*************************
https://leetcode.com/problems/reverse-linked-list/
*****************************************************/

/************************Problem Statement*********************************************
Given the head of a singly linked list, reverse the list, and return the reversed list.

***************************************************************************************/

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
    public ListNode reverseList(ListNode head) {
        
        ListNode rev = head;
        head = head.next;
        rev.next = null;
        while(head!=null)
        {
            ListNode temp = head;
            head=head.next;
            temp.next = rev;
            
            rev=temp;
            
        }
        
        return rev;
        
    }
}
