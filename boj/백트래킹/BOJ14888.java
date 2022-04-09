package 백트래킹;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class BOJ14888 {
    static int n;
    static int[] arr;
    static int[] operator = new int[4];
    static int max = Integer.MIN_VALUE;
    static int min = Integer.MAX_VALUE;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());

        arr = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());

        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        back(arr[0], 1);
        System.out.println(max);
        System.out.println(min);
    }

    private static void back(int sum, int idx) {
        if (idx == n) {
            min = Math.min(sum, min);
            max = Math.max(sum, max);
            return;
        }

        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i]--;

                switch (i) {
                    case 0:
                        back(sum + arr[idx], idx + 1);
                        break;
                    case 1:
                        back(sum - arr[idx], idx + 1);
                        break;
                    case 2:
                        back(sum * arr[idx], idx + 1);
                        break;
                    case 3:
                        back(sum / arr[idx], idx + 1);
                        break;
                }
                operator[i]++;
            }
        }
    }
}
