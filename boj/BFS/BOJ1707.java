package BFS;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ1707 {
    static String ans = "YES";
    static ArrayList<ArrayList<Integer>> graph;
    public static int RED = 1, GREEN = -1;
    static int[] team;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int k = Integer.parseInt(br.readLine());
        while (k-- > 0) {
            ans = "YES";
            StringTokenizer st;
            st = new StringTokenizer(br.readLine());
            int v = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());

            graph = new ArrayList<>();
            for (int i = 0; i < v; i++) {
                graph.add(new ArrayList<>());
            }

            for (int i = 0; i < e; i++) {
                st = new StringTokenizer(br.readLine());
                int a = Integer.parseInt(st.nextToken()) - 1;
                int b = Integer.parseInt(st.nextToken()) - 1;

                graph.get(a).add(b);
                graph.get(b).add(a);
            }
            team = new int[v];
            for (int i = 0; i < v; i++) {
                if (team[i] == 0) {
                    if (!bfs(i)) break;
                }
            }
            System.out.println(ans);
        }

    }

    static boolean bfs(int n) {
        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        team[n] = RED;
        while (!q.isEmpty()) {
            int node = q.poll();
            for (Integer i : graph.get(node)) {
                if (team[node] == team[i]) {
                    ans = "NO";
                    return false;
                }
                if (team[i] == 0) {
                    team[i] = team[node] * -1;
                    q.add(i);
                }
            }
        }
        return true;

    }
}
