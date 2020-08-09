//实现一个 Trie (前缀树)，包含 insert, search, 和 startsWith 这三个操作。
//
// 示例:
//
// Trie trie = new Trie();
//
//trie.insert("apple");
//trie.search("apple");   // 返回 true
//trie.search("app");     // 返回 false
//trie.startsWith("app"); // 返回 true
//trie.insert("app");
//trie.search("app");     // 返回 true
//
// 说明:
//
//
// 你可以假设所有的输入都是由小写字母 a-z 构成的。
// 保证所有输入均为非空字符串。
//
// Related Topics 设计 字典树

package leetcode.editor.cn;
//Java：实现 Trie (前缀树)
public class P208ImplementTriePrefixTree{
    public static void main(String[] args) {
        Trie trie = new P208ImplementTriePrefixTree().new Trie();
        // TO TEST
        trie.insert("apple");
        trie.search("apple");
        trie.search("app");
        trie.startsWith("app");
        trie.insert("app");
        trie.search("app");
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Trie {

        private Trie[] arr;
        private char c;
        private boolean isEnd;
        /** Initialize your data structure here. */
        public Trie() {
            arr = new Trie[26];
            isEnd = false;
        }

        /** Inserts a word into the trie. */
        public void insert(String word) {
            char[] wordArray = word.toCharArray();
            Trie node = this;
            Trie temp = null;
            for (char ch : wordArray) {
                temp = node.arr[ch - 'a'];
                if (temp == null) {
                    temp = new Trie();
                    temp.c = ch;
                    node.arr[ch - 'a'] = temp;
                }
                node = temp;
            }
            temp.isEnd = true;
        }

        /** Returns if the word is in the trie. */
        public boolean search(String word) {
            char[] wordArray = word.toCharArray();
            Trie node = this;
            for (char ch : wordArray) {
                node = node.arr[ch - 'a'];
                if (node == null) return false;
            }
            return node.isEnd;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char[] wordArray = prefix.toCharArray();
            Trie node = this;
            for (char ch : wordArray) {
                node = node.arr[ch - 'a'];
                if (node == null) return false;
            }
            return true;
        }
    }

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
//leetcode submit region end(Prohibit modification and deletion)

}
