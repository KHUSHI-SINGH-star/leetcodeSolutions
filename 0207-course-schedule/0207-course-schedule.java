class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        boolean[] visited = new boolean[numCourses];
        boolean[] inPath = new boolean[numCourses];

        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < numCourses; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] edge : prerequisites) {
            int u = edge[0];
            int v = edge[1];

            graph.get(v).add(u);
        }

        for (int i = 0; i < numCourses; i++) {
            if (!visited[i] && dfs(i, graph, visited, inPath)) {
                return false;
            }
        }
        return true;

    }

    public boolean dfs(int node, ArrayList<ArrayList<Integer>> graph, boolean[] visited, boolean[] inPath) {
        visited[node] = true;
        inPath[node] = true;

        for (int neighbour : graph.get(node)) {
            if (!visited[neighbour]) {
                if (dfs(neighbour, graph, visited, inPath)) {
                    return true;
                }
            } else if (inPath[neighbour]) {
                return true;
            }
        }
        inPath[node] = false;
        return false;
    }

}