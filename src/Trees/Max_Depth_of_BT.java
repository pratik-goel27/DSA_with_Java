package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Max_Depth_of_BT {

    public static int maxDepth(TreeNode root) {
        //Using Recursion:-
//        if(root == null) {
//            return 0;
//        }
//        int l = maxDepth(root.left);
//        int r = maxDepth(root.right);
//        return Math.max(l,r)+1;

        //Using Level Order Traversal: -
        if(root == null) return 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        int ans = 0;
        while(!q.isEmpty()) {
            ans++;
            int size = q.size();
            for(int i = 0; i < size; i++) {
                root = q.poll();
                if(root.left != null) q.offer(root.left);
                if(root.right != null) q.offer(root.right);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(5);

        System.out.println(maxDepth(root));
    }
}
