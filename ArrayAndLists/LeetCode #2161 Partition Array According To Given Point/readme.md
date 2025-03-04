Output:

[5, 3, 10, 10, 9, 12, 14]
Explanation:

Less than pivot (10): [5, 3]
Equal to pivot (10): [10, 10]
Greater than pivot (10): [9, 12, 14]
Final output: [5, 3, 10, 10, 9, 12, 14]

Example 2
Input:

nums = [-3, 4, 3, 2]
pivot = 2
Output:
[-3, 2, 4, 3]

🧠 Step 2: Brainstorming the Approach
Before coding, let's think logically:

We need three sections:
Less than pivot
Equal to pivot
Greater than pivot
The order in each section must be preserved.

💡 Step 3: Algorithm Design
There are different ways to solve this, but let’s build it step by step.

🔹 Plan
- Create three lists:
- lessThanPivot → Stores numbers < pivot
- equalToPivot → Stores numbers == pivot
- greaterThanPivot → Stores numbers > pivot
- Traverse the array and distribute elements into these lists.
- Combine the lists back into a single array.


Code Implementation - Approach 1: Using Extra Lists

public int[] pivotArray1(int[] nums, int pivot) {
    // Breaking the complete array into 3 parts - and merging the same at the end.
    ArrayList<Integer> temp = new ArrayList<>();
    ArrayList<Integer> temp2 = new ArrayList<>();
    ArrayList<Integer> equal = new ArrayList<>();
    int c = 0;
    for (int i = 0; i < nums.length; i++) {
        int currNumS = nums[i];
        // int currNumE = nums[j];
        if (currNumS < pivot) {
            temp.add(currNumS);
            // res[i] = currNum;
        } else if (currNumS > pivot) {
            temp2.add(currNumS);
            // res[i] = currNum;
        } else {
            equal.add(currNumS);
            c++;
            // res[i] = currNum;
        }
    }
    // Merging all the arrays manually 1 by 1
    int[] res = new int[nums.length];
    int ite = 0;
    for (int i : temp) {
        res[ite++] = i;
    }
    for (int i : equal) {
        res[ite++] = i;
    }
    for (int i : temp2) {
        res[ite++] = i;
    }
    return res;
}


🕵️‍♂️ Time Complexity Analysis
Your solution has three main steps:

- Partitioning elements into three lists (temp, equal, temp2) → O(n)
    You iterate over nums[] once and classify elements.

- Merging the three lists into res[] → O(n)
    You go through temp, equal, and temp2 once to copy values into res[].

Total time complexity: O(n) + O(n) = O(n) (Good! ✅)

📦 Space Complexity Analysis
Additional lists: Using three lists (temp, equal, temp2) → O(n)
Output array: res[] is an array of size n → O(n)
Total space complexity: O(n) + O(n) = O(n) (Not ideal, we can improve! 🚀)

**Optimizing to O(1) Space Complexity**
Now, let’s aim for a solution that sorts the array in-place instead of using extra lists.

💡 More Efficient Approach
Instead of storing numbers in extra lists, rearrange them directly in nums[] using two pointers to place elements in the correct position.

🛠️ How Does It Work?

First pass: Count how many elements are less than, equal to, and greater than pivot.
Second pass: Overwrite nums[] in-place by:
Placing smaller elements first.
Adding pivot values in the middle.
Filling larger elements at the end.
This approach removes extra space usage, reducing it to O(1) space!

Code Implementation - Approach 2: In-Place Rearrangement
public int[] pivotArray2(int[] nums, int pivot) {
    // We basically take the count of small and equal pivot points to have clarity in terms of putting the element.
    int size = nums.length;
    int[] res = new int[size];
    int small = 0;
    int pivotNum = 0;
    for (int i : nums) {
        if (i < pivot) {
            small++;
        }
        if (i == pivot) {
            pivotNum++;
        }
    }

    int right = small + pivotNum;
    int i = 0;
    for (int num : nums) {
        if (num < pivot) {
            res[i++] = num;
        } else if (num > pivot) {
            res[right++] = num;
        }
    }
    // Since we have count for the pivot nums in the array, we know the only space left is for that only, in which put the num.
    while (pivotNum-- > 0) {
        res[i++] = pivot;
    }
    return res;
}


⚡ Optimized Complexity
Time Complexity: O(n) (Single pass partitioning ✅)
Space Complexity: O(1) (Only modifies nums[], no extra arrays ✅)