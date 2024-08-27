import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws Exception{
        //TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        Stack<String> stk = new Stack<>();

        int result = 0;
        while(st.hasMoreElements()){
            String next = st.nextToken();

            if(next.equals("[")){
                stk.add(next);
            }
            else if (next.equals("]")){
                result+=8;
                stk.pop();
            }
            else if(next.chars().allMatch(Character::isDigit)){
                result+=8;
            }
            else{
                result+=(12+next.length());
            }
        }

        System.out.println(result);
    }
}