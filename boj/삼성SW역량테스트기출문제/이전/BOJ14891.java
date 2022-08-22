package 삼성SW역량테스트기출문제.이전;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class BOJ14891 {
    static ArrayList<Integer>[] wheel; // ArrayList<int[]> 같나 ?
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        wheel = new ArrayList[5];
        for (int i = 0; i < 5; i++) {
            wheel[i] = new ArrayList<>();
        }
        for (int i = 1; i <= 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i].add(s.charAt(j) - '0');
            }
        }
        int k = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            int dir = Integer.parseInt(st.nextToken());

            int c_left = wheel[num].get(6); // 현재 톱니바퀴값 저장해둠
            int c_right = wheel[num].get(2);
            int c_dir = dir;
            int left = c_left;
            int right = c_right;
            for (int p = num - 1; p >= 1; p--) {
                if (left != wheel[p].get(2)) {
                    left = wheel[p].get(6);
                    dir *= -1;
                    rotate(p, dir);
                } else {
                    break;// 회전 x
                }
            }
            left = c_left;
            right = c_right;
            dir = c_dir;
            for (int p = num + 1; p <= 4; p++) {
                if (right != wheel[p].get(6)) {
                    right = wheel[p].get(2);
                    dir *= -1;
                    rotate(p, dir);
                } else {
                    break;//회전하지 않는다
                }
            }
            rotate(num, c_dir);// 현재 톱니바퀴회전 (방향값 때문에 나중에 돌린다.)

        }
        int total = 0;
        for (int i = 1; i <= 4; i++) {
            total += wheel[i].get(0) * Math.pow(2, i - 1);
        }
        System.out.println(total);
    }

    static void rotate(int num, int dir) {
        if (dir == 1) {
            clock(num);
        } else {
            rclock(num);
        }
    }

    // 반시계
    static void rclock(int num) {
        int tmp = wheel[num].get(0);
        wheel[num].remove(0);
        wheel[num].add(7, tmp);
    }

    // 시계
    static void clock(int num) {
        int tmp = wheel[num].get(7);
        wheel[num].remove(7);
        wheel[num].add(0, tmp);
    }

    private static void print() {
        for (int i = 1; i <= 4; i++) {
            for (int j = 0; j < 8; j++) {
                System.out.print(wheel[i].get(j) + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

}
