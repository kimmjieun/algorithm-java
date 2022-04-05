package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.StringTokenizer;

public class BOJ15666 {
    public static int n, m;
    public static int[] arr;
    public static int[] re;
    public static boolean[] visit;
    static StringBuilder sb = new StringBuilder();
    static HashSet<String> set = new HashSet<>();

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

        visit = new boolean[n];
        re = new int[m];
        back(0, 0);
        System.out.println(sb);


    }

    private static void back(int depth, int start) {
        if (m == depth) {
            StringBuilder sb2 = new StringBuilder();
            for (int r : re) {
                sb2.append(r).append(" ");
            }
            if (!set.contains(sb2.toString())) {
                sb.append(sb2.toString()).append("\n");
                set.add(sb2.toString());
            }
            return;
        }


        for (int i = start; i < n; i++) {
            re[depth] = arr[i];
            back(depth + 1, i);
        }


    }

}

