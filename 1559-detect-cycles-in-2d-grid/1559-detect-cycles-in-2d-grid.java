class Solution {
    public boolean containsCycle(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];

        int[][] directions = {
                { -1, 0 }, // up
                { 1, 0 }, // down
                { 0, -1 }, // left
                { 0, 1 } // right
        };

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == true)
                    continue;

                Queue<int[]> q = new LinkedList<>();
                q.offer(new int[]{i, j, -1, -1});
                visited[i][j] = true;

                while (!q.isEmpty()) {
                    int[] current = q.poll();

                    int row = current[0];
                    int col = current[1];

                    int parrow = current[2];
                    int parcol = current[3];

                    for (int[] dir : directions) {

                        int newrow = row + dir[0];
                        int newcol = col + dir[1];

                        if (newrow < 0 || newrow >= m || newcol < 0 || newcol >= n) {
                            continue;
                        }

                        if (grid[newrow][newcol] != grid[row][col])
                            continue;

                        if (newrow == parrow && newcol == parcol)
                            continue;

                        if (visited[newrow][newcol] == true)
                            return true;

                        visited[newrow][newcol] = true;
                        q.offer(new int[]{newrow, newcol, row, col});
                    }
                }
            }
        }
        return false;
    }
}