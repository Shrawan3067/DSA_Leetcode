class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int result[] = new int[2];

        int lp = 0, rp = numbers.length - 1;

        while (lp != rp) {
                if (numbers[lp] + numbers[rp] == target) {
                    result[0] = lp+1;
                    result[1] = rp+1;
                    break;
                } else if (numbers[lp] + numbers[rp] < target) {
                    lp++;
                } else {
                    rp--;
                }
        }
        return result;
    }
}