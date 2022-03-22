package 그래프탐색;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class boj_2251 {
    static int maxA, maxB, maxC;
    static ArrayList<Integer> answer;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // 물병의 최대 용량 입력받기
        maxA = Integer.parseInt(st.nextToken());
        maxB = Integer.parseInt(st.nextToken());
        maxC = Integer.parseInt(st.nextToken());

        answer = new ArrayList<>();
        bfs();

        Collections.sort(answer);
        for (int ans : answer) {
            System.out.println(ans + " ");
        }


    }

    static class Bottle {
        int a;
        int b;
        int c;

        Bottle(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }

    static void bfs() {
        Queue<Bottle> q = new LinkedList<>();
        boolean[][][] visit = new boolean[maxA + 1][maxB + 1][maxC + 1];

        q.add(new Bottle(0, 0, maxC));// 초기상태

        while (!q.isEmpty()) {
            Bottle curr = q.poll();
            if (visit[curr.a][curr.b][curr.c]) {
                continue;
            }
            if (curr.a == 0)
                answer.add(curr.c);

            visit[curr.a][curr.b][curr.c] = true;

            // case 1: B->A
            if (curr.a + curr.b <= maxA) {
                q.add(new Bottle(curr.a + curr.b, 0, curr.c));
            } else {
                q.add(new Bottle(maxA, curr.a + curr.b - maxA, curr.c));
            }
            // case 2: C->A
            if (curr.a + curr.c <= maxA) {
                q.add(new Bottle(curr.a + curr.c, curr.b, 0));
            } else {
                q.add(new Bottle(maxA, curr.b, curr.a + curr.c - maxA));
            }
            // case 3: A->B
            if (curr.a + curr.b <= maxB) {
                q.add(new Bottle(0, curr.a + curr.b, curr.c));
            } else {
                q.add(new Bottle(curr.a + curr.b - maxB, maxB, curr.c));
            }
            // case 4: C->B
            if (curr.b + curr.c <= maxB) {
                q.add(new Bottle(curr.a, curr.b + curr.c, 0));
            } else {
                q.add(new Bottle(curr.a, maxB, curr.b + curr.c - maxB));
            }
            // case 5: A->C
            if (curr.a + curr.c <= maxC) {
                q.add(new Bottle(0, curr.b, curr.a + curr.c));
            } else {
                q.add(new Bottle(curr.a + curr.c - maxC, curr.b, maxC));
            }
            // case 6: B->C
            if (curr.b + curr.c <= maxC) {
                q.add(new Bottle(curr.a, 0, curr.b + curr.c));
            } else {
                q.add(new Bottle(curr.a, curr.b + curr.c - maxC, maxC));
            }


        }
    }


}
