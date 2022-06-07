package 수학;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2004 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int twoCnt = get(n, 2) - get(m, 2) - get(n - m, 2);
        int fiveCnt = get(n, 5) - get(m, 5) - get(n - m, 5);

        System.out.println(Math.min(twoCnt, fiveCnt));
    }

    static int get(int n, int k) {
        int cnt = 0;
        while (n >= k) {
            cnt += n / k;
            n /= k;
        }
        return cnt;
    }


}
