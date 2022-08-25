package 삼성SW역량테스트기출문제;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ20055 {
    static int[] A;
    static int k;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        A = new int[2 * n];
        boolean[] robot = new boolean[n];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 2 * n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int cnt = 0;

        // 내구도 0인 칸의 개수가 K개 미만일 때 과정 반복
        while (isOk()) {

            // 1. 벨트가 각 칸 위에 있는 로봇과 함께 한 칸 회전
            int tmp = A[A.length - 1];
            for (int i = A.length - 1; i > 0; i--) {
                A[i] = A[i - 1];
            }
            A[0] = tmp;

            for (int i = robot.length - 1; i > 0; i--) {
                robot[i] = robot[i - 1];
            }
            robot[0] = false; // 당연 false
            robot[robot.length - 1] = false; // 마지막칸 로봇 무조건 내림

            // 2. 로봇 이동
            for (int i = robot.length - 1; i > 0; i--) {
                if (robot[i - 1] && !robot[i] && A[i] > 0) {
                    A[i]--;
                    robot[i] = true;
                    robot[i - 1] = false;
                }
            }

            // 3. 올리는 위치에 있는 칸의 내구도가 0이 아니면 로봇 올리기
            if (A[0] > 0) {
                robot[0] = true;
                A[0]--;
            }


            cnt++;
        }
        System.out.println(cnt);
    }

    public static boolean isOk() {
        int cnt = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] == 0)
                cnt++;
            if (cnt >= k) return false;
        }
        return true;
    }
}
