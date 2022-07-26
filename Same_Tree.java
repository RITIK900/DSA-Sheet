/*******************************************************

https://leetcode.com/problems/same-tree/submissions/


********************************************************/

/**************************Problem Statement****************************

Given the roots of two binary trees p and q, write a function to check if 
they are the same or not.

Two binary trees are considered the same if they are structurally identical, 
and the nodes have the same value.

******************************************************* */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode root, TreeNode subRoot) {
        if((root == null && subRoot != null) || (root != null && subRoot == null))
            return false;
        
        if(root == null && subRoot == null)
            return true;
        
        if(subRoot.val != root.val)
            return false;
        
        
        return isSameTree(root.left, subRoot.left) && isSameTree(root.right, subRoot.right);
        
    }
}