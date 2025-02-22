# LeetCode 448: Find All Numbers Disappeared in an Array 🚀

## Problem Statement
Given an array `nums` of `n` integers where `nums[i]` is in the range `[1, n]`, return an array of all the integers in the range `[1, n]` that do not appear in `nums`.

### **Example 1**
**Input:**  
`nums = [4,3,2,7,8,2,3,1]`  
**Output:**  
`[5,6]`  

### **Example 2**
**Input:**  
`nums = [1,1]`  
**Output:**  
`[2]`  

---

## **Approach & Explanation**
### ✅ **Intuitive Approach**
1. **Using a Set**  
   - Insert all numbers into a set and find the missing ones.  
   - This requires **O(n) space**, so we optimize further.

2. **Using Sorting**  
   - If the array were sorted, an element `x` should be at `index = x-1`.  
   - We can use this insight for an in-place solution.

### ⚡ **Optimized Approach**
- We traverse the array and use **negative marking** to flag visited indices.
- If `nums[i] = x`, we mark `nums[x-1]` as negative.
- In the second pass, positive values indicate missing numbers.

### ⏳ **Complexity Analysis**
- **Time Complexity:** `O(n) + O(n) = O(n)`  
- **Space Complexity:** `O(1)` (modifies array in-place)

---

## **Code Implementation (Java)**
```java
import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> missingNumbers = new ArrayList<>();

        // Step 1: Mark indices corresponding to numbers as negative
        for (int i = 0; i < nums.length; i++) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] > 0) {
                nums[index] = -nums[index];
            }
        }

        // Step 2: Identify the indices that remain positive
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] > 0) {
                missingNumbers.add(j + 1);
            }
        }
        return missingNumbers;
    }
}
