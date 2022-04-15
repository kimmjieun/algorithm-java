package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ10819 {
    static int n;
    static int[] arr;
    static int[] result;
    static int max = Integer.MIN_VALUE;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        visit = new boolean[n];
        result = new int[n];
        back(0);
        System.out.println(max);
    }

    static void back(int depth) {
        if (depth == n) {
            int sum = 0;
            for (int i = 0; i < n - 1; i++) {
                sum += Math.abs(result[i] - result[i + 1]);
            }
            max = Math.max(sum, max);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                back(depth + 1);
                visit[i] = false;
            }
        }
    }
}
