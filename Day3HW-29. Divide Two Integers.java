class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }
        
        // Determine sign of result
        boolean negative = (dividend < 0) ^ (divisor < 0);
        
        // Work with positive values (convert to long to avoid overflow)
        long lDividend = Math.abs((long) dividend);
        long lDivisor = Math.abs((long) divisor);
        
        int result = 0;
        
        while (lDividend >= lDivisor) {
            long temp = lDivisor, multiple = 1;
            
            // Double temp divisor until it exceeds dividend
            while (lDividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            
            // Subtract and add to result
            lDividend -= temp;
            result += multiple;
        }
        
        return negative ? -result : result;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.divide(10, 3));   // Output: 3
        System.out.println(sol.divide(7, -3));  // Output: -2
        System.out.println(sol.divide(-15, 2)); // Output: -7
        System.out.println(sol.divide(-2147483648, -1)); // Output: 2147483647 (clamped)
    }
}
