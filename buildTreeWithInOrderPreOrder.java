import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode{
    int data;
    TreeNode left;
    TreeNode right;
    public TreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}
public class buildTreeWithInOrderPreOrder {

    static TreeNode buildTree(int[] preOrd, int preStart, int preEnd, int[] inOrd, int inStart, int inEnd, Map<Integer, Integer> inOrdmap)
    {
        if(preStart > preEnd || inStart > inEnd) return null;

        TreeNode root = new TreeNode(preOrd[preStart]);

        int inRootVal = inOrdmap.get(root.data);
        int numsLeft = inRootVal - inStart;

        root.left = buildTree(preOrd, preStart + 1, preStart + numsLeft,
                              inOrd, inStart, inRootVal - 1, inOrdmap);
        root.right = buildTree(preOrd, preStart + numsLeft + 1, preEnd,
                                inOrd, inRootVal + 1, inEnd, inOrdmap);

        return root;
    }   

    static void dfs(TreeNode root, List<Integer> list) 
    {
        if(root == null)
            return;
        dfs(root.left, list);
        dfs(root.right, list);
        list.add(root.data);
    }

    public static void main(String[] args) {
        int[] inOrder = {3, 2, 4, 1, 6, 5, 7};
        int[] preOrder = {1, 2, 3, 4, 5, 6, 7};
        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i = 0; i < inOrder.length; i++)
        {
            inMap.put(inOrder[i], i);
        }

        TreeNode root = buildTree(preOrder, 0, preOrder.length - 1, inOrder, 0, inOrder.length - 1, inMap);

        List<Integer> postOrd = new ArrayList<>();
        dfs(root, postOrd);

        System.out.println(" Post Order : " + postOrd);
    }
}
