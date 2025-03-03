class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        
        int numIslands = 0;
        
        // Loop through every cell in the grid
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                // If we find a '1', it's a new island
                if (grid[i][j] == '1') {
                    numIslands++;
                    dfs(grid, i, j);  // Explore the whole island
                }
            }
        }
        return numIslands;
    }
    
    // DFS Function - Explore all connected lands
    private void dfs(char[][] grid, int i, int j) {
        // Boundary check + If it's water ('0'), return
        if (i < 0 || j < 0 || i >= grid.length || j >= grid[0].length || grid[i][j] == '0') return;
        
        grid[i][j] = '0';  // Mark as visited
        
        // Explore in 4 directions (up, down, left, right)
        dfs(grid, i - 1, j);  // Up
        dfs(grid, i + 1, j);  // Down
        dfs(grid, i, j - 1);  // Left
        dfs(grid, i, j + 1);  // Right
    }
}