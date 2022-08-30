package 레벨2.다시풀문제;


class 가장큰정사각형_DP {
    public int solution(int[][] board) {
        int answer = 0;
        int[][] newBoard = new int[board.length + 1][board[0].length + 1];

        // 새로운 배열 생성
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                newBoard[i + 1][j + 1] = board[i][j];
            }
        }

        int max = 0;
        // 만들 수 있는 정사각형 검사
        for (int i = 1; i < newBoard.length; i++) {
            for (int j = 1; j < newBoard[i].length; j++) {
                // 현재값이 1인 경우 좌, 상 좌상 체크
                if (newBoard[i][j] == 1) {
                    int left = newBoard[i - 1][j];//좌측값
                    int up = newBoard[i][j - 1];// 상단값
                    int leftup = newBoard[i - 1][j - 1];// 좌측상단값
                    int min = Math.min(left, Math.min(up, leftup));
                    newBoard[i][j] = min + 1;
                    max = Math.max(max, min + 1);
                }
            }
        }

        answer = max * max;
        return answer;
    }
}
