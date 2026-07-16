class Solution {
    public boolean validUtf8(int[] data) {
        int remainingBytes = 0; // number of bytes expected for current character

        for (int num : data) {
            // Only consider the least significant 8 bits
            int byteVal = num & 0xFF;

            if (remainingBytes == 0) {
                // Count leading 1s to determine character length
                if ((byteVal >> 7) == 0) {
                    // 1-byte character (0xxxxxxx)
                    continue;
                } else if ((byteVal >> 5) == 0b110) {
                    remainingBytes = 1; // 2-byte character
                } else if ((byteVal >> 4) == 0b1110) {
                    remainingBytes = 2; // 3-byte character
                } else if ((byteVal >> 3) == 0b11110) {
                    remainingBytes = 3; // 4-byte character
                } else {
                    return false; // Invalid leading byte
                }
            } else {
                // Must be a continuation byte (10xxxxxx)
                if ((byteVal >> 6) != 0b10) {
                    return false;
                }
                remainingBytes--;
            }
        }

        // All characters must be fully matched
        return remainingBytes == 0;
    }
}
