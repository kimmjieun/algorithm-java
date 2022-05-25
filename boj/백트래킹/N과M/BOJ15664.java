package 백트래킹.N과M;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ15664 {
    static int n, m;
    static int[] arr;
    static boolean[] visit;
    static int[] result;
    static StringBuilder sb = new StringBuilder();
    static ArrayList<String> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr);
        result = new int[m];
        visit = new boolean[n];
        back(0, 0);
        System.out.println(sb);
    }

    public static void back(int depth, int start) {
        if (m == depth) {
            StringBuilder sb2 = new StringBuilder();
            for (int r : result) {
                sb2.append(r).append(" ");
            }
            if (!list.contains(sb2.toString())) {
                sb.append(sb2.toString()).append("\n");
                list.add(sb2.toString());
            }
            return;
        }


        for (int i = start; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                result[depth] = arr[i];
                back(depth + 1, i);
                visit[i] = false;
            }
        }
    }
}
