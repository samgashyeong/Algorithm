import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;



public class Main {
    static int b = 0;
    static int n;
    static int k;
    static int[] a;


    static boolean ok(int x){
        int cnt = 0;
        int s = 0;

        for(int i=0;i<n;i++){
            s |= a[i];
            if((s & x) == x) s = 0;
            else cnt++;
        }

        return cnt <= k;
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br=  new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        a = new int[n+1];
        for(int i =0;i<n;i++){
            a[i] = Integer.parseInt(st.nextToken());
        }

        for(int i = 30 ; i>=0;i--){
            if(ok( b| (1 << i))) b |= (1<<i);
        }

        System.out.println(b);
    }
}