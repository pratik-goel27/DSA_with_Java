package Trees;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Min_Time_to_Burn_BT {
    public static TreeNode getReference(TreeNode root, int target) {
        if (root == null) return null;

        if (root.val == target) return root;

        TreeNode left = getReference(root.left, target);
        if (left != null) return left;

        return getReference(root.right, target);
    }

    public static void markingParent(TreeNode root, HashMap<TreeNode,TreeNode> parent_track) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            TreeNode curr = q.poll();

            if(curr.left != null) {
                q.offer(curr.left);
                parent_track.put(curr.left, curr);
            }
            if(curr.right != null) {
                q.offer(curr.right);
                parent_track.put(curr.right, curr);
            }
        }
    }

    public static int minTime(TreeNode root, int target) {
        // code here
        HashMap<TreeNode, TreeNode> parent_track = new HashMap<>();
        markingParent(root, parent_track);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        TreeNode src = getReference(root, target);
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(src);
        visited.put(src, true);
        int curr_level = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            boolean anyTreeNodeBurned = false;

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if((curr.left != null) && (visited.get(curr.left)) == null) {
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                    anyTreeNodeBurned = true;
                }
                if((curr.right != null) && (visited.get(curr.right)) == null) {
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                    anyTreeNodeBurned = true;
                }
                if(parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
                    q.offer(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                    anyTreeNodeBurned = true;
                }
            }

            if(anyTreeNodeBurned) curr_level++;
        }

        return curr_level;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.left.right = new TreeNode(7);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(6);

        System.out.println(minTime(root, 2));
    }
}
