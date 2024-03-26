import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        long[] arr = new long[n];
        for(int i=0;i<n;i++){
            arr[i] = Long.parseLong(st.nextToken());
        }

        long max = Long.MAX_VALUE-2;

        long min = 1;

        //System.out.println("fewfew");
        long mid = 0;
        long result = 0;
        while(max>=min){
            
            mid = (max+min)/2;

            long cnt=0;
            int checkM = 0;
            boolean isSU = false;
            for(int j=0;j<n;j++){
                if(arr[j]>mid){
                    isSU = true;
                    break;
                }
                cnt+=arr[j];
                //System.out.println(checkM + " " + cnt + " " + mid + " " + j);
                // if(j==n-1){
                //     if(cnt>mid){
                //         checkM++;
                //         cnt = 0;
                //     }
                //     break;
                // }
                // else{
                //     if(cnt > mid){
                //         checkM++;
                //         cnt = arr[j];
                //     }
                // }

                if(cnt > mid){
                    checkM++;
                    cnt = arr[j];

                    if(cnt>mid){
                        isSU = true;
                        break;
                    }
                    else if(cnt==mid){
                        checkM++;
                        cnt=0;
                    }
                }
            }

            if(isSU){
                min = mid+1;
                result = mid;
            }
            else{
                if(checkM<m){
                    max = mid - 1;
                }
                else{
                    min = mid + 1;
                    result = mid;
                }
            }
            
        }

        System.out.println(result+1);
    }
}