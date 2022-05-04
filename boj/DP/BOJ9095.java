package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t = Integer.parseInt(br.readLine());
        int[] dy = new int[11]; //???
        // 초기값
        dy[0] = 0;
        dy[1] = 1;
        dy[2] = 2;
        dy[3] = 4;

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            // 점화식 채우기
            for (int i = 4; i <= n; i++) {
                dy[i] = dy[i - 1] + dy[i - 2] + dy[i - 3];
            }
            System.out.println(dy[n]);
        }
    }
}
