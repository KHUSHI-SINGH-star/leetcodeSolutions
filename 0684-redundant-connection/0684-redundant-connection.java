class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int[] vis = new int[n + 1];

            if (dfs(u, v, vis, graph)) {
                return edge;
            }
            graph.get(u).add(v);
            graph.get(v).add(u);
        }

        return new int[] {};

    }

    public boolean dfs(int node, int parent, int vis[], ArrayList<ArrayList<Integer>> graph) {
        if (node == parent) {
            return true;
        }
        vis[node] = 1;

        for (int adjNode : graph.get(node)) {
            if (vis[adjNode] == 0) {
                if (dfs(adjNode, parent, vis, graph) == true) {
                    return true;
                }
            }
        }
        return false;
    }

}