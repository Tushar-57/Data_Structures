class Solution {
    public int minTimeToVisitAllPoints(int[][] points) {
        int result = 0;  // Initialize a variable to keep track of total time taken

        // Iterate through the points array, excluding the last one because we compare each point to the next
        for (int i = 0; i < points.length - 1; i++) {
            
            // Extract the current point (x1, y1)
            int x1 = points[i][0];
            int y1 = points[i][1];

            // Extract the next point (x2, y2)
            int x2 = points[i + 1][0];
            int y2 = points[i + 1][1];
            
            // Calculate the time to move from (x1, y1) to (x2, y2)
            // We calculate the difference between the x-coordinates and y-coordinates separately,
            // and take the maximum of the two because diagonal movement can cover both x and y at the same time.
            int temp = Math.max(Math.abs(x2 - x1), Math.abs(y2 - y1));

            // Add the time for the current move to the total result
            result += temp;
        }

        // Return the total time taken to visit all the points
        return result;
    }
}
