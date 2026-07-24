class Solution {
    public String[] findWords(String[] words) {
        String[] rows = {"qwertyuiop", "asdfghjkl", "zxcvbnm"};
        
        // Ovvoru character ethana row-la irukku nu map pannurom
        int[] charRow = new int[26];
        for (int i = 0; i < rows.length; i++) {
            for (char c : rows[i].toCharArray()) {
                charRow[c - 'a'] = i;
            }
        }
        
        List<String> result = new ArrayList<>();
        
        for (String word : words) {
            boolean sameRow = true;
            int row = charRow[Character.toLowerCase(word.charAt(0)) - 'a'];
            
            for (char c : word.toCharArray()) {
                if (charRow[Character.toLowerCase(c) - 'a'] != row) {
                    sameRow = false;
                    break;
                }
            }
            
            if (sameRow) {
                result.add(word);
            }
        }
        
        return result.toArray(new String[0]);
    }
}
