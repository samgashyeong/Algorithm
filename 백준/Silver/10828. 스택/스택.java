import java.io.*;
import java.util.*;


public class Main {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();

        Stack<Integer> stk = new Stack<>();
        while(n-->0){
            StringTokenizer st = new StringTokenizer(br.readLine());

            String str = st.nextToken();
            if(str.equals("push")){
                int in = Integer.parseInt(st.nextToken());
                stk.push(in);
            }   

            if(str.equals("pop")){
                if(stk.empty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(stk.pop()).append("\n");
                }
            }
            else if(str.equals("size")){
                sb.append(stk.size()).append("\n");
            }
            else if(str.equals("empty")){
                if(stk.empty()){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
            else if(str.equals("top")){
                if(stk.empty()){
                    sb.append(-1).append("\n");
                }
                else{
                    sb.append(stk.peek()).append("\n");
                }
            }
        }

        System.out.println(sb);
    }
}