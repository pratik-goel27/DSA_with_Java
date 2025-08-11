package Trees;

public class Lowest_Common_Ancestors {

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q) return root;
        TreeNode left = lowestCommonAncestor(root.left,p,q);
        TreeNode right = lowestCommonAncestor(root.right,p,q);
//        if(left != null && right != null) return root;
//        if(left == null) {
//            if(right != null) return right;
//            else return null;
//        }else {
//            if(right != null) return root;
//            else return left;
//        }
        if(left == null) return right;
        else if(right == null) return left;
        else return root; // both left and right are not null
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        root.left.right.right = new TreeNode(7);
        root.right = new TreeNode(3);

        System.out.println(lowestCommonAncestor(root,root.left,root.left.right.left).val);
    }
}
