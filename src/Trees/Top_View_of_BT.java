package Trees;


import java.util.*;

public class Top_View_of_BT {
    // Function to return a list of TreeNodes visible from the top view
    // from left to right in Binary Tree.

    static class Pair {
        TreeNode TreeNode;
        int lineNum;

        Pair(TreeNode TreeNode, int lineNum) {
            this.TreeNode = TreeNode;
            this.lineNum = lineNum;
        }
    }

    public static void helper(TreeNode root, List<Integer> list) {
        Map<Integer, Integer> map = new TreeMap<>();
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(root, 0));

        while(!q.isEmpty()) {
            int size = q.size();

            for(int i = 0; i < size; i++) {
                Pair obj = q.poll();
                TreeNode curr = obj.TreeNode;
                int currLineNum = obj.lineNum;

                if (!map.containsKey(currLineNum)) map.put(currLineNum, curr.val);

                if(curr.left != null) q.offer(new Pair(curr.left, currLineNum - 1));
                if(curr.right != null) q.offer(new Pair(curr.right, currLineNum + 1));
            }
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            list.add(entry.getValue());
        }
    }

    public static ArrayList<Integer> topView(TreeNode root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        if(root == null) return list;
        helper(root, list);
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.right = new TreeNode(6);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(7);

        System.out.println(topView(root));
    }
}