package Trees;

public class Children_Sum_Property {

    //Modifying the tree to follow the children sum property:-
    public static void childSumProperty(TreeNode root) {
        //  code here
        if(root == null) return;

        int child = 0;
        if(root.left != null) {
            child += root.left.val;
        }
        if(root.right != null) {
            child += root.right.val;
        }

        if(child >= root.val) root.val = child;
        else {
            if(root.left != null) root.left.val = root.val;
            if(root.right != null) root.right.val = root.val;
        }

        childSumProperty(root.left);
        childSumProperty(root.right);

        int tot = 0;
        if(root.left != null) tot += root.left.val;
        if(root.right != null) tot += root.right.val;
        if(root.left != null || root.right != null) root.val = tot;
    }


    //Checking if the tree follows the children sum property:-
    public static boolean isChildSumProperty(TreeNode root) {
        if((root == null) || (root.left == null && root.right == null)) return true;

        int leftData = (root.left != null) ? root.left.val : 0;
        int rightData = (root.right != null) ? root.right.val : 0;

        return (leftData + rightData == root.val) &&
                (isChildSumProperty(root.left)) &&
                (isChildSumProperty(root.right));
    }

    public static void preorder(TreeNode root) {
        if(root == null) return;

        System.out.print(root.val+" ");
        preorder(root.left);
        preorder(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(40);
        root.left = new TreeNode(10);
        root.right = new TreeNode(20);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(30);
        root.right.right = new TreeNode(40);

//        preorder(root);
//        childSumProperty(root);
//        System.out.println();
//        preorder(root);

        System.out.println(isChildSumProperty(root));

    }
}
