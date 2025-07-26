class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long totSubars = 0;
        long count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                count++;
            } else {
                totSubars += count * (count + 1) / 2;
                count = 0;
            }
        }

        if (count > 0) {
            totSubars += count * (count + 1) / 2;
        }
        return totSubars;
    }
}