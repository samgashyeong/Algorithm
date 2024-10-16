import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static ArrayList<Long> map = new ArrayList<>();
    static int INF = 100000*1000;
    static int result = 0;
    static HashMap<Character, Integer> base;
    static ArrayList<String> chk;
    static char[] resultCh = new char[7];
    public static class Pair{
        int f;
        int s;

        public Pair(int f, int s){
            this.f = f;
            this.s = s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] base = {6, 2, 5, 5, 4, 5, 6, 3, 7, 6};

        int n = Integer.parseInt(br.readLine());

        for(int i=0;i<=99;i++){
            for(int j=0;j<=99;j++){
                for(int k=0;k<=99;k++){
                    if((i + j == k)){
                        int ic = base[i%10]+base[i/10];
                        int jc = base[j%10]+base[j/10];
                        int kc = base[k%10]+base[k/10];

                        if(ic+jc+kc+4 == n){
                            System.out.println(i/10 + "" +i%10 +"+" + j/10 + "" + j%10 + "=" + "" + k/10 + "" + k%10);
                            return;
                        }
                    }
                }
            }
        }

        System.out.println("impossible");
    }

}
