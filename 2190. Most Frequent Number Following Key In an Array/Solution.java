/*
 * @lc app=leetcode id=2190 lang=java
 *
 * [2190] Most Frequent Number Following Key In an Array
 */

// @lc code=start
class Solution {
    public int mostFrequent(int[] nums, int key) {
        int result[] = new int[1000];

        for (int i = 0; i < nums.length-1; i++) {
            if (nums[i] == key) {
                result[nums[i+1]-1]++;
            }
        }

        int ans = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < 1000; i++) {
            if (result[i] > max) {
                max = result[i];
                ans = i + 1;
            }
        }

        return ans;

    }
}
// @lc code=end

