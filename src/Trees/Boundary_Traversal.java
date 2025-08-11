package Trees;

import java.util.*;

public class Boundary_Traversal {

    public static boolean isLeaf(TreeNode root) {
        if(root == null) return false;
        return root.left == null && root.right == null;
    }

    public static void leftBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.left;
        while(curr != null) {
            if(!isLeaf(curr)) res.add(curr.val);
            if(curr.left != null) curr = curr.left;
            else curr = curr.right;
        }
    }

    public static void rightBoundary(TreeNode root, List<Integer> res) {
        TreeNode curr = root.right;
        Stack<Integer> st = new Stack<>();
        while (curr != null) {
            if (!isLeaf(curr)) st.push(curr.val);
            if (curr.right != null) curr = curr.right;
            else curr = curr.left;
        }

        while (!st.isEmpty()) {
            res.add(st.pop());
        }
    }

    public static void addLeavesNodes(TreeNode root, List<Integer> res) {
        // if(root == null) return;
        if (isLeaf(root)) {
            res.add(root.val);
            return;
        }

        if (root.left != null) addLeavesNodes(root.left, res);
        if (root.right != null) addLeavesNodes(root.right, res);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.left.right = new TreeNode(4);
        root.left.left.right.left = new TreeNode(5);
        root.left.left.right.right = new TreeNode(6);
        root.right = new TreeNode(7);
        root.right.right = new TreeNode(8);
        root.right.right.left = new TreeNode(9);
        root.right.right.left.left = new TreeNode(10);
        root.right.right.left.right = new TreeNode(11);

        List<Integer> list = new ArrayList<>();
        if(!isLeaf(root)) list.add(root.val);
        leftBoundary(root, list);
        addLeavesNodes(root, list);
        rightBoundary(root, list);

        System.out.println(list);

        Map<Integer,Integer> map = new TreeMap<>();
    }
}
