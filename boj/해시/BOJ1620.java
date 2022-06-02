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
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        HashMap<String, String> map = new HashMap<>();

        for (int i = 1; i <= n; i++) {
            String s = br.readLine();
            map.put(String.valueOf(i), s);
            map.put(s, String.valueOf(i));
        }
        for (int i = 0; i < m; i++) {
            System.out.println(map.get(br.readLine()));
        }
    }
}
