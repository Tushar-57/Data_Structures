# 🏁 Minimum Time to Visit All Points

## 📌 Problem Statement  
You are given a list of points on a **2D plane**, where `points[i] = [xᵢ, yᵢ]` represents a coordinate.  
You need to visit these points **in order**, and at each step, you can move:  
- **Horizontally** (left/right)  
- **Vertically** (up/down)  
- **Diagonally**  

The **time taken** to move from one point to another is determined by:  

**Time = max(|x₂ - x₁|, |y₂ - y₁|)**

points = [[1,1],[3,4],[-1,0]]
Output: 7
Explanation:
1️⃣ Move from (1,1) → (3,4) takes max(|3-1|, |4-1|) = max(2,3) = 3 seconds
2️⃣ Move from (3,4) → (-1,0) takes max(|-1-3|, |0-4|) = max(4,4) = 4 seconds
Total time: 3 + 4 = 7

🛠️ Approach
We iterate through the points list and process one move at a time:

Extract (x₁, y₁) and (x₂, y₂) for the current and next point.
Calculate the time to move using max(|x₂ - x₁|, |y₂ - y₁|).
Add this time to our total result.
Since diagonal movement allows us to minimize steps, this approach ensures the fastest route possible.

⏳ Complexity Analysis
Time Complexity: O(N), since we iterate through the points once.
Space Complexity: O(1), since we only use a few integer variables.

💻 Code Implementation
class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
            int result =0;
            for(int i=0; i<points.length-1; i++)
            {
                //First 2 starting points
                int x1,y1;
                x1= points[i][0];
                y1= points[i][1];

                //Next 2 points or destination
                int x2,y2;
                x2= points[i+1][0];
                y2= points[i+1][1];
                //The below formula is what makes it work.
                int temp = Math.max(Math.abs(y2-y1), Math.abs(x2-x1));
                result = result + temp; 
            }
            return result;
        }
}