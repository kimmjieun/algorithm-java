package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ15658 {
    static int n;
    static int[] arr;
    static int[] operator;
    static int min = Integer.MAX_VALUE;
    static int max = Integer.MIN_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        operator = new int[4];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        back(arr[0], 1);
        System.out.println(max);
        System.out.println(min);

    }

    static void back(int sum, int depth) {
        if (depth == n) {
            min = Math.min(min, sum);
            max = Math.max(max, sum);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] > 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        back(sum + arr[depth], depth + 1);
                        break;
                    case 1:
                        back(sum - arr[depth], depth + 1);
                        break;
                    case 2:
                        back(sum * arr[depth], depth + 1);
                        break;
                    case 3:
                        back(sum / arr[depth], depth + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }

}
