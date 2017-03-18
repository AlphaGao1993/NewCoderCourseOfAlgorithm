package Chapter1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 * Created by Alpha on 2017/3/17.
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺
 * 序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 * <p>
 * 本题的重点在于识别和记录当前层的最后一个节点和下一层的最后一个节点，也就是 last 和 nlast 节点
 */
public class TreePrinter {

    /**
     * 按层遍历二叉树并按层输出
     *
     * @param root 二叉树根节点
     * @return
     */
    public int[][] printTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        LinkedList<TreeNode> quene = new LinkedList<>();//模拟队列
        ArrayList<Integer> arr = new ArrayList<>();//存储当前层的节点
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();//存储所有层的节点
        TreeNode last = root;//当前层的最后一个节点
        TreeNode nlast = null;//下一层的最后一个节点
        TreeNode temp;
        quene.add(last);//让根节点入队
        while (!quene.isEmpty()) {//如果队列不为空
            temp = quene.poll();//取出队头结点
            arr.add(temp.val);//把头结点加入当如当前层的列表
            if (temp.left != null) {//如果左节点不为空
                quene.add(temp.left);//将左节点入队
                nlast = temp.left;//是当前层最后一个节点
            }
            if (temp.right != null) {//如果右节点不为空
                quene.add(temp.right);
                nlast = temp.right;//如果有右节点，那么右节点就成为当前层最后一个节点
            }
            if (temp == last) {
                ans.add(arr);//将当前层放入双层链表
                arr = new ArrayList<>();//构建新的当前层链表
                last = nlast;//换行
            }
        }

        int[][] s = new int[ans.size()][];
        for (int i = 0; i < ans.size(); i++) {
            s[i] = new int[ans.get(i).size()];//需要实例化数组长度
            for (int j = 0; j < ans.get(i).size(); j++) {
                s[i][j] = ans.get(i).get(j);
            }
        }
        return s;
    }

    private static List<String> str1;

    public static String getTreeStr(TreeNode root) {
        str1 = new ArrayList<>();
        //printTreeByPreOrderWithRecur(root);
        //printTreeByInOrderWithRecur(root);
        //printTreeByPostOrderWithRecur(root);
        printTreeByPreOrderWithStack(root);
        StringBuilder str = new StringBuilder();
        for (String s : str1) {
            str.append(s);
        }
        return str.toString();
    }

    /**
     *
     *先序遍历二叉树(递归)
     * @param root 根节点
     * @return 先序遍历合成的字符串
     */
    private static void printTreeByPreOrderWithRecur(TreeNode root) {
        if (root != null) {
            str1.add(root.val + "!");
            printTreeByPreOrderWithRecur(root.left);
            printTreeByPreOrderWithRecur(root.right);
        } else {
            str1.add("#!");
        }
    }

    /**
     * 中序遍历二叉树(递归)
     *
     * @param root 根节点
     * @return 先序遍历合成的字符串
     */
    private static void printTreeByInOrderWithRecur(TreeNode root) {
        if (root != null) {
            printTreeByInOrderWithRecur(root.left);
            str1.add(root.val + "!");
            printTreeByInOrderWithRecur(root.right);
        } else {
            str1.add("#!");
        }
    }

    /**
     * 后序遍历二叉树(递归)
     *
     * @param root 根节点
     * @return 先序遍历合成的字符串
     */
    private static void printTreeByPostOrderWithRecur(TreeNode root) {
        if (root != null) {
            printTreeByPostOrderWithRecur(root.left);
            printTreeByPostOrderWithRecur(root.right);
            str1.add(root.val + "!");
        } else {
            str1.add("#!");
        }
    }

    /**
     * 维护一个栈，不断的压入节点的左子树，直到左子树为空。然后继续访问栈顶节点的右子树并出栈
     *
     * @param root 根节点
     */
    private static void printTreeByPreOrderWithStack(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        while (root != null || !stack.isEmpty()) {//只要节点不为空或者栈不为空
            while (root != null) {//当前节点不为空，访问并入栈
                str1.add(root.val + "!");
                stack.push(root);
                root = root.left;//继续访问左节点
            }
            str1.add("#!");//当前节点为空,输出空
            root = stack.pop();//访问栈中的顶部节点，并出栈，因为栈中的节点的左节点已经被访问过
            root = root.right;//所有直接访问右节点
        }
        str1.add("#!");//最后一个出栈的节点是最后一个节点，因为其右节点为空，同时栈内已经没有元素，所以无法访问，手动添加结束
    }

    private static TreeNode getTreeRoot() {
        TreeNode node = new TreeNode(1);
        node.left = new TreeNode(2);
        node.right = new TreeNode(3);
        node.left.left = new TreeNode(4);
        node.left.right = new TreeNode(5);
        node.right.left = new TreeNode(6);
        node.right.right = new TreeNode(7);
        return node;
    }

    public static void main(String[] args) {
        String treeStr = getTreeStr(getTreeRoot());
        System.out.println(treeStr);
    }


    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
