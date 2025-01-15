import java.util.LinkedList;
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

class qPair{
    TreeNode node;
    int idx;
    public qPair(TreeNode node, int idx) {
        this.node = node;
        this.idx = idx;
    }
    
}


public class treeMaxWidth {
    static int maxWidth(TreeNode root)
    {
        int result = 0;
        if(root == null)
            return result;

        Queue<qPair> qpr = new LinkedList<>();
        qpr.add(new qPair(root, 0));

        while(!qpr.isEmpty())
        {
            int mmin = qpr.peek().idx;
            int first = 0, last = 0;
            int size = qpr.size();

            for(int i = 0; i < size; i++)
            {
                int idxctr = qpr.peek().idx - mmin;
                TreeNode tNode = qpr.peek().node;
                qPair qnode = qpr.poll();

                if( i == 0 )
                    first = idxctr;

                if( i == size - 1)
                    last = idxctr;

                if(tNode.left != null)
                {
                    qpr.add(new qPair(tNode.left, idxctr * 2 + 1));
                }
                if(tNode.right != null)
                {
                    qpr.add(new qPair(tNode.right, idxctr * 2 + 2));
                }
            }
            result = Math.max(result, last - first + 1);
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
        //root.left.right.left = new TreeNode(7);
        root.left.left.right = new TreeNode(7);
        //root.left.right.right = new TreeNode(4);
        root.right.right.left = new TreeNode(4);

        int maxWidth = maxWidth(root);

        System.out.println("Maximum width of the binary tree is: " + maxWidth);
    }
}
