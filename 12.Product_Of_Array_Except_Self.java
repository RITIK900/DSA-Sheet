/****************Link*********************
 * 
 * https://leetcode.com/problems/product-of-array-except-self/submissions/
 * 
 * **************************************/

 /******************Problem Statement*************
  Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].

The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

You must write an algorithm that runs in O(n) time and without using the division operation.


  */

  class Solution {
    public int[] productExceptSelf(int[] nums) {
        int l = nums.length;
        
        int[] left = new int[l];
        int[] right = new int[l];
        
        
        for(int i=0;i<l;i++)
        {
            if(i==0)
                left[i] = nums[i];
            else
                left[i] = left[i-1] * nums[i];
        }
        
        for(int i=l-1;i>=0;i--)
        {
            if(i==l-1)
                right[i] = nums[i];
            else
                right[i] = right[i+1] * nums[i];
        }
        
        
        
        for(int i=0;i<l;i++)
        {
            if(i==0)
              nums[i] =  right[i+1];
            else if(i==l-1)
                nums[i] = left[i-1];
            else{
                nums[i] = left[i-1]*right[i+1];
            }
        }
        
        return nums;
        
    }
}