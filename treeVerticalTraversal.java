import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.TreeMap;
import java.util.TreeSet;

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

class qNode{
    TreeNode node;
    public TreeNode getNode() {
        return node;
    }

    public void setNode(TreeNode node) {
        this.node = node;
    }

    public int getVertLevel() {
        return vertLevel;
    }

    public void setVertLevel(int vertLevel) {
        this.vertLevel = vertLevel;
    }

    public int getHoriLevel() {
        return horiLevel;
    }

    public void setHoriLevel(int horiLevel) {
        this.horiLevel = horiLevel;
    }

    int vertLevel;
    int horiLevel;
    
    public qNode(TreeNode node, int vertLevel, int horiLevel) {
        this.node = node;
        this.vertLevel = vertLevel;
        this.horiLevel = horiLevel;
    }
}

public class treeVerticalTraversal{
    static List<List<Integer>> traverseVertical(TreeNode root)
    {
        List<List<Integer>> result = new LinkedList<>();
        Queue<qNode> travQueue = new LinkedList<>();
        Map<Integer, Map<Integer, TreeSet<Integer>>> mapper = new TreeMap<>();
        
        if(root == null)
            return result;

        travQueue.add(new qNode(root, 0,0));
        
        while(!travQueue.isEmpty())
        {
            qNode qn = travQueue.poll();
            TreeNode node = qn.getNode();

            mapper.computeIfAbsent(qn.getVertLevel(), k -> new TreeMap<>())
                    .computeIfAbsent(qn.getHoriLevel(), k -> new TreeSet<>())
                    .add(node.data);

            if(node.left != null)
            {         
                travQueue.add(new qNode(node.left, qn.getVertLevel() - 1, qn.getHoriLevel() + 1));
            }

            if(node.right != null)
            {
                travQueue.add(new qNode(node.right, qn.getVertLevel() + 1, qn.getHoriLevel() + 1));
            }
        }

        for(Map.Entry<Integer, Map<Integer, TreeSet<Integer>>> vertEntry: mapper.entrySet())
        {
            List<Integer> vVals = new ArrayList<>();
            Map<Integer, TreeSet<Integer>> tremp = vertEntry.getValue();
            for(TreeSet<Integer> trVals: tremp.values())
            {
                vVals.addAll(trVals);
            }
            result.add(vVals);
        }
        return result;
    }

    static void printResult(List<List<Integer>> result) {
        for (List<Integer> level : result) {
            for (int node : level) {
                System.out.print(node + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {
        /* 
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        */

        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(10);
        root.left.left.right = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(10);
        root.right.left = new TreeNode(9);
        
        List<List<Integer>> verticalTraversal = traverseVertical(root);

        // Print the result
        System.out.print("Vertical Traversal: \n");
        printResult(verticalTraversal);

    }
}