package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ11725 {
    public static ArrayList<ArrayList<Integer>> arr;
    public static int n;
    public static int[] parent;
    public static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        arr = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            arr.add(new ArrayList<>());
        }
        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr.get(a).add(b);
            arr.get(b).add(a);
        }
        parent = new int[n + 1];
        visit = new boolean[n + 1];

        bfs(1);
        for (int i = 2; i <= n; i++) {
            System.out.println(parent[i]);
        }
    }

    public static void bfs(int x) {
        Queue<Integer> q = new LinkedList<>();
        q.add(x);
        visit[x] = true;
        while (!q.isEmpty()) {
            int v = q.poll();
            for (int a : arr.get(v)) {
                if (!visit[a]) {
                    parent[a] = v;
                    visit[a] = true;
                    q.add(a);
                }
            }
        }
    }

}

