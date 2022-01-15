package boj.알고리즘기초1.b_수학1_참고;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 2745번 진법변환
public class boj_2_2745 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        String s = st.nextToken();
        int n = Integer.parseInt(st.nextToken());

        int tmp = 1;
        int ans = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if ('A' <= c && c <= 'Z') {
                ans += (c - 'A' + 10) * tmp;
            } else {
                ans += (c - '0') * tmp;
            }
            tmp *= n;
        }
        System.out.println(ans);

    }
}
