import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws Exception{
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        Queue<Integer> que = new LinkedList<>();
        for(int i = 0;i<n;i++){
            que.add(i+1);
        }

        System.out.print("<");
        while(que.size() != 0){

            for(int i =0;i<k-1;i++){
                int num = que.poll();
                que.add(num);
            }

            int num = que.poll();
            if(que.size()==0){
                System.out.print(num+">");
            }
            else{
                System.out.print(num+", ");
            }
        }
        

        
    }
}