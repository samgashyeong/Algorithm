import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int sw, im, ai = 0;
        sw = 0;
        im = 0;
        int else1 = 0;
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());

            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            st.nextToken();
            if(g == 1){
                else1++;
                continue;
            }
            if(b <= 2){
                sw++;
            }
            else if(b == 3){
                im++;
            }
            else{
                ai++;
            }
        }

        System.out.println(sw);
        System.out.println(im);
        System.out.println(ai);
        System.out.println(else1);
    }
}