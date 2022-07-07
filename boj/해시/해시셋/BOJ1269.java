package 해시.해시셋;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ1269 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set2 = new HashSet<>();

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            set2.add(Integer.parseInt(st.nextToken()));
        }


        Iterator<Integer> iter = set.iterator();
        int cnt = 0;
        while (iter.hasNext()) {
            if (!set2.contains(iter.next())) {
                cnt++;
            }
        }

        Iterator<Integer> iter2 = set2.iterator();
        while (iter2.hasNext()) {
            if (!set.contains(iter2.next())) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
