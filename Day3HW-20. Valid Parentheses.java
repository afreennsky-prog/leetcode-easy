class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else {
                // If stack is empty, no matching opening bracket
                if (stack.isEmpty()) return false;
                
                char top = stack.pop();
                // Check matching pairs
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {
                    return false;
                }
            }
        }
        
        // Valid only if stack is empty at the end
        return stack.isEmpty();
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        System.out.println(sol.isValid("()"));       // true
        System.out.println(sol.isValid("()[]{}"));   // true
        System.out.println(sol.isValid("(]"));       // false
        System.out.println(sol.isValid("([])"));     // true
        System.out.println(sol.isValid("([)]"));     // false
    }
}
