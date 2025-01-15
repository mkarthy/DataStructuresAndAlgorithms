import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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

public class treeNodesAtKthdistance
{
    static void parentTrack(TreeNode root, Map<TreeNode,TreeNode> parentTracker)
    {
        Queue<TreeNode> trQue = new LinkedList<>();
        trQue.add(root);
        while (!trQue.isEmpty()) { 
            TreeNode node = trQue.poll();
            if( node.left != null)
            {
                parentTracker.put(node.left, node);
                trQue.add(node.left);
            }
            if( node.right != null)
            {
                parentTracker.put(node.right, node);
                trQue.add(node.right);
            }
        }
    }

    static List<Integer> findKthNodes(TreeNode root, TreeNode fromNode, int k)
    {
        List<Integer> result = new ArrayList<>();
        if( root == null || fromNode == null)
            return result;

        Map<TreeNode, TreeNode> parentTracker = new HashMap<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> treeQue = new LinkedList<>();

        parentTrack(root, parentTracker);
        treeQue.offer(fromNode);
        visited.put(fromNode, true);
        int counter = 0;

        while(!treeQue.isEmpty())
        {
            int size = treeQue.size();
            if(counter == k) break;
            counter++;
            for( int i = 0; i < size; i++)
            {
                TreeNode node = treeQue.poll();
                if(node.left != null && visited.get(node.left) == null)
                {
                    visited.put(node.left, true);
                    treeQue.offer(node.left);
                }
                if(node.right != null && visited.get(node.right) == null)
                {
                    visited.put(node.right, true);
                    treeQue.offer(node.right);
                }
                if((parentTracker.get(node) != null) && (visited.get(parentTracker.get(node)) == null))
                {
                    visited.put(parentTracker.get(node), true);
                    treeQue.offer(parentTracker.get(node));
                }
            }
        }
        while(!treeQue.isEmpty())
        {
            TreeNode node = treeQue.poll();
            result.add(node.data);
        }
        return result;
    }
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);
        root.left.right.left = new TreeNode(7);
        //root.left.left.right = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        //root.right.right.left = new TreeNode(4);

        List<Integer> res = findKthNodes(root,root.left, 2);

        System.out.println("K elements are : " + res);
    }
}