# 🏝️ Number of Islands  

## 📌 Problem Statement  
Given an `m x n` 2D binary grid where:  
- `'1'` represents land  
- `'0'` represents water  

An **island** is a group of `'1'`s that are **connected horizontally or vertically** and is **completely surrounded by water**.  

Your task is to return **the number of islands** in the grid.  

## 🔍 Understanding the Problem (For Beginners)  
Imagine a **map** where some parts are land (`'1'`) and others are water (`'0'`).  

- A land (`'1'`) **belongs to an island** if it touches another `'1'` **horizontally or vertically**.  
- **Islands are counted separately**, so even if two `'1'`s are diagonally connected, they **belong to different islands**.  

### Example 1:  
#### **Input:**  
grid = [ ["1","1","1","1","0"], ["1","1","0","1","0"], ["1","1","0","0","0"], ["0","0","0","0","0"] ]

Output = 1 -> 

## 🛠️ How to Solve the Problem?  
We need a way to **visit all the connected `'1'`s** when we find land. There are two ways to explore:

1️⃣ **Depth-First Search (DFS) → "Go deep first"**  
   - Think of it like exploring a maze deeply before turning back.  
   - When we find `'1'`, we **visit all connected land (`'1'`) recursively** (or using a stack).  
   - **Mark visited cells** so we don't count the same island multiple times.  

2️⃣ **Breadth-First Search (BFS) → "Explore layer by layer"**  
   - Think of it like spreading water over an island **one layer at a time**.  
   - We use a **queue** to visit `'1'`s level by level.  

Both methods work, but **DFS is simpler to implement recursively**.

---

## 🏗️ Approach 1: Depth-First Search (DFS)  

### 🔹 **Steps to solve using DFS:**  
1. **Loop through the grid**  
2. When you find a `'1'`, **start DFS** to explore the full island.  
3. **Mark visited land (`'1'`) as `'0'`** to avoid counting it again.  
4. **Repeat for all land cells** to count islands separately.  

### 📜 **Code (DFS - Recursive)**  
```java
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


⏳ Time Complexity: O(m × n)
We visit each cell once, marking it visited.

🛑 Space Complexity: O(m × n) (in worst case, due to recursive stack calls).

