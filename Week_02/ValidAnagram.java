import java.util.Arrays;

public class ValidAnagram{
    public static void main(String[] args) {
        Solution solution = new ValidAnagram().new Solution();
        String s = "anagram";
        String t = "nagaram";
        boolean result = solution.isAnagram(s, t);
        System.out.println(result);
    }

    class Solution {
        public boolean isAnagram(String s, String t) {
            if (s == null || t == null || s.length() != t.length()) {
                return false;
            }
            char[] sArr = s.toCharArray();
            char[] tArr = t.toCharArray();
            Arrays.sort(sArr);
            Arrays.sort(tArr);
            for (int i = 0; i < sArr.length; i++) {
                if (sArr[i] != tArr[i]) {
                    return false;
                }
            }
            return true;
        }
    }

}
