package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ15988 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        long[] dy = new long[1_000_001];
        // 초기값
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        for (int i = 4; i <= 1_000_000; i++) {
            dy[i] = (dy[i - 1] + dy[i - 2] + dy[i - 3]) %1_000_000_009;
        }

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            // 점화식 채우기

            System.out.println(dy[n]);
        }
    }
}
