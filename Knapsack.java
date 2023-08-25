public class Knapsack {
    static void sort(int arr[][]){
        int n = arr.length;
        for(int i=0;i<n-1;i++){
            for(int j=0;j<n-i-1;j++){
                if(arr[j+1][0]/arr[j+1][1]>arr[j][0]/arr[j][1]){
                    int temp1 = arr[j+1][0];
                    int temp2 = arr[j+1][1];
                    arr[j+1][0] = arr[j][0] ;
                    arr[j+1][1] = arr[j][1];
                    arr[j][0] = temp1;
                    arr[j][1] = temp2;
                }
            }
        }
    }
    public static void main(String[] args) {
        int w = 11,i;
        int arr[][] = {{5,1},{10,3},{15,5},{7,4},{8,1},{9,3},{4,2}};
        sort(arr);
        double t = 0d;
        for(i=0;i<arr.length;i++){
            if(w-arr[i][1]>=0){
                w-=arr[i][1];
                t+=arr[i][0];
            }
            else{
                t+=arr[i][0]/arr[i][1]*w;
                break;
            }
        }
        System.out.println(t);
    }
}
