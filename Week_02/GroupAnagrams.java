import java.util.*;

public class P49GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        String[] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        List<List<String>> result = solution.groupAnagrams(arr);
        System.out.println(result);
    }
    class Solution {
        public List<List<String>> groupAnagrams(String[] strs) {
            Map<String, List<String>> map = new HashMap<>();
            char[] arr;
            List<String> list;
            for (String str : strs) {
                arr = str.toCharArray();
                Arrays.sort(arr);
                String s = String.valueOf(arr);
                if ((list = map.get(s)) == null) {
                    list = new ArrayList<>();
                    map.put(s, list);
                }
                list.add(str);
            }

            return new ArrayList<>(map.values());
        }
    }

}
