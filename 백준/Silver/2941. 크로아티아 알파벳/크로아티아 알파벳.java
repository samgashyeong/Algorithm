import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[] input = br.readLine().toCharArray();
        int result = 0;
        for(int i=0;i<input.length;i++){
            if(i>0 && input[i] == '=' && input[i-1] == 'c'){
                result++;
                input[i] = ' ';
                input[i-1] = ' ';
            }
        }
        for(int i=0;i<input.length;i++){
            if(i>0 && input[i] == '-' && input[i-1] == 'c'){
                result++;
                input[i] = ' ';
                input[i-1] = ' ';
            }
        }

        for(int i=0;i<input.length;i++){
            if(i>1 && input[i] == '=' && input[i-1] == 'z' && input[i-2] == 'd'){
                result++;
                input[i] = ' ';
                input[i-1] = ' ';
                input[i-2] = ' ';
            }
        }

        for(int i=0;i<input.length;i++){
            if(i>0 && input[i] == '-' && input[i-1] == 'd'){
                result++;
                input[i] = ' ';
                input[i-1] = ' ';
            }
        }

        for(int i=0;i<input.length;i++){
            if(i>0 && input[i] == 'j' && input[i-1] == 'l'){
                result++;
                input[i] = ' ';
                input[i-1] = ' ';
            }
        }

        for(int i=0;i<input.length;i++){
            if(i>0 && input[i] == 'j' && input[i-1] == 'n'){
                result++;
                input[i] = ' ';
                input[i-1] = ' ';
            }
        }

        for(int i=0;i<input.length;i++){
            if(i>0 && input[i] == '=' && input[i-1] == 's'){
                result++;
                input[i] = ' ';
                input[i-1] = ' ';
            }
        }

        for(int i=0;i<input.length;i++){
            if(i>0 && input[i] == '=' && input[i-1] == 'z'){
                result++;
                input[i] = ' ';
                input[i-1] = ' ';
            }
        }



        for(int i=0;i<input.length;i++){
            if(input[i] !=' '){
                result++;
            }
        }
        System.out.println(result);
    }
}
