class Solution {
    public int[] smallerNumbersThanCurrent(int[] nums) {
        // Step 1: Create a frequency array of size 101 (since 0 ≤ nums[i] ≤ 100)
        // This will store how many times each number appears in the input array.
        int[] arr = new int[101]; 
        int[] result = new int[nums.length];

        // Step 2: Count occurrences of each number in nums
        // Example: If nums = [8, 1, 2, 2, 3]
        //          arr[1] = 1, arr[2] = 2, arr[3] = 1, arr[8] = 1
        for (int i : nums) {
            arr[i]++;
        }

        // Step 3: Compute prefix sum
        // arr[j] now stores the number of elements <= j
        // Example: If arr[2] was 2 (meaning two 2s in nums), then arr[3] += arr[2]
        // This makes arr[3] store count of numbers <= 3
        for (int j = 1; j < 101; j++) {
            arr[j] += arr[j - 1];
        }

        // Step 4: Compute final result
        // If nums[k] = x, then arr[x - 1] gives count of numbers < x
        for(int k=0; k<nums.length; k++)
        {
            if(nums[k] != 0)
            {
                result[k] = arr[nums[k] - 1];
            }
            else result[k] =0;
            
        }
    return result;
}}