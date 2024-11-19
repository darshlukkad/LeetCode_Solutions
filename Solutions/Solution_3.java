class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0, end = 1, max = 1;

        if (s.length() == 0)
            return 0;

        while (end < s.length()) {
            for (int i = start; i < end; i++) {
                if (s.charAt(i) == s.charAt(end)) {
                    start = i + 1;
                    break;
                }
            }
            end++;
            max = Math.max(max, end - start);
        }

        return max;
    }
}
