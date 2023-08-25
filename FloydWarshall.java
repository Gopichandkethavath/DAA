public class FloydWarshall {
    static final int inf = (int)1e9;
    public static void main(String[] args) {
        int graph[][] = {
            {0,2,inf,inf},
            {1,0,3,inf},
            {inf,inf,0,inf},
            {3,5,4,0}
        };
        for(int k=0;k<4;k++) {
            for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                    graph[i][j] = Math.min(graph[i][j],graph[i][k]+graph[k][j]);
                }
            }
        }
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print(graph[i][j]+" ");
            }
            System.out.println();
        }
    }
}
