//给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
//
// 示例 1：
//
// 输入: "babad"
//输出: "bab"
//注意: "aba" 也是一个有效答案。
//
//
// 示例 2：
//
// 输入: "cbbd"
//输出: "bb"
//
// Related Topics 字符串 动态规划

package leetcode.editor.cn;
//Java：最长回文子串
public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
        String str = "babad";
        System.out.println(solution.longestPalindrome(str));
    }
    //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String longestPalindrome(String s) {
            int n = s.length();
            if (n < 2) return s;

            String res = "";
            int maxLength = 0;
            for (int i = 0; i < n -1; i++) {
                String str1 = expand(i - 1, i + 1, s); // odd
                String str2 = expand(i, i + 1, s); // even
                String maxStr = str1.length() > str2.length() ? str1 : str2;
                if (maxStr.length() > maxLength) {
                    maxLength = maxStr.length();
                    res = maxStr;
                }
            }
            return res;
        }

        private String expand(int l, int r, String s) {
            int i = l; int j = r;
            while (i >= 0 && j < s.length()) {
                if (s.charAt(i) == s.charAt(j)) {
                    i --;
                    j++;
                } else {
                    break;
                }
            }
            return s.substring(i + 1, j);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}
