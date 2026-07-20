class Solution {
    public boolean isNumber(String s) {
        s = s.trim(); // remove leading/trailing spaces
        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
            } else if (c == '+' || c == '-') {
                // sign is only valid at start or right after exponent
                if (i > 0 && s.charAt(i - 1) != 'e' && s.charAt(i - 1) != 'E') {
                    return false;
                }
            } else if (c == '.') {
                // dot not allowed after exponent or if already seen
                if (seenDot || seenExp) {
                    return false;
                }
                seenDot = true;
            } else if (c == 'e' || c == 'E') {
                // exponent not allowed twice, must follow a digit
                if (seenExp || !seenDigit) {
                    return false;
                }
                seenExp = true;
                seenDigit = false; // reset, must see digit after exponent
            } else {
                return false; // invalid character
            }
        }

        return seenDigit;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.isNumber("0"));          // true
        System.out.println(sol.isNumber("e"));          // false
        System.out.println(sol.isNumber("."));          // false
        System.out.println(sol.isNumber("2e10"));       // true
        System.out.println(sol.isNumber("-90E3"));      // true
        System.out.println(sol.isNumber("99e2.5"));     // false
        System.out.println(sol.isNumber("53.5e93"));    // true
        System.out.println(sol.isNumber("abc"));        // false
    }
}
