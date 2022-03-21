package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class boj_2251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        if (n >= k) {
            System.out.println(n - k);
        } else {
            System.out.println(bfs(n, k));
        }

    }

    static int bfs(int n, int k) {
        Queue<Integer> q = new LinkedList<>();
        int[] arr = new int[100001];
        arr[n] = 1;
        q.add(n);

        while (!q.isEmpty()) {
            int x = q.poll();

            for (int i = 0; i < 3; i++) {
                int nx;

                if (i == 0)
                    nx = x - 1;
                else if (i == 1)
                    nx = x + 1;
                else
                    nx = x * 2;

                if (nx == k) {
                    return arr[x];
                }

                if (0 <= nx && nx <= 100000) {
                    if (arr[nx] == 0) {
                        q.add(nx);
                        arr[nx] = arr[x] + 1;
                    }
                }

            }
        }

        return 0;
    }
}
