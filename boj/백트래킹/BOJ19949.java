package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ19949 {
    static int[] answer;
    static int[] youngjae;
    static int ans;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        answer = new int[10];
        youngjae = new int[10];

        for (int i = 0; i < 10; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }
        ans = 0;
        back(0);
        System.out.println(ans);
    }

    static void back(int depth) {
        if (depth == 10) {
            int cnt = 0;
            for (int i = 0; i < 10; i++) {
                if (answer[i] == youngjae[i]) {
                    cnt++;
                }
            }
            if (cnt >= 5) {
                ans++;
            }
            return;
        }

        for (int i = 1; i <= 5; i++) {
            if (depth >= 2) {
                if (youngjae[depth - 1] == i && youngjae[depth - 2] == i) continue;
            }
            youngjae[depth] = i;
            back(depth + 1);
        }
    }

}
