package BFS;

import java.io.*;
import java.util.*;

public class BOJ1697 {
    static int n, k, arr[];
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

//        visit = new boolean[100001];
        arr = new int[100001];
        Queue<Integer> q = new LinkedList<>();

        q.add(n);
//        visit[n] = true;
        while (!q.isEmpty()) {
            int x = q.poll();
            if (x == k) break;
            for (int i = 0; i < 3; i++) {
                int nx;
                if (i == 0) {
                    nx = x + 1;
                } else if (i == 2) {
                    nx = x - 1;
                } else {
                    nx = 2 * x;
                }
//                if (nx >= 0 && nx <= 100000 && !visit[nx]) {
                if (nx >= 0 && nx <= 100000 && arr[nx] == 0) {
                    arr[nx] = arr[x] + 1;
                    q.add(nx);
//                    visit[nx] = true;
                }
            }
        }
        System.out.println(arr[k]);

    }
}
