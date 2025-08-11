package Trees;

import java.util.*;

public class Zig_Zag_Traversal {

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        if(root == null) return list;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        boolean LeftToRight = true;

        while(!q.isEmpty()) {
            int size = q.size();
            Integer[] arr = new Integer[size];
            for(int i = 0; i < size; i++) {
                root = q.poll();
                int index = (LeftToRight) ? i : (size-1-i);
                arr[index] = root.val;
                if(root.left != null) q.offer(root.left);
                if(root.right != null) q.offer(root.right);
            }
            LeftToRight = !LeftToRight;
            list.add(Arrays.asList(arr));
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(zigzagLevelOrder(root));
    }
}
