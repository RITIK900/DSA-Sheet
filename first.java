import java.lang.reflect.Array;
import java.util.ArrayList;

public class first{
    static class Node{
        int data;
        Node left,right;

        Node(int x){
            data=x;
            left=null;
            right=null;
        }
    }
    public static void main(String[] args) {
            Node root = new Node(70);
            root.left = new Node(20);
            root.right = new Node(30);
            root.left.left = new Node(10);
            root.left.right = new Node(10);
            /*
            root.left.right.left = new Node(4);
            root.left.right.right = new Node(7);
            root.right.right = new Node(14);
            root.right.left = new Node(13);
            */

            /*
            ArrayList<Integer> ans = new ArrayList<>();
            ans = inOrder(root, ans);

            System.out.println(ans);
            
            int k=14;
            int i=0,j= ans.size() - 1;
            while(i<j)
            {
                int sum = ans.get(i)+ans.get(j);
                if(sum == k)
                {
                    System.out.println("( "+ans.get(i)+" ,"+ans.get(j)+")");
                    break;
                }
                else if(sum > k)
                 j--;
                else
                 i++;
            }
            */

            //inOrder(root, root, 16);

            if(isSatisfy(root)==-1)
             System.out.println("False");
             else 
             System.out.println("True");
        
    }

    static int isSatisfy(Node root)
    {
        if(root == null)
         return 0;
         if(root.left == null && root.right == null)
         return root.data;

        int left = isSatisfy(root.left);
        if(left == -1)
         return -1;
        int right = isSatisfy(root.right);
        if(right == -1)
         return -1;

        if(root.data == (left+right))
         return 2*root.data;
        
        return -1;
    }

    static boolean search(Node root, int k)
    {
        if(root == null)
         return false;
        
        if(root.data == k)
         return true;

        else if(root.data > k)
         return search(root.left, k);
         
        return search(root.right, k);
    }



    static void inOrder(Node root, Node rootM, int k)
    {
        if(root == null)
         return ;
        
        int OriginalK = k;
        k=k-root.data;
        if(search(rootM, k))
         {
            System.out.println("( "+root.data+" ,"+k+")");
         }

        inOrder(root.left, rootM, OriginalK);
        inOrder(root.right, rootM, OriginalK);

    }
    
    static ArrayList<Integer> inOrder(Node root, ArrayList<Integer> ans)
    {
        if(root == null)
         return ans;
        
        ans = inOrder(root.left, ans);
        ans.add(root.data);
        ans = inOrder(root.right, ans);

        return ans;
    }
}