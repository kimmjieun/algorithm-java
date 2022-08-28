package 삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int n;
    static int[] arr;
    static int[] oper = new int[4];
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        arr = new int[n];
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            oper[i] = Integer.parseInt(st.nextToken());
        }

        back(1, arr[0]);
        System.out.println(max);
        System.out.println(min);
    }

    public static void back(int depth, int sum) {
        if (depth == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (oper[i] > 0) {
                oper[i]--;
                switch (i) {
                    case 0:
                        back(depth + 1, sum + arr[depth]);
                        break;
                    case 1:
                        back(depth + 1, sum - arr[depth]);
                        break;
                    case 2:
                        back(depth + 1, sum * arr[depth]);
                        break;
                    case 3:
                        back(depth + 1, sum / arr[depth]);
                        break;
                }
                oper[i]++;
            }
        }
    }
}
