import java.io.*;
import java.util.*;

public class Main {

    static long[] memo;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        char[][] input = new char[150][150];

        int n = Integer.parseInt(br.readLine());

        for (int i = 0; i < n; i++) {

            String a = br.readLine();

            for (int j = 0; j < n; j++) {
                input[i+5][j+5] = a.charAt(j);
            }
        }

        int result = 0;
        for (int i = 5; i < n + 10; i++) {
            for (int j = 5; j < n + 10; j++) {
                if (input[i][j] == 'M' &&
                        input[i][j + 1] == 'O' &&
                        input[i][j + 2] == 'B' &&
                        input[i][j + 3] == 'I' &&
                        input[i][j + 4] == 'S') {
                    //System.out.println(i + " " + j + " " + input[i][j]);
                    result++;
                }

                if (input[i][j] == 'S' &&
                        input[i][j + 1] == 'I' &&
                        input[i][j + 2] == 'B' &&
                        input[i][j + 3] == 'O' &&
                        input[i][j + 4] == 'M') {
                    //System.out.println(i + " " + j + " " + input[i][j]);
                    result++;
                }
            }
        }

        for (int i = 5; i < n + 10; i++) {
            for (int j = 5; j < n + 10; j++) {
                if (input[j][i] == 'M' &&
                        input[j + 1][i] == 'O' &&
                        input[j + 2][i] == 'B' &&
                        input[j + 3][i] == 'I' &&
                        input[j + 4][i] == 'S') {
                    //System.out.println(i + " " + j + "F" + input[i][j]);
                    result++;
                }

                if (input[j][i] == 'S' &&
                        input[j + 1][i] == 'I' &&
                        input[j + 2][i] == 'B' &&
                        input[j + 3][i] == 'O' &&
                        input[j + 4][i] == 'M') {
                    //System.out.println(i + " " + j + "F" + input[i][j]);
                    result++;
                }
            }
        }

        for (int i = 5; i < n + 10; i++) {
            for (int j = 5; j < n + 10; j++) {
                if (input[i][j] == 'M' &&
                        input[i + 1][j + 1] == 'O' &&
                        input[i + 2][j + 2] == 'B' &&
                        input[i + 3][j + 3] == 'I' &&
                        input[i + 4][j + 4] == 'S') {
                    //System.out.println(i + " " + j + " " + input[i][j]);
                    result++;
                }

                if (input[i][j] == 'S' &&
                        input[i + 1][j + 1] == 'I' &&
                        input[i + 2][j + 2] == 'B' &&
                        input[i + 3][j + 3] == 'O' &&
                        input[i + 4][j + 4] == 'M') {
                    //System.out.println(i + " " + j + ' ' + "few");
                    result++;
                }

            }
        }

        for (int i = 5; i < n  + 10; i++) {
            for (int j = 5; j < n  + 10; j++) {
                    //System.out.println("fwefff" +  " " + input[i][j]  +  " "  + input[i-1][j-1] +  " "  + input[i-2][j-2] +  " "  + input[i-3][j-3] +  " "  + input[i-4][j-4]+  " "  +  i + " " + j);
                    if (input[i][j] == 'M' &&
                            input[i + 1][j - 1] == 'O' &&
                            input[i + 2][j - 2] == 'B' &&
                            input[i + 3][j - 3] == 'I' &&
                            input[i + 4][j - 4] == 'S') {
                        //System.out.println(i + " " + j + " " + input[i][j]);
                        result++;
                    }

                    if (input[i][j] == 'S' &&
                            input[i + 1][j - 1] == 'I' &&
                            input[i + 2][j - 2] == 'B' &&
                            input[i + 3][j - 3] == 'O' &&
                            input[i + 4][j - 4] == 'M') {
                        //System.out.println(i + " " + j + ' ' + "few");
                        result++;
                    }
            }
        }

        System.out.println(result);
    }
}