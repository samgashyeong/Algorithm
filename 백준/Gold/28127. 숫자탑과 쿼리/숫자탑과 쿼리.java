import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.math.BigInteger;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Deque;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int q = Integer.parseInt(br.readLine());

        for(int i=0;i<q;i++){
            st = new StringTokenizer(br.readLine());
            
            int a = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());

            long sum;
            long maxCnt = x;
            long minCnt = 0;
            long midCnt = 1;
            long cnt = 1;
            while(maxCnt>=minCnt){
                midCnt = (maxCnt+minCnt)/2;
                sum = (midCnt*(2*a+(midCnt-1)*d))/2;
                if(sum >= x){
                    maxCnt = midCnt-1;
                    cnt = midCnt;
                }
                else{
                    minCnt = midCnt+1;
                }
            }
            bw.write(Long.toString(cnt));
            bw.write(" ");

            sum = (cnt*(2*a+(cnt-1)*d))/2;
            
            long crtBlockCount = a+(cnt-1)*d;

            bw.write(Long.toString(crtBlockCount - (sum-x)));
            bw.newLine();

        }

        bw.close();
    }
}