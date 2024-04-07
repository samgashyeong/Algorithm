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

    static int r;
    static int c;
    static int result = 0;

    static char[][] input = new char[20][20];
    static boolean[][] chk = new boolean[20][20];


    //
    static boolean isNotD(String makeChs, char target){
        for(int i=0;i<makeChs.length();i++){
            if(target == makeChs.charAt(i)){
                return false;
            }
        }
        return true;
    }

    static void f(int x, int y, String strResult, int size){
        // for(int i=0;i<r;i++){
        //     for(int j=0;j<c;j++){
        //         System.out.print(chk[i][j] + " ");
        //     }
        //     System.out.println();
        // }
        //System.out.println(strResult + " " +  x + " " + y);
        //System.out.println();
        if(!isNotD(strResult, input[y][x])){
            //chk[x][y] = false;
            return;
        }
        else{
            strResult = strResult + input[y][x];
            result = Math.max(result, strResult.length());
            //chk[y][x] = true;
        }


        if(!(x-1 < 0) && !chk[y][x-1]){
            //System.out.println("x-1 " + strResult);
            chk[y][x-1] = true;
            f(x-1, y, strResult, size+1);
            chk[y][x-1] = false;
        }
        if(!(x+1 >= c) && !chk[y][x+1]){
            //System.out.println("x+1 " + strResult);
            chk[y][x+1] = true;
            f(x+1, y, strResult, size+1);
            chk[y][x+1] = false;
        }
        if(!(y-1 < 0) && !chk[y-1][x]){
            //System.out.println("y-1 " + strResult);
            chk[y-1][x] = true;
            f(x, y-1, strResult, size+1);
            chk[y-1][x] = false;
        }
        if(!(y+1 >= r) && !chk[y+1][x]){
            //System.out.println("y+1 " + strResult);
            chk[y+1][x] = true;
            f(x, y+1, strResult, size+1);
            chk[y+1][x] = false;
        }
    
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());


        for(int i=0;i<r;i++){
            
            String str = br.readLine();

            for(int j=0;j<c;j++){
                input[i][j] = str.charAt(j);
            }
        }

        String output = new String();
        output = "";
        chk[0][0] = true;
        f(0, 0, output, 0);

        System.out.println(result);
    }
}