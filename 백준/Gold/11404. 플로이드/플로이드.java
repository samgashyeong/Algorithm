import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {


    class Pair{
        int first;
        int second;

        public Pair(int first, int second){
            this.first = first;
            this.second = second;
        }
    }

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());


        int[][] dist = new int[n+1][n+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                dist[i][j] = 123456789;
            }
        }

        for(int i=0;i<=n;i++){
            dist[i][i] = 0;
        }
        for(int i=0;i<m;i++){
             StringTokenizer st = new StringTokenizer(br.readLine());

             int a = Integer.parseInt(st.nextToken());
             int b = Integer.parseInt(st.nextToken());
             int w = Integer.parseInt(st.nextToken());

             dist[a][b] = Math.min(w, dist[a][b]);
        }

        for(int k=1;k<=n;k++){
            for(int i=1;i<=n;i++){
                for(int j=1;j<=n;j++){
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for(int i=1;i<=n;i++){
            for(int j=1;j<=n;j++){
                if(dist[i][j] >= 123456789) dist[i][j] = 0;

                System.out.print(dist[i][j] + " ");
            }
            System.out.println();
        }
    }
}
