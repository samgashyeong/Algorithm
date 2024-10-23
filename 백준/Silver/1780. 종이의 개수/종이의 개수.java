import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int[][] mp;
    static int minus = 0;
    static int zero = 0;
    static int one = 0;

    static void fun(int sx, int sy, int s){
        boolean mi = true;
        boolean ze = true;
        boolean on = true;

        for(int i=sy;i<sy+s;i++){
            for(int j=sx;j<sx+s;j++){
                if(mp[i][j] != -1){
                    mi = false;
                    break;
                }
            }
        }

        for(int i=sy;i<sy+s;i++){
            for(int j=sx;j<sx+s;j++){
                if(mp[i][j] != 0){
                    ze = false;
                    break;
                }
            }
        }

        for(int i=sy;i<sy+s;i++){
            for(int j=sx;j<sx+s;j++){
                if(mp[i][j] != 1){
                    on = false;
                    break;
                }
            }
        }

        if(!on && !ze && !mi){
            fun(sx, sy, s/3);
            fun(sx+s/3, sy, s/3);
            fun(sx+2*(s/3), sy, s/3);
            fun(sx, sy+s/3, s/3);
            fun(sx+s/3, sy+s/3, s/3);
            fun(sx+2*(s/3), sy+s/3, s/3);
            fun(sx, sy+2*(s/3), s/3);
            fun(sx+s/3, sy+2*(s/3), s/3);
            fun(sx+2*(s/3), sy+2*(s/3), s/3);
        }

        if(on){
            one++;
            return;
        }
        if(ze){
            zero++;
            return;
        }
        if(mi){
            minus++;
            return;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        mp = new int[n][n];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0;j<n;j++){
                mp[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        fun(0, 0, n);

        System.out.println(minus);
        System.out.println(zero);
        System.out.println(one);
    }
}
