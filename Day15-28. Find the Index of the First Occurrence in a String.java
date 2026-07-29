class Solution {
    public int strStr(String haystack, String needle) {
        // Edge case: empty needle
        if (needle.isEmpty()) {
            return 0;
        }

        int n = haystack.length();
        int m = needle.length();

        // Loop through haystack
        for (int i = 0; i <= n - m; i++) {
            // Check substring of length m
            if (haystack.substring(i, i + m).equals(needle)) {
                return i; // Found match
            }
        }

        return -1; // Not found
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();

        System.out.println(sol.strStr("sadbutsad", "sad"));   // Output: 0
        System.out.println(sol.strStr("leetcode", "leeto"));  // Output: -1
    }
}
