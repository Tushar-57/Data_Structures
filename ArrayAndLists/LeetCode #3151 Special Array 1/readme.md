# Check if an Array is Special! 🎉

## 📚 Problem Overview

Are you ready to dive into a fun coding challenge? 🤔 Here's what we need to do:

We are given an array of integers, and our goal is to **check if the array is "special"**. 🧐

An array is considered **special** if the **parity (even or odd nature) of every adjacent pair of elements is different**. In other words, one element in every pair must be **even**, and the other must be **odd**. ⚖️

### 💡 Examples

- **Example 1:**
  - **Input:** `nums = [1]`
  - **Output:** `true`
  - **Explanation:** There's only one element, so there's no pair to compare. It’s trivially true! ✔️

- **Example 2:**
  - **Input:** `nums = [2, 1, 4]`
  - **Output:** `true`
  - **Explanation:** Here are the pairs:
    - `(2, 1)` → 2 (even) and 1 (odd) ✅
    - `(1, 4)` → 1 (odd) and 4 (even) ✅
  - All adjacent pairs have different parity, so the answer is `true`! 🎉

- **Example 3:**
  - **Input:** `nums = [2, 4, 6]`
  - **Output:** `false`
  - **Explanation:** All elements are even, so the parity doesn’t change between any pairs. ❌

---

## 🚀 Approach to Solve the Problem

Let’s break it down! ✂️

### 1. **Single Element Case**:
If the array has only **one element**, we can immediately say **yes**, it's trivially a special array since there are no pairs to compare! 🎯

### 2. **Looping Through the Array**:
For arrays with more than one element:
- We go through the array, checking each **adjacent pair**.
- **Parity check:** We check if one number is **even** and the next number is **odd**, or vice versa.
- If we find a pair where both numbers are either **even** or both **odd**, we return `false`! 🚨

### 3. **Final Verdict**:
If all adjacent pairs satisfy the condition (one is even and the other is odd), we return `true` at the end! 🙌

---

## 📝 Code Implementation

Here’s the code for the solution:

```java
class Solution {
    public boolean isSpecialArray(int[] nums) {
        int size = nums.length;

        // If there's only one element, it's trivially true
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



🧐 How the Code Works:
Step 1: First, we check if the array has only one element. If so, we return true because there are no pairs to compare.
Step 2: For arrays with more than one element, we use a for loop to go through all adjacent pairs.
Step 3: For each pair (nums[i], nums[i+1]), we check if one is even and the other is odd by comparing their parity (nums[i] % 2).
Step 4: If we find a pair that doesn't satisfy the condition, we return false. If all pairs are good, we return true!
⚙️ Time Complexity
The time complexity of this solution is O(n) where n is the length of the array, because we only loop through the array once.



