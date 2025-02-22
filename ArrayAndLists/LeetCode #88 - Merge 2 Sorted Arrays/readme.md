Merging Two Sorted Arrays Using Two-Pointer Approach 🚀
Problem Statement
You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, along with two integers m and n, representing the number of elements in nums1 and nums2, respectively.

Your task is to merge nums1 and nums2 into a single sorted array, in-place within nums1.

🔹 nums1 has a length of m + n, where the first m elements contain actual values, and the last n elements are initialized to 0 (to accommodate nums2).
🔹 nums2 has a length of n.

Example
✅ Input:
ini
Copy
Edit
nums1 = [1,2,3,0,0,0], m = 3  
nums2 = [2,5,6], n = 3  
🔹 Process:
Merging [1,2,3] and [2,5,6].

✅ Output:
csharp
Copy
Edit
[1,2,2,3,5,6]  
Optimized Approach: Two-Pointer Merging from the End 🔥
Why Merge from the End?
🔹 nums1 has extra space at the end, allowing us to place elements directly without shifting.
🔹 By starting from the largest elements, we avoid unnecessary moves and overwrite operations.

Algorithm Breakdown
1️⃣ Use three pointers:

i = m - 1 → Points to the last actual element in nums1.
j = n - 1 → Points to the last element in nums2.
k = m + n - 1 → Points to the last position in nums1 (where elements should be placed).
2️⃣ Compare elements at i and j:

Place the larger one at k and decrement the respective pointer.
3️⃣ If elements remain in nums2, copy them directly into nums1.

Code Implementation (Java)
java
Copy
Edit
public class Solution {
    public void mergingTwoArrays(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;  // Last valid element in nums1
        int j = n - 1;  // Last element in nums2
        int k = m + n - 1;  // Last position in nums1

        // Merge nums1 and nums2 from the back
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j]) {
                nums1[k--] = nums1[i--];
            } else {
                nums1[k--] = nums2[j--];
            }
        }

        // Copy any remaining elements from nums2
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }

        // No need to handle nums1 since it's already in place
    }
}
Complexity Analysis ⏳
✅ Time Complexity: O(m + n) → Each element is processed once.
✅ Space Complexity: O(1) → No extra space used, merging is done in-place.