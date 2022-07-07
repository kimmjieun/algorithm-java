package 해시.해시셋;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.StringTokenizer;

public class BOJ19583 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        String s = st.nextToken();
        String e = st.nextToken();
        String q = st.nextToken();
        int S = Integer.parseInt(s.substring(0, 2) + s.substring(3));
        int E = Integer.parseInt(e.substring(0, 2) + e.substring(3));
        int Q = Integer.parseInt(q.substring(0, 2) + q.substring(3));

        HashSet<String> set = new HashSet<>();
        HashSet<String> set2 = new HashSet<>();
//        while (true) {
//            String str = br.readLine();
//            if (str.isEmpty()) break;
        String str="";
        while ((str=br.readLine())!=null) {

            st = new StringTokenizer(str);

            String t = st.nextToken();
            String name = st.nextToken();
            int time = Integer.parseInt(t.substring(0, 2) + t.substring(3));

            if (time <= S) {
                set.add(name);
            }
            if (time >= E && time <= Q) {
                set2.add(name);
            }
        }
        int cnt = 0;
        Iterator<String> iter = set.iterator();
        while (iter.hasNext()) {
            if (set2.contains(iter.next())) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
