# Check Powers of Three

## Problem Statement
Given an integer `n`, return `true` if it is possible to represent `n` as the sum of distinct powers of three. Otherwise, return `false`.

An integer `y` is a power of three if there exists an integer `x` such that `y == 3^x`.

### Example 1:
**Input:**
```plaintext
n = 12
```
**Output:**
```plaintext
true
```
**Explanation:**
```
12 = 3^1 + 3^2 (3 + 9)
```

### Example 2:
**Input:**
```plaintext
n = 91
```
**Output:**
```plaintext
true
```
**Explanation:**
```
91 = 3^0 + 3^2 + 3^4 (1 + 9 + 81)
```

### Example 3:
**Input:**
```plaintext
n = 21
```
**Output:**
```plaintext
false
```

---

## Approach
We convert `n` into **base-3** representation. If any digit in this base is `2`, then it is not possible to represent `n` as a sum of distinct powers of three.

### **Steps:**
1. **Convert `n` into base-3 representation:**
   - Keep dividing `n` by `3` and storing remainders.
   - If at any point, a remainder is `2`, return `false`.
2. **Return `true` if all digits are `0` or `1` in base-3.**

---

## **Code Implementation (Java)**
```java
class Solution {
    public boolean checkPowersOfThree(int n) {
        while (n > 0) {
            int remainder = n % 3;  // Get remainder
            if (remainder == 2) return false;  // If remainder is 2, return false
            n /= 3;  // Divide by 3 for next step
        }
        return true;
    }
}
```

---

## **Complexity Analysis**
- **Time Complexity:** `O(log n)` (Since we keep dividing `n` by `3`, the number of iterations is proportional to `log_3(n)`).
- **Space Complexity:** `O(1)` (We use only a few integer variables, no extra space is needed).

---

## **Generalization to Any Base (Bonus)**
If the problem was about powers of `5`, we would follow the **same approach** but check for digits `≥2` in base-5.

```java
public boolean checkPowersOfFive(int n) {
    while (n > 0) {
        int remainder = n % 5;
        if (remainder >= 2) return false;
        n /= 5;
    }
    return true;
}
```

---

### 🔥 **Key Takeaways**
✅ Checking remainders helps verify sums of distinct powers.
✅ This method can be applied to **any base** (e.g., `powers of 2, 4, 5, etc.`).

---
This solution is efficient and follows a mathematical approach rather than brute force! 🚀

**Time Complexity Analysis**
Your approach involves repeatedly dividing n by 3 to convert it into base-3 representation. This process runs in O(log₃(n)) time, as the number of steps required is proportional to the number of digits in the base-3 representation of n.

- At each step, n is divided by 3, reducing its size significantly.
- The number of times we can divide n before it becomes 0 is approximately log₃(n).
- So, the worst-case time complexity is O(log₃(n)).

✅ **Space Complexity:** O(1) (since we don’t use extra memory aside from variables)

