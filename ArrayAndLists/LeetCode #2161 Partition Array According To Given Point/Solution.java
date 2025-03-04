import java.util.ArrayList;

class Solution {

    // Approach 1: With Additional Space O(n)
    public int[] pivotArray1(int[] nums, int pivot) {

        //Breaking the complete array into 3 parts - and merging the same at the end.
        ArrayList<Integer> temp = new ArrayList<>();
        ArrayList<Integer> temp2 = new ArrayList<>();
        ArrayList<Integer> equal = new ArrayList<>();
        int c=0;
        for(int i=0; i<nums.length; i++)
        {
            int currNumS = nums[i];
            // int currNumE = nums[j];
            if(currNumS < pivot)
            {
                temp.add(currNumS);
                // res[i] = currNum;
            }
            else if(currNumS > pivot)
            {
                temp2.add(currNumS);
                // res[i] = currNum;
            }
            else
            {
                equal.add( currNumS);
                c++;
                // res[i] = currNum;
            }
        }
        //Merging all the arrays manually 1 by 1
        int[] res = new int[nums.length];
        int ite =0;
        for(int i: temp)
        {
            res[ite++] = i;
            
        }
        for(int i: equal)
        {
            res[ite++] = i;
            
        }    
        for(int i: temp2)
        {
            res[ite++] = i;
        }
    return res;

    }
    
    // Approach 2: With no Additional Space O(1)
    public int[] pivotArray2(int[] nums, int pivot) {
        
        //We basically take the count of small and equal pivot points to have clarity in terms of putting the element.
        int size = nums.length;
        int[] res = new int[size];
        int small=0;
        int pivotNum=0;
        for(int i : nums)
        {
            if(i< pivot){small++;}
            if(i==pivot){pivotNum++;}
        }

        int right = small+pivotNum;
        int i= 0;
        for(int num: nums)
        {
            if(num<pivot){res[i++]=num;}
            else if(num>pivot){res[right++]=num;}
        } 
        //Since we have count for the pivot nums in the array, we know the only space left is for that only, in which put the num.
        while(pivotNum-- > 0){res[i++]=pivot;}
    return res;
    }   

}