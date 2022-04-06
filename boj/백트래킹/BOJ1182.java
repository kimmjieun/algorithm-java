package 백트래킹;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1182 {
    static int n, s;
    static int[] arr;
    static int[] result;
    static int ans;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        s = Integer.parseInt(st.nextToken());

        arr = new int[n];
        StringTokenizer st2 = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st2.nextToken());
        }


//        //   원래 풀이
//        for (int i = 1; i <= n; i++) {
//            result = new int[i];
//            visit = new boolean[n];
//            back(0, i, 0);
//        }
//        System.out.println(ans);

        // 새로운 풀이
        dfs(0, 0);
        if (s == 0) System.out.println(ans - 1);
        else System.out.println(ans);

    }

    public static void dfs(int depth, int sum) {
        if (depth == n) {
            if (sum == s) ans++;
            return;
        }


        dfs(depth + 1, sum + arr[depth]);// 해당 인덱스 더함
        dfs(depth + 1, sum);// 해당 인덱스 더하지 않음

    }

//    public static void back(int count, int depth, int start) {
//        if (depth == count) {
//            int sum = 0;
//            for (int val : result) {
////                System.out.print(val+" ");
//                sum += val;
//            }
////            System.out.println();
//            if (sum == s) {
//                ans++;
//            }
//            return;
//        }
//
//        for (int i = start; i < n; i++) {
//            if (!visit[i]) {
//                result[count] = arr[i];
//                visit[i] = true;
//                back(count + 1, depth, i);
//                visit[i] = false;
//            }
//        }
//    }
}
