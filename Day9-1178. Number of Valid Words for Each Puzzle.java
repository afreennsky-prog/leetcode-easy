import java.util.*;

class Solution {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        Map<Integer, Integer> freq = new HashMap<>();
        
        // Preprocess words into bitmasks
        for (String w : words) {
            int mask = 0;
            for (char c : w.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            // Only consider words with <= 7 unique letters (since puzzle length = 7)
            if (Integer.bitCount(mask) <= 7) {
                freq.put(mask, freq.getOrDefault(mask, 0) + 1);
            }
        }
        
        List<Integer> res = new ArrayList<>();
        
        // Process each puzzle
        for (String p : puzzles) {
            int mask = 0;
            for (char c : p.toCharArray()) {
                mask |= 1 << (c - 'a');
            }
            
            int first = 1 << (p.charAt(0) - 'a'); // must include first letter
            int count = 0;
            
            // Enumerate all subsets of puzzle mask
            // Trick: iterate through subsets using (sub - 1) & mask
            for (int sub = mask; sub > 0; sub = (sub - 1) & mask) {
                if ((sub & first) != 0) { // must contain first letter
                    count += freq.getOrDefault(sub, 0);
                }
            }
            
            res.add(count);
        }
        
        return res;
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        String[] words1 = {"aaaa","asas","able","ability","actt","actor","access"};
        String[] puzzles1 = {"aboveyz","abrodyz","abslute","absoryz","actresz","gaswxyz"};
        System.out.println(sol.findNumOfValidWords(words1, puzzles1)); // [1,1,3,2,4,0]
        
        String[] words2 = {"apple","pleas","please"};
        String[] puzzles2 = {"aelwxyz","aelpxyz","aelpsxy","saelpxy","xaelpsy"};
        System.out.println(sol.findNumOfValidWords(words2, puzzles2)); // [0,1,3,2,0]
    }
}
