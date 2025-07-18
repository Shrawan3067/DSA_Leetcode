class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nextGreater = new int[n];
        Stack<Integer> s = new Stack<>();
        
        Arrays.fill(nextGreater, -1);
        
        for (int i = 0; i < 2 * n; i++) {
            int currentIndex = i % n;
            while (!s.isEmpty() && nums[s.peek()] < nums[currentIndex]) {
                int top = s.pop();
                nextGreater[top] = nums[currentIndex];
            }

            if (i < n) {
                s.push(currentIndex);
            }
        }
        
        return nextGreater;
    }
}