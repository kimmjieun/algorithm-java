package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 틀린코드
public class BOJ20950 {
    static int min = Integer.MAX_VALUE;
    static boolean[] visit;
    static int gomR, gomG, gomB;
    static int[][] color;
    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        n = Integer.parseInt(br.readLine());

        color = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            color[i][0] = Integer.parseInt(st.nextToken());
            color[i][1] = Integer.parseInt(st.nextToken());
            color[i][2] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        gomR = Integer.parseInt(st.nextToken());
        gomG = Integer.parseInt(st.nextToken());
        gomB = Integer.parseInt(st.nextToken());


        int N=n;
        if(N>=7){
            N=7;
        }
        for (int i = 2; i <= N; i++) {
            visit = new boolean[n];
            back(0, i, 0, 0, 0, 0);
        }

        System.out.println(min);
    }

    static void back(int depth, int n, int start, int sumR, int sumG, int sumB) {
        if (depth == n) {
            int moonR = sumR / n;
            int moonG = sumG / n;
            int moonB = sumB / n;
            int sum = Math.abs(moonR - gomR) + Math.abs(moonG - gomG) + Math.abs(moonB - gomB);
            min = Math.min(sum, min);
            return;
        }

        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                back(depth + 1, n, i, sumR + color[i][0], sumG + color[i][1], sumB + color[i][2]);
                visit[i] = false;
            }
        }
    }

}
