package 레벨2.구현;

class 행렬테두리회전하기 {
    public int[] solution(int rows, int columns, int[][] queries) {
        int[] answer = new int[queries.length];

        int num = 1;
        int[][] map = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                map[i][j] = num++;
            }
        }

        for (int j = 0; j < queries.length; j++) {
            int sx = queries[j][0] - 1;
            int sy = queries[j][1] - 1;
            int ex = queries[j][2] - 1;
            int ey = queries[j][3] - 1;
            int min = Integer.MAX_VALUE;

            // 회전하기
            int tmp = map[sx][sy];
            min = Math.min(min, tmp);

            // 위
            for (int i = sx; i < ex; i++) {
                map[i][sy] = map[i + 1][sy];
                min = Math.min(min, map[i][sy]);
            }
            // 왼
            for (int i = sy; i < ey; i++) {
                map[ex][i] = map[ex][i + 1];
                min = Math.min(min, map[ex][i]);
            }
            // 아래
            for (int i = ex; i > sx; i--) {
                map[i][ey] = map[i - 1][ey];
                min = Math.min(min, map[i][ey]);
            }
            // 오른
            for (int i = ey; i > sy + 1; i--) {
                map[sx][i] = map[sx][i - 1];
                min = Math.min(min, map[sx][i]);
            }
            map[sx][sy + 1] = tmp;

            // for(int k=0;k<rows;k++){
            //     for(int h=0;h<columns;h++){
            //         System.out.print(map[k][h]+" ");
            //     }
            //      System.out.println();
            // }
            //  System.out.println();
            answer[j] = min;

        }

        return answer;
    }
}