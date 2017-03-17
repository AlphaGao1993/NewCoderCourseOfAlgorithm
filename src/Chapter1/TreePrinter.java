package Chapter1;

import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Created by Alpha on 2017/3/17.
 * 有一棵二叉树，请设计一个算法，按照层次打印这棵二叉树。
 * 给定二叉树的根结点root，请返回打印结果，结果按照每一层一个数组进行储存，所有数组的顺
 * 序按照层数从上往下，且每一层的数组内元素按照从左往右排列。保证结点数小于等于500。
 *
 * 本题的重点在于识别和记录当前层的最后一个节点和下一层的最后一个节点，也就是 last 和 nlast 节点
 */
public class TreePrinter {

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


    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }
}
