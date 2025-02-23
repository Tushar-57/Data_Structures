# How Many Numbers Are Smaller Than the Current Number  

### 📝 Problem Statement  
Given an array `nums`, return an array `result` where `result[i]` is the count of numbers in `nums` that are smaller than `nums[i]`.  

### 📌 Example  
#### **Input:**  
```plaintext
nums = [8, 1, 2, 2, 3]
```
#### **Output:**  
```plaintext
[4, 0, 1, 1, 3]
```

---

## 🛠️ Approaches  

### **Approach 1: Hashmap with Sorted List**  
📊 **Time Complexity:** `O(N log N)` (Due to sorting)  
🛑 **Space Complexity:** `O(N)`

#### **Steps:**  
1. Create a **sorted set** (or manually sort a copy of `nums` with duplicates removed).  
2. Use a **hashmap** to store each number's index in the sorted list.  
3. Iterate over `nums`, replacing each number with its index from the hashmap.  

---

### **Approach 2: Prefix Sum (Optimized)**  
📊 **Time Complexity:** `O(N)`  
🛑 **Space Complexity:** `O(101) ≈ O(1)` (Since numbers are between `0-100`)  

#### **Steps:**  
1. **Count frequency** of each number using an array (`arr[101]`).  
2. **Compute prefix sum** to store the count of numbers less than or equal to `i`.  
3. **Construct result** by looking up `arr[nums[k] - 1]` (if `nums[k] != 0`).  

---

## 💻 Code Implementation (Prefix Sum)  

```java
class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        int[] arr = new int[101]; // Frequency array
        int[] result = new int[nums.length];

        // Count occurrences
        for (int i : nums) {
            arr[i]++;
        }

        // Compute prefix sum
        for (int j = 1; j < 101; j++) {
            arr[j] += arr[j - 1];
        }

        // Compute result
        for (int k = 0; k < nums.length; k++) {
            result[k] = (nums[k] == 0) ? 0 : arr[nums[k] - 1];
        }

        return result;
    }
}
```

---

### 🚀 **Why is this Optimal?**  
- **Prefix sum avoids sorting** (`O(N log N) → O(N)`)  
- **Constant extra space (`O(1)`)** since `arr[101]` is fixed  
- **No hashmap required**, making it **cache-friendly**  

---