# LeetCode 27 - Remove Element 🧹

## 🚀 Problem Statement
Given an integer array `nums` and an integer `val`, remove all occurrences of `val` **in-place**. The relative order of the elements may be changed.

You **must** do it with O(1) extra memory and return the new length of the array (the array itself is modified in-place up to that length).

---

### 🧠 Understanding the Problem

We're not actually deleting elements — instead, we're shifting the elements that are **not equal** to `val` to the front of the array. We then return the count of such elements.

For example:
```java
Input: nums = [3,2,2,3], val = 3  
Output: 2 → Modified array: [2,2,_,_]
```
## ✅ Approach

We use the **two-pointer** technique:

- Use pointer `i` to iterate through the array.
- Use pointer `j` to track the position where the next valid (non-val) element should be placed.

### 🔁 Algorithm Steps:
1. Initialize `j = 0`.
2. Traverse each element `nums[i]` in the array:
   - If `nums[i] != val`, we store it at `nums[j]` and increment `j`.
   - If it equals `val`, we skip it.
3. Return `j` as the new length — it represents the count of elements not equal to `val`.

---

## 🧠 Step-by-Step Example

**Input:**  
`nums = [0,1,2,2,3,0,4,2]`, `val = 2`

| i | nums[i] | Action                 | j (write index) | nums (modified)        |
|---|---------|------------------------|------------------|-------------------------|
| 0 | 0       | Keep → place at index 0| 1                | [0,_,_,_,_,_,_,_]       |
| 1 | 1       | Keep → place at index 1| 2                | [0,1,_,_,_,_,_,_]       |
| 2 | 2       | Skip                   | 2                | [0,1,_,_,_,_,_,_]       |
| 3 | 2       | Skip                   | 2                | [0,1,_,_,_,_,_,_]       |
| 4 | 3       | Keep → place at index 2| 3                | [0,1,3,_,_,_,_,_]       |
| 5 | 0       | Keep → place at index 3| 4                | [0,1,3,0,_,_,_,_]       |
| 6 | 4       | Keep → place at index 4| 5                | [0,1,3,0,4,_,_,_]       |
| 7 | 2       | Skip                   | 5                | [0,1,3,0,4,_,_,_]       |

**Output:**  
New length = `5`  
Modified array (up to index 5): `[0,1,3,0,4]`

---

## ⏱️ Time and Space Complexity

- **Time Complexity:** `O(n)`  
  - We iterate through the array once — linear time.

- **Space Complexity:** `O(1)`  
  - No additional data structures are used. The operation is performed in-place.


### 🧪 Code
```java
class Solution {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[j++] = nums[i];
            }
        }
        return j;
    }
}
```

