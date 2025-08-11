//PREORDER, INORDER, POSTORDER(BOTH USING RECURSION AND ITERATIVE METHOD)
//LEVEL ORDER TRAVERSAL
package Trees;

import java.util.*;

public class Traversal_Techniques {

//    static class TreeNode {
//        int val;
//        TreeNode left;
//        TreeNode right;
//
//        public TreeNode(int val) {
//            this.val = val;
//            this.left = null;
//            this.right = null;
//        }
//    }

    public static List<Integer> preOrder(TreeNode root) {
        // RECURSIVE:-
//        List<Integer> list = new ArrayList<>();
//        if(root == null) {
//            return list;
//        }
//        list.add(root.val);
//        list.addAll(preOrder(root.left));
//        list.addAll(preOrder(root.right));
//        return list;

        //ITERATIVE:-
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        st.push(root);
        while(!st.isEmpty()) {
            root = st.pop();
            list.add(root.val);
            if(root.right != null) st.push(root.right);
            if(root.left != null) st.push(root.left);
        }
        return list;
    }

    public static List<Integer> inOrder(TreeNode root) {
        //RECURSIVE:-
//        List<Integer> list = new ArrayList<>();
//        if(root == null) {
//            return list;
//        }
//        list.addAll(inOrder(root.left));
//        list.add(root.val);
//        list.addAll(inOrder(root.right));
//        return list;

        //ITERATIVE:-
        List<Integer> list = new ArrayList<>();
        Stack<TreeNode> st = new Stack<>();
        while(true) {
            if(root != null) {
                st.push(root);
                root = root.left;
            }else {
                if(st.isEmpty()) break;
                root = st.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    public static List<Integer> postOrder(TreeNode root) {
        //RECURSIVE:-
//        List<Integer> list = new ArrayList<>();
//        if(root == null) return list;
//        list.addAll(postOrder(root.left));
//        list.addAll(postOrder(root.right));
//        list.add(root.val);
//        return list;

        //ITERATIVE(USING 2 STACKS):-
//        Stack<TreeNode> st1 = new Stack<>();
//        Stack<TreeNode> st2 = new Stack<>();
//        List<Integer> list = new ArrayList<>();
//        if(root == null) return list;
//        st1.push(root);
//        while(!st1.isEmpty()) {
//            root = st1.pop();
//            st2.push(root);
//            if(root.left != null) st1.push(root.left);
//            if(root.right != null) st1.push(root.right);
//        }
//        while(!st2.isEmpty()) {
//            list.add(st2.pop().val);
//        }
//
//        return list;

        //ITERATIVE(USING 1 STACK):-
        Stack<TreeNode> st = new Stack<>();
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;
        TreeNode temp = null;
        while(curr != null || !st.isEmpty()) {
            if(curr != null) {
                st.push(curr);
                curr = curr.left;
            }else {
                temp = st.peek().right;
                if(temp == null){
                    temp = st.pop();
                    list.add(temp.val);
                    while(!st.isEmpty() && temp == st.peek().right) {
                        temp = st.pop();
                        list.add(temp.val);
                    }
                }else {
                    curr = temp;
                }
            }
        }
        return list;
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> wrapList = new LinkedList<>();
        if(root == null) return wrapList;
        q.offer(root);

        while(!q.isEmpty()) {
            int levelNum = q.size();
            List<Integer> subList = new LinkedList<>();
            for(int i = 0; i < levelNum; i++) {
                root = q.poll();
                subList.add(root.val);
                if(root.left != null) q.offer(root.left);
                if(root.right != null) q.offer(root.right);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        /*
                      1
                     /  \
                    2    3
                   / \  / \
                  4  5  6  7
        */
        System.out.println(levelOrder(root));
//        System.out.println(preOrder(root));
        System.out.println(inOrder(root));
        System.out.println(postOrder(root));
    }
}
