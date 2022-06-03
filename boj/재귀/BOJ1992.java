package 재귀;

import java.io.*;

public class BOJ1992 {

    static int[][] map;
    static int n;
    static StringBuilder sb = new StringBuilder();

    // 쿼드트리란 해당영역이 0과 1로 이루어진다면 압축하는 것
    // 아니라면 4영역으로 쪼개서 다시 해당역역을 0과 1로 이루어진 영역인지 확인
    // 재귀로 해결
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();

            for (int j = 0; j < n; j++) {
                map[i][j] = str.charAt(j) - '0';
            }
        }

        quardTree(0, 0, n);
        System.out.println(sb);
    }

    static void quardTree(int x, int y, int size) {
        // 해당영역을 압축할 수 있는지 확인
        if (isPossible(x, y, size)) {
            sb.append(map[x][y]);
            return;
        }

        // 압축할 수 없다면 4 영역으로 쪼개고 쿼드트리 실행하기
        int newSize = size / 2;
        sb.append("(");
        quardTree(x, y, newSize);
        quardTree(x, y + newSize, newSize);
        quardTree(x + newSize, y, newSize);
        quardTree(x + newSize, y + newSize, newSize);
        sb.append(")");
    }

    static boolean isPossible(int x, int y, int size) {
        int val = map[x][y];
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (val != map[i][j]) return false;
            }
        }
        return true;
    }
}
