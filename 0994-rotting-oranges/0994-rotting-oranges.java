class Solution {
    class Pair {
        int row;
        int col;

        Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int count = 0;

        int[][] directions = {
                { -1, 0 },
                { 1, 0 },
                { 0, -1 },
                { 0, 1 }
        };

        Queue<Pair> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    queue.add(new Pair(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            int size = queue.size();

            boolean changed = false;

            for (int k = 0; k < size; k++) {
                int i = queue.peek().row;
                int j = queue.peek().col;
                queue.poll();
                for (int[] direction : directions) {

                    int nrow = i + direction[0];
                    int ncol = j + direction[1];
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1) {
                        grid[nrow][ncol] = 2;
                        changed = true;
                        queue.add(new Pair(nrow, ncol));
                    }
                }
            }
            if (changed) {
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    return -1;
                }
            }
        }
        return count;
    }

}