import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        HashMap<Character, Integer> data = new HashMap<Character, Integer>();

        data.put('A', 3);
        data.put('B', 2);
        data.put('C', 1);
        data.put('D', 2);
        data.put('E', 3);
        data.put('F', 3);
        data.put('G', 3);
        data.put('H', 3);
        data.put('I', 1);
        data.put('J', 1);
        data.put('K', 3);
        data.put('L', 1);
        data.put('M', 3);
        data.put('N', 3);
        data.put('O', 1);
        data.put('P', 2);
        data.put('Q', 2);
        data.put('R', 2);
        data.put('S', 1);
        data.put('T', 2);
        data.put('U', 1);
        data.put('V', 1);
        data.put('W', 2);
        data.put('X', 2);
        data.put('Y', 2);
        data.put('Z', 1);


        String input = br.readLine();

        long result = 0;
        for(int i=0;i<input.length();i++){
            result+= data.get(input.charAt(i));
        }

        //System.out.println(result%10);
        if((result%10)%2 == 0){
            System.out.println("You're the winner?");
        }
        else{
            System.out.println("I'm a winner!");
        }
    }
}
