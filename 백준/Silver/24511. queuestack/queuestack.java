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

    //문제의 흐름을 잘 따라면 쉽게 풀 수 있는 문제였던 것 같다.
    public static void main(String[] args) throws Exception{
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        int[] stkOrQue = new int[n];
        Deque<Integer> que = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i =0;i<n;i++){
            stkOrQue[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());

        for(int i =0;i<n;i++){
            Integer chk = Integer.parseInt(st.nextToken());
            if(stkOrQue[i] == 0){
                que.addFirst(chk);
            }
        }

        int m = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        for(int i =0;i<m;i++){
            que.addLast(Integer.parseInt(st.nextToken()));
            sb.append(que.pollFirst()).append(" ");
        }

        System.out.println(sb);
    }
}