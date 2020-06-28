### 学习笔记
  本周刷题小结：
    1.跟着节奏走，从最开始的毫无头绪到同类是上渐渐能想出基本解题思路，真的是越做越顺；
    2.还是要用老师说的“五毒神掌”方法多写几遍，要不然过很容易忘掉或者虽然记得大致思路但提笔就错
      （做题过程中就遇到过几次，思路很清楚但细节处理不到导致过不了）
    3.周末爬了个山，意识到一个问题：
      如果不把步子迈出去就无法清楚自己到底有多菜。
      万事开头难，开始这一段时间会很难受想放弃，如果能继续坚持后面会感觉好很多。
      到最后到达山顶时回头看：
        1.山上人很多、空气好、景色美；
        2.比起“一览众楼小”带来的快感，这点苦真的没什么。

### 1.改写Deque
```
  Deque<String> deque = new LinkedList<String>();
  deque.addFirst("a");
  deque.addFirst("b");
  deque.addFirst("c");
  System.out.println(deque);

  String str = deque.peek();
  System.out.println(str);
  System.out.println(deque);

  while(deque.size() > 0) {
    System.out.println(deque.removeFirst());
  }
  System.out.println(deque);
```

### 2.Queue和PriorityQueue源码分析
#### Queue
  Queue是一个Java泛型接口，定义了队列的两组抽象接口方法：
  插入、删除、查看分别为①insert(E e)、remove()、element()；②offer(E e)、poll()、peek()
  第①组方法在队列满、空时会抛异常；第②组方法则会返回特定值false或null
#### PriorityQueue
 PriorityQueue是优先级队列的java实现泛型类，无界。
 1.元素类型必须是comparable的(通过实现Comparable接口或构造PriorityQueue时指定comparator)。
 2.维护了一个Object数组用于存储队列数据；size表示当前队列元素个数；comparator是元素比较器(构造未传时为null)；
 modCount表示队列被修改次数，初始值为0。
 3.构造方法接收的参数
   不包含数据的只初始化Object数组和comparator
   包含数据的最终会通过initElementsFromCollection/initFromPriorityQueue/initFromCollection完成初始化。
    (1)如果元素是SortedSet类型，使用其comparator，检查所有元素不为null后直接放入Object数组中;
    (2)如果元素是PriorityQueue类型，使用其comparator，直接复制数组与size；
    (3)如果是集合类型，先按(1)初始化再heapify(维持小顶堆)
 4.方法列表
   add(E e):    调用offer(E e)方法
   offer(E e):  如果元素数量大于数组长度，调用grow扩容数组(Double size if small; else grow by 50%)；
        将新元素插入队尾（有comparator时使用comparator，否则使用compareTo；维持小顶堆）
        时间复杂度O（log(n))
   peek():      取头元素（时间复杂度O(1)）
   remove(Object o):查index(遍历数组时间复杂度O(N)，为-1返回false
        否则removeAt(i)返回true，
            删除队尾元素直接置null时间复杂度O(1)；
            删除其他元素将队尾元素插入i位置，维持小顶堆（先siftDown向下，如果正好比后面元素都小再siftUp向上）
   clear():遍历数组置null，时间复杂度O(N)
   poll():返回队列顶部元素，如果还有元素则将队尾元素从位置0siftDown向下插入，维持小顶堆
 5.内部类
   Itr 迭代器，元素无特定顺序
   Spliterator
