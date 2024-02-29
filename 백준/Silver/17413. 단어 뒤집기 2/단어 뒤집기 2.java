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
        String s = br.readLine();

        Stack<Character> strStk = new Stack<>();

        Queue<Character> braketStk = new LinkedList();
        
        for(int i=0;i<s.length();i++){
            if(braketStk.size() !=0){
                if(s.charAt(i) == '>'){
                    while(!braketStk.isEmpty()){
                        System.out.print(braketStk.poll());
                    }
                    System.out.print(">");
                }
                else{
                    braketStk.add(s.charAt(i));
                }

                if(i == s.length()-1){
                    //braketStk.add(s.charAt(i));
                    while(!braketStk.isEmpty()){
                        System.out.print(braketStk.poll());
                    }
                }
            }
            else{
                if(s.charAt(i) == ' '){
                    while(!strStk.isEmpty()){
                        System.out.print(strStk.pop());
                    }
                    System.out.print(" ");
                }
                else if(s.charAt(i) == '<'){
                    while(!strStk.isEmpty()){
                        System.out.print(strStk.pop());
                    }
                    //System.out.print(" ");
                }
                else{
                    strStk.add(s.charAt(i));
                }

                if(i == s.length()-1){
                    //strStk.add(s.charAt(i));
                    while(!strStk.isEmpty()){
                        System.out.print(strStk.pop());
                    }
                }
            }
            if(s.charAt(i) == '<'){
                braketStk.add(s.charAt(i));
            }
        }
    }
}
