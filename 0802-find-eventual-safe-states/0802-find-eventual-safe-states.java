class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int n = graph.length;
        int[] state = new int[n];
        ArrayList<Integer> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            if (dfs(i, state, graph)) {
                ans.add(i);
            }
        }
        return ans;
    }

    public boolean dfs(int node, int[] state, int[][] graph) {
        if (state[node] == 1) {
            return false;
        }

        if (state[node] == 2) {
            return true;
        }

        state[node] = 1;

        for (int next : graph[node]) {
            if (!dfs(next, state, graph)) {
                return false;
            }
        }

        state[node] = 2;
        return true;
    }

}