### HashMap总结

#### V get(Object key)

先调用`hash(key)`得到key的哈希值，再调用 `getNode(int hash, Object key)`，根据hash与 object table数组找到hash对应的链表，

1.如果链表不存在返回null；

2.链表存在时：

  (1) 检查头结点的key如果正好是要查的目标则返回其值；

  (2) 当链表不止一个结点时：

​    (a) 如果结点类型是`TreeNode`，调用`first.getTreeNode(hash, key)`，从根结点开始查找key，底层实现是红黑树，时间复杂度是`log(N)`。（N为树的元素个数）

​    (b) 不是`TreeNode`则遍历链表查找key，存在时返回对应value，不存在返回null。

#### put(K key, V value)

先调用`hash(key)`得到key的哈希值，再调用 `V putVal(int hash, K key, V value)`添加键值对。底层Object数组为空时执行`resize()`进行初始化。

利用hash找到Object数组对应位置的链表，

  (1) 为空则创建新链表;

  (2) 不为空时判断头结点是要找的key时记录其值，判断ifAbsent参数，并将旧值返回；

  (3) 如果结点类型为`TreeNode`调用`p.putTreeVal`将键值对添加到树中；

  (4) 将新键值对添加到链表中（遍历找到key后赋值），判断如果链表长度超过阈值(默认8)则将链表升级为树结构；

如果是新增的key（非替换已有key的值），将size自增并在必要时扩容数组。
