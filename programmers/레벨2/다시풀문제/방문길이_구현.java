package 레벨2.다시풀문제;


class 방문길이_구현 {
    public int[] dx = {0, 0, 1, -1};
    public int[] dy = {-1, 1, 0, 0};

    public boolean[][][][] visit = new boolean[11][11][11][11];

    public int solution(String dirs) {
        int answer = 0;
        int x = 0;
        int y = 0;
        int nextX = 5;
        int nextY = 5;

        int index = 0;
        for (int i = 0; i < dirs.length(); i++) {
            x = nextX;
            y = nextY;
            if (dirs.charAt(i) == 'U')
                index = 0;
            else if (dirs.charAt(i) == 'D')
                index = 1;
            else if (dirs.charAt(i) == 'R')
                index = 2;
            else if (dirs.charAt(i) == 'L')
                index = 3;

            // u,d,r,l 맞는 캐리터 위치 이동
            nextX += dx[index];
            nextY += dy[index];

            // 이전에 움직인 범위에 의해 캐릭터 위치가 지도를 벗어났을 경우
            if (nextX < 0 || nextY < 0 || nextX > 10 || nextY > 10) {
                nextX -= dx[index];
                nextY -= dy[index];
                continue;
            }

            if (!visit[x][y][nextX][nextY] && !visit[nextX][nextY][x][y]) {
                visit[x][y][nextX][nextY] = true;
                visit[nextX][nextY][x][y] = true;
                answer++;
            }
        }
        return answer;
    }
}
