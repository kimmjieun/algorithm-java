package 해시.해시셋;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ1253 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        HashSet<Long> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(Long.parseLong(st.nextToken()));
        }

        ArrayList<Long> list = new ArrayList<>(set);
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                if (i == j) continue;

                if (set.contains(list.get(i) + list.get(j))) {
                    cnt++;
                    System.out.println(list.get(i) + " " + list.get(j));
                }
            }
        }
        System.out.println(cnt);
    }
}
