/****************************Link****************************
https://practice.geeksforgeeks.org/problems/sort-a-linked-list/1
************************************************************/

/***************************************Problem Statement***********************************************
Given Pointer/Reference to the head of the linked list, the task is to Sort the given linked list using Merge Sort.
Note: If the length of linked list is odd, then the extra node should go in the first list while splitting.
*******************************************************************************************************/

//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().mergeSort(head);
		     printList(head);
		    System.out.println();
        }
    }
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
}



// } Driver Code Ends


//User function Template for Java
/*
class Node
{
    int data;
    Node next;
    Node(int key)
    {
        this.data = key;
        next = null;
    }
} */

class Solution
{
    //Function to sort the given linked list using Merge Sort.
    static Node mergeSort(Node head)
    {
        // add your code here
        if(head.next == null || head == null)
         return head;
        if(head.next.next == null)
        {
            if(head.data > head.next.data)
            {
                Node temp = head;
                head = head.next;
                head.next = temp;
                temp.next = null;
            }
            return head;
        }
        
        Node slow=head, fast = head;
        while(fast != null && fast.next != null)
        {
            slow = slow.next;
            fast=fast.next.next;
        }
        
        Node right = mergeSort(slow.next);
        if(slow != null)
         slow.next=null;
        Node left = mergeSort(head);
        
        return merge(right, left);
        
    }
    
    static Node merge(Node list1, Node list2) {
        
        if(list1==null && list2==null)
            return null;
        else if(list1 == null)
            return list2;
        else if(list2==null)
            return list1;
        
        Node ans, temp;
        
        if(list1.data <= list2.data)
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
            if(list1.data <= list2.data)
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


