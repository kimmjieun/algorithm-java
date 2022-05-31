package 그리디;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16953 {
//    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        StringTokenizer st = new StringTokenizer(br.readLine());
//
//        int a = Integer.parseInt(st.nextToken());
//        int b = Integer.parseInt(st.nextToken());
//
//        int[] arr = new int[b + 1];
//        Queue<Integer> q = new LinkedList<>();
//        q.add(a);
//        while (!q.isEmpty()) {
//            int x = q.poll();
//            for (int i = 0; i < 2; i++) {
//                int nx;
//                if (i == 0) nx = x * 2;
//                else nx = x * 10 + 1;
//                if (nx >= 0 && nx <= b) {
//                    arr[nx] = arr[x] + 1;
//                    q.add(nx);
//                }
//            }
//        }
//
//        if (arr[b] == 0) System.out.println(-1);
//        else System.out.println(arr[b] + 1);
//    } // 메모리 초과

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        int cnt = 1;
        while (true) {
            if (a > b) {
                System.out.println(-1);
                break;
            }
            if (b % 2 == 0) {
                b = b / 2;
            } else if (b % 10 == 1) {
                b = b / 10;
            } else {
                System.out.println(-1);
                break;
            }
            if (a == b) {
                System.out.println(cnt + 1);
                break;
            }
            cnt++;
        }

    }
}
