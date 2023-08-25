public class LCS {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        int m = s1.length();
        int n = s2.length();
        int i,j;
        int res[][] = new int[m+1][n+1];
        for( i=1;i<=m;i++){
            for(j=1;j<=n;j++) {
                if(s1.charAt(i-1)==s2.charAt(j-1))
                    res[i][j] = res[i-1][j-1]+1;
                else
                    res[i][j] = Math.max(res[i-1][j],res[i][j-1]);
            }
        }
        i=m;j=n;
        String ans = "";
        while(i!=0&&j!=0){
            if(res[i][j]==res[i][j-1])
                j--;
            else{
                ans = s2.charAt(j-1)+ans;
                i--;
                j--;
            }
        }
        System.out.println(res[m][n]+" -> "+ans);
    }
}
