import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.*;

public class Main {

    static StringBuilder sb = new StringBuilder();

    static class Pair {
        BigInteger x;
        BigInteger y;

        public Pair(BigInteger x, BigInteger y) {
            this.x = x;
            this.y = y;
        }
    }

    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println(".  .   .\n" +
                "|  | _ | _. _ ._ _  _\n" +
                "|/\\|(/.|(_.(_)[ | )(/.");
    }
}
