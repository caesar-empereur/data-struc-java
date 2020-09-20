- 树的基本概念
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
        - 中根遍历
            - （中根左子树--->根结点--->中根右子树）--DBGEAFHC  (根结点总是中间到达)
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

