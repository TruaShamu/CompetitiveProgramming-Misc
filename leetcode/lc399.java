
class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        int N = equations.size();
        // Construct graph
        Map<String, ArrayList<Edge>> adj = new HashMap<>();
        for (int i=0; i< equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            if (adj.containsKey(a)) {
                adj.get(a).add(new Edge(b, values[i]));
            } else {
                adj.put(a, new ArrayList<Edge>());
                adj.get(a).add(new Edge(b, values[i]));
            }

            if (adj.containsKey(b)) {
                adj.get(b).add(new Edge(a, 1/values[i]));
            } else {
                adj.put(b, new ArrayList<Edge>());
                adj.get(b).add(new Edge(a, 1/values[i]));
            }
        }

        double[] sol = new double[queries.size()];
        for (int i=0; i< queries.size(); i++) {
            String a = queries.get(i).get(0);
            String b = queries.get(i).get(1);
            if (!adj.containsKey(a) || !adj.containsKey(b)) {
                sol[i] = -1;
                continue;
            }
            if (a.equals(b)) {
                sol[i] = 1;
                continue;
            }
            sol[i] = dfs(adj, new HashSet(), a, b);
        }
        return sol;
    }

    public double dfs(Map<String, ArrayList<Edge>> adj, HashSet<String> visited, String start, String end) {
        visited.add(start);
        for (Edge oEdge : adj.get(start)) {
            if (!visited.contains(oEdge.node)) {
                if (oEdge.node.equals(end)) {
                    return oEdge.cost;
                }
                double subTreeVal = dfs(adj, visited, oEdge.node, end);
                if (subTreeVal != -1) {
                    return subTreeVal * oEdge.cost;
                }
            }
        }
        return -1;



    }
}

class Edge {
    String node;
    double cost;
    public Edge(String node, double cost) {
        this.node = node;
        this.cost = cost;
    }
}

