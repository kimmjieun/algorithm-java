package 구현;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ2980 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int t = 0;
        int pre = 0;

        for (int i = 0; i < n; i++) {
            StringTokenizer st2 = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st2.nextToken());
            int r = Integer.parseInt(st2.nextToken());
            int g = Integer.parseInt(st2.nextToken());

            // t - 위치 d에 있는 신호등까지 걸린 시간
            t += d - pre;
            pre = d;

            int red = t % (r + g);
            if (red <= r) {
                // 빨간 불이 끝날 때까지 대기
                t += r - red;
            }
        }
        System.out.println(t + (l - pre));


    }
}
