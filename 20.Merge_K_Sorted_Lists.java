/*********************Link***************************

https://leetcode.com/problems/merge-k-sorted-lists/

****************************************************/

/************************Problem Statement***************************

You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.

Merge all the linked-lists into one sorted linked-list and return it.

********************************************************************/







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
    public ListNode mergeKLists(ListNode[] lists) {
        
        if(lists.length == 0)
         return null;
        
        for(int i=1;i<lists.length;i++)
        {
            lists[i] = mergeLinkedList(lists[i-1], lists[i]);
            
        }
        
        return lists[lists.length - 1];
    }
    
    public ListNode mergeLinkedList(ListNode list1, ListNode list2) {
        
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
