package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        long[] dy = new long[100_001];
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 2;
        dy[4] = 3;
        dy[5] = 3;
        dy[6] = 6;
        for (int i = 7; i <= 100_000; i++) {
            dy[i] = (dy[i - 2] + dy[i - 4] + dy[i - 6]) % 1_000_000_009;
        }
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            sb.append(dy[n]).append("\n");

        }

        System.out.println(sb);


    }
}
