package com.tree;

import com.stackqueue.LinkStack;

/**
 * Created by yang on 2020/9/21.
 */
public class BinaryTree<T> {

    /**二叉树的先根遍历的非递归方式
     *
     * 先访问A，A 的右子节点C入栈，然后访问A 的左子节点B，B再变成根节点
     * B 的右子节点E入栈，访问B的左子节点D，D再变成根节点
     * D为根节点跳出第一个while循环，栈有元素就弹出栈顶元素，为E，E 变成根节点
     * E 访问完左子节点G之后又跳出第一个while循环，栈弹出栈顶元素C，继续以上操作
     */
    public void preRootTraverse(BinaryTreeNode<T> root){
        if (root == null){
            return;
        }
        LinkStack<BinaryTreeNode<T>> linkStack = new LinkStack<>();
        //根节点先入栈
        linkStack.push(root);
        while (!linkStack.isEmpty()) {
            //弹出根节点
            root = linkStack.pop();
            //访问根节点
            System.out.println(root.data);
            while (root != null) {
                if (root.rchild != null) {
                    //先将根节点的右子节点入栈，对应图片的C
                    linkStack.push(root.rchild);
                }
                if (root.lchild != null) {

                    if (root.lchild != null){
                        // 访问根节点的左子结点
                        System.out.println(root.lchild);
                    }
                    //这时候根节点的左子节点变成一个根节点
                    if (root.rchild != null){
                        root = root.lchild;
                    }
                }
            }
        }
    }

    /**
     * 二叉树的中根遍历
     *
     *A B D 连续入栈，然后D出栈，B出栈，B成为根节点
     * B 的右子节点E入栈，这时候栈元素为 [A, E]
     * E 的左子节点继续入栈，[A, E, G]
     * 再进行一次外层while循环，G 出栈， E出栈，根节点变成A，访问A，A 的右字节点 C 入栈
     * C的左子节点 F 入栈，此时栈元素为 [C, F]
     * F 出栈，成为根节点，F的右子节点入栈，栈元素为 [C, H]
     * H, C 依次出栈
     */
    public void midRootTraverse(BinaryTreeNode<T> root){
        if (root == null) {
            return;
        }
        LinkStack<BinaryTreeNode<T>> stack = new LinkStack<>();
        //根节点入栈
        stack.push(root);
        while (!stack.isEmpty()) {
            while (stack.getHead() != null){
                //根节点的左子节点的左子节点....一直入栈
                stack.push(stack.getHead().lchild);
            }
            //最左边的左子节点是栈顶，出战，对应图中的D出栈
            stack.pop();
            if (!stack.isEmpty()) {
                //这里出栈是最左边的根节点出栈，并且把最左边的根节点当成根节点
                root = stack.pop();
                System.out.println(root.data);
                //最左边的根节点的右子节点入栈
                stack.push(root.rchild);
            }
        }
    }

    /**
     * 先根遍历的递归方式
     */
    public void preRootAccess(BinaryTreeNode<T> root){
        if (root == null){
            return;
        }
        System.out.println(root.data);
        preRootAccess(root.lchild);
        preRootAccess(root.rchild);
    }

    /**
     * 中根遍历的递归方式
     */
    public void midRootAccess(BinaryTreeNode<T> root){
        if (root == null){
            return;
        }
        preRootAccess(root.lchild);
        System.out.println(root.data);
        preRootAccess(root.rchild);
    }

    /**
     * 后根遍历的递归方式
     */
    public void postRootAccess(BinaryTreeNode<T> root){
        if (root == null){
            return;
        }
        preRootAccess(root.lchild);
        preRootAccess(root.rchild);
        System.out.println(root.data);
    }



    private static class BinaryTreeNode<T> {
        public T data;
        public BinaryTreeNode lchild, rchild;
        public BinaryTreeNode() {
            this(null);
        }
        public BinaryTreeNode(T data) {
            this.data = data;
        }
        public BinaryTreeNode(T data, BinaryTreeNode rchild) {
            this.data = data;
            this.lchild = lchild;
            this.rchild = rchild;
        }
    }
}
