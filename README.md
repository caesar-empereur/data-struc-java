## 第六章 树和二叉树
- 树的基本知识
    - 结点的度：一个结点拥有的子结点的数量
    - 树的度：  树中所有结点的度的最大值，就是结点的子结点的最大值
    - 树的深度：就是树的层次数
    - 满二叉树与完全二叉树
    ![2pc](https://github.com/caesar-empereur/data-struc-java/blob/master/doc/满二叉树.png)

- 二叉树的性质
    - 第i层上结点数最多为 2的 i次方
    - 深度为 h 的二叉树最多有 2^h - 1 个结点
    - N个结点的完全二叉树, 深度是 log2(n+1)

- 二叉树的遍历
![2pc](https://github.com/caesar-empereur/data-struc-java/blob/master/doc/二叉树的遍历.png)
    - 层次遍历
        - ABCDEFGH
    - 先根遍历
        - 根结点--->先根左子树--->先根右子树）--ABDEGCFH  (根结点总是先到达)
        ```
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
        ```
    - 中根遍历
        - （中根左子树--->根结点--->中根右子树）--DBGEAFHC  (根结点总是中间到达)
        ```
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
        ```
    - 后根遍历
        - （后根左子树--->后根右子树--->根结点）--DGEBHFCA  (有根结点的总是慢到达)
- 二叉树的查找过程
    - 二叉排序树的定义
        - 如果左子树不为控，左子树上的结点的值都小于根结点的值右子树不为控，右子树上的结点的值都大于根节点的值
    ![2pc](https://github.com/caesar-empereur/data-struc-java/blob/master/doc/二叉排序树.png)
    - 查找过程
        -  (时间复杂度跟有序表的查找一样， O(log2(n)) （log2(n) 是树的深度）
        - 树为空，查找失败
        - 给定值 k 等于根节点的关键字的值,则查找成功，返回
        - k 小于根节点关键字的值，继续在根结点的左子树上进行查找
        - k 大于根结点关键字的值，继续在根结点的右子树上进行查找
    - 插入过程
        - 待插入的key,先要在二叉排序树中查找, 查找成功，插入结点已经存在，不需要插入。
        - 否则插入，一定是作为叶子结点插入的，插入时要注意排序
    - 二叉排序树的缺点
    ```
    二叉排序树的查找效率与树的形状有关，给定序列建立的二叉排序树，如果左右子树分布
    均匀，则查找时间复杂度为 O(log2(n))，如果原来的序列已经是有序的，建立的二叉排序树
    就变为单链表, 查找时间复杂度变为 O(n)---看上面的图
    ```
    ![2pc](https://github.com/caesar-empereur/data-struc-java/blob/master/doc/二叉排序树的缺点.png)
- 平衡二叉树
    - 也叫平衡二叉排序树,就是一颗二叉排序树加上平衡的限制, AVL树
    - 平衡二叉树进行插入删除结点后，可能会使二叉树失去平衡, 因此需要重新调整为平衡二叉树
    ```
    二叉排序树的插入和删除操作采用平衡二叉树的优点是：
    使二叉树的结构更好，从而提高了查找的速度，缺点是插入和删除操作变得复杂，降低了插入和删除操作的
    速度，平衡二叉树适合于二叉排序树一建立后就很少进行插入和删除操作，主要进行查找操作的场合中
    ```
    ![2pc](https://github.com/caesar-empereur/data-struc-java/blob/master/doc/平衡二叉树.png)
    
## 第七章 查找
- 静态查找
    - 顺序查找(线性查找)
        ```
        从静态查找表的一端开始，将给定记录的关键字与表中各记录的关键字逐一比较，
        若表中存在要查找的记录，则查找成功
        ```
        - 顺序查找方法既适用于线性表的顺序存储结构，也适用于线性表的链式存储结构
    - 二分查找
        - 线性表中的元素必须按照关键字排序，查找过程就是先对比中间的元素，不是的话再对比大小选择2边的元素对比
- 动态查找
    - 静态查找表生成之后，一般固定不变，动态查找表是在查找过程中动态生成的
        ```
        静态查找相当于对查找表来说，只需要对查找表本身进行查找判断，
        动态表的除了查找表之外，需要维护一个外部的表来做查询,相当于 mysql 除了数据页之外，
        还需要维护索引页数据
        ```
    - 二叉排序树
        - 左子节点的值小于右子节点的值，且小于根节点的值，二叉排序树无须移动节点，只需要修改引用关系
        - 二叉排序树理想情况的查找效率为 O(log2(n)), 最差情况的查找效率是 O(N),变成了链表结构
    - 平衡二叉树
        - 为了防止二叉排序树变成链表的结构，需要对树做平衡处理
        - 左子树与右子树的深度只差不超过1
        - 它的左、右子树也分别是平衡二叉树
        - 平衡二叉树节点变化后的平衡处理
        ![2pc](https://github.com/caesar-empereur/data-struc-java/blob/master/doc/平衡二叉树的旋转.png)
- 哈希表
    - 关键字与存储位置之间有直接关系的表成为哈希表，构造关系的函数成为哈希函数
    - 哈希碰撞之后的解决方式有 再哈希法， 与链地址法

## 第八章 排序
- 插入排序
    - 直接插入排序
    - 希尔排序
- 交换排序
    - 冒泡排序
    - 快速排序
- 选择排序
    - 简单选择排序
    - 堆排序
- 归并排序
