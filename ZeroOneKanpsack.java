public class ZeroOneKanpsack {
    public static void main(String[] args) {
        int p[] = {0,1,2,5,6};
        int w[] = {0,2,3,4,5};
        int n = p.length-1;
        int wt = 8;
        int v[][] = new int[n+1][wt+1];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=wt;j++) {
                int k;
                if(j-w[i]>=0)
                    k = v[i-1][j-w[i]]+p[i];
                else
                    k = 0;
                v[i][j] = Math.max(v[i-1][j],k);
            }
        }
        int t = v[n][wt];
        int wt2 = wt;
        int output[] = new int[n];
        for(int i=n;i>0&&t>0;i--){
            if(t==v[i-1][wt2])
                continue;
            else{
                output[i-1] = 1;
                t-=p[i];
                wt2-=w[i];
            }

        }
        for(int i=0;i<n;i++)
            System.out.print(output[i]+" ");
        System.out.println("\nprofit "+v[n][wt]);
    }
}
