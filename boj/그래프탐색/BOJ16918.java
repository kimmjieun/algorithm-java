package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ16918 {
    static int r, c, n;
    static char[][] map;
    static Queue<int[]> q = new LinkedList<>();
    static int[] dx = {-1, 0, 1, 0}; // 북 동 남 서
    static int[] dy = {0, 1, 0, -1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        map = new char[r][c];
        for (int i = 0; i < r; i++) {
            String s = br.readLine();
            for (int j = 0; j < c; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 2; i <= n; i++) {
            if (i % 2 == 1) {
                // 폭탄위치 저장하기
                for (int k = 0; k < r; k++) {
                    for (int j = 0; j < c; j++) {
                        if (map[k][j] == 'O') {
                            q.add(new int[]{k, j});
                        }
                    }
                }
                for (char[] m : map) {
                    Arrays.fill(m, 'O');
                }
                bfs();
            }

        }


        if (n % 2 == 0) {
            for (char[] m : map) {
                Arrays.fill(m, 'O');
            }
        }
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                System.out.print(map[i][j]);
            }
            System.out.println();
        }
    }

    static void bfs() {
        while (!q.isEmpty()) {
            int[] t = q.poll();
            int x = t[0];
            int y = t[1];
            map[x][y] = '.';
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && nx < r && ny >= 0 && ny < c) {
                    if (map[nx][ny] == 'O') {
                        map[nx][ny] = '.';
                    }
                }
            }
        }


    }

}

/*
위 코드보단 아래 코드가 직관적이다.
하지만 속도면에선 위 코드가 낫다.
 */

//public class BOJ16918 {
//    static int r, c,n;
//    static Character[][] map;
//    static int[] dx = {-1,1,0,0};
//    static int[] dy = {0,0,-1,1};
//    public static void main(String[] args) throws IOException{
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//
//        StringTokenizer st;
//        st = new StringTokenizer(br.readLine());
//
//        r = Integer.parseInt(st.nextToken());
//        c = Integer.parseInt(st.nextToken());
//        n = Integer.parseInt(st.nextToken());
//
//        map = new Character[r][c];
//        for(int i=0;i<r;i++) {
//            String s= br.readLine();
//            for(int j=0;j<c;j++) {
//                map[i][j]=s.charAt(j);
//
//            }
//        }
//        Queue<int[]> q = new LinkedList<>();
//
//        for(int i=2;i<=n;i++) {
//            if(i%2==0) {
//                for(int j=0;j<r;j++) {
//                    for(int k=0;k<c;k++) {
//                        if(map[j][k]=='O') {
//                            q.add(new int[] {j,k});
//                        }
//                    }
//                }
//
//                for(int k=0;k<r;k++) {
//                    Arrays.fill(map[k],'O');
//                }
//
//            }else {
//                while(!q.isEmpty()) {
//                    int[]t = q.poll();
//                    int tx = t[0];
//                    int ty = t[1];
//                    map[tx][ty]='.';
//                    for(int k=0;k<4;k++) {
//                        int nx=dx[k]+tx;
//                        int ny = dy[k]+ty;
//                        if(nx>=0&&nx<r&&ny>=0&&ny<c) {
//                            map[nx][ny]='.';
//                        }
//                    }
//                }
//            }
//
//        }
//
//        for(int i=0;i<r;i++) {
//            for(int j=0;j<c;j++) {
//                System.out.print(map[i][j]);
//
//            }
//            System.out.println();
//        }
//
//    }
//}
//
