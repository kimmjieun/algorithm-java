package DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] d0 = new int[41];
        int[] d1 = new int[41];

        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());

            d0[0] = 1;
            d1[0] = 0;
            d0[1] = 0;
            d1[1] = 1;

            for (int i = 2; i <= n; i++) {
                d0[i] = d0[i - 1] + d0[i - 2];
                d1[i] = d1[i - 1] + d1[i - 2];
            }

            System.out.println(d0[n] + " " + d1[n]);
        }

    }
}
