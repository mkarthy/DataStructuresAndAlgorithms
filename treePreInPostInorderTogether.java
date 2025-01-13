/*
 * All type of Tree traversals in single traversal of tree using single stack
 * Pre, In and Post order is fetched by traversing the tree with count of every fetch
 * store the node first in stack with count of 1 and then increment it by 1 until it gets 3
 * 
 * when the count is 1 it will go in to Preorder
 * When 2 it goes in Inorder
 * When 3 it goes in Postorder
 * 
 * Note: look for stack insert of LEFT node in case 1 and then RIGHT node in case 2
 */

 import java.util.ArrayList;
 import java.util.List;
 import java.util.Stack;
 
 class TreeNode{
     int data;
     TreeNode left;
     TreeNode right;
 
     TreeNode(int val)
     {
         data = val;
         left = null;
         right = null;
     }
 }
 
 class pairVal{
     TreeNode node;
     int val;
 
     pairVal(TreeNode nd, int v)
     {
         node = nd;
         val = v;
     }
 }
 
 public class treePreInPostInorderTogether
 {
     static List<List<Integer>> preInPostTraversal(TreeNode root)
     {
         List<List<Integer>> result = new ArrayList<>();
 
         List<Integer> pre = new ArrayList<>();
         List<Integer> in = new ArrayList<>();
         List<Integer> post = new ArrayList<>();
 
         if (root == null)
         return result;
 
         Stack<pairVal> stck = new Stack<>();
         
         stck.push(new pairVal(root, 1));
 
         while(!stck.isEmpty())
         {
             pairVal pv = stck.pop();
 
             if(pv.val == 1)
             {
                 pre.add(pv.node.data);
                 pv.val++;
                 stck.push(pv);
                 if (pv.node.left != null)
                 {
                     stck.push(new pairVal(pv.node.left,1));
                 }
             }
             else if(pv.val == 2)
             {
                 in.add(pv.node.data);
                 pv.val++;
                 stck.push(pv);
                 if (pv.node.right != null)
                 {
                     stck.push(new pairVal(pv.node.right,1));
                 }
             }
             else {
                 post.add(pv.node.data);
             }
         }
 
         result.add(pre);
         result.add(in);
         result.add(post);
         return result;
     }
 
     public static void printList(List<Integer> list) {
         // Iterate through the list
         // and print each element
         for (int num : list) {
             System.out.print(num + " ");
         }
         System.out.println();
     }
     public static void main(String[] args) {
         TreeNode root = new TreeNode(1);
         root.left = new TreeNode(2);
         root.right = new TreeNode(5);
         root.left.left = new TreeNode(3);
         root.left.right = new TreeNode(4);
         root.right.left = new TreeNode(6);
         root.right.right = new TreeNode(7);
 
         List<List<Integer>> result = preInPostTraversal(root);
         List<Integer> pre, in, post;
 
         pre = result.get(0);
         in = result.get(1);
         post = result.get(2);
 
         // Printing the traversals
         System.out.print("Preorder traversal: ");
         printList(pre);
 
         System.out.print("Inorder traversal: ");
         printList(in);
 
         System.out.print("Postorder traversal: ");
         printList(post);
     }
 }
 