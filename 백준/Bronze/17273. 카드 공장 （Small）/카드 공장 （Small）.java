import java.io.*;
import java.util.*;


public class Main {

    static long[] memo;
    

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean[] now = new boolean[101];
        int[] front = new int[101];
        int[] back  = new int[101];
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());
            
            int f = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            now[i] = true;
            front[i] = f;
            back[i] = b;
        }

        for(int i=0;i<m;i++){
            int q = Integer.parseInt(br.readLine());
            
            for(int j=0;j<n;j++){
                int nowI;
                if(now[j]){
                    nowI = front[j];
                }
                else{
                    nowI = back[j];
                }

                if(nowI <= q){
                    now[j] = !now[j];
                }
            }
        }

        int sum = 0;
        for(int i=0;i<n;i++){
            if(now[i]){
                sum+=front[i];
            }
            else{
                sum+=back[i];
            }
        }

        System.out.println(sum);
    }
}