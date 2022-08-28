package 삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ13458 {
    static int n;
    static int[] a;
    static int b, c;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        a = new int[n];

        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        b = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        long count = a.length;

        for (int i = 0; i < n; i++) {
            if (a[i] - b < 0) {
                a[i] = 0;
            } else {
                a[i] -= b;
            }

            if (a[i] % c == 0) {
                count += a[i] / c;
            } else {
                count += a[i] / c + 1;
            }
        }

        System.out.println(count);

    }
}
