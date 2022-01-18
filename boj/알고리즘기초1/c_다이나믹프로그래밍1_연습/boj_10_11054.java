package 알고리즘기초1.c_다이나믹프로그래밍1_연습;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 11054번 가장 긴 바이토닉 부분 수열
public class boj_10_11054 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] r_dp = new int[n];
        int[] l_dp = new int[n];
        int[] seq = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            seq[i] = Integer.parseInt(st.nextToken());
        }

        // LIS
        for (int i = 0; i < n; i++) {
            r_dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (seq[j] < seq[i] && r_dp[i] < r_dp[j] + 1) {
                    r_dp[i] = r_dp[j] + 1;
                }
            }
        }

        // LDS
        for (int i = n - 1; i >= 0; i--) {
            l_dp[i] = 1;
            for (int j = n - 1; j > i; j--) {
                if (seq[j] < seq[i] && l_dp[i] < l_dp[j] + 1) {
                    l_dp[i] = l_dp[j] + 1;
                }
            }
        }

        int max = 0;
        for (int i = 0; i < n; i++) {
            if (max < r_dp[i] + l_dp[i]) {
                max = r_dp[i] + l_dp[i];
            }
        }
        System.out.println(max - 1);
    }
}
