package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ16987 {
    static int n, answer;
    static int arr[][];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());

        arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[i][0] = a;
            arr[i][1] = b;

        }

        back(0, 0);
        System.out.println(answer);


    }

    public static void back(int level, int sum) {
        if (level == n) return;

        for (int i = 0; i < n; i++) {
            if (i == level || arr[i][0] <= 0) continue;// b가 깨진 상태
            if (arr[level][0] <= 0) {
                back(level + 1, sum);
                return;
            }
            arr[level][0] -= arr[i][1];
            arr[i][0] -= arr[level][1];
            int cnt = 0;
            if (arr[level][0] <= 0)
                cnt++;
            if (arr[i][0] <= 0)
                cnt++;
            answer = Math.max(answer, sum + cnt);
            back(level + 1, sum + cnt);
            arr[level][0] += arr[i][1];
            arr[i][0] += arr[level][1];
        }
    }
}
