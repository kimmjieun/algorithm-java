package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class BOJ16922 {
    static int n;
    static boolean[] visit;
    static int cnt;
    static int[] num = {1, 5, 10, 50};
    static ArrayList<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        visit = new boolean[50 * 20 + 1];
        bruteforce();
//        back(0, 0, 0);
        System.out.println(cnt);
    }

    private static void bruteforce() {
        for (int i = 0; i <= n; i++) { // 1의 개수
            for (int j = 0; j <= n - i; j++) { //5의 개수
                for (int k = 0; k <= n - i - j; k++) { // 10의 개수
                    int l = n - i - j - k; // 50의 개수
                    int sum = i * 1 + j * 5 + k * 10 + l * 50;
                    if (!visit[sum]) {
                        cnt++;
                        visit[sum] = true;
                    }
                }
            }
        }
    }

    public static void back(int start, int sum, int count) {
        if (count == n) {
            if (!visit[sum]) {
                visit[sum] = true;
                cnt++;
            }
            return;
        }

        for (int i = start; i < 4; i++) {
            back(i, sum + num[i], count + 1);
        }
    }

    static void back2(int depth, int start, int sum) {
        if (n == depth) {
            if (!list.contains(sum)) {
                list.add(sum);
            }
            return;
        }

        for (int i = start; i < 4; i++) {
            switch (i) {
                case 0:
                    back(depth + 1, i, sum + 1);
                    break;
                case 1:
                    back(depth + 1, i, sum + 5);
                    break;
                case 2:
                    back(depth + 1, i, sum + 10);
                    break;
                case 3:
                    back(depth + 1, i, sum + 50);
                    break;
            }

        }
    }
}
