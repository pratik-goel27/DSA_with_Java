package Trees;

import java.util.LinkedList;
import java.util.Queue;

public class Max_Width_of_BT {
    static class Pair {
        int idx;
        TreeNode node;
        Pair(int idx, TreeNode node) {
            this.idx = idx;
            this.node = node;
        }
    }

    public static int widthOfBinaryTree(TreeNode root) {
        if(root == null) return 0;
        int ans = 0;
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(0,root));
        while(!q.isEmpty()) {
            int size = q.size();
            int minn = q.peek().idx;
            int first = 0, last = 0;
            for(int i = 0; i < size; i++) {
                int currIdx = q.peek().idx-minn;
                TreeNode currNode = q.peek().node;
                q.poll();
                if(i == 0) first = currIdx;
                if(i == size-1) last = currIdx;
                if(currNode.left != null) q.offer(new Pair((2*currIdx)+1,currNode.left));
                if(currNode.right != null) q.offer(new Pair((2*currIdx)+2,currNode.right));
            }
            ans = Math.max(ans,last-first+1);
        }
        return ans;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(3);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.right.right = new TreeNode(4);

        System.out.println(widthOfBinaryTree(root));
    }
}
