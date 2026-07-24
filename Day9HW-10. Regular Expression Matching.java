class Solution {
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();
        
        // dp[i][j] means: does s[0..i) match p[0..j)
        boolean[][] dp = new boolean[m + 1][n + 1];
        
        // Empty string matches empty pattern
        dp[0][0] = true;
        
        // Handle patterns like a*, a*b*, a*b*c* that can match empty string
        for (int j = 2; j <= n; j++) {
            if (p.charAt(j - 1) == '*') {
                dp[0][j] = dp[0][j - 2];
            }
        }
        
        // Fill DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                char sc = s.charAt(i - 1);
                char pc = p.charAt(j - 1);
                
                if (pc == sc || pc == '.') {
                    // Direct match or '.' wildcard
                    dp[i][j] = dp[i - 1][j - 1];
                } else if (pc == '*') {
                    // '*' can mean zero occurrence of previous char
                    dp[i][j] = dp[i][j - 2];
                    
                    // Or one/more occurrence if preceding char matches
                    char prev = p.charAt(j - 2);
                    if (prev == sc || prev == '.') {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                }
            }
        }
        
        return dp[m][n];
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.isMatch("aa", "a"));    // false
        System.out.println(sol.isMatch("aa", "a*"));   // true
        System.out.println(sol.isMatch("ab", ".*"));   // true
        System.out.println(sol.isMatch("aab", "c*a*b"));// true
        System.out.println(sol.isMatch("mississippi", "mis*is*p*.")); // false
    }
}
