package 백트래킹.N과M;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15652 {
    static int n, m;
    static int[] result;
    static boolean[] visit;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[m];
        visit = new boolean[n + 1];
        back(0, 1);
        System.out.println(sb);
    }

    public static void back(int depth, int start) {
        if (m == depth) {
            for (int r : result) {
                sb.append(r + " ");
            }
            sb.append("\n");
            return;
        }
        for (int i = start; i <= n; i++) {
            result[depth] = i;
            back(depth + 1, i);
        }
    }
}

