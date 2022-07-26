/******************************Link******************************* 

https://leetcode.com/problems/subtree-of-another-tree/

*****************************************************************/

/**************************Problem Statement****************************

Given the roots of two binary trees root and subRoot, return true if there is a 
subtree of root with the same structure and node values of subRoot and false otherwise.

A subtree of a binary tree tree is a tree that consists of a node in tree and all of 
this node's descendants. The tree tree could also be considered as a subtree of itself.

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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        
        if(root == null)
            return false;
         boolean res=false;
        if(subRoot.val == root.val)
            res = isEqual(root, subRoot);
        
        
        if(res == false)
           res = isSubtree(root.left, subRoot);
        
        if(res == false)
            res = isSubtree(root.right, subRoot);
        
        return res;
    }
    
    public boolean isEqual(TreeNode root, TreeNode subRoot) {
        if((root == null && subRoot != null) || (root != null && subRoot == null))
            return false;
        
        if(root == null && subRoot == null)
            return true;
        
        if(subRoot.val != root.val)
            return false;
        
        
        return isEqual(root.left, subRoot.left) && isEqual(root.right, subRoot.right);
        
       
    }
}