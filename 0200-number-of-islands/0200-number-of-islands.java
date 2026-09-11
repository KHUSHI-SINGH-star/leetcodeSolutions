class Solution {
    class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public void bfs(int row, int col, boolean[][] marked, char[][] grid) {
        marked[row][col] = true;
        Queue<Pair> queue = new LinkedList<>();
        int n = grid.length;
        int m = grid[0].length;
        queue.add(new Pair(row, col));
        ;
        int[][] directions = {
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        };
        while (!queue.isEmpty()) {
            int row1 = queue.peek().first;
            int col1 = queue.peek().second;
            queue.poll();
            for (int[] direction : directions) {
                int nrow = row1 + direction[0];
                int ncol = col1 + direction[1];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == '1' && !marked[nrow][ncol]) {
                    marked[nrow][ncol] = true;
                    queue.add(new Pair(nrow, ncol));
                }
            }
        }
    }

    public int numIslands(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] marked = new boolean[n][m];
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && !marked[i][j]) {
                    count++;
                    bfs(i, j, marked, grid);
                }
            }
        }
        return count;
    }
}