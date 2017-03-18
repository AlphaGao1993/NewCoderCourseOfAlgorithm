# NewCoderCourseOfAlgorithm
牛客网算法课程专题练习题
#### Chapter1
##### [TreePrinter](https://github.com/AlphaGao1993/NewCoderCourseOfAlgorithm/blob/master/src/Chapter1/TreePrinter.java)
- private static int[][] printTree(TreeNode root)
    + 按层遍历二叉树并按层输出
- private static void printTreeByPreOrderWithRecur(TreeNode root)
    + 先序遍历二叉树(递归)
- private static void printTreeByInOrderWithRecur(TreeNode root)
    + 中序遍历二叉树(递归)
- private static void printTreeByPostOrderWithRecur(TreeNode root)
    + 后序遍历二叉树(递归)
- private static void printTreeByPreOrderWithStack(TreeNode root)
    + 维护一个栈，不断的压入节点的左子树，直到左子树为空。然后继续访问栈顶节点的右子树并出栈
- private static void printTreeByInOrderWithStack(TreeNode root)
    + 中序遍历,维护一个栈，不断的压入节点的左子树，直到左子树为空。然后继续访问栈顶节点，再访问该节点的右节点
- private static void printTreeByPostOrderWithStack(TreeNode root)
    + 后序遍历,维护一个栈，不断的压入某节点下的所有左子树，直到左子树为空;然后切换到右子树再重复此过程;当一个节点的左右子树都为空或都已经被访问，则输出该节点
- public static String getTreeStr(TreeNode root)
    + 调用具体的算法输出打印结果
- private static TreeNode getTreeRoot()
    + 构造一颗二叉树
