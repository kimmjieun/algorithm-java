package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1149 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] d = new int[n + 1][3];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int g = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            d[i][0] = Math.min(d[i - 1][1] + r, d[i - 1][2] + r);
            d[i][1] = Math.min(d[i - 1][0] + g, d[i - 1][2] + g);
            d[i][2] = Math.min(d[i - 1][0] + b, d[i - 1][1] + b);
        }

        System.out.println(Math.min(Math.min(d[n][0], d[n][1]), d[n][2]));

    }
}
