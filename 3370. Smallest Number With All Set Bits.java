class Solution {
    public int smallestNumber(int n) {
        // Find the number of bits in n
        int bitLength = 32 - Integer.numberOfLeadingZeros(n);
        
        // Return (2^bitLength) - 1, which sets all bitLength bits to 1
        return (1 << bitLength) - 1;
    }
}
