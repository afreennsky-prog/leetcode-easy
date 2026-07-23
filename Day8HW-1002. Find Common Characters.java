class Solution {
    public List<String> commonChars(String[] words) {
        // Frequency array to store the minimum count of each character across all words
        int[] minFreq = new int[26];

        // Initialize minFreq with the character counts of the first word
        for (char c : words[0].toCharArray()) {
            minFreq[c - 'a']++;
        }

        // Compare frequencies with the rest of the words
        for (int i = 1; i < words.length; i++) {
            int[] charFreq = new int[26];
            for (char c : words[i].toCharArray()) {
                charFreq[c - 'a']++;
            }

            // Keep the minimum frequency for each character
            for (int j = 0; j < 26; j++) {
                minFreq[j] = Math.min(minFreq[j], charFreq[j]);
            }
        }

        // Construct the result list based on minFreq
        List<String> result = new ArrayList<>();
        for (int i = 0; i < 26; i++) {
            while (minFreq[i] > 0) {
                result.add(String.valueOf((char) (i + 'a')));
                minFreq[i]--;
            }
        }

        return result;
    }
}
