
// 原地遍历，从0开始遇到更大的就放到下一个位置
class Solution {
    public int removeDuplicates(int[] nums) {
        int length = nums.length;
        if (length <= 1) return length;
        int index = 0;
        for (int i = 1; i < length; i++) {
            if (nums[i] > nums[index]) {
                nums[++index] = nums[i];
            }
        }
        return index + 1;
    }
}
