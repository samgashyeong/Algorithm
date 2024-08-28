import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] arr = new int[n+1][m+1];

        int result = 0;

        for(int i=0;i<n;i++){
            st = new StringTokenizer(br.readLine());

            for(int j=0;j<m;j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        //****
        for(int i=0;i<n;i++){
            for(int j=3;j<m;j++){
                result = Math.max(result, arr[i][j]+arr[i][j-1]+arr[i][j-2]+arr[i][j-3]);
            }
        }

        //*
        //*
        //*
        //+
        for(int i=0;i<n-3;i++){
            for(int j=0;j<m;j++){
                result = Math.max(result, arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+3][j]);
            }
        }

        //**
        //**
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m-1;j++){
                result = Math.max(result, arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+1][j]);
            }
        }


        //*
        //*
        //**4
        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-1;j++){
                result = Math.max(result, arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+2][j+1]);

                result = Math.max(result, arr[i+2][j]+arr[i+2][j+1]+arr[i+1][j+1]+arr[i][j+1]);

                result = Math.max(result, arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+2][j+1]);

                result = Math.max(result, arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i][j+1]);
            }
        }

        for(int i=0;i<n-1;i++){
            for(int j=0;j<m-2;j++){
                result = Math.max(result, arr[i][j]+arr[i+1][j]+arr[i][j+1]+arr[i][j+2]);

                result = Math.max(result, arr[i][j]+arr[i+1][j]+arr[i+1][j+1]+arr[i+1][j+2]);

                result = Math.max(result, arr[i][j]+arr[i][j+1]+arr[i][j+2]+arr[i+1][j+2]);

                result = Math.max(result, arr[i+1][j]+arr[i+1][j+1]+arr[i+1][j+2]+arr[i][j+2]);
            }
        }



        //*
        //**
        // *
        for(int i=0;i<n-1;i++){
            for(int j=0;j<m-2;j++){
                result = Math.max(result, arr[i+1][j]+arr[i+1][j+1]+arr[i][j+1]+arr[i][j+2]);

                result = Math.max(result, arr[i][j]+arr[i][j+1]+arr[i+1][j+1]+arr[i+1][j+2]);
            }
        }

        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-1;j++) {
                result = Math.max(result, arr[i][j] + arr[i + 1][j] + arr[i + 1][j + 1] + arr[i + 2][j + 1]);

                result = Math.max(result, arr[i][j + 1] + arr[i + 1][j + 1] + arr[i + 1][j] + arr[i + 2][j]);
            }
        }


        //***
        // +
        for(int i=0;i<n-2;i++){
            for(int j=0;j<m-1;j++){
                result = Math.max(result, arr[i][j]+arr[i+1][j]+arr[i+2][j]+arr[i+1][j+1]);

                result = Math.max(result, arr[i+1][j]+arr[i+2][j+1]+arr[i+1][j+1]+arr[i][j+1]);
            }
        }

        for(int i=0;i<n-1;i++){
            for(int j=0;j<m-2;j++){
                result = Math.max(result, arr[i][j]+arr[i+1][j+1]+arr[i][j+1]+arr[i][j+2]);

                result = Math.max(result, arr[i][j+1]+arr[i+1][j]+arr[i+1][j+1]+arr[i+1][j+2]);
            }
        }


        System.out.println(result);

    }
}
