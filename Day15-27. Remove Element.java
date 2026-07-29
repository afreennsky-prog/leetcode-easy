class Solution {
    public int removeElement(int[] nums, int val) {
        int k = 0; // Counter for elements not equal to val

        // Traverse the array
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[k] = nums[i]; // Place non-val element at position k
                k++;
            }
        }

        return k; // Number of elements not equal to val
    }

    // Example usage
    public static void main(String[] args) {
        Solution sol = new Solution();

        int[] nums1 = {3, 2, 2, 3};
        int k1 = sol.removeElement(nums1, 3);
        System.out.println("k = " + k1); // Output: 2
        for (int i = 0; i < k1; i++) {
            System.out.print(nums1[i] + " "); // Output: 2 2
        }
        System.out.println();

        int[] nums2 = {0, 1, 2, 2, 3, 0, 4, 2};
        int k2 = sol.removeElement(nums2, 2);
        System.out.println("k = " + k2); // Output: 5
        for (int i = 0; i < k2; i++) {
            System.out.print(nums2[i] + " "); // Output: 0 1 3 0 4 (order may vary)
        }
    }
}
