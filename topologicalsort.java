import java.util.*;

public class topologicalsort {
    static class Edge {
        int s, d;

        Edge(int s, int d) {
            this.s = s;
            this.d = d;
        }
    }

    public static void constructGraph(ArrayList<Edge> graph[], int n) {
        for (int i = 0; i < n; i++)
            graph[i] = new ArrayList<Edge>();
        graph[5].add(new Edge(5, 0));
        graph[5].add(new Edge(5, 2));

        graph[4].add(new Edge(4, 0));
        graph[4].add(new Edge(4, 1));

        graph[2].add(new Edge(2, 3));

        graph[3].add(new Edge(3, 1));

        graph[3].add(new Edge(3, 3));

    }

    static void dfs(ArrayList<Edge> graph[], int curr_vert, boolean visit[], Stack<Integer> s) {
        // System.out.print(curr_vert + "->");
        visit[curr_vert] = true;
        for (int i = 0; i < graph[curr_vert].size(); i++) {
            Edge e = graph[curr_vert].get(i);
            if (visit[e.d] == false)
                dfs(graph, e.d, visit, s);
        }
        s.push(curr_vert);
    }

    public static void main(String[] args) {
        int n = 6;
        ArrayList<Edge> graph[] = new ArrayList[n];
        boolean visited[] = new boolean[n];
        Stack<Integer> s = new Stack<>();
        constructGraph(graph, n);
        for (int i = 0; i < visited.length; i++) {
            if (visited[i] == false)
                dfs(graph, i, visited, s);
        }
        while (!s.isEmpty())
            System.out.print(s.pop() + "->");

    }
}
