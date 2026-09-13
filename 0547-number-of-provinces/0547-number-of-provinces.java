class Solution {

    public void bfs(int node, boolean[] marked, int[][] grid) {
     Queue<Integer> queue = new LinkedList<>();

        marked[node] = true;
        queue.add(node);

        while (!queue.isEmpty()) {

            int current = queue.poll();

            for (int i = 0; i < grid.length; i++) {

                // If current city is connected to city i
                if (grid[current][i] == 1 && !marked[i]) {

                    marked[i] = true;
                    queue.add(i);
                }
            }
        }
    }
    public int findCircleNum(int[][] isConnected) {
         int n = isConnected.length;
        boolean[] marked = new boolean[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
                if (!marked[i]) {
                    count++;
                    bfs(i, marked, isConnected);
            }
        }
        return count;
    }
}