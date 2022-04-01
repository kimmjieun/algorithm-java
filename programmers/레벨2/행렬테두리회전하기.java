package 레벨2;

public class 행렬테두리회전하기 {
    public int[][] map;

    public int[] solution(int rows, int columns, int[][] queries) {

        int num = 1;
        map = new int[rows][columns];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }

        int[] answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int x1 = queries[i][0] - 1;
            int y1 = queries[i][1] - 1;
            int x2 = queries[i][2] - 1;
            int y2 = queries[i][3] - 1;

            answer[i] = rotate(x1, y1, x2, y2);
        }


        return answer;
    }

    public int rotate(int r1, int c1, int r2, int c2) {
        int tmp = map[r1][c1];
        int min = tmp;

        // 왼쪽 벽 아래->위
        for (int i = r1; i < r2; i++) {
            map[i][c1] = map[i + 1][c1];
            min = Math.min(min, map[i][c1]);
        }

        // 아랫변 오른 -> 왼
        for (int i = c1; i < c2; i++) {
            map[r2][i] = map[r2][i + 1];
            min = Math.min(min, map[r2][i]);
        }

        // 오른변 위 -> 아래
        for (int i = r2; i > r1; i--) {
            map[i][c2] = map[i - 1][c2];
            min = Math.min(min, map[i][c2]);
        }

        // 윗변 왼 -> 오른
        for (int i = c2; i > c1; i--) {
            map[r1][i] = map[r1][i - 1];
            min = Math.min(min, map[r1][i]);
        }

        map[r1][c1 + 1] = tmp;
        return min;

    }

}
