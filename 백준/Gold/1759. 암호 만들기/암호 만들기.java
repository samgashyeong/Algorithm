import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static char[] arr = new char[15];
    static int l;
    static int c;
    static int ans;

    static void f(int d, char[] str, int inx) {
        if (d == l) {
            //System.out.println(str);
            int aeiou = 0;
            int withOutAeiou = 0;
            for (int i = 0; i < l; i++) {
                if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') {
                    aeiou++;
                } else {
                    withOutAeiou++;
                }
            }

            
            if (aeiou < 1 || withOutAeiou < 2) {
                return;
            }

            // char[] strCom = new char[l];

            // for(int i=0;i<l;i++){
            //     strCom[i] = str[i];
            // }

            // Arrays.sort(strCom);
            // for(int i=0;i<l;i++){
            //     if(strCom[i] != str[i]){
            //         return;
            //     }
            // }
            
            sb.append(str).append("\n");
            return;
        }

        for (int i = inx; i < c; i++) {
            str[d] = arr[i];
            f(d + 1, str, i+1);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        l = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < c; i++) {
            arr[i] = st.nextToken().charAt(0);
        }

        Arrays.sort(arr, 0, c);
        //System.out.println(arr);

        char[] result = new char[l];
        f(0, result, 0);

        System.out.println(sb);
    }
}