class Solution {
    public boolean possibleBipartition(int n, int[][] dislikes) {
        int[] color = new int[n];

        Arrays.fill(color, -1);

        List<Integer>[] graph = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] edge : dislikes) {
            int u = edge[0] - 1;
            int v = edge[1] - 1;

            graph[u].add(v);
            graph[v].add(u);
        }

        for (int i = 0; i < n; i++) {
            if (color[i] == -1) {
                if (!dfs(i, 0, color, graph)) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean dfs(int node, int currentColor, int[] color, List<Integer>[] graph) {
        color[node] = currentColor;

        for (int neighbour : graph[node]) {
            if (color[neighbour] == -1) {
                if (!dfs(neighbour, 1 - currentColor, color, graph)) {
                    return false;
                }
            } else if (color[neighbour] == color[node]) {
                return false;
            }
        }
        return true;
    }
}