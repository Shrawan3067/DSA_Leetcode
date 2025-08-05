class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashSet<Character> hm = new HashSet<>();
        int maxLen = 0;
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            int j = i;
            while (j < s.length()) {
                if (hm.contains(s.charAt(j))) {
                    if (count > maxLen) {
                        maxLen = count;
                    }
                    count = 0;
                    hm.clear();
                    break;
                } else {
                    hm.add(s.charAt(j));
                    count++;
                    
                }
                j++;
            }
        }
        return maxLen;
    }
}