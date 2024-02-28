import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main {

    //
    public static void main(String[] args) throws Exception{
        //BufferedReader로 입력 더 빠르게 하기
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int s = Integer.parseInt(br.readLine());


        Queue<Integer> cards = new LinkedList<>();

        
        for(int i =0;i<s;i++){
            cards.add(i+1);
        }

        int check = 0;
        while(cards.size() != 1){

            int checkNum;
            if(check == 0){
                cards.remove();
                check++;
            }
            else{
                check = 0;
                checkNum = cards.poll();
                cards.add(checkNum);
            }
        }

        System.out.println(cards.peek());
    }
}
