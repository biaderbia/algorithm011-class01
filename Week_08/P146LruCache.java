//运用你所掌握的数据结构，设计和实现一个 LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。 
//
// 获取数据 get(key) - 如果关键字 (key) 存在于缓存中，则获取关键字的值（总是正数），否则返回 -1。 
//写入数据 put(key, value) - 如果关键字已经存在，则变更其数据值；如果关键字不存在，则插入该组「关键字/值」。当缓存容量达到上限时，它应该在
//写入新数据之前删除最久未使用的数据值，从而为新的数据值留出空间。 
//
// 
//
// 进阶: 
//
// 你是否可以在 O(1) 时间复杂度内完成这两种操作？ 
//
// 
//
// 示例: 
//
// LRUCache cache = new LRUCache( 2 /* 缓存容量 */ );
//
//cache.put(1, 1);
//cache.put(2, 2);
//cache.get(1);       // 返回  1
//cache.put(3, 3);    // 该操作会使得关键字 2 作废
//cache.get(2);       // 返回 -1 (未找到)
//cache.put(4, 4);    // 该操作会使得关键字 1 作废
//cache.get(1);       // 返回 -1 (未找到)
//cache.get(3);       // 返回  3
//cache.get(4);       // 返回  4
// 
// Related Topics 设计 
// 👍 843 👎 0

package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

//Java：LRU缓存机制
public class P146LruCache{
    public static void main(String[] args) {
        LRUCache solution = new P146LruCache().new LRUCache(16);
        // TO TEST
        solution.put(4,2);
        solution.put(1,4);
        System.out.println(solution.head.next.value);
        solution.get(4);
        System.out.println(solution.head.next.value);
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class LRUCache {
        private Map<Integer, DLinkNode> cache = new HashMap<>();
        private int size;
        private int capacity;
        private DLinkNode head, tail;
        public LRUCache(int capacity) {
            this.size = 0;
            this.capacity = capacity;
            head = new DLinkNode();
            tail = new DLinkNode();
            head.next = tail;
            tail.prev = head;
        }

        public int get(int key) {
            DLinkNode node = cache.get(key);
            if (node == null) return -1;

            // move to head;
            moveToHead(node);
            return node.value;
        }

        public void put(int key, int value) {
            DLinkNode node = cache.get(key);
            if (node == null) {
                node = new DLinkNode(key, value);
                addToHead(node);
                cache.put(key, node);
                ++size;
                if (size > capacity) {
                    DLinkNode tail = removeTail();
                    cache.remove(tail.key);
                    --size;
                }
            } else {
                node.value = value;
                moveToHead(node);
            }
        }

        private DLinkNode removeTail() {
            DLinkNode lastNode = tail.prev;
            removeNode(lastNode);
            return lastNode;
        }
        private void removeNode(DLinkNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        private void addToHead(DLinkNode node) {
            node.next = head.next;
            head.next.prev = node;
            node.prev = head;
            head.next = node;
        }

        private void moveToHead(DLinkNode node) {
            removeNode(node);
            addToHead(node);
        }

        class DLinkNode {
            private int key;
            private int value;
            DLinkNode prev;
            DLinkNode next;

            public DLinkNode(){}
            public DLinkNode(int key, int value) {
                this.key = key;
                this.value = value;
            }
        }
    }

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
//leetcode submit region end(Prohibit modification and deletion)

}