package Trees;

import java.util.*;

public class All_Nodes_Distance_K {

    public static void markingParent(TreeNode root, Map<TreeNode, TreeNode> parent_track) {
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode curr = q.poll();

            if (curr.left != null) {
                parent_track.put(curr.left, curr);
                q.offer(curr.left);
            }
            if (curr.right != null) {
                parent_track.put(curr.right, curr);
                q.offer(curr.right);
            }
        }
    }

    public static List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        HashMap<TreeNode, TreeNode> parent_track = new HashMap<>();
        markingParent(root, parent_track);
        HashMap<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(target);
        visited.put(target, true);
        int curr_level = 0;

        while(!q.isEmpty()) {
            int size = q.size();
            if(curr_level == k) break;
            curr_level++;

            for(int i = 0; i < size; i++) {
                TreeNode curr = q.poll();

                if(curr.left != null && visited.get(curr.left) == null) {
                    q.offer(curr.left);
                    visited.put(curr.left, true);
                }
                if(curr.right != null && visited.get(curr.left)) {
                    q.offer(curr.right);
                    visited.put(curr.right, true);
                }
                if(parent_track.get(curr) != null && visited.get(parent_track.get(curr)) == null) {
                    q.offer(parent_track.get(curr));
                    visited.put(parent_track.get(curr), true);
                }
            }
        }

        List<Integer> list = new ArrayList<>();
        while(!q.isEmpty()) {
            list.add(q.poll().val);
        }
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        root.right = new TreeNode(1);
        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        System.out.println(distanceK(root,root.left,3));
    }
}