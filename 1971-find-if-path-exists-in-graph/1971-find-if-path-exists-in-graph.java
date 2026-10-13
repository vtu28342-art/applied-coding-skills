class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++)
            adj.add(new ArrayList<>());
        for (int[] e : edges) {
            adj.get(e[0]).add(e[1]);
            adj.get(e[1]).add(e[0]);
        }
        boolean[] visited = new boolean[n];
        return dfs(source, destination, adj, visited);
    }
    boolean dfs(int s, int d, List<List<Integer>> adj, boolean[] visited) {
        if (s == d) return true;
        visited[s] = true;
        for (int x : adj.get(s)) {
            if (!visited[x] && dfs(x, d, adj, visited))
                return true;
        }
        return false;
    }
}