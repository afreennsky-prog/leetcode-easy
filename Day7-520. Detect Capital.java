class Solution {
    public boolean detectCapitalUse(String word) {
        int upperCount = 0;
        for (char c : word.toCharArray()) {
            if (Character.isUpperCase(c)) {
                upperCount++;
            }
        }
        
        // Case 1: All capitals (eg: USA)
        if (upperCount == word.length()) {
            return true;
        }
        // Case 2: No capitals (eg: leetcode)
        if (upperCount == 0) {
            return true;
        }
        // Case 3: Only first letter capital, rest small (eg: Google)
        if (upperCount == 1 && Character.isUpperCase(word.charAt(0))) {
            return true;
        }
        
        return false;
    }
}
