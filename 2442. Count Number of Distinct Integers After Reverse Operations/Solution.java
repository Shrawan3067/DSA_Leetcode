class Solution {
    public int countDistinctIntegers(int[] nums) {
        int[] newArr = new int[nums.length * 2];
        int j = nums.length;
        for (int i = 0; i < nums.length; i++) {
            newArr[i] = nums[i];
            int n = nums[i];
            int digit = 0;
            while (n > 0) {
                int rem = n % 10;
                digit = digit * 10 + rem;
                n /= 10;
            }
            newArr[j] = digit;
            j++;
        }

        Arrays.sort(newArr);
        int count = 0;
        for (int i = 0; i < newArr.length - 1; i++) {
            if (newArr[i] == newArr[i + 1]) {
                continue;
            } else {
                count++;
            }
        }
        count++;
        return count;
    }
}