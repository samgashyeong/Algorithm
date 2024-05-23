import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//탑다운으로 푼 문제
public class Main {

    static int t;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int result = 1;
        for(int i=0;i<n;i++){
            System.out.print(result+i*2 + " ");
        }
    }
}
