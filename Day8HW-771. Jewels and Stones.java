class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // Step 1: Store all jewel types in a HashSet for O(1) lookup time
        Set<Character> jewelSet = new HashSet<>();
        for (char j : jewels.toCharArray()) {
            jewelSet.add(j);
        }

        // Step 2: Iterate through stones and count how many are in jewelSet
        int count = 0;
        for (char s : stones.toCharArray()) {
            if (jewelSet.contains(s)) {
                count++;
            }
        }

        return count;
    }
}
