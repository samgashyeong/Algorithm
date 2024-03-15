import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static int[] a = new int[100];
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        for(int i=0;i<n;i++){
            a[i] = 0;
        }
        for(int x=0;x<m;x++){
            int i,j,k;
            
            st = new StringTokenizer(br.readLine());
            i = Integer.parseInt(st.nextToken());
            j = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            for(int y=i;y<=j;y++){
                a[y-1] = k;

                // StringBuilder sb = new StringBuilder();

                // for(int z=0;z<n;z++){
                //     sb.append(a[z]).append(" ");
                // }
                // System.out.println(sb);
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i=0;i<n;i++){
            sb.append(a[i]).append(" ");
        }
        System.out.println(sb);
    }
}