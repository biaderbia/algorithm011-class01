// 按列求每列能容纳的雨水量，
// 某列的雨水=(val = Math.min(左边最大高度,右边最大高度)) > height[i] ? val : 0;
class Solution {
    public int trap(int[] height) {
        int length = height.length;
        if (length == 0) return 0;

        int[] maxLeftHeight = new int[length];
        int[] maxRightHeight = new int[length];
        maxLeftHeight[0] = 0;
        maxRightHeight[length - 1] = 0;
        for (int i = 1; i < length; i++) {
            maxLeftHeight[i] = Math.max(maxLeftHeight[i - 1], height[i - 1]);
        }
        for (int i = length - 2; i >=0; i--) {
            maxRightHeight[i] = Math.max(maxRightHeight[i + 1], height[i + 1]);
        }
        int sum = 0;
        for (int i = 1; i < length - 1; i++) {
            int diff = Math.min(maxLeftHeight[i], maxRightHeight[i]) - height[i];
            if (diff > 0) {
                sum += diff;
            }
        }
        return sum;
    }
}
