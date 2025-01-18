import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

public class serializeDeserializeBT {
    static String serializeBtree(TreeNode root)
    {
        if ( root == null)
            return " ";

        StringBuilder result = new StringBuilder();
        Queue<TreeNode> treeQueue = new LinkedList<>();
        
        treeQueue.add(root);

        while(!treeQueue.isEmpty())
        {
            TreeNode node = treeQueue.poll();
            
            if(node == null){
                result.append("n,");
            }
            else{
                result.append(node.data).append(",");
                treeQueue.add(node.left);
                treeQueue.add(node.right);
            }
        }
        return result.toString();
    }

    static TreeNode deserializeBtree(String input)
    {
        if (input.isEmpty() ) return null;
        String[] values = input.split(",");

        TreeNode root = new TreeNode(Integer.parseInt(values[0]));
        Queue<TreeNode> trque = new LinkedList<>();
        trque.offer(root);

        for(int i = 1; i < values.length; i++)
        {
            TreeNode node = trque.poll();   
            if(!values[i].equals("n"))
            {
                node.left = new TreeNode(Integer.parseInt(values[i]));
                trque.add(node.left);
            }
            if(!values[++i].equals("n"))
            {
                node.right = new TreeNode(Integer.parseInt(values[i]));
                trque.add(node.right);
            }
        }
        return root;
    }

    static void dfs(TreeNode root, List<Integer> list) 
    {
        if(root == null)
            return;

        list.add(root.data);
        dfs(root.left, list);
        dfs(root.right, list);
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);

        String serializedBtree = serializeBtree(root);
        System.out.println(" Serialized String: " + serializedBtree);

        TreeNode reroot = deserializeBtree(serializedBtree);

        List<Integer> preOrd = new ArrayList<>();
        dfs(reroot, preOrd);

        System.out.println(" Post Order : " + preOrd);
    }
}
