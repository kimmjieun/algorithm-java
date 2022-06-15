package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ17103 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        boolean[] prime = new boolean[1_000_001];
        prime[0] = prime[1] = true;
        for (int i = 2; i < prime.length; i++) {
            if (!prime[i]) {
                for (int j = i + i; j < prime.length; j += i) {
                    prime[j] = true;
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            int n = Integer.parseInt(br.readLine());
            int cnt = 0;
            for (int i = 0; i <= n / 2; i++) {
                if (!prime[i] && !prime[n - i]) {
                    cnt++;
                }

            }

            sb.append(cnt).append("\n");
        }
        System.out.println(sb);
    }
}
