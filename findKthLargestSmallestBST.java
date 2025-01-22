
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
class counter{
    int val;

    public counter(int val) {
        this.val = val;
    }
}

class result{
    int val;

    public result(int val) {
        this.val = val;
    }
}

public class findKthLargestSmallestBST {
    static void findkthSmallestbyInOrder(TreeNode root, int k, counter ctr, result res)
    {
        if( root == null || ctr.val == k ) return;

        findkthSmallestbyInOrder(root.left, k, ctr, res);

        ctr.val++;
        if(ctr.val == k)
            res.val = root.data;

        findkthSmallestbyInOrder(root.right, k, ctr, res);
    }

    static void findkthLargestbyInOrder(TreeNode root, int k, counter ctr, result res)
    {
        if( root == null || ctr.val == k ) return;

        findkthLargestbyInOrder(root.right, k, ctr, res);

        ctr.val++;
        if(ctr.val == k)
            res.val = root.data;

        findkthLargestbyInOrder(root.left, k, ctr, res);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(10);
        
        counter ctr = new counter(0);
        result res = new result(0);
        findkthSmallestbyInOrder(root, 3, ctr, res);
        System.out.println("Result : "+ res.val);

        counter ctr1 = new counter(0);
        result res1 = new result(0);
        findkthLargestbyInOrder(root, 3, ctr1, res1);
        System.out.println("Result : "+ res1.val);

    }
}
