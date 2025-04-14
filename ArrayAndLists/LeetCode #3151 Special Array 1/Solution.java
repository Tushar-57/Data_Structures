class Solution {
    public boolean isArraySpecial(int[] nums) {
        int size = nums.length;
        if (size == 1) {
            return true;
        }

        // Check each pair of adjacent elements
        for (int i = 0; i < size - 1; i++) {
            // Check if the parity of the current element is different from the next
            if (nums[i] % 2 == nums[i + 1] % 2) {
                return false; // If both elements have the same parity, return false
            }
        }

        // If all pairs have different parity, return true
        return true;
    }
}
