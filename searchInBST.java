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

public class searchInBST {
    static TreeNode searchBst(TreeNode root, int key)
    {
        while(root != null && root.data == key)
        {
            root = key < root.data ? root.left : root.right;
        }
        return root;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        
        TreeNode res = searchBst(root, 6);

        System.out.println("Node found: " + res.data);
    }
}
