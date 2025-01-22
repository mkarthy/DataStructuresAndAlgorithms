//check if the given tree is a Binary Search Tree
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

public class validateaBST {
    static boolean isBST(TreeNode root, int minVal, int maxVal)
    {
        if (root == null) return true;

        if( root.data <= minVal || root.data >= maxVal) return false;

        return isBST(root.left, minVal, root.data) 
            && isBST(root.right, root.data, maxVal);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);

        if (isBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE))
            System.out.println("Tree is BST");
        else
            System.out.println("Tree is NOT BST");
    }
}
