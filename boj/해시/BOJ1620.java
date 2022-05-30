package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class BOJ1620 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            map.put(String.valueOf(i), s);
            map.put(s, String.valueOf(i));
        }
        for (int i = 0; i < m; i++) {
            String question = br.readLine();
            // 숫자인지 문자인지 판단하는 방법
            if (question.charAt(0) >= '1' && question.charAt(0) <= '9') {
                // 숫자라면
                sb.append(map.get(question)).append("\n");
            } else {
                // 아니라면
                sb.append(map.get(question)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
