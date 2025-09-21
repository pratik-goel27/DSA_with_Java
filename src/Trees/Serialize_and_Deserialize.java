package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Serialize_and_Deserialize {
    public static String serialize(TreeNode root) {
        StringBuilder str = new StringBuilder("");
        if(root == null) return str.toString();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                root = q.poll();

                if(root != null) str.append(root.val).append(",");
                else {
                    str.append("#,");
                    break;
                }

                if(root.left != null) q.offer(root.left);
                else q.offer(null);

                if(root.right != null) q.offer(root.right);
                else q.offer(null);
            }
        }
        return str.toString();
    }


//    public static TreeNode deserialize(String str) {
//
//    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(5);

        System.out.println(serialize(root));
    }
}
