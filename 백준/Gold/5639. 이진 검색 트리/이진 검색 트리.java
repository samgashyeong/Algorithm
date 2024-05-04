import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
// 자료구조 시간 때 배웠던 지식으로 오랜만에 1트라이만에 끝난 문제. 클래스를 이용하고 재귀를 요리조리 이용하면은 잘 풀 수 있는 문제였다.
import java.util.*;

public class Main {

    static ArrayList<Integer> list = new ArrayList<>();

    static void f(int start, int end){
        if(start > end){
            return;
        }
        
        //System.out.println(end + " " + size);
        int startData = list.get(start);

        int startMax = start+1;
        for(int i=start+1;i<=end;i++){
            if(startData < list.get(i)){
                startMax = i;
                break;
            }
        }

        //System.out.println(startMax);
        f(start+1, startMax-1);
        f(startMax, end);
        System.out.println(startData);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s;
        while (true){
            s=br.readLine();
            if(s==null||s.equals("")) break;
            list.add(Integer.parseInt(s));
        }

        f(0, list.size()-1);
        

        // for(int i=0;i<list.size();i++){
        //     System.out.println(list.get(i));
        // }
    }
}