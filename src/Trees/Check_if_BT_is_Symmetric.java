package Trees;

public class Check_if_BT_is_Symmetric {
    public static boolean isSymmetric(TreeNode root) {
        return (root == null) || helper(root.left, root.right);
    }

    public static boolean helper(TreeNode p, TreeNode q) {
        if(p == null || q == null) return (p == q);
        return (p.val == q.val) && helper(p.left,q.right) && helper(p.right, q.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(2);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);

        System.out.println("The given tree is symmetric?: "+isSymmetric(root));
    }
}
