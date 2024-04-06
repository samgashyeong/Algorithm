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

    static boolean[][] star= new boolean[6561][6561];

    static void f(int size, int startX, int startY){

        if(size == 1){
            return;
        }

        for(int i=0;i<size/3;i++){
            for(int j=0;j<size/3;j++){
                star[size/3+i+startY][size/3+j+startX] = false;
                //System.out.println(star[size/3+i][size/3+j]);
            }
        }
        

        // for(int i=0;i<size;i++){
        //     for(int j=0;j<size;j++){
        //         if(star[i][j]){
        //             System.out.print("*");
        //         }
        //         else{
        //             System.out.print(" ");
        //         }
        //     }
        //     System.out.println();
        // }

        f(size/3, startX, startY);
        f(size/3, startX+size/3, startY);
        f(size/3, startX+(2*size/3), startY);
        f(size/3, startX, startY+size/3);
        f(size/3, startX+size/3, startY+size/3);
        f(size/3, startX+(2*size/3), startY+size/3);
        f(size/3, startX, startY+2*(size/3));
        f(size/3, startX+size/3, startY+2*(size/3));
        f(size/3, startX+(2*size/3), startY+2*(size/3));
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int input = Integer.parseInt(br.readLine());


        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                
                star[i][j] = true;
            }
        }

        f(input, 0, 0);

        for(int i=0;i<input;i++){
            for(int j=0;j<input;j++){
                if(star[i][j]){
                    sb.append("*");
                }
                else{
                    sb.append(" ");
                }
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }
}