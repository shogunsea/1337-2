public class Solution {
    public int numIslands(char[][] grid) {
        int row = grid.length;
        if (row == 0) {
            return 0;
        }
        int col = grid[0].length;
        boolean[][] visited = new boolean[row][col];

        int count = 0;

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (!visited[i][j]  && grid[i][j] == '1') {
                    visit(grid, visited, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    public void visit(char[][] grid, boolean[][] visited, int row, int col) {
        // index validation
        if (row < 0 || col < 0 || row == grid.length || col == grid[0].length) {
            return;
        }

        if (visited[row][col]) {
            return;
        } else {
            visited[row][col] = true;
        }

        if (grid[row][col] == '0') {
            return;
        }

        visit(grid, visited, row + 1, col);
        visit(grid, visited, row - 1, col);
        visit(grid, visited, row, col + 1);
        visit(grid, visited, row, col - 1);
    }
}