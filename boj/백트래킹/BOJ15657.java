package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15657 {
    public static int n, m;
    public static int[] arr;
    public static int[] result;
    public static boolean[] visit;
    public static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);

        visit = new boolean[n];
        result = new int[m];
        back(0, 0);
        System.out.println(sb);
    }

    private static void back(int depth, int start) {
        if (m == depth) {
            for (int r : result) {
                sb.append(r + " ");
            }
            sb.append("\n");
            return;
        }

        for (int i = start; i < n; i++) {
            visit[i] = true;
            result[depth] = arr[i];
            back(depth + 1, i);
            visit[i] = false;

        }
    }

}
