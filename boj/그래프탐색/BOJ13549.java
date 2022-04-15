package 그래프탐색;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ13549 {
    static int n, k;
    static int[] arr;
    static Queue<Integer> q = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());


        if (n >= k) {
            System.out.println(n - k);
        } else {
            System.out.println(bfs());
        }

    }

    static int bfs() {

        // 시간을 재는 배열선언
        arr = new int[100001];
        Arrays.fill(arr, -1);
        q.add(n);
        arr[n] = 0;
        while (!q.isEmpty()) {
            int x = q.poll();

            if (x == k)
                return arr[x];

            int tmp = x * 2;
            while (tmp <= 100000 && arr[tmp] == -1) {
                arr[tmp] = arr[x];
                q.add(tmp);
                tmp *= 2;
            }
            for (int i = 0; i < 2; i++) {
                int nx;
                if (i == 0)
                    nx = x - 1;
                else
                    nx = x + 1;

                if (nx >= 0 && nx < 100001 && arr[nx] == -1) {
                    arr[nx] = arr[x] + 1;
                    q.add(nx);
                }
            }
        }
        return 0;
    }

}
