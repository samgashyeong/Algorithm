import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        int t = Integer.parseInt(br.readLine());

        while(t-->0){

            int n = Integer.parseInt(br.readLine());
            int[] arr = new int[n+2];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i=0;i<n;i++){
                arr[i] = Integer.parseInt(st.nextToken());
            }
            arr[n] = arr[0];
            int[] original = Arrays.copyOf(arr, n);

            //System.out.println(Arrays.toString(Arrays.stream(original).toArray()));

            int sum = 0;
            Loop:
            while(true){
                int[] chk = new int[n];
                for(int i=1;i<n+1;i++){
                    chk[i-1] = Math.abs(arr[i]-arr[i-1]);
                }

                boolean zero = true;
                boolean loop = true;

                for(int i=0;i<n;i++){
                    if(chk[i] !=0){
                        zero = false;
                        break;
                    }
                }

                HashSet<Integer> set = new HashSet<>();

                for(int i=0;i<n;i++){
                    set.add(chk[i]);
                }



                if(zero){
                    System.out.println("ZERO");
                    break Loop;
                }
                else if(sum > 1100){
                    System.out.println("LOOP");
                    break Loop;
                }
                else{
                    arr = new int[n+1];
                    arr = Arrays.copyOf(chk, n+1);
                    arr[n] = arr[0];
                    sum++;
                }

            }

        }
    }
}
