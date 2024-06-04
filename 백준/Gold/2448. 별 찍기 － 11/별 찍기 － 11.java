import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static char[][] stars;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int N = Integer.parseInt(br.readLine());
        stars = new char[N][N * 2 - 1]; // 꼭대기 별이 (0,N-1)에 찍힘
        for (int i = 0; i < N; i++) {
            Arrays.fill(stars[i], ' '); // 공백으로 채움
        }

        star(0, N-1, N);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 2 * N - 1; j++) {
                sb.append(stars[i][j]);
            }
            sb.append('\n');
        }
        System.out.println(sb);
    }

    public static void star(int r, int c, int N) {
        if (N == 3) {
            stars[r][c] = '*';
            stars[r + 1][c - 1] = stars[r + 1][c + 1] = '*';
            stars[r + 2][c - 2] = stars[r + 2][c - 1] = stars[r + 2][c] = stars[r + 2][c + 1] = stars[r + 2][c + 2] = '*';
        } else {
            int cut = N / 2;
            star(r, c, cut);
            star(r + cut, c - cut, cut); 
            star(r + cut, c + cut, cut);
        }
    }
}