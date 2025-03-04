class Solution {
    public boolean checkPowersOfThree(int n) {
        //Max 3^16 = 43046721
        if (n == 0){ System.out.println("0");}  // Edge case
        while (n > 0) {
            int remainder = n % 3;  // Get remainder
            if(remainder == 2)
            {
                System.out.println("2 found in base");
                return false;
            }
            n /= 3;  // Divide by 3 for next step
        }
        return true;
    }
}