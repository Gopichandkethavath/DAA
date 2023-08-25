import java.util.*;

public class DijkstraAlgorithm {
    static final int inf = Integer.MAX_VALUE; 
    static void dijkstra(List<List<int[]>> graph,int src) {
        int v = graph.size();
        int distance[] = new int[v];
        boolean vis[] = new boolean[v];
        Arrays.fill(distance,inf);
        distance[src] = 0;
        for(int i=0;i<v-1;i++) {
            int minVer = findMinDis(distance,vis);
            vis[minVer] = true;
            List<int[]> adjNodes = graph.get(minVer);
            for(int[] node:adjNodes){
                int vertex = node[0];
                int dist = node[1];
                if(!vis[vertex]&&distance[minVer]!=inf){
                    int newDist = distance[minVer]+dist;
                    if(newDist<distance[vertex]){
                        distance[vertex] =newDist; 
                    }
                }
            }
        }
        for(int i = 0;i<distance.length;i++){
            System.out.println(distance[i]);
        }

    }
    static int findMinDis(int distances[],boolean vis[]){
        int min = -1;
        int minDist = inf;
        for(int i=0;i<distances.length;i++) {
            if(!vis[i]&&distances[i]<minDist){
                minDist = distances[i];
                min = i;
            }
        }
        return min;
    }
    public static void main(String[] args) {
        List<List<int[]>> graph = new ArrayList<>();
        int n = 9;

        for(int i=0;i<n;i++) {
            graph.add(new ArrayList<>());
        }
        addEdge(graph, 0, 1, 4);
        addEdge(graph, 0, 7, 8);
        addEdge(graph, 1, 2, 8);
        addEdge(graph, 1, 7, 11);
        addEdge(graph, 2, 3, 7);
        addEdge(graph, 2, 5, 4);
        addEdge(graph, 2, 8, 2);
        addEdge(graph, 3, 4, 9);
        addEdge(graph, 3, 5, 14);
        addEdge(graph, 4, 5, 10);
        addEdge(graph, 5, 6, 2);
        addEdge(graph, 6, 7, 1);
        addEdge(graph, 6, 8, 6);
        addEdge(graph, 7, 8, 7);
        dijkstra(graph,0);
    }
    static void addEdge(List<List<int[]>>graph,int s,int d,int w){
        graph.get(s).add(new int[]{d,w});
        graph.get(d).add(new int[]{s,w});
    }
}
