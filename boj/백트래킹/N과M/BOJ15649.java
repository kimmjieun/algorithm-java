package 백트래킹.N과M;


import java.io.*;
import java.util.*;

public class BOJ15649 {
    static int n, m;

    static int[] result;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        result = new int[m];
        visit = new boolean[n + 1];
        back(0);
    }

    public static void back(int depth) {
        if (m == depth) {
            for (int r : result) {
                System.out.print(r + " ");
            }
            System.out.println();
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = i;
                back(depth + 1);
                visit[i] = false;
            }
        }
    }
}