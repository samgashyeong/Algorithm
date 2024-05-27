import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();
    static ArrayList<Integer> P = new ArrayList<>();
    static ArrayList<Integer> Q = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        if(n==1){
            System.out.println(10);
        }
        else if(n==2 || n==3){
            System.out.println(11);
        }
        else{
            int j = 3;
            while(true){
                if(Math.pow(2, j-1) <= n && n < Math.pow(2, j)){
                    System.out.println(10+j-1);
                    break;
                }
                j++;
            }
        }
    }
}
