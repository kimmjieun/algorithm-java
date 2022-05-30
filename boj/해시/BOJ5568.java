package 해시;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;

public class BOJ5568 {
    static int n, k;
    static int[] arr;
    static boolean[] visit;
    static HashSet<String> set = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        visit = new boolean[n];
        arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        back(0, "");
        System.out.println(set.size());

    }

    public static void back(int depth, String s) {
        if (depth == k) {
            set.add(s);
            return;

        }
        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                visit[i] = true;
                back(depth + 1, s + arr[i]);
                visit[i] = false;
            }
        }
    }

}
