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

class Asdf{
    public int index;
    public int num;

    public Asdf(int index, int num){
        this.index = index;
        this.num = num;
    }
}

public class Main {
    //문제의 흐름을 잘 따라면 쉽게 풀 수 있는 문제였던 것 같다.

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        Deque<Asdf> dq = new ArrayDeque<>();

        StringTokenizer st = new StringTokenizer(br.readLine());

        int cnt = 1;
        while(st.hasMoreTokens()){
            dq.addLast(new Asdf(cnt++, Integer.parseInt(st.nextToken())));
        }

        for(int i =0;i<n-1;i++){
            Asdf tmp = dq.pollFirst();

            sb.append(tmp.index).append(" ");
            if(tmp.num>0){
                for(int j=0;j<tmp.num-1;j++){
                    Asdf num = dq.pollFirst();
                    dq.addLast(num);
                }
            }
            else{
                for(int j=0;j>tmp.num;j--){
                    Asdf num = dq.pollLast();
                    dq.addFirst(num);
                }
            }
            
        }

        Asdf tmp = dq.pollFirst();

        sb.append(tmp.index).append(" ");

        System.out.println(sb);
    }
}