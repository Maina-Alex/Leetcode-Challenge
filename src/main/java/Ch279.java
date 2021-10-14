import java.util.Arrays;

public class Ch279 {
    //perfect squares
    public int numSquares(int n) {
        int [] arr = new int [n+1];
        Arrays.fill(arr,Integer.MAX_VALUE);
        arr[0]=0;

        for(int i= 1; i<n+1;i++){
            for (int j=1; j*j<=i; j++){
                arr[i]=Math.min(arr[i], arr[i-j*j]+1);
            }
        }
        return arr[n];

    }

}
